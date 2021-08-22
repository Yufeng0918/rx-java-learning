package com.binance.reactive01;


/**
 * @author daiyu
 */
public class S01CallbackSample {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("main is running");
        //Runnable r = () -> new S01CallbackSample().runningAysnc(() -> System.out.println("call back here"));
        Runnable r = () -> new S01CallbackSample().runningAysnc(new Callback2() {

            @Override
            public void pushData(String data) {
                System.out.println("push data: " + data);
            }

            @Override
            public void pushComplete() {
                System.out.println("completed");
            }

            @Override
            public void pushError(Exception ex) {
                System.out.println("callback error: " + ex);
            }
        });

        Thread t = new Thread(r);
        t.start();

        Thread.sleep(2000);
        System.out.println("main thread completed");
    }


    public void runningAysnc(Callback2 callBack) {
        System.out.println("running separate thread");
        sleep(1000);
        //callBack.call();
        callBack.pushData("data1");
        callBack.pushData("data2");
        callBack.pushData("data3");
        callBack.pushError(new RuntimeException("Oops"));
        callBack.pushComplete();
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
