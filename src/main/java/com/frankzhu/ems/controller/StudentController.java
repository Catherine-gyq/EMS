package com.frankzhu.ems.controller;

import com.frankzhu.ems.mapper.AccountMapper;
import com.frankzhu.ems.mapper.StudentMapper;
import com.frankzhu.ems.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    private final StudentMapper studentMapper;
    private final AccountMapper accountMapper;
    private final static String[] hexArray = {"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};

    @Autowired
    public StudentController(StudentMapper studentMapper, AccountMapper accountMapper){
        this.studentMapper = studentMapper;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/api/student/all")
    public List<Map<String, Object>> findAllStudent(
            @RequestParam(value = "no", defaultValue = "") String no,
            @RequestParam(value = "name", defaultValue = "") String name){
        return studentMapper.findAllStudent(no, name);
    }

    @PostMapping("/api/student/add")
    public Integer insertStudent(@RequestBody Map<String, Object> params) throws NoSuchAlgorithmException {
        String name = params.get("name").toString();
        String no = params.get("no").toString();
        String sex = params.get("sex").toString();
        String birthday = params.get("birthday").toString();
        String department = params.get("departmentID").toString();
        // 同步创建一个账号
        accountMapper.addAccount(no, md5(no), "student");
        return studentMapper.insertStudent(new Student(no, name, sex, birthday, department));
    }

    @PostMapping("/api/student/update")
    public Integer updateStudent(@RequestBody Map<String, Object> params){
        String name = params.get("name").toString();
        String no = params.get("no").toString();
        String sex = params.get("sex").toString();
        String birthday = params.get("birthday").toString();
        String department = params.get("departmentID").toString();
        return studentMapper.updateStudent(new Student(no, name, sex, birthday, department));
    }

    @GetMapping("/api/student/delete")
    public Integer deleteStudentByNo(@RequestParam(value = "no", defaultValue = "") String no){
        return studentMapper.deleteStudentByNo(no);
    }

    // md5加密算法
    public String md5(String source) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
        byte[] bytes = md.digest(source.getBytes());
        //将得到的字节数组变成字符串返回
        return byteArrayToHex(bytes).toUpperCase();
    }

    // 将字节数组转换成十六进制，并以字符串的形式返回
    private static String byteArrayToHex(byte[] b){
        StringBuilder sb = new StringBuilder();
        for (byte value : b) {
            sb.append(byteToHex(value));
        }
        return sb.toString();
    }

    // 将一个字节转换成十六进制，并以字符串的形式返回
    public static String byteToHex(byte b) {
        int n = b;
        if (n < 0)
            n = n + 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexArray[d1]+hexArray[d2];
    }

}
