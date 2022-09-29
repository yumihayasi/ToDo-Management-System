package com.example.task.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

// JpaRepositoryインターフェイスを継承
public interface UserRepository extends JpaRepository<Task, Long> {

}