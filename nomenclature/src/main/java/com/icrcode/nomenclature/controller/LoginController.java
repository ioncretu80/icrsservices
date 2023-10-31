package com.icrcode.nomenclature.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class LoginController {

  @RequestMapping(value = "login", method = RequestMethod.GET)
  public String gotoLogin(@RequestParam String name, Model model){
    model.addAttribute("name", name);
    log.info("TestLogging");
    return "login/login";
  }

  @RequestMapping(value = "login", method = RequestMethod.POST)
  public String gotoWelcomePage(){


    return "index";
  }


}
