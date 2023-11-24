package ui.panels.buttonfunctionality.popup.save;

import model.DnaFolder;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

// represents a button in which the user creates a new DnaFolder to save within a json file
public class SavePathButton extends JButton implements ActionListener {
    private JTextField textField;
    private String name;
    private JsonWriter jsonWriter;
    private String pathOfSave = "./data/";
    private JFrame frame;
    private DnaFolder dnaFolder;

    //MODIFIES: this
    //EFFECTS: sets up a SavePathButton, whose action is determined by actionPerformed method w/in
    //         this method.
    public SavePathButton(JTextField textField, JFrame frame, DnaFolder dnaFolder) {
        super("submit");
        this.frame = frame;
        this.dnaFolder = dnaFolder;
        this.addActionListener(this);
        this.textField = textField;
    }

    //EFFECTS: returns the name of the created Dna Folder
    public String getName() {
        return name;
    }

    //EFFECTS: saves the Dna Folder within a json file. FileNotFoundException should never be reached.
    private void saveDnaFolder() {
        try {
            jsonWriter.open();
            jsonWriter.write(dnaFolder);
            jsonWriter.close();
            System.out.println("Saved " + dnaFolder.getName() + " to " + pathOfSave);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + pathOfSave);
        }
    }

    //MODIFIES: this
    //EFFECTS: sets up a the name of the DnaFolder saved and creates a json file with the Dna folder. Disposes of the
    //         pop-up panel.
    @Override
    public void actionPerformed(ActionEvent e) {
        name = textField.getText();
        dnaFolder.setName(name);
        textField.setText("   ");
        pathOfSave += name + ".json";
        jsonWriter = new JsonWriter(pathOfSave);
        saveDnaFolder();
        frame.dispose();
        frame.setVisible(false);
    }
}
