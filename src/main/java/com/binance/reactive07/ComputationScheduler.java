package com.binance.reactive07;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ComputationScheduler {

	public static void main(String[] args) throws InterruptedException {
		
		Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
				.subscribeOn(Schedulers.newThread());
		
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		
		Thread.sleep(5000);
	
	}
	
	
	public static void compute() throws InterruptedException {
		
			Thread.sleep(1000);
			System.out.println("Computation Done By : "+ Thread.currentThread().getName());
	}

}
