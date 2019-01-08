package 各类;

import java.io.*;
import java.util.*;

//课程
public class Lesson implements Serializable{
	
	private String ID;//课程id
	private String teachID;//老师id
	private ArrayList<Score> stuScore;//Score:学生ID 学生姓名 学生成绩 
	
	private String name;//课程名称
	
	public void setID(String lessonID) {
		this.ID=lessonID;
	}
	public String getID() {
		return ID;
	}
	public void setTeachID(String teachID) {
		this.teachID=teachID;
	}
	public String getTeachID() {
		return teachID;
	}
	
	////////添加学生ID
	public void addStu(Score t) {
		if(stuScore==null) {
			stuScore=new ArrayList<>();
		}
		stuScore.add(t);
	}
	/////////返回学生ID
	public ArrayList<Score> getStu(){
		return stuScore;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Lesson#"+ID;
	}
}

















