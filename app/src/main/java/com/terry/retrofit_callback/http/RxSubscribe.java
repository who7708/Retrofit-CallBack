package com.terry.retrofit_callback.http;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * *
 * name     RxSubscribe
 * Creater  Terry
 * time     2017/8/7
 * *
 **/

public abstract class RxSubscribe<T> implements Observer<T> {

    public RxSubscribe() {
    }

    protected abstract void onSuccess(T t);

    protected void onFailed(int code, String msg) {
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        // 比如显示加载中对话框
    }

    @Override
    public void onComplete() {
        // 比如隐藏加载中对话框
    }

    @Override
    public void onNext(T baseModel) {
        onSuccess(baseModel);
    }

    @Override
    public void onError(Throwable t) {
        if (t instanceof HttpException) {
            HttpException ex = (HttpException) t;
            onFailed(ex.code(), ex.message());
        } else {
            onFailed(-1, t.getMessage());
        }
    }
}