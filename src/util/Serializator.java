package util;

import app.MainFrame;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Instalation;
import model.Instalator;
import model.Parameter;

/**
 *
 * Klasa za serijalizaciju i deserilaizaciju klasa u json.
 */
public class Serializator {

    /**
     *
     * @param model
     */
    public static void serializeToJson(Instalation model) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Parameter.class, new ParameterAdapter());
        Gson gson = gsonBuilder.create();

        try (FileWriter file = new FileWriter(new File("instal.json"))) {
            file.write(gson.toJson(model));
        } catch (IOException e) {
        }
    }

    /**
     *
     * @return
     */
    public static Instalation serializeFromJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Parameter.class, new ParameterAdapter());
        Gson gson = gsonBuilder.create();

        try {
            JsonReader reader = new JsonReader(new FileReader("instal.json"));
            return gson.fromJson(reader, Instalation.class);
        } catch (FileNotFoundException | MyJsonException | JsonSyntaxException jpe) {
            JOptionPane.showMessageDialog(null, jpe.getLocalizedMessage(), MainFrame.getInstance().getResourceBundle().getString("edit-instalator-message"), JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     *
     * @param model
     */
    public static void save(Instalation model) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Parameter.class, new ParameterAdapter());
        Gson gson = gsonBuilder.create();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON FILES", ".json", "json");

        fileChooser.setFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try (FileWriter file = new FileWriter(selectedFile.getAbsolutePath() + ".json")) {
                file.write(gson.toJson(model));
            } catch (IOException e) {
            }
        }
    }

    public static Instalation load() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Parameter.class, new ParameterAdapter());
        Gson gson = gsonBuilder.create();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON FILES", ".json", "json");

        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                JsonReader reader = new JsonReader(new FileReader(selectedFile.getAbsolutePath()));
                return gson.fromJson(reader, Instalation.class);
            } catch (FileNotFoundException | MyJsonException | JsonSyntaxException jpe) {
                JOptionPane.showMessageDialog(null, jpe.getLocalizedMessage(), MainFrame.getInstance().getResourceBundle().getString("edit-instalator-message"), JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    /**
     *
     * @param model
     */
    public static void saveInstalator(Instalator model) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Parameter.class, new ParameterAdapter());
        Gson gson = gsonBuilder.create();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON FILES", ".json", "json");

        fileChooser.setFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try (FileWriter file = new FileWriter(selectedFile.getAbsolutePath() + ".json")) {
                file.write(gson.toJson(model));
            } catch (IOException e) {
            }
        }
    }

    /**
     *
     * @return
     */
    public static Instalator loadInstalator() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Parameter.class, new ParameterAdapter());
        Gson gson = gsonBuilder.create();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON FILES", ".json", "json");

        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                JsonReader reader = new JsonReader(new FileReader(selectedFile.getAbsolutePath()));
                return gson.fromJson(reader, Instalator.class);
            } catch (FileNotFoundException | MyJsonException | JsonSyntaxException jpe) {
                JOptionPane.showMessageDialog(null, jpe.getLocalizedMessage(), MainFrame.getInstance().getResourceBundle().getString("edit-instalator-message"), JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    public static void extractFolder(String zipFile, String extractFolder) {
        try {
            int BUFFER = 2048;
            File file = new File(zipFile);

            @SuppressWarnings("resource")
            ZipFile zip = new ZipFile(file);
            String newPath = extractFolder;

            new File(newPath).mkdir();

            @SuppressWarnings("rawtypes")
            Enumeration zipFileEntries = zip.entries();

            // Process each entry
            while (zipFileEntries.hasMoreElements()) {
                // grab a zip file entry
                ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
                String currentEntry = entry.getName();

                File destFile = new File(newPath, currentEntry);
                //destFile = new File(newPath, destFile.getName());
                File destinationParent = destFile.getParentFile();

                // create the parent directory structure if needed
                destinationParent.mkdirs();

                if (!entry.isDirectory()) {
                    try (BufferedInputStream is = new BufferedInputStream(zip
                            .getInputStream(entry))) {
                        int currentByte;
                        // establish buffer for writing file
                        byte data[] = new byte[BUFFER];

                        // write the current file to disk
                        FileOutputStream fos = new FileOutputStream(destFile);
                        // read and write until last byte is encountered
                        try (BufferedOutputStream dest = new BufferedOutputStream(fos,
                                BUFFER)) {
                            // read and write until last byte is encountered
                            while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
                                dest.write(data, 0, currentByte);
                            }
                            dest.flush();
                        }
                    }
                }

            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }
}
