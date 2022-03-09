package com.example.week02.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;

import static org.junit.jupiter.api.Assertions.*;

@DataRedisTest
class MyDataRepositoryTest {

    @Autowired
    private MyDataRepository myDataRepository;

    @Test
    public void case01() {
        MyData dummy = new MyData(1, "data 1");
        MyData result = myDataRepository.save(dummy);
        assertEquals(dummy, result);
    }

}