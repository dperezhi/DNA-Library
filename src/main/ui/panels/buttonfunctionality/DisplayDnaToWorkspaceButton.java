package ui.panels.buttonfunctionality;

import model.Dna;
import ui.panels.workspace.MainContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// represents Button that allows the user to display a specific DNA's contents within the Workspace
public class DisplayDnaToWorkspaceButton extends JButton implements ActionListener {
    private Dna dna;
    private MainContent displayPanel;

    //MODIFIES: this
    //EFFECTS: sets up a DisplayDnaToWorkspaceButton, whose action is determined by actionPerformed method w/in
    //         this method.
    public DisplayDnaToWorkspaceButton(Dna dna, MainContent displayPanel) {
        this.dna = dna;
        this.displayPanel = displayPanel;
        this.addActionListener(this);
    }

    //EFFECTS: updates the DNA contents within the MainContent to those of the DNA selected
    @Override
    public void actionPerformed(ActionEvent e) {
        displayPanel.update(dna);
    }
}
