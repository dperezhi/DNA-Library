package ui.panels.buttonfunctionality.popup.load;

import exceptions.InvalidCharForNucSeqException;
import model.DnaFolder;
import persistence.JsonReader;
import ui.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// represents a button in which the user loads a DnaFolder from within a json file
public class LoadPathButton extends JButton implements ActionListener {
    private JTextField textField;
    private String name;
    private JsonReader jsonReader;
    private String pathOfSave = "./data/";
    private JFrame popUpFrame;
    private JFrame masterFrame;
    private DnaFolder dnaFolder;

    //MODIFIES: this
    //EFFECTS: sets up a LoadPathButton, whose action is determined by actionPerformed method w/in
    //         this method.
    public LoadPathButton(JTextField textField, JFrame popUpFrame, JFrame masterFrame) {
        super("submit");
        this.textField = textField;
        this.popUpFrame = popUpFrame;
        this.masterFrame = masterFrame;
        this.addActionListener(this);
    }

    //EFFECTS: loads a Dna Folder from a json file. If filename input not found it creates a new pop-up frame
    //         LoadFrameFileNotFound. It should never encounter InvalidCharForNucSeqException as that is checked when
    //         file is initially saved. If no exception is found it will dispose of the pop-up frame and load a new GUI
    //         with the loaded Dna Folder.
    private void loadDnaFolder() {
        try {
            dnaFolder = jsonReader.read();
            new GUI(dnaFolder);

            masterFrame.dispose();
            masterFrame.setVisible(false);
        } catch (IOException e) {
            new LoadFrameFileNotFound(masterFrame);
        } catch (InvalidCharForNucSeqException e) {
            throw new RuntimeException(e);
        }
        popUpFrame.dispose();
        popUpFrame.setVisible(false);
    }

    //MODIFIES: this
    //EFFECTS: gets the name of the loaded file from the user and creates a new GUI with the loaded DnaFolder.
    @Override
    public void actionPerformed(ActionEvent e) {
        name = textField.getText();
        textField.setText("   ");
        pathOfSave += name + ".json";
        jsonReader = new JsonReader(pathOfSave);
        loadDnaFolder();
    }
}
