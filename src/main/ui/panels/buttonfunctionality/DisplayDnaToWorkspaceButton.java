package ui.panels.buttonfunctionality;

import model.Dna;
import ui.panels.workspace.MainContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayDnaToWorkspaceButton extends JButton implements ActionListener {
    private Dna dna;
    private MainContent displayPanel;

    public DisplayDnaToWorkspaceButton(Dna dna, MainContent displayPanel) {
        this.dna = dna;
        this.displayPanel = displayPanel;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        displayPanel.update(dna);
    }
}
