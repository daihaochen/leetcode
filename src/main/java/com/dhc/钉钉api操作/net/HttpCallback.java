package com.dhc.钉钉api操作.net;

public interface HttpCallback<T> {
    void onSuccess(T data);

    void onFail(String error);
}
