package com.icrcode.nomenclature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {
  @GetMapping("main")
  String getMain(Model model){
    return "main";
  }

}
