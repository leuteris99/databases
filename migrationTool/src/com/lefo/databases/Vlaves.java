package com.lefo.databases;

class Vlaves{
    private String ypalilos_id;
    private String ypalilos_eponymo;
    private String ypalilos_typos;
    private String syntirisi_id;
    private String syntirisi_perigrafi;
    private String syntirisi_timestamp;
    private String syntirisi_kodikos;
    private String syntirisi_oloklirothike;
    private String vlavi_idAutokinito;
    
    Vlaves(){
        //empty constructor
    }
    
    Vlaves(String ypalilos_id, String ypalilos_eponymo, String ypalilos_typos,
           String syntirisi_id, String syntirisi_perigrafi, String syntirisi_timestamp,
           String syntirisi_kodikos, String syntirisi_oloklirothike, String vlavi_idAutokinito){
        this.ypalilos_id = ypalilos_id;
        this.ypalilos_eponymo = ypalilos_eponymo;
        this.ypalilos_typos = ypalilos_typos;
        this.syntirisi_id = syntirisi_id;
        this.syntirisi_perigrafi = syntirisi_perigrafi;
        this.syntirisi_timestamp = syntirisi_timestamp;
        this.syntirisi_kodikos = syntirisi_kodikos;
        this.syntirisi_oloklirothike = syntirisi_oloklirothike;
        this.vlavi_idAutokinito = vlavi_idAutokinito;
    }

    // Getters and Setters for all the attributes

    public String getYpalilos_id() {
        return ypalilos_id;
    }

    public void setYpalilos_id(String ypalilos_id) {
        this.ypalilos_id = ypalilos_id;
    }

    public String getYpalilos_eponymo() {
        return ypalilos_eponymo;
    }

    public void setYpalilos_eponymo(String ypalilos_eponymo) {
        this.ypalilos_eponymo = ypalilos_eponymo;
    }

    public String getYpalilos_typos() {
        return ypalilos_typos;
    }

    public void setYpalilos_typos(String ypalilos_typos) {
        this.ypalilos_typos = ypalilos_typos;
    }

    public String getSyntirisi_id() {
        return syntirisi_id;
    }

    public void setSyntirisi_id(String syntirisi_id) {
        this.syntirisi_id = syntirisi_id;
    }

    public String getSyntirisi_perigrafi() {
        return syntirisi_perigrafi;
    }

    public void setSyntirisi_perigrafi(String syntirisi_perigrafi) {
        this.syntirisi_perigrafi = syntirisi_perigrafi;
    }

    public String getSyntirisi_timestamp() {
        return syntirisi_timestamp;
    }

    public void setSyntirisi_timestamp(String syntirisi_timestamp) {
        this.syntirisi_timestamp = syntirisi_timestamp;
    }

    public String getSyntirisi_kodikos() {
        return syntirisi_kodikos;
    }

    public void setSyntirisi_kodikos(String syntirisi_kodikos) {
        this.syntirisi_kodikos = syntirisi_kodikos;
    }

    public String getSyntirisi_oloklirothike() {
        return syntirisi_oloklirothike;
    }

    public void setSyntirisi_oloklirothike(String syntirisi_oloklirothike) {
        this.syntirisi_oloklirothike = syntirisi_oloklirothike;
    }

    public String getVlavi_idAutokinito() {
        return vlavi_idAutokinito;
    }

    public void setVlavi_idAutokinito(String vlavi_idAutokinito) {
        this.vlavi_idAutokinito = vlavi_idAutokinito;
    }

    // to string

    @Override
    public String toString() {
        return "Vlaves{" +
                "ypalilos_id='" + ypalilos_id + '\'' +
                ", ypalilos_eponymo='" + ypalilos_eponymo + '\'' +
                ", ypalilos_typos='" + ypalilos_typos + '\'' +
                ", syntirisi_id='" + syntirisi_id + '\'' +
                ", syntirisi_perigrafi='" + syntirisi_perigrafi + '\'' +
                ", syntirisi_timestamp='" + syntirisi_timestamp + '\'' +
                ", syntirisi_kodikos='" + syntirisi_kodikos + '\'' +
                ", syntirisi_oloklirothike='" + syntirisi_oloklirothike + '\'' +
                ", vlavi_idAutokinito='" + vlavi_idAutokinito + '\'' +
                '}';
    }
}