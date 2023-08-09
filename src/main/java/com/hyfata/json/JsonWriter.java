package com.hyfata.json;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonWriter {
    public static void writeToFile(JSONObject obj, String path) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(obj.toString());
        }
    }
}
