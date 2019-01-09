package 各类;

import java.io.Serializable;

public class Score implements Serializable {
	
	private String ID;//学生id
	private String name;//学生姓名
	private double CWA;//考勤 check work attendance
	private double TEST;//测试
	private double HW;//作业     HomeWork
	private double EOT;//期末   End of term
	private double SUM;//总评 
	
	public Score() {
		
	}
	public Score(String ID,String NAME) {
		this.ID=ID;
		this.name=NAME;
	}
	public Score(String ID,String NAME,double CWA,double TEST,double HW,double EOT) {
		this.ID=ID;
		this.name=NAME;
		this.CWA=CWA;
		this.TEST=TEST;
		this.HW=HW;
		this.EOT=EOT;
		setSUM();
	}
	
	public void setID(String ID) {
		this.ID=ID;
	}
	public String getID() {
		return ID;
	}
	public void setName(String NAME) {
		this.name=NAME;
	}
	public String getName() {
		return name;
	}
	public void setCWA(double CWA) {
		this.CWA=CWA;
	}
	public double getCWA() {
		return CWA;
	}
	public void setTEST(double TEST) {
		this.TEST=TEST;
	}
	public double getTEST() {
		return TEST;
	}
	public void setHW(double HW) {
		this.HW=HW;
	}
	public double getHW() {
		return HW;
	}
	public void setEOT(double EOT) {
		this.EOT=EOT;
	}
	public double getEOT() {
		return EOT;
	}
	public void setSUM() {
		this.SUM=CWA+TEST+HW+EOT;
	}
	public double getSUM() {
		return SUM;
	}
	
	
}


























