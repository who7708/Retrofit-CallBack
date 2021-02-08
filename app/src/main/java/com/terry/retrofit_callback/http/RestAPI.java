package com.terry.retrofit_callback.http;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * *
 * name     RestAPI
 * Creater  Terry
 * time     2017/6/21
 * *
 **/

public interface RestAPI {

    @GET("/users/octocat")
    // Observable<BaseModel<User>> getRxUser();
    Observable<User> getRxUser();

    @GET("/users/octocat")
    // Call<BaseModel<User>> getUser();
    Call<User> getUser();

}
