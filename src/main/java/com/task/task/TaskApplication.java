package com.task.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@ComponentScan(basePackages={"com.task"})
@EntityScan("com.task.models")
@EnableJpaRepositories("com.task.repository")
public class TaskApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

}
