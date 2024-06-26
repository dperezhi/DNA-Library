package ui.panels.buttonfunctionality;

import ui.panels.buttonfunctionality.popup.load.LoadPathButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// represents Button that allows one to load a dnaFolder within a json file
public class Load extends JButton implements ActionListener {
    private JFrame masterFrame;

    //MODIFIES: this
    //EFFECTS: sets up a load button within the File menu, whose action is determined by actionPerformed method w/in
    //         this method.
    public Load(JFrame masterFrame) {
        this.masterFrame = masterFrame;
        ImageIcon addIcon = new ImageIcon("./src/main/img/load-icon.png");
        addIcon.setImage(addIcon.getImage().getScaledInstance(64,64, 1));
        this.setIcon(addIcon);
        this.addActionListener(this);
    }

    //EFFECTS: sets up a new pop-up frame and panel in which one can load a DnaLibrary once the button is clicked,
    //         given the name of a file.
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame loadFrame = new JFrame("Load Library");
        JPanel loadPanel = new JPanel();
        loadPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        loadPanel.setLayout(new GridLayout(0,1));
        loadPanel.add(new Label("Load Dna Libary from: "));

        JTextField path = new JTextField("Enter the name of the loaded file");
        loadPanel.add(path);

        LoadPathButton loadPathButton = new LoadPathButton(path, loadFrame, masterFrame);
        loadPanel.add(loadPathButton);

        ImageIcon loadImage = new ImageIcon("./src/main/img/happy-cheetah.jpg");
        loadImage.setImage(loadImage.getImage().getScaledInstance(150,100, 1));
        JLabel labelForImg = new JLabel(loadImage);
        loadPanel.add(labelForImg);

        loadFrame.add(loadPanel, BorderLayout.CENTER);
        loadFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        loadFrame.pack();
        loadFrame.setSize(300, 400);
        loadFrame.setVisible(true);
    }
}
