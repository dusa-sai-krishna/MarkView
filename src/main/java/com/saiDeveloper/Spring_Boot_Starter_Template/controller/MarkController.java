package com.saiDeveloper.Spring_Boot_Starter_Template.controller;

import com.saiDeveloper.Spring_Boot_Starter_Template.model.Markdown;
import com.saiDeveloper.Spring_Boot_Starter_Template.service.MarkdownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api")
public class MarkController {

    @Autowired
    private MarkdownService service;

    @GetMapping("/")
    private ResponseEntity<String> helloWorld(){
        return new ResponseEntity<>("helloWorld", HttpStatus.OK);
    }

    @PostMapping("/upload")
    private ResponseEntity<Markdown> handlingFileUpload(@RequestParam("file")MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String content = new String(file.getBytes());
        log.info("filename:{}",fileName);
        log.info("Content:{}",content);
        return new ResponseEntity<>(this.service.saveMarkdown(fileName,content), HttpStatus.ACCEPTED);
    }

}
