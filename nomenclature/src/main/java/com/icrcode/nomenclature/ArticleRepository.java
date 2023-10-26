package com.icrcode.nomenclature;

import com.icrcode.nomenclature.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Integer> {

}
