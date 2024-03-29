package com.pts.ckhome.Configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private UserDetailsService userDetailsService;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		super.configure(auth);
	}
	//Phan quyen
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.formLogin().loginPage("/login")
			.usernameParameter("username").passwordParameter("password");
			http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");
			http.logout().logoutSuccessUrl("/");
			http.exceptionHandling().accessDeniedPage("/login?accessDenied");
			http.authorizeRequests().antMatchers("/").permitAll();
//			http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
			http.authorizeRequests().antMatchers("/user/**").access("hasRole('ROLE_USER')");
			http.authorizeRequests().antMatchers("/info").access("hasRole('ROLE_USER')");
			http.csrf().disable();
		}

}
