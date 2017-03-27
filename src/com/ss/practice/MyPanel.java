//�г��� �󺧰� ��ư�� ������ �ִ�
//JPanel has a JLabel & JButton

package com.ss.practice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements ActionListener{
	JLabel la;
	JButton bt;
	
	//�г��� �¾ �� �� ��ǰ�� ���� �¾�� �ϹǷ�, �����ڿ��� �ʱ�ȭ����
	public MyPanel(String title, Icon icon) {
		la=new JLabel(title);
		bt=new JButton(icon);
		
		bt.setBorderPainted(false);//��輱 ���ֱ�
		bt.setContentAreaFilled(false);//��ä��� ����
		bt.setFocusPainted(false);//��Ŀ���� ���� �����ֱ� �ٸ�â Ŭ���ϸ� �������� ��Ŀ��
		bt.setOpaque(false);//����(������ ���ֱ�)
		
		bt.addActionListener(this);
		
		this.setLayout(new BorderLayout());
		add(la, BorderLayout.NORTH);
		add(bt);		
	}
	
	public void actionPerformed(ActionEvent e) {
		open();
	}

	public void open() {
		
	}
}
