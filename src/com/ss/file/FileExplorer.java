package com.ss.file;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileExplorer extends JFrame{
	JPanel p_bt;
	File file;
	JButton bt;
	ImageIcon icon_open, icon_close;
	JLabel label;
	
	public FileExplorer() {
		setLayout(new FlowLayout());		
		p_bt=new JPanel();	
		icon_open=new ImageIcon("D:/google/½Ö¿ë±³À°¼¾ÅÍ/java_workspace2/project_day031/src/com/ss/res/folder_on.png");
		icon_close=new ImageIcon("D:/google/½Ö¿ë±³À°¼¾ÅÍ/java_workspace2/project_day031/src/com/ss/res/folder_off.png");
				
		file=new File("c:/");
		File[] dir=file.listFiles();
		
		for (int i = 0; i < dir.length; i++) {
			if(dir[i].isDirectory()){
				label=new JLabel(dir[i].getName());
				bt=new JButton(icon_close);		
				
				bt.setBorderPainted(false);
				bt.setContentAreaFilled(false);
				bt.setFocusPainted(false);
				bt.setOpaque(false);
				
				bt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				
				p_bt.add(label);
				p_bt.add(bt);
				add(p_bt);
			}
		}

		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}

	public static void main(String[] args) {
		new FileExplorer();
	}

}
