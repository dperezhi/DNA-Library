package persistence;

import model.DnaFolder;
import org.json.JSONObject;
import java.io.*;

/*
 Citation
 Title: JsonSerializationDemo
 Author: Paul Carter
 Date: 24 Oct, 2023
 Code version: Java 11
 Availability: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */

public class JsonWriter {
    private static final int INDENT_FACTOR = 4;
    private PrintWriter writer;
    private String path;

    // EFFECTS: constructs Jsonwriter to set up a path to a file
    public JsonWriter(String path) {
        this.path = path;
    }

    // MODIFIES: this
    // EFFECTS: opens writer, if path to file can't be found for writing throws FileNotFoundException
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(path));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of workroom to file
    public void write(DnaFolder dnaFolder) {
        JSONObject json = dnaFolder.toJson();
        saveToFile(json.toString(INDENT_FACTOR));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes json to JSON file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
