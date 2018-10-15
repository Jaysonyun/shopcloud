package org.com.shopcloud.rest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@RestController
public class UploadRest {
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@HystrixCommand(fallbackMethod="uploadFallback")   // 如果需要性能监控，那么必须需要此注解
	public String get(@RequestParam("photo")MultipartFile photo) {
		if(photo!=null) {
			System.out.println("******文件名称："+photo.getOriginalFilename()+"   文件大小："+photo.getSize());
		}
		return photo.getOriginalFilename();
	}	
	public String uploadFallback(@RequestParam("photo")MultipartFile photo) {
		return "nophoto.jpg";
	}
}
