package ui.panels.buttonFunctionality;

import model.DnaFolder;
import ui.panels.buttonFunctionality.popup.AddDnaFrame;
import ui.panels.buttonFunctionality.popup.AddDnaFrameInitial;
import ui.panels.sidebar.DnaDisplayed;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDnaToLibrary extends JButton implements ActionListener {
    private DnaFolder dnaFolder;
    private AddDnaFrame frame;
    private DnaDisplayed updateDnaDisplayPanel;

    public AddDnaToLibrary(DnaFolder dnaFolder, DnaDisplayed updateDnaDisplayPanel) {
        this.dnaFolder = dnaFolder;
        this.updateDnaDisplayPanel = updateDnaDisplayPanel;
        ImageIcon addIcon = new ImageIcon("./src/main/img/addIcon.png");
        addIcon.setImage(addIcon.getImage().getScaledInstance(30,30, 1));
        this.setIcon(addIcon);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame = new AddDnaFrameInitial(dnaFolder, updateDnaDisplayPanel);
    }
}
