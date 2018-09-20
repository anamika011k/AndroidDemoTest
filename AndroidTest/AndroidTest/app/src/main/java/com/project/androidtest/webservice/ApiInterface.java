package com.project.androidtest.webservice;

import com.project.androidtest.pojo.FactsResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by AnamikaKumari on 25/08/2018.
 */

public interface ApiInterface {
    @GET ("facts.json")
    Call<FactsResponse> getFactsResponse();
}
