package com.icrcode.nomenclature.controller;


import com.icrcode.nomenclature.ArticleServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Slf4j
@Controller
@AllArgsConstructor
public class ArticleController {

  private final ArticleServiceImpl articleService;

  @GetMapping(path ="api/v1/articles")
  String getArticles(Model model){
    model.addAttribute("students", articleService.findAllArticles());
    return "articles";
  }



}
