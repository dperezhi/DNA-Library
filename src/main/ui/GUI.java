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

// Citation: https://introcs.cs.princeton.edu/java/15inout/GUI.java.html

//Creates a Graphical User Interface for the DNA Library
public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;

    private JButton button;
    private JLabel label;
    private JTextField textOne;

    private int count = 0;
    private DnaFolder dnaFolder;

    private JPanel displayDnaInfo;


    public GUI() {
        dnaFolder = new DnaFolder();
        testAddDna();
        frame = new JFrame("DNA library");

        label = new JLabel("0# DNAs in your Library");

        button = new JButton("Check add DNA to your Library!");
        button.addActionListener(this);

        textOne = new JTextField();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        panel.setLayout(new GridLayout(0,2));


        //panel.add(leftColumn());
        panel.add(new SideBar(dnaFolder));
        //panel.add(rightColumn());
        panel.add(new WorkSpace(dnaFolder));
        //panel.add(button);
        //panel.add(label);
        //panel.add(textOne);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1200, 750);            //sets frame size
        frame.setVisible(true);                          //to see the frame

    }


    /*public JPanel leftColumn() {
        JPanel p1 = new JPanel();
        p1.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        p1.setLayout(new GridLayout(0,1));
        p1.setBackground(Color.green);
        p1.setSize(new Dimension(250,500));


        p1.add(leftTop(),BorderLayout.CENTER);
        p1.add(leftBottom(),BorderLayout.CENTER);
        return p1;
    }*/

    /*public JPanel rightColumn() {
        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        p2.setLayout(new GridLayout(0,1));
        p2.setBackground(Color.red);

        p2.add(rightTop(),BorderLayout.CENTER);
        p2.add(rightBottom(),BorderLayout.CENTER);
        return p2;
    }*/

    /*public JPanel leftTop() {
        JPanel p3 = new JPanel();
        p3.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        p3.setLayout(new GridLayout(0,1));
        p3.setBackground(Color.blue);

        p3.add(leftTopTop());
        p3.add(leftTopBottom());

        return p3;
    }*/

    /*public JPanel leftTopTop() {
        JPanel p7 = new JPanel();
        p7.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        p7.setLayout(new GridLayout(0,3));
        p7.setBackground(Color.CYAN);

        ImageIcon logo = new ImageIcon("./src/main/img/logo.png");
        logo.setImage(logo.getImage().getScaledInstance(60,60, 1));
        JLabel labelForImg = new JLabel(logo);
        p7.add(labelForImg);

        JLabel l1 = new JLabel("My Library");
        p7.add(l1);

        JButton b1 = new JButton("+");
        p7.add(b1);

        return p7;
    }*/

    /*public JPanel leftTopBottom() {
        JPanel p8 = new JPanel();
        p8.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        p8.setLayout(new GridLayout(0,1));
        p8.setBackground(Color.YELLOW);

        JLabel l2 = new JLabel("SEARCH BAR: To be implemented...");
        p8.add(l2);

        return p8;
    }*/

    /*public JPanel leftBottom() {
        JPanel p4 = new JPanel();
        p4.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        p4.setLayout(new GridLayout(0,1));
        p4.setBackground(Color.MAGENTA);

        for (int i = 0; i < dnaFolder.getDnaFolder().size(); i++) {
            p4.add(addDnaToInterface(i));
        }
        return p4;
    }*/

    /*public JButton addDnaToInterface(int index) {
        JButton dnaButton = new JButton();
        JPanel dnaEntryPanel = new JPanel();
        dnaButton.add(dnaEntryPanel);

        dnaEntryPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        dnaEntryPanel.setLayout(new GridLayout(0,3));
        dnaEntryPanel.setBackground(Color.red);

        ImageIcon dnaLogo = new ImageIcon("./src/main/img/dna.png");
        dnaLogo.setImage(dnaLogo.getImage().getScaledInstance(35,35, 1));
        JLabel labelForImg = new JLabel(dnaLogo);
        dnaEntryPanel.add(labelForImg);

        String name = dnaFolder.getDnaFolder().get(index).getName();
        JLabel labelForName = new JLabel(name);
        dnaEntryPanel.add(labelForName);

        JMenuBar menuBar2 = new JMenuBar();
        JMenu menu = new JMenu("...");
        JMenuItem menuItem1 = new JMenuItem("Modify DNA");
        JMenuItem menuItem2 = new JMenuItem("Add MoClo flanks... to be implemented");
        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar2.add(menu);
        dnaEntryPanel.add(menuBar2);

        return dnaButton;
    }*/

    /*public JPanel rightTop() {
        JPanel p5 = new JPanel();
        p5.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        p5.setLayout(new GridLayout(0,4));
        p5.setBackground(Color.cyan);

        JButton b1 = new JButton("SAVE");
        p5.add(b1);

        JButton b2 = new JButton("LOAD");
        p5.add(b2);

        // p1.add(p1,BorderLayout.CENTER);
        return p5;
    }*/

    /*public JPanel rightBottom() {
        displayDnaInfo = new JPanel();
        displayDnaInfo.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        displayDnaInfo.setLayout(new GridLayout(0,1));
        displayDnaInfo.setBackground(Color.orange);

        // needs to be interactive
        displayDnaInfo.add(rightBottomTop(1));
        displayDnaInfo.add(rightBottomMiddle(1));
        displayDnaInfo.add(rightBottomBottom(1));

        // p1.add(p1,BorderLayout.CENTER);
        return displayDnaInfo;
    }*/

    /*public JPanel rightBottomTop(int index) {
        JPanel p9 = new JPanel();
        p9.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        p9.setLayout(new GridLayout(0,1));
        p9.setBackground(Color.PINK);

        JLabel l1 = new JLabel("Nucleotide Sequence: ");
        p9.add(l1);

        String nucleotideSequence = "5' - " + dnaFolder.getDnaFolder().get(index).getNucleotideSequence() + " - 3'";
        JLabel labelForNucSeq = new JLabel(nucleotideSequence);
        p9.add(labelForNucSeq);
        return p9;
    }*/

    /*public JPanel rightBottomMiddle(int index) {
        JPanel p10 = new JPanel();
        p10.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        p10.setLayout(new GridLayout(0,1));
        p10.setBackground(Color.green);

        JLabel l1 = new JLabel("Protein Sequence: ");
        p10.add(l1);

        String proteinSequence = "N - " + dnaFolder.getDnaFolder().get(index).getProteinSequence() + " - C";
        JLabel labelForProtSeq = new JLabel(proteinSequence);
        p10.add(labelForProtSeq);
        return p10;
    }*/

    /*public JPanel rightBottomBottom(int index) {
        JPanel p11 = new JPanel();
        p11.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        p11.setLayout(new GridLayout(0,2));
        p11.setBackground(Color.GRAY);

        String bpLength = "" + dnaFolder.getDnaFolder().get(index).getNucleotideSequence().length();
        JLabel labelBpLength = new JLabel("Length: " + bpLength + " bp");
        p11.add(labelBpLength);
        return p11;
    }*/

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
