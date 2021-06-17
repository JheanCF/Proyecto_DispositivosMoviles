package com.jp.proyecto_api.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Character {
   /* @SerializedName("url")
    private String idCharacter;*/

    @SerializedName("name")
    private String nameCharacter;

    @SerializedName("culture")
    private String  cultureCharacter;

    @SerializedName("aliases")
    private ArrayList<String> aliasCharacter;

    /*public String getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(String idCharacter) {
        this.idCharacter = idCharacter;
    }*/

    public String getNameCharacter() {
        return nameCharacter;
    }

    public void setNameCharacter(String nameCharacter) {
        this.nameCharacter = nameCharacter;
    }

    public String getCultureCharacter() {
        return cultureCharacter;
    }

    public void setCultureCharacter(String cultureCharacter) {
        this.cultureCharacter = cultureCharacter;
    }

    public ArrayList<String> getAliasCharacter() {
        return aliasCharacter;
    }

    public void setAliasCharacter(ArrayList<String> aliasCharacter) {
        this.aliasCharacter = aliasCharacter;
    }
}
