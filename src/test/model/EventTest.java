package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

// Citation: Paul Carter (2023) https://github.students.cs.ubc.ca/CPSC210/AlarmSystem
public class EventTest {
    private Event e;
    private Date d;

    @BeforeEach
    public void runBefore() {
        e = new Event("Dna saved");
        d = Calendar.getInstance().getTime();
    }

    @Test
    public void testEvent() {
        assertEquals("Dna saved", e.getDescription());
        assertEquals(d, e.getDate());
    }

    @Test
    public void testEquals() {
        Event event = null;
        assertFalse(e.equals(event));
        Dna dna = new Dna();
        assertFalse(e.equals(dna));
    }

    @Test
    public void testHashCode() {
        assertEquals(e.hashCode(), e.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "Dna saved", e.toString());
    }
}
