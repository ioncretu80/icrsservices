package com.icrcode;

import com.icrcode.nomenclature.model.Article;
import java.util.List;

public interface ArticleService {
  List<Article> findAllArticles();


  Article findById(Integer theId);

  public void deleteById(Integer theId);
}
