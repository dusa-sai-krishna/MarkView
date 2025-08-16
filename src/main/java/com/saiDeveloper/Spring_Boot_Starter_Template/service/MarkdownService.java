package com.saiDeveloper.Spring_Boot_Starter_Template.service;

import com.saiDeveloper.Spring_Boot_Starter_Template.exception.MarkdownException;
import com.saiDeveloper.Spring_Boot_Starter_Template.model.Markdown;
import com.saiDeveloper.Spring_Boot_Starter_Template.repo.MarkdownRepo;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Slf4j
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


    public Markdown fetchMarkdown(Long id) throws MarkdownException {
        Markdown md = repo.findById(id).orElse(new Markdown());
        if(md.getId()==null){
            throw new MarkdownException(String.format("Markdown of id:%d not found", id));
        }
        return md;
    }

    public List<Markdown> fetchAllMarkdowns() {
        return repo.findAll();
    }

    public String convertMdToHtml(Long id) throws MarkdownException {
        log.info("Service convertMdToHTML");
        Markdown md = fetchMarkdown(id);

        log.info("Markdown fetched successfully");

        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        log.info("Parser and renderer built successfully");

        Node doc = parser.parse(md.getContent());

        log.info("Markdown parsed successfully");
        String html = renderer.render(doc);

        log.info("Markdown converted to html successfully/n {}",html);

        return html;
    }
}
