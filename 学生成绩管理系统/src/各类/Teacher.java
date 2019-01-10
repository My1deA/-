package 各类;

import java.util.*;
import java.io.*;

public class Teacher implements Serializable {
	
	private String ID;//老师ID；
	private String name;//老师名字
	private String passWord;//老师密码

	private ArrayList<String> lessonID;//老师的课程 放课程Id
	/////添加课程ID
	public void addLesson(String t) {
		if(lessonID==null) {
			lessonID=new ArrayList<>();
		}
		lessonID.add(t);
	}
	/////////返回课程ID
	public ArrayList<String> getLesson() {
		return lessonID;
	}
	public void setID(String ID) {
		this.ID=ID;
	}
	public String getID() {
		return ID;
	}
	public void setPassWord(String passWord) {
		this.passWord=passWord;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Teacher#"+ID;
	}
	
//	private ArrayList<Integer> lesIndex;//课程下标
//	
//	public void addLes(int i) {
//		if(lesIndex==null) {
//			lesIndex=new ArrayList<Integer>();
//		}
//		lesIndex.add(i);
//	}
//	public ArrayList<Integer> getLes(){
//		return lesIndex;
//	}
	
}








