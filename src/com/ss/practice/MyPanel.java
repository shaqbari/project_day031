//�г��� �󺧰� ��ư�� ������ �ִ�
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
		
	//�г��� �¾ �� �� ��ǰ�� ���� �¾�� �ϹǷ�, �����ڿ��� �ʱ�ȭ����
	public MyPanel(FileWindow fw, int id, String title) {
		setLayout(new BorderLayout());
		
		this.fw=fw;
		this.id=id;
		folder_on=new MyIcon(this.getClass().getResource("/folder_on.png"), 50, 50);
		folder_off=new MyIcon(this.getClass().getResource("/folder_off.png"), 50, 50);
				
		la=new JLabel(title);
		bt=new JButton(folder_off);		
			
		bt.setBorderPainted(false);//��輱 ���ֱ�
		bt.setContentAreaFilled(false);//��ä��� ����
		bt.setFocusPainted(false);//��Ŀ���� ���� �����ֱ� �ٸ�â Ŭ���ϸ� �������� ��Ŀ��
		bt.setOpaque(false);//����(������ ���ֱ�)
		
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
