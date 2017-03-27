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
	ImageIcon icon_open, icon_close; //icon�� ���(is a)�޴� �Ϲ�Ŭ����
	JTextArea area;
	JScrollPane scroll;
	
	String ori="D:/google/�ֿ뱳������/java_workspace2/project_day031/src/com/ss/res/memo.txt";//����
	String dest="D:/google/�ֿ뱳������/java_workspace2/project_day031/src/com/ss/res/memo_copy.txt";//�ٸ������� ������	
	FileInputStream fis;
	FileOutputStream fos;
	
	InputStreamReader reader;//���ڱ�� �Է½�Ʈ��	
	BufferedReader buffer; //���۱�� �Է½�Ʈ��, ä���Ҷ��� �����̴�.
	
	OutputStreamWriter writer;//���ڱ�� ��½�Ʈ��
	PrintWriter writer2; //���ڱ���� ��½�Ʈ��. �ѱ��� ������� �ٸ� writer�� �̿��غ���.
	
	public MemoEditor() {
		p=new JPanel();
		icon_open=new ImageIcon("D:/google/�ֿ뱳������/java_workspace2/project_day031/src/com/ss/res/folder_on.png");
		icon_close=new ImageIcon("D:/google/�ֿ뱳������/java_workspace2/project_day031/src/com/ss/res/folder_off.png");
		bt_open=new JButton(icon_open);
		bt_save=new JButton("����");
		area=new JTextArea(30, 20);
		scroll=new JScrollPane(area);
		
		bt_open.setBorderPainted(false); //���׵θ� �����
		bt_open.setContentAreaFilled(false); //������ �����
		bt_open.setFocusPainted(false); //��� �׵θ� �����
		bt_open.setOpaque(false); //�̹����� �ִ� ���� pixel�� ����(����κ� ����)
		
		p.add(bt_open);
		p.add(bt_save);
		
		add(p, BorderLayout.NORTH);
		add(scroll);

		//��ư 2�� �����͸����ΰ���
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
	
	//�����ϱ�
	public void open() {
		try {
			fis=new FileInputStream(ori);			
			//���ڱ�� ��Ʈ������ �������ڵ� �Ӽ��� ������ �� �ִ�.
			reader=new InputStreamReader(fis, "utf-8"); //���׷��̵�
			buffer=new BufferedReader(reader); //�ѹ��� ���׷��̵�
			
			//int data;
			String data; //���پ� �б� ����
			int count=0; //readȽ���� �˱� ����
			
			while(true){
				//data=fis.read(); //1byte�� �о���δ�. �ѱ� ����
				//data=reader.read();//2byte�� �о���δ�. ��û���� �о�� �ؼ� ������.
				data=buffer.readLine();	//String�� ��ȯ�Ѵ�.
				count++;
				
				//if(data==-1) break;
				if(data==null) break; //String�� ��ü�ڷ����̹Ƿ� �ʱ�ȭ ���ϰų� ���� ������ null�� ����.
				//area.append(Integer.toString(data));//�̷����ϸ� ������ string�̵ȴ�.
				//area.append(Character.toString((char)data));
				area.append(data+"\n"); //\n�Ⱦ��� ���ٷ� �о���δ�.
			}
			System.out.println("count="+count);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); //�����ڸ� ���� ���� �α�����, ������ �ܼ�â�� ���ñ����� ���� �Ⱦ��� �����ڿ��� �Ⱥ��δ�.
			JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//����
	public void save() {
		//FileOutputStream�� ������ ����� ������ �����ع�����.(ũ��� 0����Ʈ�� empty ����). �������������� ���������� ���λ���
		try {
			fos=new FileOutputStream(dest);
			//writer=new OutputStreamWriter(fos, "utf-8"); //���׷��̵�
			writer2=new PrintWriter(fos); //���׷��̵�
			
			//writer.write(area.getText()); //��Ʈ���� �ݾ���� �۾��� �������ȴ�.
			writer2.write(area.getText()); //��Ʈ���� �ݾ���� �۾��� �������ȴ�.
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		//} catch (UnsupportedEncodingException e) {
		//	e.printStackTrace();
		//	JOptionPane.showMessageDialog(this, "�������� �ʴ� ���������Դϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "io�۾��� �����߻�");
		}finally{
			//���׷��̵� ���� �����ϰ� ���� �����ϴ°��� ����
			//������� ��Ʈ���� ���� �ݴ� ó��
			if (writer2 !=null) { //�����Ѵٸ� �ݴ´�.
				//try {
					//writer.close();
					writer2.close();
				//} catch (IOException e) {
				//	e.printStackTrace();
				//}
			}
			
			if (fos !=null) { //�����Ѵٸ� �ݴ´�.
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
