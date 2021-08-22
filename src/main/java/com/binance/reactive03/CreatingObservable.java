package com.binance.reactive03;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreatingObservable {

    public static void main(String[] args) {

        Observable<Integer> source = Observable.create(e -> {

            e.onNext(10);
            e.onNext(11);
            e.onNext(12);
            e.onNext(13);
            e.onComplete();
        });


        source.subscribe(System.out::println);

        Observable<Integer> just = Observable.just(1, 2, 3);
        just.subscribe(System.out::println);

        List<String> list = List.of("Ram", "Shyam", "Mike");
        Observable<String> iterator = Observable.fromIterable(list);
        iterator.subscribe(System.out::println);

        Observable<Integer> range = Observable.range(3, 10);
        range.subscribe(System.out::println);

    }
}
