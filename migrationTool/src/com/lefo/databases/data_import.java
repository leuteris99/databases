/**
 * @author Lefteris Alexiou
 * @since 20/5/2019
 *
 * This class is a migration tool that takes a JSON file as an input and exports a SQL file containing the commands
 * to insert the data from the input file to a MySQL database.
 *
 * */

package com.lefo.databases;

import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;

class data_import {
    private static String fileInput = "src\\com\\lefo\\databases\\databases2.json";
    private static String fileOutput = "src\\com\\lefo\\databases\\insert.sql";

    public static void main(String[] args) {
        // create arrays with every object from the file
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

        // create an object to execute methods inside the data_import.java
        data_import di = new data_import();
        // adding escape characters to not confuse sql inside strings
        di.fixingErgasies(ergasiesArray);
        // changing data of syntirisi_oloklirothike to a boolean so it can pass correctly in sql
        di.changingSyntOlok(ergasiesArray);

        // append all the insert SQL commands to String Builder
        StringBuilder sqlOutput = new StringBuilder();
        sqlOutput.append(di.insertToPelatis(pelatesOximataArray))
                .append(di.insertToMontelo(pelatesOximataArray))
                .append(di.insertToAutokinito(pelatesOximataArray,ergasiesArray))
                .append(di.insertToErgasia(ergasiesArray))
                .append(di.insertToYpalilos(ergasiesArray))
                .append(di.insertToAitima(ergasiesArray, vlavesArray))
                .append(di.insertToVlavi(vlavesArray))
                .append(di.insertToSyntirisi(ergasiesArray))
                .append(di.insertToEksipiretisiVlavis(vlavesArray))
                .append(di.insertToEksipiretisiSyntirisis(ergasiesArray))
                .append(di.insertToProgrammaSyntirisis(ergasiesArray));
        // write the inserts from the string builder to a file
        save(sqlOutput.toString(), fileOutput);
    }

    /**
     * method that changes the syntirisi_oloklirothike var from a (Nai,Oxi) to a boolean
     * @param ergasiesArray an array with all the ergasies to convert their syntirisi_oloklirothike var.
     * */
    private void changingSyntOlok(Ergasies[] ergasiesArray){
        for (Ergasies er:ergasiesArray){
            String temp = er.getSyntirisi_oloklirothike();
            if (temp.equals("Nai")){
                er.setSyntirisi_oloklirothike("true");
            }else{
                er.setSyntirisi_oloklirothike("false");
            }
        }
    }

    /**
     * method that adds escape characters to an ergasies array.
     * @param ergasiesArray an array with all the ergasies that will be edit
     * */
    private void fixingErgasies(Ergasies[] ergasiesArray) {
        for (Ergasies er : ergasiesArray) {
            er.setSyntirisi_perigrafi(fixingEscapeChars(er.getSyntirisi_perigrafi()));
        }
    }

    /**
     * method that adds escape characters to a string and return it.
     * @param inputString the string that will be searched for escape chars.
     * @return the input string edited to have escape chars.
     * */
    private String fixingEscapeChars(String inputString) {
        final String[] escapeCharacters = {"'", "\""};

        for (int i = 0; i < escapeCharacters.length; i++) {
            if (inputString.contains(escapeCharacters[i])) {
                inputString = inputString.replace(escapeCharacters[i], "\\" + escapeCharacters[i]);
            }
        }
        return inputString;
    }


        /*
        * Insert SQL commands for all the tables
        * based from the arrays that contains the data from the input file.
        * */


