package com.frankzhu.ems.controller;

import com.frankzhu.ems.mapper.OpenMapper;
import com.frankzhu.ems.mapper.TermMapper;
import com.frankzhu.ems.model.Open;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class OpenController {

    private final OpenMapper openMapper;
    private final TermMapper termMapper;

    @Autowired
    public OpenController(OpenMapper openMapper, TermMapper termMapper){
        this.openMapper = openMapper;
        this.termMapper = termMapper;
    }

    @GetMapping("/api/open/all")
    public List<Map<String, Object>> findAllOpen(
            @RequestParam(value = "no", defaultValue = "") String no,
            @RequestParam(value = "name", defaultValue = "") String name){
        return openMapper.findAllOpen(no, name);
    }

    @PostMapping("/api/open/search")
    public List<Map<String, Object>> findAllOpenByMu(@RequestBody Map<String, Object> params){
        String term = params.get("term").toString();
        String tno = params.get("tno").toString();
        String tname = params.get("tname").toString();
        String cno = params.get("cno").toString();
        String cname = params.get("cname").toString();
        return openMapper.findAllOpenByMu(term, tno, tname, cno, cname);
    }

    @PostMapping("/api/open/add")
    public Integer insertOpen(@RequestBody Map<String, Object> params) {
        String course = params.get("cid").toString();
        String teacher = params.get("tid").toString();
        String term = params.get("term").toString();
        String time = params.get("time").toString();
        String location = params.get("location").toString();
        return openMapper.insertOpen(new Open(null, course, teacher, term, time, location));
    }

    @PostMapping("/api/open/update")
    public Integer updateOpen(@RequestBody Map<String, Object> params){
        String term = params.get("no").toString();
        boolean choice = params.get("choice").toString().equals("true");
        // 同步更新term表
        termMapper.updateTerm(term, choice);
        return openMapper.updateOpen(term, choice);
    }

    @GetMapping("/api/open/delete")
    public Integer deleteOpenByNo(@RequestParam(value = "id", defaultValue = "") int id){
        return openMapper.deleteOpenByNo(id);
    }

}
