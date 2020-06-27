package com.frankzhu.ems.controller;

import com.frankzhu.ems.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;


@RestController
public class AccountController {

    private final AccountMapper accountMapper;
    // 十六进制符号
    private final static String[] hexArray = {"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};

    @Autowired
    public AccountController(AccountMapper accountMapper){
        this.accountMapper=accountMapper;
    }

    @GetMapping("/api/account/resetPwd")
    public Integer resetPwd(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "identity") String identity
    ) throws NoSuchAlgorithmException {
        return accountMapper.updateAccount(username, md5(username), identity);
    }

    @PostMapping("/api/account/updatePwd")
    public Integer updatePwd(@RequestBody Map<String, Object> params) throws NoSuchAlgorithmException {
        String name = params.get("name").toString();
        String password = params.get("password").toString();
        String identity = params.get("identity").toString();
        return accountMapper.updateAccount(name, md5(password), identity);
    }

    @PostMapping("/api/account/login")
    public Integer login(@RequestBody Map<String, Object> params) throws NoSuchAlgorithmException {
        String name = params.get("username").toString();
        String password = params.get("password").toString();
        String identity = params.get("identity").toString();;
        return accountMapper.findAccount(name, md5(password), identity) == null ? 0 : 1;
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
