package �ļ�;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ����.Teacher;

public class TeacherFileOperate {
	//��ȡ
		public static void readTeacher(){
			try {
				File f1=new File("Teacher.txt");
				FileInputStream f2=new FileInputStream(f1);
				ObjectInputStream f3=new ObjectInputStream(f2);
				DB.arrTea=(ArrayList<Teacher>)f3.readObject();
				
				f3.close();
				f2.close();
				
			}catch(IOException e) {
				System.out.println("Tecaher Read IO Exception");
				DB.arrTea=new ArrayList<Teacher>();
			}catch(ClassNotFoundException e) {
				System.out.println("Tecaher Read Class Not Found Exception");
			}
		}
		
		//д��
		public static void writeTeacher() {
			try {
				File f1=new File("Teacher.txt");
				FileOutputStream f2=new FileOutputStream(f1);
				ObjectOutputStream f3=new ObjectOutputStream(f2);
				f3.writeObject((ArrayList<Teacher>)DB.arrTea);
				
				f3.close();
				f2.close();
			}catch(IOException e) {
				System.out.println("Tecaher Write IO Exception");
			}
		}
}
