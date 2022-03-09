package com.example.week02.redis;

import com.redis.testcontainers.RedisContainer;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataRedisTest
@Testcontainers
@ContextConfiguration(initializers = MyDataRepositoryWithContainerTest.RedisInitializer.class)
public class MyDataRepositoryWithContainerTest {

    @Autowired
    private MyDataRepository myDataRepository;

    @Container
    private static RedisContainer redis =
            new RedisContainer(DockerImageName.parse("redis"))
            .withExposedPorts(6379);

    public static class RedisInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {

            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
                    applicationContext,
                    "spring.redis.host=" + redis.getHost(),
                    "spring.redis.port=" + redis.getFirstMappedPort()
            );
        }
    }

    @Test
    public void case01() {
        MyData dummy = new MyData(1, "data 1");
        MyData result = myDataRepository.save(dummy);
        assertEquals(dummy, result);
    }

}