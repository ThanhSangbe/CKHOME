package com.pts.ckhome.DTO;

import org.springframework.web.multipart.MultipartFile;

import com.pts.ckhome.Entity.LoaiMon;
import com.pts.ckhome.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MonDTO {
	private long id;

	private String khauPhan;

	private String tenMon;

	private long luotXem;

	private String hinhNen;

	private User user;

	private LoaiMon loaiMon;
	
	private MultipartFile hinhNenFile;
}