package com.icrcode.nomenclature.controller;

import com.icrcode.nomenclature.ArticleServiceImpl;
import com.icrcode.nomenclature.model.Article;
import com.icrcode.nomenclature.model.ArticleRequest;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/articles_rest")
@AllArgsConstructor
public class ArticleRestController {

  private ArticleServiceImpl articleService;




  @GetMapping()
  public List<Article> findAllArticles(){
    return articleService.findAllArticles();
  }

  @PostMapping()
  public void saveArticle(@RequestBody ArticleRequest articleRequest){
   articleService.saveArticle(articleRequest);
  }

}
