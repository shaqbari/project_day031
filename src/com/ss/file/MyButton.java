package com.ss.file;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyButton extends JPanel implements ActionListener{
	JLabel label;
	JButton bt;
	ImageIcon icon_open, icon_close;
	boolean flag=false;
	
	public MyButton(String dir) {
		label=new JLabel(dir);
		icon_open=new ImageIcon("D:/google/½Ö¿ë±³À°¼¾ÅÍ/java_workspace2/project_day031/src/com/ss/res/folder_on.png");
		icon_close=new ImageIcon("D:/google/½Ö¿ë±³À°¼¾ÅÍ/java_workspace2/project_day031/src/com/ss/res/folder_off.png");
		bt=new JButton(icon_close);
		
		bt.setBorderPainted(false);
		bt.setContentAreaFilled(false);
		bt.setFocusPainted(false);
		bt.setOpaque(false);		
		
		bt.addActionListener(this);
		
		add(label);
		add(bt);
	}
	
	public void actionPerformed(ActionEvent e) {		
		if (flag==false) {
			setBackground(Color.YELLOW);
			bt.setIcon(icon_open);
			flag=!flag;
		}else{
			setBackground(null);
			bt.setIcon(icon_close);
			flag=!flag;
		}		
	}
}
