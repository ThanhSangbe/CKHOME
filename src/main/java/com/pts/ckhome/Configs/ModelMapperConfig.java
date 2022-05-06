package com.pts.ckhome.Configs;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class ModelMapperConfig {
	@Bean
	public ModelMapper modelMapper()
	{
		ModelMapper map = new ModelMapper();
		map.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return map;
	}
	
	
}
