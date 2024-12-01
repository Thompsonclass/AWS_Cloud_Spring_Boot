package com.example.cloud.repository;

import com.example.cloud.entity.Movie;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {

}
