package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Citation: Paul Carter (2023) https://github.students.cs.ubc.ca/CPSC210/AlarmSystem
public class EventLogTest {
    private Event event1;
    private Event event2;
    private Event event3;

    @BeforeEach
    public void loadEvents() {
        event1 = new Event("dna saved");
        event2 = new Event("dna loaded");
        event3 = new Event("dna folder created");
        EventLog el = EventLog.getInstance();
        el.logEvent(event1);
        el.logEvent(event2);
        el.logEvent(event3);
    }

    @Test
    public void testLogEvent() {
        List<Event> l = new ArrayList<Event>();

        EventLog el = EventLog.getInstance();
        for (Event next : el) {
            l.add(next);
        }

        assertTrue(l.contains(event1));
        assertTrue(l.contains(event2));
        assertTrue(l.contains(event3));
    }

    @Test
    public void testClear() {
        EventLog el = EventLog.getInstance();
        el.clear();
        Iterator<Event> itr = el.iterator();
        assertTrue(itr.hasNext());
        assertEquals("Event log cleared.", itr.next().getDescription());
        assertFalse(itr.hasNext());
    }
}
