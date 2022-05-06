package com.pts.ckhome.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pts.ckhome.Service.MonService;

@Controller
@RequestMapping("Mon")
public class MonController {
	@Autowired
	private MonService monService;
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("monAll", this.monService.findAll());
		return "user/Mon/Index";
	}
}
