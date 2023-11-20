package ui.panels.workspace;

import javax.swing.*;
import java.awt.*;

public class FileMenu extends JPanel {

    public FileMenu() {
        //JPanel p5 = new JPanel();
        this.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        this.setLayout(new GridLayout(0,4));
        this.setBackground(Color.cyan);

        //package ui.panels.buttonFunctionality.Save
        JButton b1 = new JButton("SAVE");
        this.add(b1);

        //package ui.panels.buttonFunctionality.Load
        JButton b2 = new JButton("LOAD");
        this.add(b2);

        // p1.add(p1,BorderLayout.CENTER);
    }
}
