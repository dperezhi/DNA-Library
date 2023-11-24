package ui;

import model.Event;
import model.EventLog;

import javax.swing.*;
import java.awt.event.WindowEvent;

// creates new WindowAdapter to display event log when window is closed
public class WindowAdapter extends java.awt.event.WindowAdapter {
    private JFrame frame;

    // MODIFIES: this
    // EFFECTS: creates new WindowAdapter
    public WindowAdapter(JFrame frame) {
        this.frame = frame;
    }

    //EFFECTS: when the window closes the event log will be printed on the console
    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        for (Event event : EventLog.getInstance()) {
            System.out.println(event.toString());
        }
        frame.dispose();
    }
}
