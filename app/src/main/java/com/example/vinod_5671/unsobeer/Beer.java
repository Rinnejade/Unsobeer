package com.example.vinod_5671.unsobeer;

/**
 * Created by vinod-5671 on 30/06/18.
 */

public class Beer {
    private Double  ounces;
    private String id, name, style, abv, ibu;

    public Beer(String id, String name, String style, String abv, String ibu, Double ounces) {
        this.abv = abv;
        this.ibu = ibu;
        this.ounces = ounces;
        this.id = id;
        this.name = name;
        this.style = style;
    }

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }

    public String getIbu() {
        return ibu;
    }

    public void setIbu(String ibu) {
        this.ibu = ibu;
    }

    public Double getOunces() {
        return ounces;
    }

    public void setOunces(Double ounces) {
        this.ounces = ounces;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
