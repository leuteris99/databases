package com.lefo.databases;

class Ergasies{
    private String montelo_id;
    private String autokinito_id;
    private String ergasia_id;
    private String ergasia_AA;
    private String ergasia_xiliometra;
    private String ergasia_perigrafi;
    private String ergasia_typos;
    private String ergasia_kostos;
    private String ypalilos_id;
    private String ypalilos_eponymo;
    private String ypalilos_typos;
    private String syntirisi_id;
    private String syntirisi_perigrafi;
    private String syntirisi_timestamp;
    private String syntirisi_kodikos;
    private String syntirisi_oloklirothike;
    private String eksypiretisiSyntirisis_timestamp;
    private String synt_id;
    
    Ergasies(){
        //empty constructor
    }
    
    Ergasies(String montelo_id, String autokinito_id, String ergasia_id, String ergasia_AA,
             String ergasia_xiliometra, String ergasia_perigrafi, String ergasia_typos,
             String ergasia_kostos, String ypalilos_id, String ypalilos_eponymo,
             String ypalilos_typos, String syntirisi_id, String syntirisi_perigrafi,
             String syntirisi_timestamp, String syntirisi_kodikos,
             String syntirisi_oloklirothike, String eksypiretisiSyntirisis_timestamp, String synt_id){
    this.montelo_id = montelo_id;
    this.autokinito_id = autokinito_id;
    this.ergasia_id = ergasia_id;
    this.ergasia_AA = ergasia_AA;
    this.ergasia_xiliometra = ergasia_xiliometra;
    this.ergasia_perigrafi = ergasia_perigrafi;
    this.ergasia_typos = ergasia_typos;
    this.ergasia_kostos = ergasia_kostos;
    this.ypalilos_id = ypalilos_id;
    this.ypalilos_eponymo = ypalilos_eponymo;
    this.ypalilos_typos = ypalilos_typos;
    this.syntirisi_id = syntirisi_id;
    this.syntirisi_perigrafi = syntirisi_perigrafi;
    this.syntirisi_timestamp = syntirisi_timestamp;
    this.syntirisi_kodikos = syntirisi_kodikos;
    this.syntirisi_oloklirothike = syntirisi_oloklirothike;
    this.eksypiretisiSyntirisis_timestamp = eksypiretisiSyntirisis_timestamp;
    this.synt_id = synt_id;
    }

    // Getters and Setters for all the attributes


    public String getMontelo_id() {
        return montelo_id;
    }

    public void setMontelo_id(String montelo_id) {
        this.montelo_id = montelo_id;
    }

    public String getAutokinito_id() {
        return autokinito_id;
    }

    public void setAutokinito_id(String autokinito_id) {
        this.autokinito_id = autokinito_id;
    }

    public String getErgasia_id() {
        return ergasia_id;
    }

    public void setErgasia_id(String ergasia_id) {
        this.ergasia_id = ergasia_id;
    }

    public String getErgasia_AA() {
        return ergasia_AA;
    }

    public void setErgasia_AA(String ergasia_AA) {
        this.ergasia_AA = ergasia_AA;
    }

    public String getErgasia_xiliometra() {
        return ergasia_xiliometra;
    }

    public void setErgasia_xiliometra(String ergasia_xiliometra) {
        this.ergasia_xiliometra = ergasia_xiliometra;
    }

    public String getErgasia_perigrafi() {
        return ergasia_perigrafi;
    }

    public void setErgasia_perigrafi(String ergasia_perigrafi) {
        this.ergasia_perigrafi = ergasia_perigrafi;
    }

    public String getErgasia_typos() {
        return ergasia_typos;
    }

    public void setErgasia_typos(String ergasia_typos) {
        this.ergasia_typos = ergasia_typos;
    }

    public String getErgasia_kostos() {
        return ergasia_kostos;
    }

    public void setErgasia_kostos(String ergasia_kostos) {
        this.ergasia_kostos = ergasia_kostos;
    }

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

    public String getEksypiretisiSyntirisis_timestamp() {
        return eksypiretisiSyntirisis_timestamp;
    }

    public void setEksypiretisiSyntirisis_timestamp(String eksypiretisiSyntirisis_timestamp) {
        this.eksypiretisiSyntirisis_timestamp = eksypiretisiSyntirisis_timestamp;
    }

    public String getSynt_id() {
        return synt_id;
    }

    public void setSynt_id(String synt_id) {
        this.synt_id = synt_id;
    }

    // to string
    @Override
    public String toString() {
        return "Ergasies{" +
                "montelo_id='" + montelo_id + '\'' +
                ", autokinito_id='" + autokinito_id + '\'' +
                ", ergasia_id='" + ergasia_id + '\'' +
                ", ergasia_AA='" + ergasia_AA + '\'' +
                ", ergasia_xiliometra='" + ergasia_xiliometra + '\'' +
                ", ergasia_perigrafi='" + ergasia_perigrafi + '\'' +
                ", ergasia_typos='" + ergasia_typos + '\'' +
                ", ergasia_kostos='" + ergasia_kostos + '\'' +
                ", ypalilos_id='" + ypalilos_id + '\'' +
                ", ypalilos_eponymo='" + ypalilos_eponymo + '\'' +
                ", ypalilos_typos='" + ypalilos_typos + '\'' +
                ", syntirisi_id='" + syntirisi_id + '\'' +
                ", syntirisi_perigrafi='" + syntirisi_perigrafi + '\'' +
                ", syntirisi_timestamp='" + syntirisi_timestamp + '\'' +
                ", syntirisi_kodikos='" + syntirisi_kodikos + '\'' +
                ", syntirisi_oloklirothike='" + syntirisi_oloklirothike + '\'' +
                ", eksypiretisiSyntirisis_timestamp='" + eksypiretisiSyntirisis_timestamp + '\'' +
                '}';
    }
}