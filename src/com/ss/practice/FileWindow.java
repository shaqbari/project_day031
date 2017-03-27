package com.ss.practice;

import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FileWindow extends JFrame{	
	//ImageIcon folder_on, folder_off;
	MyIcon folder_on, folder_off;

	public FileWindow() {	
		setLayout(new FlowLayout());
		
		//이미지를 현재경로에 기준해서 얻어오는 방법 res를 classpath로 등록!!
		//package explorer에서 해당폴더 우클릭-->Build path-->Use as Source Folder
		//navigator에서는 이 메뉴가 안뜬다.
		
		//이미지 아이콘을 생성하되, 리소스 폴더로부터..
		//URL: uniformed Resource Locator
		//URL url=this.getClass().getResource("folder_on.png");
		//folder_on=new ImageIcon(url);
		//folder_on=new ImageIcon(this.getClass().getResource("/folder_on.png"));
		//folder_off=new ImageIcon(this.getClass().getResource("/folder_off.png"));		
		
		//Image scaledImg=folder_on.getImage();
		//크기를 재조정한 후 결과적으로 이미지 객체를 다시 반환
		//Image result=scaledImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH); //잘모르는 인수나오면 see also를 잘 보자
		//folder_on.setImage(result);
		
		//아래와 같은 형태는 안드로이드에서도 많이 쓰인다. 카카오톡 친구목록등
		folder_on=new MyIcon(this.getClass().getResource("/folder_on.png"), 50, 50);
		folder_off=new MyIcon(this.getClass().getResource("/folder_off.png"), 50, 50);
		
		//제대로 붙을지 테스트
		//MyPanel mp1=new MyPanel("MyPanel", folder_on);
		//add(mp1);
		
		//원하는 경로의 하위 디렉토리/파일 구하기
		//생성자가 길어지므로 따로 빼자
		ArrayList<String> list=getDirList(); //여기서도 generic으로 선언해야 에러가 안난다. 
		for (int i = 0; i < list.size(); i++) {
			String dirName=list.get(i);
			MyPanel mp=new MyPanel(list.get(i), folder_off);
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
