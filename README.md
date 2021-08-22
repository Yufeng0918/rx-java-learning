# Rx Java



## 1. Reactive Programming

RxJava developed by Netflix

Interface: Flowable instead Observable

Reactive Stream Technology Compatiable Kit





### 1.1 Manifesto

**Responsive**: upperlimit of response time

**Resilient**: failure/error are same important as data

**Elastic**: horzontal scalling

**Message Driven**: async communication



### 1.2 Sync vs Async

program flow are independent, but call back is difficult to handle. Rxjava will resolve this



### 1.3 Callback

pass callback in async thread

```java
public class S01CallbackSample {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                new S01CallbackSample().runningAysnc(() -> System.out.println("call back here"));
            }
        };
        Thread t = new Thread(r);
        t.start();
  }

    public void runningAysnc(CallBack callBack) {
        System.out.println("running separate thread");
        callBack.call();
    }
 }   
```



### 1.4 Pull vs Push

Request/Response Model: pull

Rxjava: push



### 1.5 Observable & Observser

Observer register into subject

Subject setState and notify observers

Observer update based on event



### 1.6 Concurrent vs Parallel

**Concurrent**: multile task execute in same time

**Parallel**: multile task execute in different CPU





## 2. Observable vs Observer

### Observable

**subscribe()**: subscribe to observer via subscribe method

**onNext()**: pass each item on at time, **data channel**

**onComplete()**: indicate all action complete, **complete signal**

**onError()**: indicate error ocurr, error same important as data, **error signal** 



### Hot vs Cold

**Cold Observable**: data is replable

**Hot Observable**: only listen current active data



### Variants

**SingleObservable**: only react one item

**MaybeObservable**: may emit 0 or 1 item

**CompleteObservable**: only react complete action



### Disposable

dispose obserable

```java
Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS);

@NonNull
Disposable d1 = src.subscribe(e -> System.out.println("Observer 1 : "+ e));
Disposable d2 = src.subscribe(e -> System.out.println("Observer 2 : "+ e));
Thread.sleep(5000);

disp.addAll(d1, d2);
disp.dispose();
```



