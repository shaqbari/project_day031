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
		//원하는 경로의 하위 디렉토리/파일 구하기
		//생성자가 길어지므로 따로 빼자
		ArrayList<String> list=getDirList();
		for (int i = 0; i < list.size(); i++) {
			String dirName=list.get(i);
			MyPanel mp=new MyPanel(this, i, dirName);
			p_list.add(mp);
			add(mp);			
		}
		
		//for문으로 한개를 클릭하면 나머지가 다 열리는 것을 숙제로 해보자.
		//선택한 거만 제외(continue)
		

		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);			
	}
	
	//원하는 경로의 하위 디렉토리/파일 구하기
	public ArrayList<String> getDirList(){
		File file=new File("c:/");
		File[] fileList=file.listFiles();
		
		//배열은 크기를 명시해야 하므로 컬렉션 프레임워크를 써서 디렉토리 경로를 받자
		ArrayList<String> dirList=new ArrayList<String>();		
		//디렉토리만 골라내자				
		for (int i = 0; i < fileList.length; i++) {
			 if (fileList[i].isDirectory()) {
				//디렉토리가 발견될때마다 리스트 추가
				dirList.add(fileList[i].getName());				
			}
		}
		return dirList;
	}	

	public static void main(String[] args) {
		new FileWindow();
	}
	
}
