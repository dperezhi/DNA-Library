package persistence;

import org.json.JSONObject;

/*
 Citation
 Title: JsonSerializationDemo
 Author: Paul Carter
 Date: 24 Oct, 2023
 Code version: Java 11
 Availability: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */

// Represents an interface that allows for an object to be returned as a JSON object
public interface Writable {

    // EFFECTS: returns object as JSON object
    JSONObject toJson();
}
