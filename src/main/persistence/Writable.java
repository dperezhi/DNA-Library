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

public interface Writable {
    // EFFECTS: returns object as JSON object
    JSONObject toJson();
}
