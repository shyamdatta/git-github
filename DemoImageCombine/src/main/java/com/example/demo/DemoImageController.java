package com.example.demo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.aspectj.apache.bcel.classfile.Utility;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DemoImageController {

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test(@RequestParam("name1") Optional<String> name1,
			@RequestParam("name2") Optional<String> name2)
	{
		System.out.println("name1 :"+name1.get());
		System.out.println("name2 :"+name2.get());
		if(name1.get().isEmpty() || name2.get().isEmpty()) {
			System.out.println("no value");
		}
		return "check Api working";
}
	
	@RequestMapping(value="/imageCombine", method=RequestMethod.POST)
	public ModelMap image(@RequestParam("image1") Optional<MultipartFile> image1,
			@RequestParam("image2") Optional<MultipartFile> image2,
			@RequestParam("image3") Optional<MultipartFile> image3,
			@RequestParam("image4") Optional<MultipartFile> image4) throws IOException {
		
	if(image1.get().isEmpty() || image2.get().isEmpty() || image3.get().isEmpty() || image4.get().isEmpty()) {
		System.out.println("image is not there inside if");		
		ModelMap map1= new ModelMap();
		map1.addAttribute("msg", "image is not there");
		map1.addAttribute("value", false);
		return map1;
			}else {
				System.out.println("inside else");
			    File outputfile=new File("C:\\Users\\Shyam\\Documents\\testImage\\finalimage.jpg");
				BufferedImage img1=ImageIO.read(image1.get().getInputStream());
				BufferedImage img2=ImageIO.read(image2.get().getInputStream());
				BufferedImage img3=ImageIO.read(image3.get().getInputStream());
				BufferedImage img4=ImageIO.read(image4.get().getInputStream());
				BufferedImage joinedimg=joinBufferedImage.joinImages(img1, img2,img3,img4);
				boolean m = ImageIO.write(joinedimg, "jpg",outputfile );
			System.out.println("image saved: "+m);
			ModelMap map=new ModelMap();
			map.addAttribute("msg", "image saved");
			map.addAttribute("value", m);
				  return map;
		}
	}
}
