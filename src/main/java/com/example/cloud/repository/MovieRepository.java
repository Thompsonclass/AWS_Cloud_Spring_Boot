package com.example.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cloud.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
