package com.saiDeveloper.Spring_Boot_Starter_Template.service;

import com.saiDeveloper.Spring_Boot_Starter_Template.model.Markdown;
import com.saiDeveloper.Spring_Boot_Starter_Template.repo.MarkdownRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkdownService {

    @Autowired
    private MarkdownRepo repo;


    public Markdown saveMarkdown(String fileName, String content){
        Markdown md = new Markdown();
        md.setFileName(fileName);
        md.setContent(content);
        return repo.save(md);
    }

    public List<Markdown> fetchAllMarkdowns() {
        return repo.findAll();
    }
}
