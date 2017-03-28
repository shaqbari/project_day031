//패널이 라벨과 버튼을 가지고 있다
//JPanel has a JLabel & JButton

package com.ss.practice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements ActionListener{
	FileWindow fw;
	MyIcon folder_on, folder_off;	
	
	JLabel la;
	JButton bt;
	int id;
		
	//패널이 태어날 때 그 부품도 같이 태어나야 하므로, 생성자에서 초기화하자
	public MyPanel(FileWindow fw, int id, String title) {
		setLayout(new BorderLayout());
		
		this.fw=fw;
		this.id=id;
		folder_on=new MyIcon(this.getClass().getResource("/folder_on.png"), 50, 50);
		folder_off=new MyIcon(this.getClass().getResource("/folder_off.png"), 50, 50);
				
		la=new JLabel(title);
		bt=new JButton(folder_off);		
			
		bt.setBorderPainted(false);//경계선 없애기
		bt.setContentAreaFilled(false);//색채우기 없음
		bt.setFocusPainted(false);//포커스에 의한 경계없애기 다른창 클릭하면 없어지는 포커스
		bt.setOpaque(false);//투명(불투명 없애기)
		
		bt.addActionListener(this);		
		
		add(la, BorderLayout.NORTH);
		add(bt);		
	}
	
	public void actionPerformed(ActionEvent e) {
		open();
	}

	public void open() {
		for (int i = 0; i < fw.p_list.size(); i++) {
			if(i!=id){
				fw.p_list.get(i).bt.setIcon(folder_on);
			}
		}
	}
}
