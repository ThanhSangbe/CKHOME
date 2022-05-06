package com.pts.ckhome.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pts.ckhome.DTO.UserDTO;
import com.pts.ckhome.Entity.User;



public interface UserService extends UserDetailsService{
	UserDTO findByUsername(String username);


	void delete(UserDTO entity);

	long count();

	<S extends User> S saveAndFlush(S entity);

	Optional<UserDTO> findById(String id);

	List<UserDTO> findAll(Sort sort);

	List<UserDTO> findAll();

	boolean save(UserDTO entity) throws Exception;

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;


	void update(UserDTO u);

}
