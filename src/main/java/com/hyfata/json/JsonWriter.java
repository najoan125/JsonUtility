package com.hyfata.json;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import org.json.JSONObject;

public class JsonWriter {
    public static void writeToFile(JSONObject obj, String path) throws IOException {
        try (PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"))) {
            out.write(obj.toString());
        }
    }
}
