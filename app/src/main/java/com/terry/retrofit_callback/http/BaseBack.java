package com.terry.retrofit_callback.http;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * *
 * name     BaseBack
 * Creater  Terry
 * time     2017/6/21
 * *
 **/

public abstract class BaseBack<T> implements Callback<T> {

    public BaseBack() {
    }

    protected abstract void onSuccess(T t);

    protected void onFailed(int code, String msg) {
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T baseModel = response.body();
        if (response.isSuccessful() && baseModel != null) {
            onSuccess(baseModel);
            // if (baseModel.code == 0) {
            // } else if (baseModel.code == 3) {
            //     //比如 做token无效统一处理
            //     onFailed(baseModel.code, baseModel.message);
            // } else {
            //     onFailed(baseModel.code, baseModel.message);
            // }
        } else {
            onFailed(response.code(), response.message());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof HttpException) {
            HttpException ex = (HttpException) t;
            onFailed(ex.code(), ex.message());
        } else {
            onFailed(-1, t.getMessage());
        }
    }
}
