package ui.panels.buttonfunctionality.popup.save;

import model.DnaFolder;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class SavePathButton extends JButton implements ActionListener {
    private JTextField textField;
    private String name;
    private JsonWriter jsonWriter;
    private String pathOfSave = "./data/";
    private JFrame frame;
    private DnaFolder dnaFolder;

    public SavePathButton(JTextField textField, JFrame frame, DnaFolder dnaFolder) {
        super("submit");
        this.frame = frame;
        this.dnaFolder = dnaFolder;
        this.addActionListener(this);
        this.textField = textField;
    }

    public String getName() {
        return name;
    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        name = textField.getText();
        textField.setText("   ");
        pathOfSave += name + ".json";
        jsonWriter = new JsonWriter(pathOfSave);
        saveDnaFolder();

        frame.dispose();
        frame.setVisible(false);
    }
}
