/*아이콘 생성시 그 크기를 조정하려면 코드가 복잡하므로, 
 * 앞으로 재사용 가능성을 염두해두고
 * 나만의 재조정 이미지 아이콘을 새로 정의해 본다.
 * 
 * 다른 프로젝트에서도 사용가능
 * */

package com.ss.file;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIcon extends ImageIcon{	
	
	public MyIcon(URL url, int width, int height) {
		//folder_on=new ImageIcon(this.getClass().getResource("/folder_on.png"));
		//folder_off=new ImageIcon(this.getClass().getResource("/folder_off.png"));
		//super(this.getClass().getResource("/folder_on.png"));//부모가 태어나기 전에 this가 쓰일수 없다.
		super(url);
		
		Image scaledImg=this.getImage();
		//크기를 재조정한 후 결과적으로 이미지 객체를 다시 반환
		scaledImg=scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH); //잘모르는 인수나오면 see also를 잘 보자
		this.setImage(scaledImg);
	}
}
