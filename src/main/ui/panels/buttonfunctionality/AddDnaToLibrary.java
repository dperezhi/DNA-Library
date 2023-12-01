package ui.panels.buttonfunctionality;

import model.DnaFolder;
import ui.panels.buttonfunctionality.popup.adddna.AddDnaFrameAbstract;
import ui.panels.buttonfunctionality.popup.adddna.AddDnaFrameInitial;
import ui.panels.sidebar.DnaDisplayed;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represents a button within the Header that allows the user to add DNA to the DNA name displayer
public class AddDnaToLibrary extends JButton implements ActionListener {
    private DnaFolder dnaFolder;
    private DnaDisplayed updateDnaDisplayPanel;

    //MODIFIES: this
    //EFFECTS: sets up a AddDnaToLibrary, whose action is determined by actionPerformed method w/in
    //         this method.
    public AddDnaToLibrary(DnaFolder dnaFolder, DnaDisplayed updateDnaDisplayPanel) {
        this.dnaFolder = dnaFolder;
        this.updateDnaDisplayPanel = updateDnaDisplayPanel;
        ImageIcon addIcon = new ImageIcon("./src/main/img/addIcon.png");
        addIcon.setImage(addIcon.getImage().getScaledInstance(30,30, 1));
        this.setIcon(addIcon);
        this.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: creates a new pop-up Frame and Panel where one can add a new DNA
    @Override
    public void actionPerformed(ActionEvent e) {
        new AddDnaFrameInitial(dnaFolder, updateDnaDisplayPanel);
    }
}
