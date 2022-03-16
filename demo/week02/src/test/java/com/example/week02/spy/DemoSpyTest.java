package com.example.week02.spy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpyNoti extends NotiService {
    private int count;

    @Override
    void send() {
        count++;
    }
    public void verify(int i) {
        assertEquals(i, count);
    }
}

class Entity1 {

}

class Response1 {
    Entity1 enntity2;
}

public class DemoSpyTest {

    @Test
    public void case01() {
        SpyNoti spy = new SpyNoti();
        DemoFlow demoFlow = new DemoFlow(spy);
        demoFlow.process();

        // Called noti service 2 timces
        spy.verify(2);

    }

}
