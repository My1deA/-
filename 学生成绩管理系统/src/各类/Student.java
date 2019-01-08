package 各类;

import java.util.*;
import java.io.*;
//学生

public class Student implements Serializable{
	
	private String ID;//学生学号
	private String passWord;//学生密码
	private ArrayList<String> lessonIDGroup;//学生课程 放课程Id
	
	private String name;//名字
	private int classID;//班级
	private String majorName;//专业名称
	
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
	
	/////////添加课程ID
	public void addLesson(Lesson t) {
		if(lessonIDGroup==null) {
			lessonIDGroup=new ArrayList<>();
		}
		lessonIDGroup.add(t.getID());
	}
	/////////返回课程ID
	public ArrayList<String> getLesson(){
		return lessonIDGroup;
	}
	
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setClassID(int classID) {
		this.classID=classID;
	}
	
	public String toString() {
		return "Stduent#"+ID;
	}
	
}
























