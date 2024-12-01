package com.example.cloud.entity;

import jakarta.persistence.Entity;  // JPA Entity로 지정하는 어노테이션, 데이터베이스 테이블과 매핑됩니다.
import jakarta.persistence.GeneratedValue;  // 기본 키 생성 전략을 설정하는 어노테이션
import jakarta.persistence.GenerationType;  // 생성 전략을 지정하는 어노테이션
import jakarta.persistence.Id;  // 이 필드가 테이블의 기본 키임을 나타내는 어노테이션
import jakarta.persistence.JoinColumn;  // 외래 키를 나타내는 어노테이션
import jakarta.persistence.ManyToOne;  // 다대일 관계를 나타내는 어노테이션

@Entity  // 이 클래스가 JPA 엔티티임을 나타내며, 데이터베이스 테이블에 매핑됩니다.
public class Review {

    @Id  // 기본 키 필드를 지정합니다. JPA에서 기본 키는 반드시 필요합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 기본 키 생성 전략을 설정합니다. 이 경우 데이터베이스가 자동으로 기본 키 값을 생성합니다.
    private Long id;  // 리뷰의 고유 ID (Primary Key)

    private String content;  // 리뷰 내용

    private int rating;  // 리뷰의 별점 (1~5)

    @ManyToOne  // 여러 리뷰가 하나의 영화에 속하므로 다대일 관계입니다.
    @JoinColumn(name = "movie_id")  // 외래 키인 "movie_id" 컬럼으로 매핑됩니다. 해당 리뷰가 어떤 영화를 참조하는지 표시합니다.
    private Movie movie;  // 이 리뷰가 속한 영화 객체

    // 기본 생성자와 getter, setter 메서드들

    public Long getId() {
        return id;  // 리뷰 ID 반환
    }

    public void setId(Long id) {
        this.id = id;  // 리뷰 ID 설정
    }

    public String getContent() {
        return content;  // 리뷰 내용 반환
    }

    public void setContent(String content) {
        this.content = content;  // 리뷰 내용 설정
    }

    public int getRating() {
        return rating;  // 별점 반환
    }

    public void setRating(int rating) {
        this.rating = rating;  // 별점 설정
    }

    public Movie getMovie() {
        return movie;  // 이 리뷰에 속한 영화 객체 반환
    }

    public void setMovie(Movie movie) {
        this.movie = movie;  // 이 리뷰에 속한 영화 객체 설정
    }
}
