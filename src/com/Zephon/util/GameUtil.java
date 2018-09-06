package com.Zephon.util;

import java.awt.Image;
import java.awt.Toolkit;


public class GameUtil {
	private GameUtil() {}//��������ý�������˽����
	
	public static Image getImage(String path) {
		/*URL u=GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img=null;
		try {
			img=ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;*/
		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
	}
}
