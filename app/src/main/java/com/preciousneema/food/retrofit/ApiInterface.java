package com.preciousneema.food.retrofit;

import com.preciousneema.food.model.FoodData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("fooddata.json")
    Call<List<FoodData>> getAllData();

}
