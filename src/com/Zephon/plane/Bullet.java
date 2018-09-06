package com.Zephon.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.Zephon.util.Constant;

public class Bullet extends GameObject {
	double degree;
	
	
	public Bullet() {
		degree =Math.random()*Math.PI*2;
		x=Constant.GAME_WIDTH/2;
		y=Constant.GAME_HEIGHT/2;
		width=10;
		height=10;
		speed=3;
	}
	
	public Rectangle getRect() {
		return new Rectangle((int)x, (int)y, width, height);
	}
	
	public void draw(Graphics g) {
		Color c=g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int)x,(int) y, width, height);
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		if(x>=Constant.GAME_WIDTH-width||x<0)degree=Math.PI-degree;
		if(y>=Constant.GAME_HEIGHT-height||y<0)degree=-degree;
		
		g.setColor(c);
	}
}
