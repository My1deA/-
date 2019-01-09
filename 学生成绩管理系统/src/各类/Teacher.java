package 各类;

import java.util.*;
import java.io.*;

public class Teacher implements Serializable {
	
	private String ID;//老师ID；
	private String passWord;//老师密码
	private ArrayList<String> lessonID;//老师的课程 放课程Id
	
	private String name;//老师名字
	
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
	
	///////添加课程ID
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

	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Teacher#"+ID;
	}
	
}








