package com.icrcode.nomenclature;

import com.icrcode.ArticleService;
import com.icrcode.nomenclature.model.Article;
import com.icrcode.nomenclature.model.ArticleRequest;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {
  private final ArticleRepository articleRepository;



  public void saveArticle(ArticleRequest articleRequest) {
    Article article = Article.builder()
        .name(articleRequest.name())
        .producer(articleRequest.producer())
        .category(articleRequest.category())
        .build();
      articleRepository.save(article);

  }

  @Override
  public List<Article> findAllArticles() {
    return articleRepository.findAll();
  }
}
