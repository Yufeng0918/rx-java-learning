package com.binance.reactive05;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class MergeAndConcat {

    public static void main(String[] args) throws InterruptedException {

		Observable<String> src1 = Observable.just("Ella","Alexa","Lily");
		Observable<String> src2 = Observable.just("Priya","Chloe");

        Observable.merge(src1, src2).subscribe(e -> System.out.println("event " + e));

        Observable<String> src3 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src3 : "+e);
        Observable<String> src4 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src4 : "+e);
		Observable.merge(src3, src4)
		.subscribe(e -> System.out.println("Received : "+ e));

        src1.concatWith(src2)
                .subscribe(e -> System.out.println("Received : "+ e));

        Thread.sleep(20000);

    }

}
