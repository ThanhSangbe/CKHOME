package com.pts.ckhome.DTO;


import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	public static String Role_Admin = "ROLE_ADMIN";
	public static String Role_User = "ROLE_USER";
	private String username;
	private String password;
	private String confirmPassword;
	private String logo;
	private String email;
	private String gioiThieu;
	private String role;
	private String name;
	private MultipartFile logoFile;
}
