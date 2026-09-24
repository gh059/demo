package com.example.demo.model.service;

import java.util.List; // 1. List 사용을 위해 import 추가

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.domain.TestDB;
import com.example.demo.model.repository.TestRepository;

@Service // 서비스 등록, 자동 등록됨
public class TestService {
    
    @Autowired // 객체 의존성 주입 DI(컨테이너 내부 등록)
    private TestRepository testRepository;

    public TestDB findByName(String name) { // 이름 찾기
        return testRepository.findByName(name);
    }

    // --- 2. 다수 사용자 조회를 위한 findAll() 메서드 추가 ---
    public List<TestDB> findAll() {
        return testRepository.findAll();
    }
}