package com.pts.ckhome;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cloudinary.Cloudinary;
import com.cloudinary.SingletonManager;
import com.cloudinary.utils.ObjectUtils;

@SpringBootApplication
@EnableScheduling
public class CkhomeApplication {
	 private static final Logger logger = LoggerFactory.getLogger(CkhomeApplication.class);
	public static void main(String[] args) {
		Cloudinary cloudinary
        = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "thanhsang123",
                "api_key", "115532222794176",
                "api_secret", "ViKawvrTLeLMFSKXT-nkRf19uco"));
		SingletonManager manager = new SingletonManager();
        manager.setCloudinary(cloudinary);
        manager.init();
		SpringApplication.run(CkhomeApplication.class, args);
	}
	

}
