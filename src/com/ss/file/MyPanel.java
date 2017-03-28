//�г��� �󺧰� ��ư�� ������ �ִ�
//JPanel has a JLabel & JButton

package com.ss.file;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	JLabel la;
	JButton bt;
	int id;
	
	//�г��� �¾ �� �� ��ǰ�� ���� �¾�� �ϹǷ�, �����ڿ��� �ʱ�ȭ����
	public MyPanel(String title, Icon icon, int id) {
		la=new JLabel(title);
		bt=new JButton(icon);
		this.id=id;
		
		bt.setBorderPainted(false);//��輱 ���ֱ�
		bt.setContentAreaFilled(false);//��ä��� ����
		bt.setFocusPainted(false);//��Ŀ���� ���� �����ֱ� �ٸ�â Ŭ���ϸ� �������� ��Ŀ��
		bt.setOpaque(false);//����(������ ���ֱ�)
		
		this.setLayout(new BorderLayout());
		add(la, BorderLayout.NORTH);
		add(bt);		
	}	
}
