package com.project.androidtest.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AnamikaKumari on 25/08/2018.
 */

public class ApiClient {

    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        //if(retrofit != null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
       // }
        return retrofit;
    }

}
