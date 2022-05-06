package com.pts.ckhome.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @GetMapping("/")
  public String index()
  {
	  return "page/home";
  }
}
