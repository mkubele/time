package com.example.demo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalTime

@Entity(name = "interval")
data class IntervalEntity(
    @Id
	@GeneratedValue
    val id: Long = 0,
    val startTime: LocalTime,
	val endTime: LocalTime
)
