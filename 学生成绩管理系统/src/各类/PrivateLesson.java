package ¸÷Àà;

import java.io.Serializable;

public class PrivateLesson implements Serializable {
	private int lesIndex;
	private int myPosition;
	
	public int getLesIndex() {
		return lesIndex;
	}
	public void setLesIndex(int lesIndex) {
		this.lesIndex = lesIndex;
	}
	public int getMyPosition() {
		return myPosition;
	}
	public void setMyPosition(int myPosition) {
		this.myPosition = myPosition;
	}
	
}
