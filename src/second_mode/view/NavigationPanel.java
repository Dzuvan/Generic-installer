package second_mode.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import model.Parameter;
import model.Wizard;
import model.parameters.CheckBoxParameter;
import org.apache.commons.io.FileUtils;
import second_mode.app.SecondFrame;
import second_mode.progress.StatusUpdater;

/**
 * Panel preko kojeg se vrši navigacija prilikom instalacije. U zavisnoti od
 * pritisnutog dugmeta vrši se instaciranje panela s parametrima
 *
 */
@SuppressWarnings("serial")
public class NavigationPanel extends JPanel {

    private int totalSize;
    private JButton nextButton;
    private JButton backButton;
    private JButton finishButton;
    private int position;
    private SecondFrame frame;
    private JProgressBar progressBar;
    private JPanel valuePanel;
    private JProgressBar speedLabel;

    /**
     *
     * @param totalSize
     * @param frame
     */
    public NavigationPanel(int totalSize, SecondFrame frame) {
        this.totalSize = totalSize;
        this.frame = frame;

        this.position = 0;
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        initGUI();
        firstRun();

    }

    private void firstRun() {

        if (position == totalSize - 1) {
            nextButton.setEnabled(false);
            backButton.setEnabled(false);
            finishButton.setEnabled(true);
        }
    }

    private void initGUI() {
        nextButton = new JButton("Next");
        backButton = new JButton("Back");
        finishButton = new JButton("Finish");
        
        valuePanel = new JPanel();
        progressBar = new JProgressBar();
        speedLabel = new JProgressBar();
        
        backButton.setEnabled(false);
        finishButton.setEnabled(false);
        progressBar.setStringPainted(true);
        speedLabel.setStringPainted(true);
        
        progressBar.setPreferredSize(new Dimension(400, 50));
        speedLabel.setPreferredSize(new Dimension(400, 50));
        valuePanel.setPreferredSize(new Dimension(400, 200));
         for (Parameter p : frame.getModel().getWizards().get(0).getParameters()) {
                    if (p instanceof CheckBoxParameter) {                        
                        JCheckBox f = frame.getMainPanel().getCheckboxView().getCheck();
                        f.setSelected(false);
                        if (f.isSelected()) {
                            nextButton.setEnabled(true);
                        } else {
                            nextButton.setEnabled(false);
                        }
                        f.addActionListener((ActionEvent es) -> {
                            nextButton.setEnabled(f.isSelected());
                        });
                    }
                }
        nextButton.addActionListener((ActionEvent e) -> {
            Wizard nextWizard = getNextWizard();

            if (nextWizard != null) {

                MainPanel mainPanel = new MainPanel(nextWizard);
                for (Parameter p : nextWizard.getParameters()) {
                    if (p instanceof CheckBoxParameter) {                        
                        JCheckBox f = mainPanel.getCheckboxView().getCheck();
                        f.setSelected(false);
                        if (f.isSelected()) {
                            nextButton.setEnabled(true);
                        } else {
                            nextButton.setEnabled(false);
                        }
                        f.addActionListener((ActionEvent es) -> {
                            nextButton.setEnabled(f.isSelected());
                        });
                    }
                }
                frame.setMainPanel(mainPanel);
                frame.getJsp().setViewportView(mainPanel);
                frame.repaint();
                frame.revalidate();
            }
        });

        backButton.addActionListener((ActionEvent e) -> {
            Wizard previousWizard = getPreviousWizard();

            if (previousWizard != null) {
                MainPanel mainPanel = new MainPanel(previousWizard);
                for (Parameter p : previousWizard.getParameters()) {
                    if (p instanceof CheckBoxParameter) {
                        JCheckBox f = mainPanel.getCheckboxView().getCheck();
                        f.setSelected(false);
                        if (f.isSelected()) {
                            nextButton.setEnabled(true);
                        } else {
                            nextButton.setEnabled(false);
                        }
                        f.addActionListener((ActionEvent es) -> {
                            nextButton.setEnabled(f.isSelected());
                        });
                    }
                }
                frame.setMainPanel(mainPanel);
                frame.getJsp().setViewportView(mainPanel);
                frame.repaint();
                frame.revalidate();
            }
        });

        finishButton.addActionListener((ActionEvent e) -> {
            StatusUpdater dirStatus = new StatusUpdater();

            valuePanel.add(progressBar, BorderLayout.NORTH);
            valuePanel.add(speedLabel, BorderLayout.SOUTH);
            frame.getJsp().setViewportView(valuePanel);
            frame.repaint();
            frame.revalidate();
            frame.pack();

            File source = new File(SelectInstallerPanel.getZipURL());
            Path p = Paths.get(source.getAbsolutePath());
            String fileName = p.getFileName().toString();
            File dest = new File(SelectInstallerPanel.pathUrl.getText() + File.separator + fileName + File.separator);

            dirStatus.monitor(dest, FileUtils.sizeOfDirectory(source), (double percent, double speed) -> {
                speedLabel.setString(new StringBuilder().append("Speed: ").append(speed).append("Mb/s").toString());
                speedLabel.repaint();
                speedLabel.revalidate();
                speedLabel.update(speedLabel.getGraphics());

                progressBar.setValue((int) percent);
                progressBar.repaint();
                progressBar.revalidate();
                progressBar.update(progressBar.getGraphics());

            });
            try {
                FileUtils.copyDirectory(source, dest);
            } catch (IOException ex) {
                Logger.getLogger(NavigationPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            dirStatus.stopMonitoring();

            if (dirStatus.isInterrupted()) {
                finishButton.setText("Close");
                finishButton.addActionListener((ActionEvent e1) -> {
                    System.exit(0);
                });
            }
        });

        add(backButton);
        add(nextButton);
        add(finishButton);

    }

    private Wizard getNextWizard() {
        if (position < totalSize - 1) {
            position++;

            if (position == totalSize - 1) {
                finishButton.setEnabled(true);
                nextButton.setEnabled(false);
                backButton.setEnabled(true);
            } else {
                finishButton.setEnabled(false);
                nextButton.setEnabled(true);
                backButton.setEnabled(true);
            }

            return frame.getModel().getWizards().get(position);
        }
        return null;
    }

    private Wizard getPreviousWizard() {
        if (position <= totalSize - 1) {
            position--;

            finishButton.setEnabled(false);
            nextButton.setEnabled(true);

            if (position == 0) {
                backButton.setEnabled(false);
            } else {
                backButton.setEnabled(true);
            }
            return frame.getModel().getWizards().get(position);
        }
        return null;
    }
}
