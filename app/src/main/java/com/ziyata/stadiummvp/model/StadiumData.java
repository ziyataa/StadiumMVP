package com.ziyata.stadiummvp.model;

import com.google.gson.annotations.SerializedName;

public class StadiumData {
    @SerializedName("idTeam")
    private String idTeam;

    @SerializedName("strStadium")
    private String strStadium;

    @SerializedName("strStadiumThumb")
    private String strStadiumThumb;

    @SerializedName("strStadiumDescription")
    private String strStadiumDescription;

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    public void setStrStadiumThumb(String strStadiumThumb) {
        this.strStadiumThumb = strStadiumThumb;
    }

    public String getStrStadiumDescriptiom() {
        return strStadiumDescription;
    }

    public void setStrStadiumDescriptiom(String strStadiumDescriptiom) {
        this.strStadiumDescription = strStadiumDescriptiom;
    }
}
