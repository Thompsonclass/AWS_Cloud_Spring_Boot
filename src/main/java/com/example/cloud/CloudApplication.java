package com.example.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cloud.entity.Movie;
import com.example.cloud.repository.MovieRepository;

@SpringBootApplication
public class CloudApplication implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository; // MovieRepository 사용

    public static void main(String[] args) {
        SpringApplication.run(CloudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 초기 영화 데이터를 H2 데이터베이스에 삽입
        Movie movie1 = new Movie();
        movie1.setId("1");
        movie1.setTitle("더 문(The Moon)");
        movie1.setSynopsis("영화 \"더 문\"은 인류가 달로 가는 과정을 그린 SF 영화로, 주로 우주 탐사와 관련된 위기 상황을 다룹니다. 영화는 달 탐사 중 우주선이 예상치 못한 사고를 당하면서 시작됩니다. 인류 최초의 달 기지가 위기에 처하고, 이를 해결하기 위해 남은 자원과 지식을 총동원하여 구조 작업을 벌입니다.");
        movie1.setImageUrl("/a1.jpg");

        Movie movie2 = new Movie();
        movie2.setId("2");
        movie2.setTitle("백두산");
        movie2.setSynopsis("영화 \"백두산\"은 한반도와 중국에 걸쳐 있는 백두산 화산의 폭발을 중심으로 한 재난 영화입니다. 백두산 화산이 갑작스럽게 폭발할 위험에 처하고, 이를 막기 위해 국가와 전 세계의 다양한 사람들이 협력하여 재난을 막으려는 과정을 그립니다.");
        movie2.setImageUrl("/a2.jpg");

        movieRepository.save(movie1);
        movieRepository.save(movie2);

        System.out.println("Initial data has been added to the database.");
    }
}
