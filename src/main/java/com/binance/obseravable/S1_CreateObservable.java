package com.binance.obseravable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class S1_CreateObservable {

    public static void main(String[] args) throws InterruptedException {


        Scheduler scheduler = Schedulers.single();
        Observable<Task> taskObservable = Observable
                .fromIterable(DataSource.createTasksList())
                .subscribeOn(scheduler)
                .filter(task -> {
                    Thread.sleep(1000L);
                    return task.isComplete();
                })
                ;

        taskObservable.subscribe(new Observer<Task>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe is called");
            }

            @Override
            public void onNext(@NonNull Task task) {
                System.out.println("onNext " + Thread.currentThread().getName() + ", " + task.getDescription());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });


        TimeUnit.SECONDS.sleep(15L);
    }
}
