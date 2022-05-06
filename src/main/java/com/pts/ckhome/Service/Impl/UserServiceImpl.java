package com.pts.ckhome.Service.Impl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.pts.ckhome.DTO.UserDTO;
import com.pts.ckhome.Entity.User;
import com.pts.ckhome.Repository.UserRepository;
import com.pts.ckhome.Service.CloudinaryService;
import com.pts.ckhome.Service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private CloudinaryService cloudinaryService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO userDTO = findByUsername(username);
		if(userDTO == null)
		{
			 throw new UsernameNotFoundException("Username not found!");
		}
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(userDTO.getRole()));
		
		return new org.springframework.security.core.userdetails.User(userDTO.getUsername(),userDTO.getPassword(),authorities);
	}

	public  boolean save(UserDTO entity) throws Exception {
		if(this.findByUsername(entity.getUsername()) != null)
		{
			throw new Exception("Tên đăng nhập đã tồn tại!");
		}
		else
		{	
			String pass = entity.getPassword();
			entity.setPassword(this.passwordEncoder.encode(pass));
			entity.setRole(UserDTO.Role_User);
			User u = this.modelMapper.map(entity, User.class);
			try {
				userRepository.save(u); return true;
			}
			catch (Exception e) {
				System.out.print(e.getStackTrace());
			}
			return false;
			
		}
		
	}
	@Override
	public void update(UserDTO u )
	{
		UserDTO item = this.findByUsername(u.getUsername());
		if(!u.getLogoFile().isEmpty())
		{
			item.setLogo(this.cloudinaryService.upload(u.getLogoFile()));
		}
		item.setEmail(u.getEmail()); 
		item.setGioiThieu(u.getGioiThieu());
		item.setName(u.getName());
		User user = this.modelMapper.map(item, User.class);
		try {
			userRepository.save(user); 
		}
		catch (Exception e) {
			System.out.print(e.getStackTrace());
		}
		System.out.println(user.getLogo());
		System.out.println(user.getEmail());
	}

	@Override
	public List<UserDTO> findAll() {
		Type listDTO = new TypeToken<List<UserDTO>>() {}.getType();
		return this.modelMapper.map(this.userRepository.findAll(), listDTO);
	}

	@Override
	public List<UserDTO> findAll(Sort sort) {
		Type listType = new TypeToken<List<UserDTO>>() {}.getType();
		return this.modelMapper.map(this.userRepository.findAll(sort), listType);
	}

	@Override
	public Optional<UserDTO> findById(String id) {
		Type listType = new TypeToken<Optional<UserDTO>>() {}.getType();
		return this.modelMapper.map(userRepository.findById(id),listType);
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void delete(UserDTO entity) {
		User u = this.modelMapper.map(entity, User.class);
		userRepository.delete(u);
	}

	@Override
	public UserDTO findByUsername(String username) {
		User user = this.userRepository.findByUsername(username);
		if(user == null) return null;
		UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);
		return userDTO;
	}

	@Override
	public <S extends User> S saveAndFlush(S entity) {
		 
		return this.userRepository.saveAndFlush(entity);
	}

}
