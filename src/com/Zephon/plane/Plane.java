package com.Zephon.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.text.AbstractDocument.Content;

import com.Zephon.util.Constant;
import com.Zephon.util.GameUtil;

public class Plane extends GameObject{
	boolean left,up,right,down;
	
	private boolean live=true;
	//¹¹Ôìº¯Êý
	
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public Plane(String path,double x,double y){
		img=GameUtil.getImage(path);
		this.x=x;
		this.y=y;

	}
	public Plane() {
		
	}

	
	public void addDirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:left=true;;break;
		case KeyEvent.VK_DOWN:down=true;break;
		case KeyEvent.VK_RIGHT:right=true;break;
		case KeyEvent.VK_UP:up=true;break;
		default:break;
		}
	}
	
	public void minusDirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:left=false;;break;
		case KeyEvent.VK_DOWN:down=false;break;
		case KeyEvent.VK_RIGHT:right=false;break;
		case KeyEvent.VK_UP:up=false;break;
		default:break;
		}

	}
	
	public void draw(Graphics g) {
		if(live) {
			g.drawImage(img, (int)x, (int)y, null);
			move();
		}
		
		
	}
	

	public void move() {
		if(x<10)left=false;
		if(x>Constant.GAME_WIDTH-width-10)right=false;
		if(y>Constant.GAME_HEIGHT-height-10)down=false;
		if(y<40)up=false;
			if(left)x-=speed;
			if(right)x+=speed;
			if(up)y-=speed;
			if(down)y+=speed;
		
		
		
	}
	
}
