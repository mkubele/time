package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import java.time.LocalTime

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Test {

	companion object {
		@Container
		var postgres: PostgreSQLContainer<*> =
			PostgreSQLContainer<Nothing>("postgres:16.2")

		init {
			postgres.start()
		}

		@JvmStatic
		@DynamicPropertySource
		fun dynamicConfiguration(registry: DynamicPropertyRegistry) = registry.run {
			add("spring.datasource.url", postgres::getJdbcUrl)
			add("spring.datasource.username", postgres::getUsername)
			add("spring.datasource.password", postgres::getPassword)
		}
	}

	@Autowired
	private lateinit var repository: IntervalRepository

	@Test
	fun test() {
		repository.save(IntervalEntity(startTime = LocalTime.now(), endTime = LocalTime.now()))
		repository.findAll()
	}
}

