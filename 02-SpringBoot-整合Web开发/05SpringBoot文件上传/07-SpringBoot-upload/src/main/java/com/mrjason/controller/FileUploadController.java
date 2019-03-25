package com.mrjason.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@Controller
@RestController  //表示该类下的方法返回值将会自动做Json格式转换

public class FileUploadController {
    /*
    处理文件上传
     */
    @RequestMapping("fileUploadController")
    public Map<String,Object> fileUpload(MultipartFile filename) throws IOException {
        System.out.println(filename.getOriginalFilename());
        filename.transferTo(new File("e:/"+filename.getOriginalFilename()));
        Map<String,Object> map = new HashMap<>();
        map.put("msg","ok");
        return map;
    }
}
