package ����;

import java.io.*;
import java.util.*;

//�γ�
public class Lesson implements Serializable{
	
	private String ID;//�γ�id
	private String teachID;//��ʦid
	private ArrayList<Score> stuScore;//Score:ѧ��ID ѧ������ ѧ���ɼ� 
	
	private String name;//�γ�����
	
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
	
	////////���ѧ��ID
	public void addStu(Score t) {
		if(stuScore==null) {
			stuScore=new ArrayList<>();
		}
		stuScore.add(t);
	}
	/////////����ѧ��ID
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

















