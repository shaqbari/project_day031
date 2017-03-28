//패널이 라벨과 버튼을 가지고 있다
//JPanel has a JLabel & JButton

package com.ss.file;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	JLabel la;
	JButton bt;
	int id;
	
	//패널이 태어날 때 그 부품도 같이 태어나야 하므로, 생성자에서 초기화하자
	public MyPanel(String title, Icon icon, int id) {
		la=new JLabel(title);
		bt=new JButton(icon);
		this.id=id;
		
		bt.setBorderPainted(false);//경계선 없애기
		bt.setContentAreaFilled(false);//색채우기 없음
		bt.setFocusPainted(false);//포커스에 의한 경계없애기 다른창 클릭하면 없어지는 포커스
		bt.setOpaque(false);//투명(불투명 없애기)
		
		this.setLayout(new BorderLayout());
		add(la, BorderLayout.NORTH);
		add(bt);		
	}	
}
