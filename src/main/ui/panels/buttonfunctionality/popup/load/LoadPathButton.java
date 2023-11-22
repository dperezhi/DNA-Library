package ui.panels.buttonfunctionality.popup.load;

import model.DnaFolder;
import persistence.JsonReader;
import ui.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadPathButton extends JButton implements ActionListener {
    private JTextField textField;
    private String name;
    private JsonReader jsonReader;
    private String pathOfSave = "./data/";
    private JFrame popUpFrame;
    private JFrame masterFrame;
    private DnaFolder dnaFolder;
    private JPanel panel;

    public LoadPathButton(JTextField textField, JFrame popUpFrame, JFrame masterFrame, JPanel panel) {
        super("submit");
        this.panel = panel;
        this.textField = textField;
        this.popUpFrame = popUpFrame;
        this.masterFrame = masterFrame;
        this.addActionListener(this);
    }

    // Resiliency
    private void loadDnaFolder() {
        try {
            dnaFolder = jsonReader.read();
            //System.out.println("Loaded " + dnaFolder.getName() + " from " + pathOfSave);
            new GUI(dnaFolder);

            popUpFrame.dispose();
            popUpFrame.setVisible(false);

            masterFrame.dispose();
            masterFrame.setVisible(false);
        } catch (FileNotFoundException e) {
            panel.add(new Label("File not found."));
        } catch (IOException e) {
            panel.add(new Label("File not found."));
            //System.out.println("Unable to read from file: " + pathOfSave);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        name = textField.getText();
        textField.setText("   ");
        pathOfSave += name + ".json";
        jsonReader = new JsonReader(pathOfSave);
        loadDnaFolder();
    }
}
