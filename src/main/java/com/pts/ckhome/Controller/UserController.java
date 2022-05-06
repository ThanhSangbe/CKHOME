package com.pts.ckhome.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pts.ckhome.DTO.UserDTO;
import com.pts.ckhome.Entity.User;
import com.pts.ckhome.Service.UserService;

@Controller
public class UserController {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserService userService;
	private String login = "user/login";
	private String reLogin = "redirect:/login";
	private String register = "user/register";
	@RequestMapping("/login")
	public String login()
	{
		return login;
	}
	@GetMapping("/register")
	public String registerGet(Model model)
	{
		model.addAttribute("user", new UserDTO());
		return register;
	}
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("user") UserDTO user, Model model)
	{
		if(user.getPassword().equals(user.getConfirmPassword()))
		{
			try {
				this.userService.save(user);
			} catch (Exception e) {
				model.addAttribute("msgUsername", e.getMessage()); return register;
			}
			model.addAttribute("msgSusscess", "Đăng ký thành công!");
			return reLogin;
		}
		else 
		{
			model.addAttribute("user",user);
			model.addAttribute("msgPass", "Mật khẩu không khớp!");
			return register;
		}
		
	}
	@GetMapping("/info/{username}")
	public String getUser(@PathVariable(name = "username",required = false) String username,Model model)
	{
		model.addAttribute("user", this.userService.findByUsername(username));
		return "user/edit";
	}
	@PostMapping("/info/update")
	public String updateUser(@ModelAttribute("user") UserDTO userDTO)
	{
		try {
			this.userService.update(userDTO);
			System.out.println(userDTO.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
}
