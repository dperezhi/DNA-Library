package ui.panels.buttonFunctionality.popup;

import model.Dna;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//NEED TO BE DELETED
public class GetOrganismFromUser extends JButton implements ActionListener {
    private Dna dna;
    private JTextField textField;

    public GetOrganismFromUser(Dna dna, JTextField textField) {
        super("submit");
        this.dna = dna;
        this.textField = textField;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        //Can't I just delete the if-statement and just add the implementation
        if (s.equals("submit")) {
            dna.setOrganism(textField.getText());
            textField.setText("   ");
        }
    }
}