package ����;

import java.util.*;
import java.io.*;
//ѧ��

public class Student implements Serializable{
	
	private String ID;//ѧ��ѧ��
	private String passWord;//ѧ������
	private ArrayList<String> lessonIDGroup;//ѧ���γ� �ſγ�Id
	
	private String name;//����
	private int classID;//�༶
	private String majorName;//רҵ����
	
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
	
	/////////��ӿγ�ID
	public void addLesson(Lesson t) {
		if(lessonIDGroup==null) {
			lessonIDGroup=new ArrayList<>();
		}
		lessonIDGroup.add(t.getID());
	}
	/////////���ؿγ�ID
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
























