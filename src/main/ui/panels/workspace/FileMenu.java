package ui.panels.workspace;

import model.DnaFolder;
import ui.panels.buttonfunctionality.Load;
import ui.panels.buttonfunctionality.Save;

import javax.swing.*;
import java.awt.*;

public class FileMenu extends JPanel {
    private DnaFolder dnaFolder;
    private JFrame masterFrame;

    public FileMenu(DnaFolder dnaFolder, JFrame masterFrame) {
        //JPanel p5 = new JPanel();
        this.dnaFolder = dnaFolder;
        this.masterFrame = masterFrame;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,4));
        this.setBackground(Color.cyan);

        //package ui.panels.buttonFunctionality.Save
        Save saveButton = new Save(dnaFolder);
        this.add(saveButton);

        //package ui.panels.buttonFunctionality.Load
        Load load = new Load(masterFrame);
        this.add(load);

        // p1.add(p1,BorderLayout.CENTER);
    }
}
