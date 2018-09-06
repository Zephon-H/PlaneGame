package com.Zephon.plane;

import java.awt.Image;
import java.awt.Rectangle;

/**
 * @author 15284
 *
 */
public class GameObject {
	Image img;
	double x,y;
	int speed=4;
	int width;
	int height;
	public GameObject(Image img, double x, double y, int speed, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle getRect() {
		if(this.img!=null) {
			width=img.getWidth(null);
			height=img.getHeight(null);
		}
		return new Rectangle((int)x, (int)y, width, height);
	}
	
	public GameObject() {
		
	}
}
