package com.example.cloud.entity;
// 패키지 선언: 이 클래스가 속한 패키지를 정의합니다.

import java.util.ArrayList;
import java.util.List;
// Java의 기본 라이브러리에서 ArrayList와 List를 가져옵니다. List는 컬렉션 인터페이스이고, ArrayList는 그 구현체입니다.

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
// JPA 애너테이션을 가져옵니다. 데이터베이스 매핑과 관련된 기능을 제공합니다.

@Entity
// 이 클래스가 JPA 엔터티임을 나타냅니다. 데이터베이스 테이블에 매핑됩니다.
public class Movie {

	@Id
	// 데이터베이스에서 이 필드를 기본 키로 지정합니다.
	private int id;

	private String title;
	// 영화의 제목을 저장합니다.

	private String synopsis;
	// 영화의 줄거리를 저장합니다.

	private String imageUrl;
	// 영화의 이미지를 나타내는 URL을 저장합니다.

	@OneToMany(mappedBy = "movie")
	// 일대다 관계를 정의합니다. 이 경우, 하나의 Movie가 여러 개의 Review를 가질 수 있습니다.
	// mappedBy 속성은 관계의 주체가 Review 클래스의 "movie" 필드임을 나타냅니다.
	private List<Review> reviews = new ArrayList<>();
	// Movie와 연결된 Review 객체의 목록을 저장하는 컬렉션입니다.

	// Getters and Setters
	// 클래스 필드에 접근하고 값을 설정하기 위한 메서드입니다.

	public int getId() {
		// id 필드 값을 반환합니다.
		return id;
	}

	public void setId(int id) {
		// id 필드 값을 설정합니다.
		this.id = id;
	}

	public String getTitle() {
		// title 필드 값을 반환합니다.
		return title;
	}

	public void setTitle(String title) {
		// title 필드 값을 설정합니다.
		this.title = title;
	}

	public String getSynopsis() {
		// synopsis 필드 값을 반환합니다.
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		// synopsis 필드 값을 설정합니다.
		this.synopsis = synopsis;
	}

	public String getImageUrl() {
		// imageUrl 필드 값을 반환합니다.
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		// imageUrl 필드 값을 설정합니다.
		this.imageUrl = imageUrl;
	}

	public List<Review> getReviews() {
		// reviews 필드 값을 반환합니다.
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		// reviews 필드 값을 설정합니다.
		this.reviews = reviews;
	}
}
