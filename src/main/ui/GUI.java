package ui;

import exceptions.InvalidCharForNucSeqException;
import model.Dna;
import model.DnaFolder;
import ui.panels.sidebar.SideBar;
import ui.panels.workspace.WorkSpace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Creates a Graphical User Interface for the DNA Library
public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;

    private JButton button;
    private JTextField textOne;
    private JLabel label;

    private int count = 0;
    private DnaFolder dnaFolder;

    private JPanel displayDnaInfo;


    public GUI() {
        dnaFolder = new DnaFolder();
        testAddDna();

        frame = new JFrame("DNA library");
        button = new JButton("Check add DNA to your Library!");
        button.addActionListener(this);

        textOne = new JTextField();

        label = new JLabel("0 Dnas");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        panel.setLayout(new GridLayout(0,2));
        panel.add(new SideBar(dnaFolder));
        panel.add(new WorkSpace(dnaFolder));
        //panel.add(textOne);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1200, 750);            //sets frame size
        frame.setVisible(true);                          //to see the frame

    }

    public void testAddDna() {
        try {
            dnaFolder.addDna(new Dna("test1", "ATGATGATGATG", "B.Subtilis"));
            dnaFolder.addDna(new Dna("test2", "TTT", "B.Subtilis"));
            dnaFolder.addDna(new Dna("test3", "ATTAGTAT", "E.coli"));
            dnaFolder.addDna(new Dna("test4", "GCGAGAGTAA", "E.coli"));
        } catch (InvalidCharForNucSeqException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText(++count + "# DNAs in your Library");
    }
}
