package com.jp.proyecto_api.models;

import com.google.gson.annotations.SerializedName;

public class House {
    @SerializedName("name")
    private String nameHouse;

    @SerializedName("region")
    private String regionHouse;

    @SerializedName("coatOfArms")
    private String coatOfArmsHouse;

    public String getNameHouse() {
        return nameHouse;
    }

    public void setNameHouse(String nameHouse) {
        this.nameHouse = nameHouse;
    }

    public String getRegionHouse() {
        return regionHouse;
    }

    public void setRegionHouse(String regionHouse) {
        this.regionHouse = regionHouse;
    }

    public String getCoatOfArmsHouse() {
        return coatOfArmsHouse;
    }

    public void setCoatOfArmsHouse(String coatOfArmsHouse) {
        this.coatOfArmsHouse = coatOfArmsHouse;
    }
}
