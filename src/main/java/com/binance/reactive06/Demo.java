package com.binance.reactive06;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class Demo {

	public static void main(String[] args) {

		@NonNull
		PublishSubject<String> subject = PublishSubject.create();

		//Thread safe
		@NonNull
		Subject<String> serialized = subject.toSerialized();
		
		serialized.subscribe(System.out::println);
		serialized.subscribe(e -> System.out.println("Observer 2 "+ e));
		
		serialized.onNext("Hello");
		serialized.onNext("BasicsStrong");
		serialized.onComplete();
		serialized.onNext("BasicsStrong");
	}
}
