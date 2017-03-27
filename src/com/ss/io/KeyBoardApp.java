/*FileInputSteam 등은 개발자가 원하는 시점에 스트림을 생성할 수 있지만,
키보드와 같은 표준 입력 하드웨어의 경우엔 자바가 스트림을 생성하지 못하고 해당 os가 관리하므로,
자바 개발자는 os로 부터 표준입력 스트림을 얻어와야 한다.

자바의 클래스 중 System 클래스의 static 멤버변수 중 즉 has a관계로 보유한 inputStream형
in 객체가 바로 표준입력 스트림을 받아놓은 클래스이다.
따라서 사용시엔 그냥 System.in

문자기반 스트림 클래스의 이름 규칙
입력: ~~Reader
출력: ~~Writer
한글(2byte)이 안깨진다.
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
				//data=is.read(); //1byte 읽어들임 이미지복사할때 등에 좋음
				/*System.out.print(data); //여기까지만 있으면 엔터(13, 10)친거는 안나오고 a에해당하는 97만 출력됨
				data=is.read(); //1byte 읽어들임 13
				System.out.print(data);
				data=is.read(); //1byte 읽어들임 10
				System.out.print(data);*/
				//System.out.print((char)data); 영어는 출력되지만 한글은 깨진다

				/*문자기반 스트림은 단독으로 존재하는 것이 아니라, 이미
				바이트 기반 스트림을 전제로 한다. 따라서 생성시 생성자의 인수에
				바이트기반 스트림을 넣는다.*/
				 //byte기반 자료형이 인자로 와야한다.업그레이드 빨때, 3d안경	
				data=reader.read();
				System.out.print((char)data);
			}


		}catch(IOException e){
			//JOptionPane.showMessageDialog(this, "IO작업중 에러");//이클래스가 JFrame(container)이 아니라 못씀
			System.out.print("IO작업중 에러");
		}
	}	
}
