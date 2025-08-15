package com.saiDeveloper.Spring_Boot_Starter_Template.repo;

import com.saiDeveloper.Spring_Boot_Starter_Template.model.Markdown;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkdownRepo extends JpaRepository<Markdown,Long> {
}
