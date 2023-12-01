package ui.panels.buttonfunctionality.popup.load;

import javax.swing.*;
import java.awt.*;

//represents a pop-ip frame in which the input file to load was not found. The user will be asked to try again.
public class LoadFrameFileNotFound extends JFrame {
    private JPanel loadPanel;
    private JFrame loadFrame;

    //MODIFIES: this
    //EFFECTS: sets up a LoadFrameFileNotFound to try to input a valid name of a file to load.
    public LoadFrameFileNotFound(JFrame masterFrame) {
        loadFrame = new JFrame("Load Library");
        loadPanel = new JPanel();
        loadPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        loadPanel.setLayout(new GridLayout(0,1));
        loadPanel.add(new Label("Load Dna Libary from: "));

        JTextField path = new JTextField("Enter the name of the file");
        loadPanel.add(path);

        LoadPathButton loadPathButton = new LoadPathButton(path, loadFrame, masterFrame);
        loadPanel.add(loadPathButton);

        loadPanel.add(new Label(("File Not Found. Try Again!")));

        loadFrame.add(loadPanel, BorderLayout.CENTER);
        loadFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        loadFrame.pack();
        loadFrame.setSize(300, 400);
        loadFrame.setVisible(true);
    }

}
