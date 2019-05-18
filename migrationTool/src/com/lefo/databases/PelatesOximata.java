package com.lefo.databases;

class PelatesOximata{
    private String pelatis_id;
    private String pelatis_Eponymo;
    private String autokinito_id;
    private String autokinito_arithmosKykloforias;
    private String montelo_id;
    private String montelo_marka;
    private String montelo_typos;
    private String montelo_etos;
    private String montelo_kubismos;
    
    PelatesOximata(){
        //empty constructor
    }
    
    PelatesOximata(String pelatis_id, String pelatis_Eponymo, String autokinito_id,
                   String autokinito_arithmosKykloforias, String montelo_id,
                   String montelo_marka, String montelo_typos,String montelo_etos, String montelo_kubismos){
        this.pelatis_id = pelatis_id;
        this.pelatis_Eponymo = pelatis_Eponymo;
        this.autokinito_id = autokinito_id;
        this.autokinito_arithmosKykloforias = autokinito_arithmosKykloforias;
        this.montelo_id = montelo_id;
        this.montelo_marka = montelo_marka;
        this.montelo_typos = montelo_typos;
        this.montelo_etos = montelo_etos;
        this.montelo_kubismos = montelo_kubismos;
    }

    // Getters and Setters for all the attributes

    public String getPelatis_id() {
        return pelatis_id;
    }

    public void setPelatis_id(String pelatis_id) {
        this.pelatis_id = pelatis_id;
    }

    public String getPelatis_Eponymo() {
        return pelatis_Eponymo;
    }

    public void setPelatis_Eponymo(String pelatis_Eponymo) {
        this.pelatis_Eponymo = pelatis_Eponymo;
    }

    public String getAutokinito_id() {
        return autokinito_id;
    }

    public void setAutokinito_id(String autokinito_id) {
        this.autokinito_id = autokinito_id;
    }

    public String getAutokinito_arithmosKykloforias() {
        return autokinito_arithmosKykloforias;
    }

    public void setAutokinito_arithmosKykloforias(String autokinito_arithmosKykloforias) {
        this.autokinito_arithmosKykloforias = autokinito_arithmosKykloforias;
    }

    public String getMontelo_id() {
        return montelo_id;
    }

    public void setMontelo_id(String montelo_id) {
        this.montelo_id = montelo_id;
    }

    public String getMontelo_marka() {
        return montelo_marka;
    }

    public void setMontelo_marka(String montelo_marka) {
        this.montelo_marka = montelo_marka;
    }

    public String getMontelo_typos() {
        return montelo_typos;
    }

    public void setMontelo_typos(String montelo_typos) {
        this.montelo_typos = montelo_typos;
    }

    public String getMontelo_etos() {
        return montelo_etos;
    }

    public void setMontelo_etos(String montelo_etos) {
        this.montelo_etos = montelo_etos;
    }

    public String getMontelo_kubismos() {
        return montelo_kubismos;
    }

    public void setMontelo_kubismos(String montelo_kubismos) {
        this.montelo_kubismos = montelo_kubismos;
    }

    // to string

    @Override
    public String toString() {
        return "PelatesOximata{" +
                "pelatis_id='" + pelatis_id + '\'' +
                ", pelatis_Eponymo='" + pelatis_Eponymo + '\'' +
                ", autokinito_id='" + autokinito_id + '\'' +
                ", autokinito_arithmosKykloforias='" + autokinito_arithmosKykloforias + '\'' +
                ", montelo_id='" + montelo_id + '\'' +
                ", montelo_marka='" + montelo_marka + '\'' +
                ", montelo_typos='" + montelo_typos + '\'' +
                ", montelo_etos='" + montelo_etos + '\'' +
                ", montelo_kubismos='" + montelo_kubismos + '\'' +
                '}';
    }
}