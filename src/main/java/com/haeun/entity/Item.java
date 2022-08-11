package com.haeun.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Entity	//클래스를 엔티티로 지정
@Table(name="item")	//엔티티 테이블 지정
@Data
public class Item {
	
	@Id	//테이블의 기본키 지정(어노테이션)
	@Column(name="item_id")	//테이블 컬럼과 필드를 매핑
	@GeneratedValue(strategy = GenerationType.AUTO)	//기본키 생성 전략
	private Long id;				//상품코드(기본키(PK))
	
	@Column(nullable = false, length = 50)	//null값 허용 여부(not null)와 길이 설정
	private String itemName;		//상품명
	
	@Column(nullable = false)	//not null
	private int price;				//상품가격
	
	@Column(nullable = false)
	private int stockNumber;		//상품재고수량
	
	
	private LocalDateTime regTime;	//상품등록시간
}