    private String insertToPelatis(PelatesOximata[] poArray) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        for (PelatesOximata po : poArray) {
            boolean pelatisExist = false;
            for (String ch : checkerArray) {
                if (ch.equals(po.getPelatis_id()))
                    pelatisExist = true;
            }
            if (!pelatisExist) {
                sb.append("insert ignore into pelatis (pelatis_id, pelatis_Eponymo)")
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

    private String insertToAutokinito(PelatesOximata[] poArray, Ergasies[] erArray) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        for (PelatesOximata po : poArray) {
            boolean autokinitoExist = false;
            for (String ch : checkerArray) {
                if (ch.equals(po.getAutokinito_id()))
                    autokinitoExist = true;
            }
            if (!autokinitoExist) {
                sb.append("insert ignore into autokinito (autokinito_id, autokinito_arithmosKykloforias, montelo_id, pelatis_id)")
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

        for (Ergasies er : erArray) {
            boolean autokinitoExist = false;
            for (String ch : checkerArray) {
                if (ch.equals(er.getAutokinito_id()))
                    autokinitoExist = true;
            }
            if (!autokinitoExist) {
                sb.append("insert ignore into autokinito (autokinito_id, autokinito_arithmosKykloforias, montelo_id, pelatis_id)")
                        .append("\n\tvalues (")
                        .append(er.getAutokinito_id())
                        .append(", ")
                        .append("null")
                        .append(", ")
                        .append(er.getMontelo_id())
                        .append(", ")
                        .append("null")
                        .append(");\n");

                checkerArray.add(er.getAutokinito_id());
            }
        }

        return sb.toString();
    }

    private String insertToMontelo(PelatesOximata[] poArray) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        for (PelatesOximata po : poArray) {
            boolean monteloExist = false;
            for (String ch : checkerArray) {
                if (ch.equals(po.getMontelo_id()))
                    monteloExist = true;
            }
            if (!monteloExist) {
                sb.append("insert ignore into montelo (montelo_id, montelo_marka, montelo_typos, montelo_etos, montelo_kubismos)")
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

    private String insertToErgasia(Ergasies[] erArray) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        for (Ergasies er : erArray) {
            boolean ergasiaExist = false;
            for (String ch : checkerArray) {
                if (ch.equals(er.getErgasia_id()))
                    ergasiaExist = true;
            }
            if (!ergasiaExist) {
                sb.append("insert ignore into ergasia (ergasia_id, ergasia_AA, ergasia_xiliometra, ergasia_perigrafi, ergasia_typos, ergasia_kostos)")
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

    private String insertToYpalilos(Ergasies[] erArray) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        for (Ergasies er : erArray) {
            boolean ypalilosExist = false;
            for (String ch : checkerArray) {
                if (ch.equals(er.getYpalilos_id()))
                    ypalilosExist = true;
            }
            if (!ypalilosExist) {
                sb.append("insert ignore into ypalilos (ypalilos_id, ypalilos_eponymo, ypalilos_typos)")
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

    private String insertToAitima(Ergasies[] erArray, Vlaves[] vlArray) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        for (Ergasies er : erArray) {
            boolean aitimaExist = false;
            for (String ch : checkerArray) {
                if (ch.equals(er.getSyntirisi_id()))
                    aitimaExist = true;
            }
            if (!aitimaExist) {
                sb.append("insert ignore into aitima (syntirisi_id, autokinito_id, syntirisi_perigrafi, syntirisi_timestamp, syntirisi_kodikos, syntirisi_oloklirothike)")
                        .append("\n\tvalues (")
                        .append(er.getSyntirisi_id())
                        .append(", ")
                        .append(er.getAutokinito_id())
                        .append(", \"")
                        .append(er.getSyntirisi_perigrafi())
                        .append("\", \"")
                        .append(er.getSyntirisi_timestamp())
                        .append("\", ")
                        .append(er.getSyntirisi_kodikos())
                        .append(", ")
                        .append(er.getSyntirisi_oloklirothike())
                        .append(");\n");

                checkerArray.add(er.getSyntirisi_id());
            }
        }

        for (Vlaves vl : vlArray) {
            boolean aitimaExist = false;
            for (String ch : checkerArray) {
                if (ch.equals(vl.getSyntirisi_id()))
                    aitimaExist = true;
            }
            if (!aitimaExist) {
                sb.append("insert ignore into aitima (syntirisi_id, autokinito_id, syntirisi_perigrafi, syntirisi_timestamp, syntirisi_kodikos, syntirisi_oloklirothike)")
                        .append("\n\tvalues (")
                        .append(vl.getSyntirisi_id())
                        .append(", ")
                        .append(vl.getVlavi_idAutokinito())
                        .append(", \"")
                        .append(vl.getSyntirisi_perigrafi())
                        .append("\", \"")
                        .append(vl.getSyntirisi_timestamp())
                        .append("\", ")
                        .append(vl.getSyntirisi_kodikos())
                        .append(", ")
                        .append(vl.getSyntirisi_oloklirothike())
                        .append(");\n");

                checkerArray.add(vl.getSyntirisi_id());
            }
        }

        return sb.toString();
    }

    private String insertToVlavi(Vlaves[] vlArray) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        int vlavi_id = 0;

        for (Vlaves vl : vlArray) {
            boolean vlavesExist = false;
            for (String ch : checkerArray) {
                if (ch.equals(vl.getVlavi_id()))
                    vlavesExist = true;
            }
            if (!vlavesExist) {
                vl.setVlavi_id(String.valueOf(vlavi_id));

                sb.append("insert ignore into vlavi (vlavi_id, syntirisi_id)")
                        .append("\n\tvalues (")
                        .append(vl.getVlavi_id())
                        .append(", ")
                        .append(vl.getSyntirisi_id())
                        .append(");\n");

                vlavi_id++;
                checkerArray.add(vl.getVlavi_id());
            }
        }

        return sb.toString();
    }

    private String insertToSyntirisi(Ergasies[] erArray) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        int synt_id = 0;

        for (Ergasies er : erArray) {
            boolean syntirisiExist = false;
            for (String ch : checkerArray) {
                if (ch.equals(er.getSyntirisi_id()))
                    syntirisiExist = true;
            }
            if (!syntirisiExist) {
                er.setSynt_id(String.valueOf(synt_id));
                sb.append("insert ignore into syntirisi (synt_id, syntirisi_id)")
                        .append("\n\tvalues (")
                        .append(er.getSynt_id())
                        .append(", ")
                        .append(er.getSyntirisi_id())
                        .append(");\n");

                synt_id++;
                checkerArray.add(er.getSyntirisi_id());
            }
        }

        return sb.toString();
    }

    private String insertToEksipiretisiVlavis(Vlaves[] vlArray) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        for (Vlaves vl : vlArray) {
            boolean eksipiretisiVlavisExist = false;
            for (String ch : checkerArray) {
                if (ch.equals(vl.getYpalilos_id() + "-" + vl.getVlavi_id()))
                    eksipiretisiVlavisExist = true;
            }
            if (!eksipiretisiVlavisExist) {
                sb.append("insert ignore into eksipiretisi_vlavis (ypalilos_id, vlavi_id)")
                        .append("\n\tvalues (")
                        .append(vl.getYpalilos_id())
                        .append(", ")
                        .append(vl.getVlavi_id())
                        .append(");\n");

                checkerArray.add(vl.getYpalilos_id() + "-" + vl.getVlavi_id());
            }
        }

        return sb.toString();
    }

    private String insertToEksipiretisiSyntirisis(Ergasies[] erArray) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        for (Ergasies er : erArray) {
            boolean eksipiretisiSyntirisisExist = false;
            for (String ch : checkerArray) {
                if (ch.equals(er.getErgasia_id() + "-" + er.getSynt_id()))
                    eksipiretisiSyntirisisExist = true;
            }
            if (!eksipiretisiSyntirisisExist) {
                sb.append("insert ignore into eksipiretisi_syntirisis (ypalilos_id, ergasia_id, synt_id, eksypiretisiSyntirisis_timestamp)")
                        .append("\n\tvalues (")
                        .append(er.getYpalilos_id())
                        .append(", ")
                        .append(er.getErgasia_id())
                        .append(", ")
                        .append(er.getSynt_id())
                        .append(", \"")
                        .append(er.getEksypiretisiSyntirisis_timestamp())
                        .append("\");\n");

                checkerArray.add(er.getErgasia_id() + "-" + er.getSynt_id());
            }
        }

        return sb.toString();
    }

    private String insertToProgrammaSyntirisis(Ergasies[] erArray) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> checkerArray = new ArrayList<>();

        for (Ergasies er : erArray) {
            boolean programmaSyntirisisExist = false;
            for (String ch : checkerArray) {
                if (ch.equals(er.getErgasia_id() + "-" + er.getMontelo_id()))
                    programmaSyntirisisExist = true;
            }
            if (!programmaSyntirisisExist) {
                sb.append("insert ignore into programma_syntirisis (ergasia_id, montelo_id)")
                        .append("\n\tvalues (")
                        .append(er.getErgasia_id())
                        .append(", ")
                        .append(er.getMontelo_id())
                        .append(");\n");

                checkerArray.add(er.getErgasia_id() + "-" + er.getMontelo_id());
            }
        }

        return sb.toString();
    }

    /**
     *  method that reads a file
     * @param filename the name of the file that will be read
     * @return a string with the data that the file contains
     * */
    private static String load(String filename) {
        FileInputStream fileInputStream = null;
        String data = "";

        try {
            fileInputStream = new FileInputStream(filename);
            StringBuilder sb = new StringBuilder();
            int checker;
            while ((checker = fileInputStream.read()) != -1) {
                sb.append((char) checker);
            }

            data = sb.toString();
            System.out.println("File loaded.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return data;
    }

    /**
     * method that write data to a file
     * @param data the data to write in the file
     * @param fileName the name of the file we want to write to.
     * */
    private static void save(String data, String fileName) {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(fileName);
            fos.write(data.getBytes());
            System.out.println("File saved.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}