package ui;

import exceptions.InvalidCharForNucSeqException;
import model.Dna;
import model.DnaFolder;
import ui.panels.sidebar.SideBar;
import ui.panels.workspace.MainContent;
import ui.panels.workspace.WorkSpace;

import javax.swing.*;
import java.awt.*;

//Creates a Graphical User Interface for the DNA Library
public class GUI {
    private JFrame frame;
    private JPanel panel;
    private DnaFolder dnaFolder;
    private MainContent workSpacePanel;

    //MODIFIES: this
    //EFFECTS: creates a new GRAPHICAL user interface of the Dna Library app when a DnaFolder is NOT provided
    public GUI() {
        dnaFolder = new DnaFolder();
        testAddDna();
        frameSetUp();
    }

    //MODIFIES: this
    //EFFECTS: creates a new GRAPHICAL user interface of the Dna Library app when a DnaFolder is provided
    public GUI(DnaFolder dnaFolder) {
        this.dnaFolder = dnaFolder;
        frameSetUp();
    }

    //EFFECTS: creates the new main frame and panel for the DNA library
    public void frameSetUp() {
        frame = new JFrame("DNA library");
        panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        panel.setLayout(new GridLayout(0,2));

        WorkSpace workSpace = new WorkSpace(dnaFolder, frame, this);
        SideBar sideBar = new SideBar(dnaFolder, workSpacePanel);

        panel.add(sideBar);
        panel.add(workSpace);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter(frame));
        frame.pack();
        frame.setSize(1200, 750);            //sets frame size
        frame.setVisible(true);                          //to see the frame
    }

    //MODIFIES: this
    //EFFECTS: adds DNAs to a test DnaFolder
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

    //MODIFIES: this
    //EFFECTS: sets up the workspace panel for future modifications
    public void setWorkSpacePanel(MainContent workSpacePanel) {
        this.workSpacePanel = workSpacePanel;
    }

}
