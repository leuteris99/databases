package com.lefo.databases;

import com.google.gson.*;

import java.io.*;

class data_import{
    private static String file = "src\\com\\lefo\\databases\\databases2.json";

    public static void main(String[] args) {
        PelatesOximata[] pelatesOximataArray;
        Ergasies[] ergasiesArray;
        Vlaves[] vlavesArray;

        // creating a json instance
        Gson gson = new Gson();
        //loading the data from the file
        String data = load(file);

        // append the data to arrays
        JsonParser parser = new JsonParser();
        JsonObject d = parser.parse(data).getAsJsonObject();
        pelatesOximataArray = gson.fromJson(d.get("pelatesOximata"), PelatesOximata[].class);
        ergasiesArray = gson.fromJson(d.get("ergasies"), Ergasies[].class);
        vlavesArray = gson.fromJson(d.get("vlaves"), Vlaves[].class);

        //testing the data
        System.out.println(pelatesOximataArray[0].toString());
        System.out.println(ergasiesArray[0].toString());
        System.out.println(vlavesArray[0].toString());
    }

    // loads a file
    private static String load(String filename){
        FileInputStream fileInputStream = null;
        String data = "";

        try {
            fileInputStream = new FileInputStream(filename);
            StringBuilder sb = new StringBuilder();
            int checker;
            while ((checker = fileInputStream.read()) != -1){
                sb.append((char) checker);
            }

            data = sb.toString();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}