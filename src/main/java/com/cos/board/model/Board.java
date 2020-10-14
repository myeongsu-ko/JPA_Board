package com.cos.board.model;

import java.sql.Date;
import java.sql.Timestamp; //중요!

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data //-> Getter,Setter 합쳐져있음. toString도 구현되어 있음.
//@Setter
//@Getter
@AllArgsConstructor //모두를 다 받는 생성자 (전체 파라메터를 가진 생성자)
@NoArgsConstructor //디폴트 생성자 (파라메터가 없는 생성자)
@Builder //빌더 패턴
@Entity // ORM
public class Board {
	@Id // 기본키 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) //해당 데이터베이스 번호증가 전략을 따라가기
	private int id;
	private String title;
	private String content;
	private int readCount;
	@CreationTimestamp
	//@JsonFormat(pattern = "yyyy-mm-dd",timezone = "Asia/Seoul")
	private Date createDate;
	

	
	
}
