/*
 * �ڹٿ����� ���丮�� �����ϱ� ���� Ŭ������ ������ �������� �ʰ�,
 * ���丮�� ���Ϸ� �����Ѵ�.
 * ���: java.io.File Ŭ������ ����+���丮���� ó���Ѵ�.
 * 
 * */

package com.ss.file;

import java.io.File;

public class FileTest {
	
	public FileTest() {
		//c����̺��� ������ �����ϴ� ��� ���丮 �� ������ ����غ���!
		File file=new File("c:/");
		
		//���� ���丮 �� ������ ��� ����
		//String[] dir=file.list(); 
		File[] dir=file.listFiles(); //���Ϸ� �޾ƾ� �� �������� �� �� �ִ�.
		
		/*
		for (String e : dir) {
			System.out.println(e);
		}
		*/
		
		for (int i = 0; i < dir.length; i++) {
			if(dir[i].isDirectory()){
				System.out.println(dir[i].getName());		
			}
		}
		
		
	}

	public static void main(String[] args) {
		new FileTest();
	}

}
