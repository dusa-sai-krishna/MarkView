package com.saiDeveloper.Spring_Boot_Starter_Template.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HtmlResponse {
    private String message;
    private String html;

}
