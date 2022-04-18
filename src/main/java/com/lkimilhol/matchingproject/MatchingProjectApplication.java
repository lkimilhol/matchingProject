package com.lkimilhol.matchingproject;

import java.util.PriorityQueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MatchingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchingProjectApplication.class, args);

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(1);

		queue.stream().sorted();
	}

}
