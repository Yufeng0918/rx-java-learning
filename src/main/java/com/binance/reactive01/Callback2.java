package com.binance.reactive01;

public interface Callback2 {

    void pushData(String data);

    void pushComplete();

    void pushError(Exception ex);
}
