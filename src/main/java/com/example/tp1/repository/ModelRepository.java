package com.example.tp1.repository;

import com.example.tp1.model.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Models, Long> {
}
