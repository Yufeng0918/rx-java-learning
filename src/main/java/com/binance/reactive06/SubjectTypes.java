package com.binance.reactive06;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.*;

public class SubjectTypes {

	public static void main(String[] args) throws InterruptedException {
		
//		Subject<Long> subject = UnicastSubject.create();
//
//		Observable.interval(500, TimeUnit.MILLISECONDS)
//		.subscribe(subject);
//
//		Thread.sleep(2000);
//		subject.subscribe(e -> System.out.println("Subscriber 1: "+ e));
//		Thread.sleep(2000);


//		Subject<String> subject1 = PublishSubject.create();
//		Subject<String> subject1 = ReplaySubject.create();
//		Subject<String> subject1 = BehaviorSubject.create();
//		Subject<String> subject1 = AsyncSubject.create();
//		Subject<String> subject1 = AsyncSubject.create();
		Subject<String> subject1 = UnicastSubject.create();
		subject1.subscribe(e -> System.out.println("Subscriber 1: "+ e));
		subject1.onNext("a");
		subject1.onNext("b");
		subject1.onNext("c");

//		subject1.subscribe(e -> System.out.println("Subscriber 2: "+ e));
//		subject1.onNext("d");
//		subject1.onNext("e");
//		subject1.onComplete();


	}

}
