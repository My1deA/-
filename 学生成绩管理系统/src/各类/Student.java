package ����;

import java.util.*;
import java.io.*;
//ѧ��

public class Student implements Serializable{
	
	private String ID;//ѧ��ѧ��
	private String passWord;//ѧ������

	private String name;//����
	private String classID;//�༶
	private String major;//רҵ����

	private ArrayList<String> lessonIDGroup;//ѧ���γ� �ſγ�Id
	/////////��ӿγ�ID
	public void addLesson(String t) {
		if(lessonIDGroup==null) {
			lessonIDGroup=new ArrayList<>();
		}
		lessonIDGroup.add(t);
	}
	/////////���ؿγ�ID
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
//	private ArrayList<PrivateLesson> stuLes;//�γ� �±�
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
























