/*FileInputSteam ���� �����ڰ� ���ϴ� ������ ��Ʈ���� ������ �� ������,
Ű����� ���� ǥ�� �Է� �ϵ������ ��쿣 �ڹٰ� ��Ʈ���� �������� ���ϰ� �ش� os�� �����ϹǷ�,
�ڹ� �����ڴ� os�� ���� ǥ���Է� ��Ʈ���� ���;� �Ѵ�.

�ڹ��� Ŭ���� �� System Ŭ������ static ������� �� �� has a����� ������ inputStream��
in ��ü�� �ٷ� ǥ���Է� ��Ʈ���� �޾Ƴ��� Ŭ�����̴�.
���� ���ÿ� �׳� System.in

���ڱ�� ��Ʈ�� Ŭ������ �̸� ��Ģ
�Է�: ~~Reader
���: ~~Writer
�ѱ�(2byte)�� �ȱ�����.
*/

package com.ss.io;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

class KeyBoardApp{
	public static void main(String[] args){
		InputStream is=System.in;
		InputStreamReader reader=null;
		reader=new InputStreamReader(is);
		int data;
		
		try{
			while(true){
				//data=is.read(); //1byte �о���� �̹��������Ҷ� � ����
				/*System.out.print(data); //��������� ������ ����(13, 10)ģ�Ŵ� �ȳ����� a���ش��ϴ� 97�� ��µ�
				data=is.read(); //1byte �о���� 13
				System.out.print(data);
				data=is.read(); //1byte �о���� 10
				System.out.print(data);*/
				//System.out.print((char)data); ����� ��µ����� �ѱ��� ������

				/*���ڱ�� ��Ʈ���� �ܵ����� �����ϴ� ���� �ƴ϶�, �̹�
				����Ʈ ��� ��Ʈ���� ������ �Ѵ�. ���� ������ �������� �μ���
				����Ʈ��� ��Ʈ���� �ִ´�.*/
				 //byte��� �ڷ����� ���ڷ� �;��Ѵ�.���׷��̵� ����, 3d�Ȱ�	
				data=reader.read();
				System.out.print((char)data);
			}


		}catch(IOException e){
			//JOptionPane.showMessageDialog(this, "IO�۾��� ����");//��Ŭ������ JFrame(container)�� �ƴ϶� ����
			System.out.print("IO�۾��� ����");
		}
	}	
}
