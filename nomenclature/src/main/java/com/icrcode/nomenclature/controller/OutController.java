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
public class OutController {

  private final ArticleServiceImpl articleService;

  @GetMapping(path ="out")
  String getArticles(Model model){
    return "out";
  }



}
