package com.tohamy.gads.data;

import com.tohamy.gads.Model.Hours;
import com.tohamy.gads.Model.SkillIq;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserInterface {


    @GET("/api/hours")
    Call<List<Hours>> getAllLeadersHours();

    @GET("/api/skilliq")
    Call<List<SkillIq>> getallSqillTop();

}
