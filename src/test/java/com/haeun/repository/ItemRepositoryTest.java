package com.haeun.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.haeun.entity.Item;

@SpringBootTest
//H2 DB에 접속
//@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {

	@Autowired	//외부 객체 자동 주입
	ItemRepository itemRepository;
	
	@Test
	@DisplayName("상품 저장 코드 테스트")	//테스트 이름
	public void createItemTest() {	//INSERT
		
		//Setter로 데이터 값을 넣어주면 DB에 들어감
		
		for(int i=1; i<=10; i++) {
			Item item = new Item();
			item.setItemName("모나미볼펜" + i);
			item.setPrice(1000);
			item.setRegTime(LocalDateTime.now());	//현재시간입력
			item.setStockNumber(100);
			
			//itemRepository로 item 객체 반환
			Item savedItem = itemRepository.save(item);	//셋팅한 데이터 객체를 넣어줌
		}
	}
	
	@Test
	@DisplayName("상품 조회 테스트")
	public void findByItemNameTest() {
		
		this.createItemTest();
		List<Item> itemList = itemRepository.findByItemName("모나미볼펜1");
		
		for(Item item:itemList) {	
			System.out.println(item.toString());
		}		
	}
	
	@Test
	@DisplayName("모든 상품 조회 리스트 출력 테스트")
	public void findByItemListTest() {
		
		this.createItemTest();
		List<Item> itemList = itemRepository.findAll();	//전체 리스트가 반환되는 메소드
		
		for(Item item:itemList) {	
			System.out.println(item.toString());
		}		
	}
}
