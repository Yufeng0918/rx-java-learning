package com.binance.reactive07;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComputationScheduler {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService service = Executors.newFixedThreadPool(20);

		Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
				.subscribeOn(Schedulers.from(service))
				.doFinally(service::shutdown);
		
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
