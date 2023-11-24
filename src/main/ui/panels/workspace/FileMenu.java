package ui.panels.workspace;

import model.DnaFolder;
import ui.panels.buttonfunctionality.Load;
import ui.panels.buttonfunctionality.Save;

import javax.swing.*;
import java.awt.*;

//represents a panel where one can see the file menu: where you can save and load a DnaLibrary file
public class FileMenu extends JPanel {
    private DnaFolder dnaFolder;
    private JFrame masterFrame;

    //MODIFIES: this
    //EFFECTS: sets up the the file menu panel within in the workspace
    public FileMenu(DnaFolder dnaFolder, JFrame masterFrame) {
        this.dnaFolder = dnaFolder;
        this.masterFrame = masterFrame;
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,4));
        this.setBackground(Color.cyan);

        Save saveButton = new Save(dnaFolder);
        this.add(saveButton);
        Load load = new Load(masterFrame);
        this.add(load);
    }
}
