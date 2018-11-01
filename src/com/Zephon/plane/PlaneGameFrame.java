package com.Zephon.plane;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;

import com.Zephon.util.Constant;
import com.Zephon.util.GameUtil;
import com.Zephon.util.MyFrame;

public class PlaneGameFrame extends MyFrame {
	Image bg=GameUtil.getImage("images/bg.jpg");
	Plane plane=new Plane("images/plane.png",50,50);
	
	ArrayList bulletList=new ArrayList();//泛型暂时不加
	
	Explode bao;
	
	Date startTime;
	Date endTime;
	Date lastTime;
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, 0,0,null);
		plane.draw(g);
		
		for(int i=0;i<bulletList.size();i++) {
			Bullet b=(Bullet) bulletList.get(i);
			b.draw(g);

			//检测跟飞机的碰撞
			boolean boom=b.getRect().intersects(plane.getRect());
			
			if(boom){
				plane.setLive(false);
				if(endTime==null)endTime=new Date();
				if(bao==null)
				bao=new Explode(plane.x, plane.y);
				
			}else lastTime=new Date();
			}
		if(!plane.isLive()) {
			bao.draw(g);
			int period=(int)(endTime.getTime()-startTime.getTime())/1000;
			printInfo(g,"时间："+period+"秒",20,190,280,Color.white);
			switch (period/10) {
			case 0:
				printInfo(g, "菜  鸟", 60,140,250,Color.white);
				break;
			case 1:
				printInfo(g, "小 辣 鸡", 60,140,250,Color.white);
				break;
			case 2:
				printInfo(g, "大  鸟", 60,140,250,Color.white);
				break;	
			case 3:
				printInfo(g, "老  鸟", 60,140,250,Color.white);
				break;
			default:
				printInfo(g, "鸟  人", 60,140,250,Color.white);
				break;
			}
		}

		int s=(int)(lastTime.getTime()-startTime.getTime())/1000;
		printInfo(g,"时间"+s,15,10,50,Color.yellow);
		
		}
	
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color){
		Color c=g.getColor();
		Font font=new Font("宋体",Font.BOLD,size);
		g.setColor(color);
		g.setFont(font);
		g.drawString(str, x, y);
		g.setColor(c);
	}






	//利用双缓冲解决闪烁问题
	private Image offScreeImage=null;
	@Override
	public void update(Graphics g) {
		if(offScreeImage==null)offScreeImage=this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
	
		Graphics gOff=offScreeImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreeImage, 0,0,null);
	}
	
	
	
	public static void main(String[] args) {
		PlaneGameFrame p=new PlaneGameFrame();
		p.launchFrame();
	}
	
	public void launchFrame () {
		super.launchFrame();

		//增加键盘的监听
		addKeyListener((KeyListener) new KeyMonitor());

		//生成子弹
		for(int i=0;i<20;i++) {
			Bullet b=new Bullet();
			bulletList.add(b);
		}
		startTime=new Date();
			
	}

	//定义为内部类可以方便使用外部类的普通属性
	class KeyMonitor extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
	}
}
