package 文件;

import java.util.*;
import java.io.*;
import 各类.*;

public class StudentFileOperate {
	//读取
		public static void readStudent(){
			try {
				File f1=new File("Student.txt");
				FileInputStream f2=new FileInputStream(f1);
				ObjectInputStream f3=new ObjectInputStream(f2);
				DB.arrStu=(ArrayList<Student>)f3.readObject();
				
				f3.close();
				f2.close();
				
			}catch(IOException e) {
				System.out.println("Student Read IO Exception");
				DB.arrStu=new ArrayList<Student>();
			}catch(ClassNotFoundException e) {
				System.out.println("Student Read Class Not Found Exception");
			}
		}
		
		//写入
		public static void writeStudent() {
			try {
				File f1=new File("Student.txt");
				FileOutputStream f2=new FileOutputStream(f1);
				ObjectOutputStream f3=new ObjectOutputStream(f2);
				f3.writeObject((ArrayList<Student>)DB.arrStu);
				
				f3.close();
				f2.close();
				
			}catch(IOException e) {
				System.out.println("Student Write IO Exception");
			}
		}
}








