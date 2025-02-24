package com.cine.kata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cine.kata.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
