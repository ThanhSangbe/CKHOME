package com.pts.ckhome.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "user")
public class User {
	@Id
	private String username;
	private String password;
	private String logo;
	private String email;
	@Column(name="gioithieu")
	private String gioiThieu;
	private String role;
	@Column(name = "ten")
	private String name;
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	private Set<Mon> mons;
}
