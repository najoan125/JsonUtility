package com.hyfata.json;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

class Utils {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537";
    protected static URLConnection getJsonUrlConnection(String url) throws IOException {
        URL temp = new URL(url);
        URLConnection connection = temp.openConnection();
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setRequestProperty("Accept", "application/json");
        return connection;
    }
}
