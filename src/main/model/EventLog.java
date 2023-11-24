package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

// Citation: Paul Carter (2023) https://github.students.cs.ubc.ca/CPSC210/AlarmSystem
// Represents a log of DNA library events: using the Singleton pattern
public class EventLog implements Iterable<Event> {
    /** the only EventLog in the system (Singleton Design Pattern) */
    private static EventLog theLog;
    private Collection<Event> events;

    //MODIFIES: this
    //EFFECTS: initializes the events arraylist
    private EventLog() {
        events = new ArrayList<Event>();
    }

    //MODIFIES: this
    //EFFECTS: Gets instance of Event: internally constructs the class if not created
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }
        return theLog;
    }


    //EFFECTS: adds an event to the event log
    public void logEvent(Event e) {
        events.add(e);
    }


    //EFFECTS: Clears the event log and logs the event.
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    //EFFECTS: iterates over events list
    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
