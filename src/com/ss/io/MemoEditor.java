package com.ss.io;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame{
	JPanel p;
	JButton bt_open, bt_save;
	ImageIcon icon_open, icon_close; //icon을 상속(is a)받는 일반클래스
	JTextArea area;
	JScrollPane scroll;
	
	String ori="D:/google/쌍용교육센터/java_workspace2/project_day031/src/com/ss/res/memo.txt";//원본
	String dest="D:/google/쌍용교육센터/java_workspace2/project_day031/src/com/ss/res/memo_copy.txt";//다른파일의 저장경로	
	FileInputStream fis;
	FileOutputStream fos;
	
	InputStreamReader reader;//문자기반 입력스트림	
	BufferedReader buffer; //버퍼기반 입력스트림, 채팅할때도 쓸것이다.
	
	OutputStreamWriter writer;//문자기반 출력스트림
	PrintWriter writer2; //문자기반의 출력스트림. 한글이 깨질경우 다른 writer도 이용해보자.
	
	public MemoEditor() {
		p=new JPanel();
		icon_open=new ImageIcon("D:/google/쌍용교육센터/java_workspace2/project_day031/src/com/ss/res/folder_on.png");
		icon_close=new ImageIcon("D:/google/쌍용교육센터/java_workspace2/project_day031/src/com/ss/res/folder_off.png");
		bt_open=new JButton(icon_open);
		bt_save=new JButton("저장");
		area=new JTextArea(30, 20);
		scroll=new JScrollPane(area);
		
		bt_open.setBorderPainted(false); //맨테두리 사라짐
		bt_open.setContentAreaFilled(false); //바탕색 사라짐
		bt_open.setFocusPainted(false); //가운데 테두리 사라짐
		bt_open.setOpaque(false); //이미지가 있는 곳만 pixel이 생성(투명부분 투명)
		
		p.add(bt_open);
		p.add(bt_save);
		
		add(p, BorderLayout.NORTH);
		add(scroll);

		//버튼 2개 내부익명으로가자
		bt_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		
		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	
	//저장하기
	public void open() {
		try {
			fis=new FileInputStream(ori);			
			//문자기반 스트림에는 문자인코딩 속성을 지정할 수 있다.
			reader=new InputStreamReader(fis, "utf-8"); //업그레이드
			buffer=new BufferedReader(reader); //한번더 업그레이드
			
			//int data;
			String data; //한줄씩 읽기 위해
			int count=0; //read횟수를 알기 위해
			
			while(true){
				//data=fis.read(); //1byte씩 읽어들인다. 한글 깨짐
				//data=reader.read();//2byte씩 읽어들인다. 엄청나게 읽어야 해서 느리다.
				data=buffer.readLine();	//String을 반환한다.
				count++;
				
				//if(data==-1) break;
				if(data==null) break; //String은 객체자료형이므로 초기화 안하거나 값이 없으면 null이 들어간다.
				//area.append(Integer.toString(data));//이렇게하면 숫자인 string이된다.
				//area.append(Character.toString((char)data));
				area.append(data+"\n"); //\n안쓰면 한줄로 읽어들인다.
			}
			System.out.println("count="+count);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); //개발자를 위한 에러 로그정보, 에러가 콘솔창에 스택구조로 쌓임 안쓰면 개발자에게 안보인다.
			JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//열기
	public void save() {
		//FileOutputStream은 지정한 경로의 파일을 생성해버린다.(크기는 0바이트인 empty 파일). 기존파일있으면 날려버리고 새로생성
		try {
			fos=new FileOutputStream(dest);
			//writer=new OutputStreamWriter(fos, "utf-8"); //업그레이드
			writer2=new PrintWriter(fos); //업그레이드
			
			//writer.write(area.getText()); //스트림을 닫아줘야 작업이 마무리된다.
			writer2.write(area.getText()); //스트림을 닫아줘야 작업이 마무리된다.
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		//} catch (UnsupportedEncodingException e) {
		//	e.printStackTrace();
		//	JOptionPane.showMessageDialog(this, "존재하지 않는 문자형식입니다.");
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "io작업중 에러발생");
		}finally{
			//업그레이드 빨때 제거하고 안쪽 제거하는것이 좋다
			//열어놓은 스트림은 전부 닫는 처리
			if (writer2 !=null) { //존재한다면 닫는다.
				//try {
					//writer.close();
					writer2.close();
				//} catch (IOException e) {
				//	e.printStackTrace();
				//}
			}
			
			if (fos !=null) { //존재한다면 닫는다.
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		}
	}
	
	public static void main(String[] args) {
		new MemoEditor();
	}

}
