package ui.panels.buttonfunctionality.popup.adddna;

import exceptions.InvalidCharForNucSeqException;
import model.Dna;
import model.DnaFolder;
import ui.panels.sidebar.DnaDisplayed;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// represents a button in which the user's inputs for the addition of a DNA are used to add a new DNA to their library
public class GetDnaInfoFromUser extends JButton implements ActionListener {
    private Dna dna;
    private JTextField textName;
    private JTextField textOrganism;
    private JTextField textNucleotideSeq;
    private DnaFolder dnaFolder;
    private JFrame frame;
    private JFrame newFrame;
    private DnaDisplayed updateDnaDisplayPanel;

    //MODIFIES: this
    //EFFECTS: sets up a GetDnaInfoFromUser button, whose action is determined by actionPerformed method w/in
    //         this method.
    public GetDnaInfoFromUser(JTextField textName, JTextField textOrganism, JTextField textNucleotideSeq,
                              DnaFolder dnaFolder, JFrame frame, DnaDisplayed updateDnaDisplayPanel) {
        super("submit");
        this.dna = new Dna();
        this.textName = textName;
        this.textOrganism = textOrganism;
        this.textNucleotideSeq = textNucleotideSeq;
        this.updateDnaDisplayPanel = updateDnaDisplayPanel;
        this.dnaFolder = dnaFolder;
        this.frame = frame;
        this.addActionListener(this);
        //
    }

    //MODIFIES: this
    //EFFECTS: if the nucleotide sequence input for the new dna is valid, the DNA is added to the Dna Display panel
    //         within the sidebar panel. If it is not valid InvalidCharForNucSeqException is caught and new pop-up
    //         frame: AddDnaFrameInvalidCharacter is created. The current pop-up frame is disposed once the button is
    //         clicked.
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionString = e.getActionCommand();
        if (actionString.equals("submit")) {
            dna.setName(textName.getText());
            textName.setText("   ");
            dna.setOrganism(textOrganism.getText());
            textOrganism.setText("   ");

            try {
                dna.setNucleotideSequence(textNucleotideSeq.getText());
                dnaFolder.addDna(dna);
                updateDnaDisplayPanel.addExtraDnaToInterface();
            } catch (InvalidCharForNucSeqException ex) {
                newFrame = new AddDnaFrameInvalidCharacter(dnaFolder, updateDnaDisplayPanel);
            }
            frame.setVisible(false);
            frame.dispose();
            textNucleotideSeq.setText("   ");
        }
    }
}
