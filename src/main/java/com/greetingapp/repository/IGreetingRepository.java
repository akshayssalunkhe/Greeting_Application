package com.greetingapp.repository;

import com.greetingapp.dto.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGreetingRepository extends JpaRepository<Greeting, Long> {
}
