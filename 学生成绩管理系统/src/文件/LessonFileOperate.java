package �ļ�;

import java.util.*;
import java.io.*;
import ����.*;

public class LessonFileOperate {
	//��ȡ
		public static void readLesson(){
			try {
				File f1=new File("Lesson.txt");
				FileInputStream f2=new FileInputStream(f1);
				ObjectInputStream f3=new ObjectInputStream(f2);
				DB.arrLes=(ArrayList<Lesson>)f3.readObject();
				
				f3.close();
				f2.close();
				
			}catch(IOException e) {
				System.out.println("Lesson Read IO Exception");
				DB.arrLes=new ArrayList<Lesson>();
			}catch(ClassNotFoundException e) {
				System.out.println("Lesson Read Class Not Found Exception");
			}
		}
		
		//д��
		public static void writeLesson() {
			try {
				File f1=new File("Lesson.txt");
				FileOutputStream f2=new FileOutputStream(f1);
				ObjectOutputStream f3=new ObjectOutputStream(f2);
				f3.writeObject((ArrayList<Lesson>)DB.arrLes);
				
				f3.close();
				f2.close();
				
			}catch(IOException e) {
				System.out.println("Lesson Write IO Exception");
			}
		}
}








