package com.cos.board.controller;

import java.util.List;	
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.board.config.ex.MyArgsNotFound;
import com.cos.board.dto.BoardSaveRequestDto;
import com.cos.board.model.Board;
import com.cos.board.repository.BoardRepository;
import com.cos.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//http://localhost:8000/saveForm
	@GetMapping("/saveForm")
	public String writeForm() {
		return "saveForm";
	}
	
//	@PostMapping("/save")
//	//두개만 받아서 오는데 json은 오브젝트를 받아서 오지만 이건 아님 그래서 
//	//두개만 받는 클래스를 따로 만든다 
//	public String save(BoardSaveRequestDto dto) {
//		boardService.글쓰기(dto);
//		System.out.println(dto);
//		return "redirect:/list";
//	}
	
	@PostMapping("/save")
	@ResponseBody
	//두개만 받아서 오는데 json은 오브젝트를 받아서 오지만 이건 아님 그래서 
	//두개만 받는 클래스를 따로 만든다 
	public String save(@RequestBody BoardSaveRequestDto dto) {
		boardService.글쓰기(dto);
		System.out.println(dto);
		return "ok";
	}
	
	
	//스프링에서 Controller의 메서드의 파라메터 부분은 자동 DI가 됨.
	@GetMapping({"","/","/list"})
	public String list(Model model) {
		model.addAttribute("boards",boardService.글목록());
		return "list";
	}
	
	@GetMapping("/board/{id}")
	public String detail(@PathVariable int id,Model model) {
		//Board board = boardRepository.findById(id).orElse(new Board());
		//Board board = boardRepository.findById(id).orElseGet(() ->new Board());
		model.addAttribute("board",boardService.글상세보기(id));

		return "detail";
	}
	

	@DeleteMapping("/board/{id}")
	@ResponseBody
	public String delete(@PathVariable int id) {
		boardService.글삭제하기(id);
		return "ok";
	}
	
	@PutMapping("/board/{id}")
	@ResponseBody
	public String update(@PathVariable int id,@RequestBody BoardSaveRequestDto dto) throws MyArgsNotFound {
		boardService.글수정하기(id,dto);
		return "ok";
	}
}
