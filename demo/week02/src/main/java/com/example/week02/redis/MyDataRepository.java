package com.example.week02.redis;

import org.springframework.data.repository.CrudRepository;

public interface MyDataRepository extends CrudRepository<MyData, Integer> {
}
