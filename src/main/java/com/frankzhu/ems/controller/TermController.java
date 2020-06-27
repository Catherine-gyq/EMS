package com.frankzhu.ems.controller;

import com.frankzhu.ems.mapper.TermMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TermController {

    private final TermMapper termMapper;

    @Autowired
    public TermController(TermMapper termMapper){
        this.termMapper = termMapper;
    }

    @GetMapping("/api/term/all")
    public List<Map<String, Object>> findAllTerm(){
        return termMapper.findAllTerm();
    }

}
