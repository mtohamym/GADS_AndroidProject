package com.tohamy.gads.Model;

import com.google.gson.annotations.SerializedName;

public class Hours {

    @SerializedName("name")
    private String name;

    @SerializedName("hours")
    private String hours;

    @SerializedName("country")
    private String country;

    @SerializedName("badgeUrl")
    private String badgeUrl;

  public Hours(String name, String hours, String country, String badgeUrl) {
    this.name = name;
    this.hours = hours;
    this.country = country;
    this.badgeUrl = badgeUrl;
  }

  public String getName() {
    return name;
  }

  public String getHours() {
    return hours;
  }

  public String getCountry() {
    return country;
  }

  public String getBadgeUrl() {
    return badgeUrl;
  }
}
