package ui.panels.buttonfunctionality;

import model.DnaFolder;
import persistence.JsonWriter;
import ui.panels.buttonfunctionality.popup.save.SavePathButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Save extends JButton implements ActionListener {
    private DnaFolder dnaFolder;
    private JFrame frame;

    public Save(DnaFolder dnaFolder) {
        this.dnaFolder = dnaFolder;
        ImageIcon addIcon = new ImageIcon("./src/main/img/save-icon.png");
        addIcon.setImage(addIcon.getImage().getScaledInstance(64,64, 1));
        this.setIcon(addIcon);
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame saveFrame = new JFrame("Save Library");
        JPanel savePanel = new JPanel();
        savePanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        savePanel.setLayout(new GridLayout(0,1));
        savePanel.add(new Label("Save the Dna Libary to: "));

        JTextField path = new JTextField("Enter the name of the saved file");
        savePanel.add(path);

        SavePathButton savePathButton = new SavePathButton(path, saveFrame, dnaFolder);
        savePanel.add(savePathButton);

        ImageIcon savedImage = new ImageIcon("./src/main/img/happy-cheetah.jpg");
        savedImage.setImage(savedImage.getImage().getScaledInstance(150,100, 1));
        JLabel labelForImg = new JLabel(savedImage);
        savePanel.add(labelForImg);

        saveFrame.add(savePanel, BorderLayout.CENTER);
        saveFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        saveFrame.pack();
        saveFrame.setSize(300, 400);
        saveFrame.setVisible(true);
    }
}
