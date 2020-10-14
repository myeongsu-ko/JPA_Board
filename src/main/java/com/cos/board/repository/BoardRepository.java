package com.cos.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.board.model.Board;

//이 레파지토리는 보드를 관리하고 프라이머리키의 타입 적기
// 자동 Ioc 등록됨. JpaRepository가 내부적으로 들고 있음.
// JpaRepository에는 CRUD가 기본적으로 다 적용되어 있음. 
public interface BoardRepository extends JpaRepository<Board, Integer> {
	//public abstract 생략
	@Query(value = "select * from board where id =:id",nativeQuery = true)
	Board mFindById(int id);
	
	@Modifying //수정,삭제, 저장 // 이게 걸려있어야 변경하고 커밋함.
	@Query(value = "delete from board where id=:id",nativeQuery = true)
	int mdeleteById(int id);
	
}
