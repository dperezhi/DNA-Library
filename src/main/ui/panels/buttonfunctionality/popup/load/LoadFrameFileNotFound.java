package ui.panels.buttonfunctionality.popup.load;

import javax.swing.*;
import java.awt.*;

public class LoadFrameFileNotFound extends JFrame {
    private JFrame masterFrame;
    private JPanel loadPanel;
    private JFrame loadFrame;

    public LoadFrameFileNotFound(JFrame masterFrame) {
        this.masterFrame = masterFrame;
        loadFrame = new JFrame("Load Library");
        loadPanel = new JPanel();
        loadPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        loadPanel.setLayout(new GridLayout(0,1));
        loadPanel.add(new Label("Load Dna Libary from: "));

        JTextField path = new JTextField("Enter the name of the file");
        loadPanel.add(path);

        LoadPathButton loadPathButton = new LoadPathButton(path, loadFrame, masterFrame, loadPanel);
        loadPanel.add(loadPathButton);

        loadPanel.add(new Label(("File Not Found. Try Again!")));

        loadFrame.add(loadPanel, BorderLayout.CENTER);
        loadFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        loadFrame.pack();
        loadFrame.setSize(300, 400);
        loadFrame.setVisible(true);
    }

}
