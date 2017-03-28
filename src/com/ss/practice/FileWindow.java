package com.ss.practice;

import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FileWindow extends JFrame{		
	ArrayList<MyPanel> p_list;	

	public FileWindow() {	
		setLayout(new FlowLayout());
		
		p_list=new ArrayList<MyPanel>();	
		//���ϴ� ����� ���� ���丮/���� ���ϱ�
		//�����ڰ� ������Ƿ� ���� ����
		ArrayList<String> list=getDirList();
		for (int i = 0; i < list.size(); i++) {
			String dirName=list.get(i);
			MyPanel mp=new MyPanel(this, i, dirName);
			p_list.add(mp);
			add(mp);			
		}
		
		//for������ �Ѱ��� Ŭ���ϸ� �������� �� ������ ���� ������ �غ���.
		//������ �Ÿ� ����(continue)
		

		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);			
	}
	
	//���ϴ� ����� ���� ���丮/���� ���ϱ�
	public ArrayList<String> getDirList(){
		File file=new File("c:/");
		File[] fileList=file.listFiles();
		
		//�迭�� ũ�⸦ ����ؾ� �ϹǷ� �÷��� �����ӿ�ũ�� �Ἥ ���丮 ��θ� ����
		ArrayList<String> dirList=new ArrayList<String>();		
		//���丮�� �����				
		for (int i = 0; i < fileList.length; i++) {
			 if (fileList[i].isDirectory()) {
				//���丮�� �߰ߵɶ����� ����Ʈ �߰�
				dirList.add(fileList[i].getName());				
			}
		}
		return dirList;
	}	

	public static void main(String[] args) {
		new FileWindow();
	}
	
}
