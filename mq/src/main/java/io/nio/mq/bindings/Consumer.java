package io.nio.mq.bindings;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Consumer {

    private CountDownLatch latch = new CountDownLatch(1);

    public void read(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
