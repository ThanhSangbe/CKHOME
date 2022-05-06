package com.pts.ckhome.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "mon")
public class Mon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "KhauPhan")
	private String khauPhan;
	@Column(name = "TenMon")
	private String tenMon;
	@Column(name = "LuotXem")
	private long luotXem;
	@Column(name = "HinhNen")
	private String hinhNen;
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	@ManyToOne
	@JoinColumn(name = "ID_Loai")
	private LoaiMon loaiMon;
}
