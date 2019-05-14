package com.al2.ddk.jee.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class JsonReader {
    private final String API_KEY = "63432dd659d5bef066257ac1e2788cf2";
    private final String API_URL = "https://api.themoviedb.org";
    private String requestURL;
    private static Logger logger = LogManager.getLogger(JsonReader.class);

    public JsonReader (String route) {
        this.requestURL = API_URL+route+"?api_key="+API_KEY;
    }

    public JsonReader (String route, String params) {
        this.requestURL = API_URL+route+"?api_key="+API_KEY+params;
    }

    public JsonObject getResult() {
        try {
            URL url = new URL(requestURL);
            URLConnection request = url.openConnection();
            request.connect();

            JsonParser parser = new JsonParser();
            JsonElement root = parser.parse(new InputStreamReader((InputStream) request.getContent()));
            return root.getAsJsonObject();
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
        return null;
    }
}
