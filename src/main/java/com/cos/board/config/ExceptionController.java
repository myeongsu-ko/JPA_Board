package com.cos.board.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.board.config.ex.MyArgsNotFound;

@ControllerAdvice //전역함수(프로젝트 전체)로 됨 전체범위
@RestController
public class ExceptionController {
//IllegalArgumentException 실행될때 실행
   
   @ExceptionHandler(value = MyArgsNotFound.class)
   public String 잘못된인수(Exception e) {
      return e.getMessage();
   }
}