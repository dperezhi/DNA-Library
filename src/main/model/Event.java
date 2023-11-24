package model;

import java.util.Calendar;
import java.util.Date;

// Citation: Paul Carter (2023) https://github.students.cs.ubc.ca/CPSC210/AlarmSystem
// Represents an event which happens inside the DNA Library
public class Event {
    private static final int HASH_CONSTANT = 13;
    private Date dateLogged;
    private String description;

    // MODIFIES: this
    // EFFECTS: creates an even with a given description, the current date/time
    public Event(String description) {
        dateLogged = Calendar.getInstance().getTime();
        this.description = description;
    }

    // EFFECTS: Gets the date and time of this event
    public Date getDate() {
        return dateLogged;
    }

    // EFFECTS: gets the description of the event
    public String getDescription() {
        return description;
    }


    //EFFECTS: return true if the given object is equal to this object, else false.
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Event otherEvent = (Event) other;

        return (this.dateLogged.equals(otherEvent.dateLogged) && this.description.equals(otherEvent.description));
    }

    //EFFECTS: returns hashcode
    @Override
    public int hashCode() {
        return (HASH_CONSTANT * dateLogged.hashCode() + description.hashCode());
    }

    //EFFECTS: return String of the date log and description
    @Override
    public String toString() {
        return dateLogged.toString() + "\n" + description + "\n";
    }
}
