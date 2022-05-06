package com.pts.ckhome.Service;

import java.io.IOException;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {
	   private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	    private final Cloudinary cloudinary = Singleton.getCloudinary();
	    
	    public String upload(MultipartFile file)
	    {
	    	Map r;
			try {
				r = this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
				return r.get("secure_url").toString();
			}catch (IOException e) {
				System.out.print(e.getStackTrace());
			}
	    	return null;
	    }
}
