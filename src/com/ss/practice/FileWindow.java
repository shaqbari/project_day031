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
		
		//�̹����� �����ο� �����ؼ� ������ ��� res�� classpath�� ���!!
		//package explorer���� �ش����� ��Ŭ��-->Build path-->Use as Source Folder
		//navigator������ �� �޴��� �ȶ��.
		
		//�̹��� �������� �����ϵ�, ���ҽ� �����κ���..
		//URL: uniformed Resource Locator
		//URL url=this.getClass().getResource("folder_on.png");
		//folder_on=new ImageIcon(url);
		//folder_on=new ImageIcon(this.getClass().getResource("/folder_on.png"));
		//folder_off=new ImageIcon(this.getClass().getResource("/folder_off.png"));		
		
		//Image scaledImg=folder_on.getImage();
		//ũ�⸦ �������� �� ��������� �̹��� ��ü�� �ٽ� ��ȯ
		//Image result=scaledImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH); //�߸𸣴� �μ������� see also�� �� ����
		//folder_on.setImage(result);
		
		//�Ʒ��� ���� ���´� �ȵ���̵忡���� ���� ���δ�. īī���� ģ����ϵ�
		folder_on=new MyIcon(this.getClass().getResource("/folder_on.png"), 50, 50);
		folder_off=new MyIcon(this.getClass().getResource("/folder_off.png"), 50, 50);
		
		//����� ������ �׽�Ʈ
		//MyPanel mp1=new MyPanel("MyPanel", folder_on);
		//add(mp1);
		
		//���ϴ� ����� ���� ���丮/���� ���ϱ�
		//�����ڰ� ������Ƿ� ���� ����
		ArrayList<String> list=getDirList(); //���⼭�� generic���� �����ؾ� ������ �ȳ���. 
		for (int i = 0; i < list.size(); i++) {
			String dirName=list.get(i);
			MyPanel mp=new MyPanel(list.get(i), folder_off);
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
