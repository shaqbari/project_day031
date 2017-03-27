package com.ss.file;

import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JFrame;

public class FileExplorer2 extends JFrame{
	File file;
	
	public FileExplorer2() {		
		file=new File("c:/");
		File[] dir=file.listFiles();
		
		for (int i = 0; i < dir.length; i++) {
			 if (dir[i].isDirectory()) {
				MyButton bt=new MyButton(dir[i].getName());
				add(bt);
			}
		}
		
		setLayout(new FlowLayout());

		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
	}
	
	public static void main(String[] args) {
		new FileExplorer2();
	}

}
