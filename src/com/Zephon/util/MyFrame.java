package com.Zephon.util;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
public class MyFrame extends Frame {

	/**
	 * 加载窗口
	 */
	public void launchFrame() {
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(100,100);
		setVisible(true);
		new PaintThread().start();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});
	}
	
	/**
	 * 定义一个重画窗口的线程类
	 * @author 15284
	 *
	 */
	class PaintThread extends Thread{
		@Override
		public void run() {
			
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
