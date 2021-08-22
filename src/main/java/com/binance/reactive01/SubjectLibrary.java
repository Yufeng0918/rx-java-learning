package com.binance.reactive01;

public interface SubjectLibrary {

    void subscribeObserver(Observer ob);

    void unsubscribeObserver(Observer ob);

    void notifyObserver();
}
