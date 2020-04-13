package com.example.demo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class joinBufferedImage {
	
public static  BufferedImage joinImages(BufferedImage img1, BufferedImage img2,BufferedImage img3,BufferedImage img4) {
		
		int offset=10;
		int wid=img1.getWidth()+img2.getWidth()+img3.getWidth()+img4.getWidth()+offset;
		int len1=Math.max(img1.getHeight(),img2.getHeight());
		int len2=Math.max(img3.getHeight(),img4.getHeight());
		int height=Math.max(len1,len2)+offset;
		BufferedImage newImage= new BufferedImage(wid,height,BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g2 = newImage.createGraphics();
		Color oldcolor=g2.getColor();
		g2.setPaint(Color.LIGHT_GRAY);
		g2.fillRect(0, 0, wid, height);
		g2.setColor(oldcolor);
		g2.drawImage(img1, null, 0, 0);
		g2.drawImage(img2, null, img1.getWidth()+offset, 0);
		g2.drawImage(img3, null, 10+img1.getWidth()+img2.getWidth()+offset, 0);
		g2.drawImage(img4, null, 20+img1.getWidth()+img2.getWidth()+img3.getWidth()+offset, 0);
		g2.dispose();
		return newImage;
	}
}
