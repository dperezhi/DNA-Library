package ui.panels.buttonFunctionality.popup;

import exceptions.InvalidCharForNucSeqException;
import model.Dna;
import model.DnaFolder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetDnaInfoFromUser extends JButton implements ActionListener {
    private Dna dna;
    private JTextField textName;
    private JTextField textOrganism;
    private JTextField textNucleotideSeq;
    private DnaFolder dnaFolder;
    private JFrame frame;
    private JFrame newFrame;

    public GetDnaInfoFromUser(Dna dna, JTextField textName, JTextField textOrganism,
                              JTextField textNucleotideSeq, DnaFolder dnaFolder, JFrame frame) {
        super("submit");
        this.dna = dna;
        this.textName = textName;
        this.textOrganism = textOrganism;
        this.textNucleotideSeq = textNucleotideSeq;
        this.dnaFolder = dnaFolder;
        this.frame = frame;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionString = e.getActionCommand();
        //Can't I just delete the if-statement and just add the implementation
        if (actionString.equals("submit")) {
            dna.setName(textName.getText());
            textName.setText("   ");
            dna.setOrganism(textOrganism.getText());
            textOrganism.setText("   ");

            //frame.setVisible(false);
            //frame.dispose();
            try {
                //frame.setVisible(false);
                //frame.dispose();
                dna.setNucleotideSequence(textNucleotideSeq.getText());
                dnaFolder.addDna(dna);
            } catch (InvalidCharForNucSeqException ex) {
                //frame.setVisible(false);
                //frame.dispose();
                newFrame = new AddDnaFrameInvalidCharacter(dnaFolder);
                //frame.setVisible(false);
                //frame.dispose();
            }
            frame.setVisible(false);
            frame.dispose();
            //newFrame.setVisible(false);
            //newFrame.dispose();
            textNucleotideSeq.setText("   ");
        }
    }
}
