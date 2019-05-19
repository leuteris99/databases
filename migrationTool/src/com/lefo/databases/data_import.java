package com.lefo.databases;

import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;

class data_import{
    private static String fileInput = "src\\com\\lefo\\databases\\databases2.json";
    private static String fileOutput = "src\\com\\lefo\\databases\\insert.sql";

    public static void main(String[] args) {
        PelatesOximata[] pelatesOximataArray;
        Ergasies[] ergasiesArray;
        Vlaves[] vlavesArray;

        // creating a json instance
        Gson gson = new Gson();
        //loading the data from the fileInput
        String data = load(fileInput);

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

        //save(data,fileOutput);
    }

    private String insertToPelatis(PelatesOximata[] poArray){
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        for (PelatesOximata po : poArray) {
            boolean pelatisExist = false;
            for (String ch : checkerArray){
                if (ch.equals(po.getPelatis_id()))
                    pelatisExist = true;
            }
            if (!pelatisExist) {
                sb.append("insert into pelatis (pelatis_id, pelatis_Eponymo)")
                        .append("\n\tvalues (")
                        .append(po.getPelatis_id())
                        .append(", \"")
                        .append(po.getPelatis_Eponymo())
                        .append("\");\n");

                checkerArray.add(po.getPelatis_id());
            }
        }

        return sb.toString();
    }

    private String insertToAutokinito(PelatesOximata[] poArray){
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        for (PelatesOximata po : poArray) {
            boolean autokinitoExist = false;
            for (String ch : checkerArray){
                if (ch.equals(po.getAutokinito_id()))
                    autokinitoExist = true;
            }
            if (!autokinitoExist) {
                sb.append("insert into autokinito (autokinito_id, autokinito_arithmosKykloforias, montelo_id, pelatis_id)")
                        .append("\n\tvalues (")
                        .append(po.getAutokinito_id())
                        .append(", \"")
                        .append(po.getAutokinito_arithmosKykloforias())
                        .append("\", ")
                        .append(po.getMontelo_id())
                        .append(", ")
                        .append(po.getPelatis_id())
                        .append(");\n");

                checkerArray.add(po.getAutokinito_id());
            }
        }

        return sb.toString();
    }

    private String insertToMontelo(PelatesOximata[] poArray){
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        for (PelatesOximata po : poArray) {
            boolean monteloExist = false;
            for (String ch : checkerArray){
                if (ch.equals(po.getMontelo_id()))
                    monteloExist = true;
            }
            if (!monteloExist) {
                sb.append("insert into montelo (montelo_id, montelo_marka, montelo_typos, montelo_etos, montelo_kubismos)")
                        .append("\n\tvalues (")
                        .append(po.getMontelo_id())
                        .append(", \"")
                        .append(po.getMontelo_marka())
                        .append("\", \"")
                        .append(po.getMontelo_typos())
                        .append("\", ")
                        .append(po.getMontelo_etos())
                        .append(", ")
                        .append(po.getMontelo_kubismos())
                        .append(");\n");

                checkerArray.add(po.getMontelo_id());
            }
        }

        return sb.toString();
    }

    private String insertToErgasia(Ergasies[] erArray){
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        for (Ergasies er : erArray) {
            boolean ergasiaExist = false;
            for (String ch : checkerArray){
                if (ch.equals(er.getErgasia_id()))
                    ergasiaExist = true;
            }
            if (!ergasiaExist) {
                sb.append("insert into ergasia (ergasia_id, ergasia_AA, ergasia_xiliometra, ergasia_perigrafi, ergasia_typos, ergasia_kostos)")
                        .append("\n\tvalues (")
                        .append(er.getErgasia_id())
                        .append(", ")
                        .append(er.getErgasia_AA())
                        .append(", ")
                        .append(er.getErgasia_xiliometra())
                        .append(", \"")
                        .append(er.getErgasia_perigrafi())
                        .append("\", \"")
                        .append(er.getErgasia_typos())
                        .append("\", ")
                        .append(er.getErgasia_kostos())
                        .append(");\n");

                checkerArray.add(er.getErgasia_id());
            }
        }

        return sb.toString();
    }

    private String insertToYpalilos(Ergasies[] erArray){
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        for (Ergasies er : erArray) {
            boolean ypalilosExist = false;
            for (String ch : checkerArray){
                if (ch.equals(er.getYpalilos_id()))
                    ypalilosExist = true;
            }
            if (!ypalilosExist) {
                sb.append("insert into ypalilos (ypalilos_id, ypalilos_eponymo, ypalilos_typos)")
                        .append("\n\tvalues (")
                        .append(er.getYpalilos_id())
                        .append(", \"")
                        .append(er.getYpalilos_eponymo())
                        .append("\", \"")
                        .append(er.getYpalilos_typos())
                        .append("\");\n");

                checkerArray.add(er.getYpalilos_id());
            }
        }

        return sb.toString();
    }

    // type: the type of aitima -> 1 if syntirisi, 0 if vlavi
    private String insertToAitima(Ergasies[] erArray, Vlaves[] vlArray, boolean type){
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        int aitimaId = 0;

        for (Ergasies er : erArray) {
            for (Vlaves vl : vlArray) {
                boolean aitimaExist = false;
                for (String ch : checkerArray){
                    if (ch.equals(er.getSyntirisi_id()) || ch.equals(vl.getVlavi_idAutokinito()))
                        aitimaExist = true;
                }
                if (!aitimaExist && type) {
                    sb.append("insert into aitima (aitima_id, autokinito_id, syntirisi_perigrafi, syntirisi_timestamp, syntirisi_kodikos, syntirisi_oloklirothike)")
                            .append("\n\tvalues (")
                            .append(aitimaId)
                            .append(", ")
                            .append(er.getAutokinito_id())
                            .append(", \"")
                            .append(er.getSyntirisi_perigrafi())
                            .append("\", ")
                            .append(er.getSyntirisi_timestamp())
                            .append(", ")
                            .append(er.getSyntirisi_kodikos())
                            .append(", ")
                            .append(er.getSyntirisi_oloklirothike())
                            .append(");\n");

                    aitimaId++;
                    checkerArray.add(er.getSyntirisi_id());
                }else if (!aitimaExist){
                    sb.append("insert into aitima (aitima_id, autokinito_id, syntirisi_perigrafi, syntirisi_timestamp, syntirisi_kodikos, syntirisi_oloklirothike)")
                            .append("\n\tvalues (")
                            .append(aitimaId)
                            .append(", ")
                            .append(vl.getVlavi_idAutokinito())
                            .append(", \"")
                            .append(vl.getSyntirisi_perigrafi())
                            .append("\", ")
                            .append(vl.getSyntirisi_timestamp())
                            .append(", ")
                            .append(vl.getSyntirisi_kodikos())
                            .append(", ")
                            .append(vl.getSyntirisi_oloklirothike())
                            .append(");\n");

                    aitimaId++;
                    checkerArray.add(vl.getVlavi_idAutokinito());
                }
            }
        }

        return sb.toString();
    }


    // loads a fileInput
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
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return data;
    }

    // save to a fileOutput
    private static void save(String data, String fileName){
        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream(fileName);
            fos.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}