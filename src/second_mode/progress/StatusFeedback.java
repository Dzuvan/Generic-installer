package second_mode.progress;

/**
 *
 * Interfejs preko koje se saopštava progres.
 */
public interface StatusFeedback {

    void notifyStatus(double percentMoved, double speedInMb);
}
