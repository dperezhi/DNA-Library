package ui.panels.buttonFunctionality.popup;

import exceptions.InvalidCharForNucSeqException;
import model.Dna;
import model.DnaFolder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//NEED TO BE DELETED
public class GetNucleotideSeqFromUser extends JButton implements ActionListener {
    private Dna dna;
    private JTextField textField;
    private DnaFolder dnaFolder;
    private JFrame frame;

    public GetNucleotideSeqFromUser(Dna dna, JTextField textField, DnaFolder dnaFolder, JFrame frame) {
        super("submit");
        this.dna = dna;
        this.frame = frame;
        this.dnaFolder = dnaFolder;
        this.textField = textField;
        this.addActionListener(this);
    }

    //NOT DONE!!!
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        //Can't I just delete the if-statement and just add the implementation
        //How do I make it so that the frame work is reset
        if (s.equals("submit")) {
            try {
                dna.setNucleotideSequence(textField.getText());
                dnaFolder.addDna(dna);
            } catch (InvalidCharForNucSeqException ex) {
                frame = new AddDnaFrameInvalidCharacter(dnaFolder, frame);
            }
            textField.setText("   ");
        }
    }
}
