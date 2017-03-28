/*������ ������ �� ũ�⸦ �����Ϸ��� �ڵ尡 �����ϹǷ�, 
 * ������ ���� ���ɼ��� �����صΰ�
 * ������ ������ �̹��� �������� ���� ������ ����.
 * 
 * �ٸ� ������Ʈ������ ��밡��
 * */

package com.ss.practice;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIcon extends ImageIcon{	
	
	public MyIcon(URL url, int width, int height) {		
		super(url);
		
		Image scaledImg=this.getImage();
		//ũ�⸦ �������� �� ��������� �̹��� ��ü�� �ٽ� ��ȯ
		scaledImg=scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH); //�߸𸣴� �μ������� see also�� �� ����
		this.setImage(scaledImg);
	}
}
