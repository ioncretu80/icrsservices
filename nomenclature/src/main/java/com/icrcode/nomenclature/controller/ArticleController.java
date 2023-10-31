package com.icrcode.nomenclature.controller;


import com.icrcode.nomenclature.ArticleServiceImpl;
import com.icrcode.nomenclature.model.Article;
import com.icrcode.nomenclature.model.ArticleRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

  private final ArticleServiceImpl articleService;

  @GetMapping
  public String getArticles(Model model) {
    model.addAttribute("articles", articleService.findAllArticles());
    return "articles/articles";
  }

  @GetMapping(path = "/deleteArticle")
  public String deleteArticle(@RequestParam("articleId") Integer theId) {
    articleService.deleteById(theId);

    return "redirect:/articles";
  }
  @GetMapping(path = "/updateArticle")
  public String showFormForUpdate(@RequestParam("articleId") Integer theId, Model model) {
    Article article = articleService.findById(theId);
    model.addAttribute("article", article);
    return "articles/articleForm";
  }


  @GetMapping(path = "/addArticle")
  public String showFormForAdd(Model model) {
    Article article = new Article();
    model.addAttribute("article", article);
    return "articles/articleForm";
  }

  @PostMapping(path = "/saveArticle")
  public String saveArticle(@ModelAttribute("article") ArticleRequest article) {
   articleService.saveArticle(article);
    return "redirect:/articles";
  }


}
