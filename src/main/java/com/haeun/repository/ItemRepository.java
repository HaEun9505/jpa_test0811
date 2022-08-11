package com.haeun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haeun.entity.Item;

//기본적으로 CRUD 메소드를 제공함
public interface ItemRepository extends JpaRepository<Item, Long> {	//entity클래스명, 기본키 데이터 타입
		
	List<Item> findByItemName(String ItemName);	//리스트 조회
	
}
