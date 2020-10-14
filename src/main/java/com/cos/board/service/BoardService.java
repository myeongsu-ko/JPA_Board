package com.cos.board.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;//import 유의

import com.cos.board.config.ex.MyArgsNotFound;
import com.cos.board.dto.BoardSaveRequestDto;
import com.cos.board.model.Board;
import com.cos.board.repository.BoardRepository;

@Service
public class BoardService {
	
	// 의존성 주입 DI
	@Autowired
	private BoardRepository boardRepository;
	
	//보통은 DB의 변경이 일어났을 때 @Transactional 걸어준다
	@Transactional
	public void 글쓰기(BoardSaveRequestDto dto) {
		Board boardEntity = BoardSaveRequestDto.toEntity(dto);
		boardRepository.save(boardEntity);
	}
	
	
	public List<Board> 글목록() {
		return boardRepository.findAll();
	}
	
	@Transactional
	public Board 글상세보기(int id){
		Board board = boardRepository.findById(id)
				.orElseThrow(() ->new RuntimeException(id + "는 잘못된 id 값입니다."));
		board.setReadCount(board.getReadCount()+1);
		return board;
	}
	
	@Transactional
	public void 글삭제하기(int id) {
		boardRepository.mdeleteById(id);
	}
	
	@Transactional
	public void 글수정하기(int id, BoardSaveRequestDto dto) throws MyArgsNotFound {
		//더티체킹
		Board boardEntity = boardRepository.mFindById(id);
		boardEntity.setTitle(dto.getTitle());
		boardEntity.setContent(dto.getContent());
		
	}
}
