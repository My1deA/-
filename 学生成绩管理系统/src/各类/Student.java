package 各类;

import java.util.*;
import java.io.*;
//学生

public class Student implements Serializable{
	
	private String ID;//学生学号
	private String passWord;//学生密码

	private String name;//名字
	private String classID;//班级
	private String major;//专业名称

	private ArrayList<String> lessonIDGroup;//学生课程 放课程Id
	/////////添加课程ID
	public void addLesson(String t) {
		if(lessonIDGroup==null) {
			lessonIDGroup=new ArrayList<>();
		}
		lessonIDGroup.add(t);
	}
	/////////返回课程ID
	public ArrayList<String> getLesson(){
		return lessonIDGroup;
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
	public void setClassID(String classID) {
		this.classID=classID;
	}
	public String getClassID() {
		return classID;
	}
	public void setMajor(String major) {
		this.major=major;
	}
	public String getMajor() {
		return major;
	}
	
	public String toString() {
		return "Stduent#"+ID;
	}
//	private ArrayList<PrivateLesson> stuLes;//课程 下标
//	public void addLes(PrivateLesson p) {
//		if(stuLes==null) {
//			stuLes=new ArrayList<PrivateLesson>();
//		}
//		stuLes.add(p);
//	}
//	public ArrayList<PrivateLesson> getLes(){
//		return stuLes;
//	}
	
	
}
























