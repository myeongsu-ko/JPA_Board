package com.cos.board.dto;

import com.cos.board.model.Board;

import lombok.Data;

@Data
public class BoardSaveRequestDto {
	private String title;
	private String content;
	
	//BoardSaveRequestDto 은 board랑 다른 객체니깐 BoardRepository
	//를 받을라면 Board 객체로 바까주야됨 그래서 toEntity 를 Board형으로 
	//바꾸는 작업이 필요
	public static Board toEntity(BoardSaveRequestDto dto) {
		Board board = Board.builder().title(dto.getTitle()).content(dto.getContent()).build();
		return board;
	}
	
	
}
