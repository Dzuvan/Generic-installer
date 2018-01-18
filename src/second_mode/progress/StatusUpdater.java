package second_mode.progress;

import java.io.File;
import org.apache.commons.io.FileUtils;

/**
 *
 * Klasa zadužena za nadgledanje progresa instalcije.
 */
public class StatusUpdater {

    private long checkInterval = 5;
    private boolean interrupted = false;

    /**
     *
     * @return
     */
    public long getCheckInterval() {
        return this.checkInterval;
    }

    /**
     *
     * @param checkInterval
     */
    public void setCheckInterval(long checkInterval) {
        this.checkInterval = checkInterval;
    }

    /**
     * Metoda koja u novoj niti ažurira procentualnu vrednost instalacije.
     *
     * @param directory
     * @param desiredSize
     * @param feedback
     */
    public void monitor( File directory, long desiredSize, StatusFeedback feedback) {
        new Thread(() -> {
            try {
                double percentageMoved = 0;
                double lastCheckedSize = 0;
                do {
                    double currentSize = directory.exists()? FileUtils.sizeOfDirectory(directory) : 0;
                    double speed = (currentSize - lastCheckedSize) / (1024 * checkInterval);
                    lastCheckedSize = currentSize;
                    percentageMoved = 100 * currentSize / desiredSize;
                    feedback.notifyStatus(percentageMoved, speed);
                    Thread.sleep(checkInterval);
                } while (percentageMoved < 100 && !interrupted);
            } catch (InterruptedException e) {
                System.err.println("Directory monitor failed. " + e.getMessage());
            }
        }).start();
    }

    /**
     * Učitavanje stilgo do kraja, može da se gasi.
     */
    public void stopMonitoring() {
        this.interrupted = true;

    }

    /**
     *
     * @return
     */
    public boolean isInterrupted() {
        return interrupted;
    }

}
