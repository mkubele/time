package com.example.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.time.LocalTime

@SpringBootApplication
class DemoApplication {
	@Bean
	fun init(repository: IntervalRepository) = CommandLineRunner {
		repository.save(IntervalEntity(1, LocalTime.now(), LocalTime.now()))
		repository.save(IntervalEntity(2, LocalTime.now(), LocalTime.now()))

		repository.findAll()
	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
