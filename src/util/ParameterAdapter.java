package util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import model.Parameter;

/**
 *
 * Pomoćna klasa za serijalizaciju preko gson builder-a.
 */
public class ParameterAdapter implements JsonSerializer<Parameter>, JsonDeserializer<Parameter> {

    /**
     *
     * @param src
     * @param typeOfSrc
     * @param jsc
     * @return
     */
    @Override
    public JsonElement serialize(Parameter src, Type typeOfSrc, JsonSerializationContext jsc) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
        result.add("properties", jsc.serialize(src, src.getClass()));

        return result;
    }

    /**
     *
     * @param je
     * @param type
     * @param jdc
     * @return
     * @throws JsonParseException
     */
    @Override
    public Parameter deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonObject jsonObject = je.getAsJsonObject();
        String myType = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");

        try {
            return jdc.deserialize(element, Class.forName("model.parameters." + myType));
        } catch (ClassNotFoundException e) {
            throw new JsonParseException("Unknown element type: " + myType, e);
        }
    }
}
