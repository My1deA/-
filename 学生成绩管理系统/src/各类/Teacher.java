package ����;

import java.util.*;
import java.io.*;

public class Teacher implements Serializable {
	
	private String ID;//��ʦID��
	private String passWord;//��ʦ����
	private ArrayList<String> lessonID;//��ʦ�Ŀγ� �ſγ�Id
	
	private String name;//��ʦ����
	
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
	
	///////��ӿγ�ID
	public void addLesson(String t) {
		if(lessonID==null) {
			lessonID=new ArrayList<>();
		}
		lessonID.add(t);
	}
	/////////���ؿγ�ID
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








