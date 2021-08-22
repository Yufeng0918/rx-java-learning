package com.binance.reactive03;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ConnectableObservable {


    public static void main(String[] args) throws InterruptedException {

        io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<@NonNull Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();
        source.connect();

        source.subscribe(i -> System.out.println("Observer1 " + i));
        Thread.sleep(10000);

        source.subscribe(i -> System.out.println("Observer2 " + i));
        Thread.sleep(10000);

    }
}
