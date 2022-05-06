package com.pts.ckhome.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pts.ckhome.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);
}
