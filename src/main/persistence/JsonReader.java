package persistence;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;


/*
 Citation
 Title: JsonSerializationDemo
 Author: Paul Carter
 Date: 24 Oct, 2023
 Code version: Java 11
 Availability: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */

// A reader that reads a Dna Folder from JSON data stored in file
public class JsonReader {
    private String path;

    // EFFECTS: constructs reader to read file from path
    public JsonReader(String path) {
        this.path = path;
    }

    // EFFECTS: reads Dna Folder data from file and returns the data; If error occurs throws IOException
    public DnaFolder read() throws IOException {
        String jsonData = readFile(path);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseDnaFolder(jsonObject);
    }

    // EFFECTS: parses DnaFolder from JSON object and returns it
    private DnaFolder parseDnaFolder(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        DnaFolder dnaFolder = new DnaFolder(name);
        addDnas(dnaFolder, jsonObject);
        return dnaFolder;
    }

    // MODIFIES: dnaFolder
    // EFFECTS: parses Dnas from JSON object and adds them to the DnaFolder
    private void addDnas(DnaFolder dnaFolder, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("DNA Sequences");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addDna(dnaFolder, nextThingy);
        }
    }

    // MODIFIES: dnaFolder
    // EFFECTS: parses Dna from JSON object and adds it to Dna Folder
    private void addDna(DnaFolder dnaFolder, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String sequence = jsonObject.getString("sequence");
        String organism = jsonObject.getString("organism");
        Dna dna = new Dna(name, sequence, organism);
        dnaFolder.addDna(dna);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
            stream.forEach(content::append);
        }
        return content.toString();
    }
}
