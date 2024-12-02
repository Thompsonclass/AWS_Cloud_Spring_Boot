package com.example.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cloud.entity.Movie;
import com.example.cloud.entity.Review;
import com.example.cloud.repository.MovieRepository;
import com.example.cloud.repository.ReviewRepository;

@Service
@Transactional
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	// 모든 영화 목록을 가져오는 메서드
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	// 특정 영화의 상세 정보를 가져오는 메서드
	public Movie getMovieById(Long movieId) {
		return movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
	}

	// MovieService 수정: 예외 처리 및 메소드 최적화
	public void addReviewToMovie(Long movieId, Review review) {
	    Movie movie = movieRepository.findById(movieId)
	        .orElseThrow(() -> new RuntimeException("Movie not found for id: " + movieId));
	    
	    // 리뷰 객체에 영화 정보 설정
	    review.setMovie(movie);

	    // 리뷰 저장
	    reviewRepository.save(review);
	}


}
