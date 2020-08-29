package com.tohamy.gads.Model;

import com.google.gson.annotations.SerializedName;

public class SkillIq {

    @SerializedName("name")
    private String name;

    @SerializedName("score")
    private String Score;
    @SerializedName("country")
    private String country;

    @SerializedName("badgeUrl")
    private String badgeUrl;
    public String getName() {
        return name;
    }

    public String getScore() {
        return Score;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }



    public SkillIq(String name, String score, String country, String badgeUrl) {
        this.name = name;
        Score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }
}
