package com.binance.reactive02;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {

    public static void main(String[] args) {

        Observable<String> source = Observable.create(
                e -> {
                    e.onNext("Hello");
                    e.onNext("RxJava");
                    e.onComplete();
                }
        );

        source.subscribe(
                e -> System.out.println("Observer 1 :"+e + " Thread Name : "+ Thread.currentThread().getName()),
                e -> {},
                () -> System.out.println("completed"));

        source.subscribe(e -> System.out.println("Observer 2 :"+e + " Thread Name : "+ Thread.currentThread().getName()));
    }
}
