package com.pts.ckhome.Controller;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pts.ckhome.DTO.LoaiMonDTO;
import com.pts.ckhome.Entity.LoaiMon;
import com.pts.ckhome.Service.LoaiMonService;

@Controller
@RequestMapping("admin/LoaiMon")
public class LoaiMonController {
	@Autowired
	private LoaiMonService loaiMonService;
	@Autowired
	private ModelMapper modelMapper;
	private String Redirect = "redirect:/admin/LoaiMon/";
	@GetMapping("/")
	public String getAll(Model model)
	{
		model.addAttribute("loaiMons", this.loaiMonService.findAll());
		return "admin/LoaiMon/index";
	}
	@PostMapping("/add")
	public String loaiMonAddPost(@RequestParam(required = false) Map<String, String> params)
	{
		LoaiMonDTO  l = new LoaiMonDTO(); l.setTenLoai(params.get("TenLoaiMon"));
		LoaiMon loaiMon = this.modelMapper.map(l, LoaiMon.class);
		this.loaiMonService.save(loaiMon);
		return Redirect;
	}
	@PostMapping("/update")
	public String update(@RequestParam(required = false) Map<String, String> params)
	{
		LoaiMonDTO dto = new LoaiMonDTO( Integer.parseInt(params.get("ID")), params.get("LoaiMonName"));
		LoaiMon loaiMon = this.modelMapper.map(dto, LoaiMon.class);
		this.loaiMonService.save(loaiMon);
		return Redirect;
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable() int id)
	{
		this.loaiMonService.deleteById(id);
		return Redirect;
	}
	
}
