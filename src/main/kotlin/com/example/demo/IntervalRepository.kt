package com.example.demo

import org.springframework.data.repository.CrudRepository

interface IntervalRepository : CrudRepository<IntervalEntity, Long>