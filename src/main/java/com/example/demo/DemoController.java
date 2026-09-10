package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "반갑습니다.");
        return "hello";
    }

     // --- 연습문제 추가 부분 ---
    @GetMapping("/hello2")
    public String hello2(Model model) {
        model.addAttribute("name", "김가현님.");
        model.addAttribute("greeting", "반갑습니다.");
        model.addAttribute("today", "오늘.");
        model.addAttribute("weather", "날씨는.");
        model.addAttribute("desc", "어제보다 선선합니다.");
        return "hello2"; // templates/hello2.html 연결
    }
}