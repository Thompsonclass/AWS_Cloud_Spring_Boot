package com.example.cloud.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.cloud.entity.Movie;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")  // "test" 프로파일을 사용
public class MyServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void contextLoads() {
        // 서비스가 제대로 로드되는지 확인하는 기본적인 테스트
        assertNotNull(movieService);
    }

    @Test
    void testGetAllMovies() {
        // 영화 목록이 정상적으로 반환되는지 확인하는 테스트
        var movies = movieService.getAllMovies();
        assertNotNull(movies);  // 영화 목록이 null이 아니어야 함
        assertTrue(movies.size() > 0);  // 영화 목록이 비어있지 않아야 함
    }

    @Test
    void testGetMovieById() {
        // 특정 영화 ID에 대한 조회 테스트 (영화가 존재한다고 가정)
        Long movieId = 1L;  // 실제 DB에 존재하는 영화 ID로 설정
        Movie movie = movieService.getMovieById(movieId);
        assertNotNull(movie);  // 영화가 null이 아니어야 함
        assertEquals(movieId, movie.getId());  // 영화 ID가 일치해야 함
    }
}
