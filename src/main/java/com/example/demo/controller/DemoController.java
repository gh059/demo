package com.example.demo.controller;

import java.util.List; // 1. List를 사용하기 위해 import 추가

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.domain.TestDB;
import com.example.demo.model.service.TestService;

@Controller
public class DemoController {
    
    @Autowired
    TestService testService;

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "반갑습니다.");
        return "hello";
    }

    @GetMapping("/hello2")
    public String hello2(Model model) {
        model.addAttribute("name", "김가현님.");
        model.addAttribute("greeting", "반갑습니다.");
        model.addAttribute("today", "오늘.");
        model.addAttribute("weather", "날씨는.");
        model.addAttribute("desc", "어제보다 선선합니다.");
        return "hello2"; 
    }

    // --- 다수 사용자 출력 실습 부분 수정 ---
    @GetMapping("/testdb")
    public String getAllTestDBs(Model model) {
        // 기존 단일 조회 코드는 주석 처리 또는 변경합니다.
        // TestDB test = testService.findByName("홍길동"); 
        
        // 전체 사용자 리스트를 조회하여 "users" 이름으로 모델에 담습니다.
        List<TestDB> users = testService.findAll();
        model.addAttribute("users", users);
        
        System.out.println("데이터 출력 디버그 (총 사용자 수) : " + users.size());
        return "testdb";
    }
}