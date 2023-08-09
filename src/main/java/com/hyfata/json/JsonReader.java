package com.hyfata.json;

import com.hyfata.json.exceptions.JsonEmptyException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class JsonReader {
    public static JSONObject readFromURL(String url) throws IOException, JsonEmptyException {
        URLConnection connection = Utils.getJsonUrlConnection(url);
        Scanner scanner = new Scanner(connection.getInputStream(), "UTF-8").useDelimiter("\\A");

        String json = scanner.hasNext() ? scanner.next() : "";
        if (json.equals("")) {
            throw new JsonEmptyException("Json URL is empty or it damaged!");
        }
        return new JSONObject(json);
    }

    public static JSONObject readFromURL(String url, int fromLine) throws IOException, JsonEmptyException {
        URLConnection connection = Utils.getJsonUrlConnection(url);

        // 데이터를 UTF-8로 읽을 수 있는 reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));

        // fromline까지 불필요한 줄 읽기
        for (int i = 0; i < fromLine - 1; i++) {
            reader.readLine();
        }

        // 데이터 읽기
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        reader.close();

        String json = stringBuilder.toString();
        if (json.equals("")) {
            throw new JsonEmptyException("Json URL is empty or it damaged!");
        }
        return new JSONObject(json);
    }

    public static JSONObject readFromFile(String path) throws IOException {
        String json = "";
        json = new String(
                Files.readAllBytes(Paths.get(path))
        );
        return new JSONObject(json);
    }
}
