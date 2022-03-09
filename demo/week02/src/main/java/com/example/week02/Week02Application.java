package com.example.week02;

import com.example.week02.scope.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Week02Application {

	public static void main(String[] args) {
		// Demo with scope of bean
		ConfigurableApplicationContext context
				 = SpringApplication.run(Week02Application.class, args);

		Employee employee1 = context.getBean(Employee.class);
		Employee employee2 = context.getBean(Employee.class);

		System.out.println("Employee 1 => " + employee1);
		System.out.println("Employee 2 => " + employee2);

	}

}
