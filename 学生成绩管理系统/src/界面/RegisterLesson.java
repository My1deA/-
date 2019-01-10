package 界面;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import 文件.DB;
import 文件.LessonFileOperate;
import 文件.StudentFileOperate;
import 文件.TeacherFileOperate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import 各类.*;


public class RegisterLesson extends JFrame implements Check,CreateObject {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public RegisterLesson() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("课程名称:");
		label.setFont(new Font("宋体", Font.PLAIN, 13));
		label.setBounds(68, 57, 68, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("课程编号:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 13));
		label_1.setBounds(68, 114, 68, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("任课老师账号:");
		label_2.setFont(new Font("宋体", Font.PLAIN, 13));
		label_2.setBounds(42, 173, 85, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("教学专业:");
		label_3.setFont(new Font("宋体", Font.PLAIN, 13));
		label_3.setBounds(68, 225, 68, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("教学班级:");
		label_4.setFont(new Font("宋体", Font.PLAIN, 13));
		label_4.setBounds(68, 273, 68, 15);
		contentPane.add(label_4);
		
		//课堂名称
		textField = new JTextField();
		textField.setBounds(146, 54, 146, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		//课程id
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(146, 111, 146, 21);
		contentPane.add(textField_1);
		//老师id
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(146, 170, 146, 21);
		contentPane.add(textField_2);
		//专业
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(146, 222, 146, 21);
		contentPane.add(textField_3);
		//班级
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(146, 270, 146, 21);
		contentPane.add(textField_4);
		
		
		//创建课程
		JButton btnNewButton = new JButton("创   建");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||
						textField_3.getText().equals("")||textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(new JFrame(),"还有未填写的信息", "", JOptionPane.WARNING_MESSAGE);
				}else if(check()){
					
				}else {
					create();
				}
				
			}

//			private boolean check() {
			
		});
		btnNewButton.setBounds(55, 353, 93, 23);
		contentPane.add(btnNewButton);
		
		
		//返回
		JButton button = new JButton("返   回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				AdminFrame a=new AdminFrame();
				dispose();
			}
		});
		button.setBounds(263, 353, 93, 23);
		contentPane.add(button);
		
		this.setLocationRelativeTo(null);
		this.setTitle("创建课程");
		this.setVisible(true);
	}
	
	public boolean check() {
		// TODO Auto-generated method stub\
		//检测课程是否存在
		String lid=textField_1.getText();
		for(int i=0;i<DB.arrLes.size();i++) {
			if(lid.equals(DB.arrLes.get(i).getID())) {
				JOptionPane.showMessageDialog(new JFrame(), "已经有相同课程编号","", JOptionPane.WARNING_MESSAGE);
				return true;
			}
		}
		//检测老师id是否存在
		String tid=textField_2.getText();
		boolean flag=false;
		for(int i=0;i<DB.arrTea.size();i++) {
			if(tid.equals(DB.arrTea.get(i).getID())) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			JOptionPane.showMessageDialog(new JFrame(), "没有相应的教师","", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		
		//检测学生是否存在
		 String major=textField_3.getText();
		 String clazz=textField_4.getText();
		 boolean flag1=false;
		 for(int i=0;i<DB.arrStu.size();i++) {
			 Student s=DB.arrStu.get(i);
			 if(s.getMajor().equals(major)&&s.getClass().equals(clazz)) {
				 flag=true;
				 break;
			 }
		 }
		 if(!flag) {
			 JOptionPane.showMessageDialog(new JFrame(), "没有相应的学生", "", JOptionPane.WARNING_MESSAGE);
			 return true;
		 }

		return false;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		String lesName=textField.getText();//课程名字
		String lesID=textField_1.getText();//课程编号
		String teaID=textField_2.getText();//课程任课老师id
		String major=textField_3.getText();//专业
		String clazz=textField_4.getText();//班级
		
		//创建课程
		Lesson l=new Lesson();
		l.setTeachID(teaID);
		l.setName(lesName);
		l.setID(lesID);
		
		/**
		 * 分界线-----------------------------
		 */

		//老师的信息
		for(int i=0;i<DB.arrTea.size();i++) {
			Teacher t=DB.arrTea.get(i);
			if(t.getID().equals(teaID)) {
				t.addLesson(lesID);
				DB.arrTea.set(i, t);
				break;
			}
		}
		

		//学生的信息修改
		ArrayList<Integer> rec=new ArrayList<Integer>();//记录多少个学生
				
		for(int i=0;i<DB.arrStu.size();i++) {
			Student s=DB.arrStu.get(i);
			if(s.getClassID().equals(clazz)&&s.getMajor().equals(major)) {
				s.addLesson(lesID);
				DB.arrStu.set(i, s);
				rec.add(i);
			}
		}
		
		/**
		 *  将课程名单修改
		 */
		
		//课程信息修改 和学生上的课修改
		for(int i=0;i<rec.size();i++) {
			
			Student s2=DB.arrStu.get(rec.get(i));		
			Score s=new Score(s2.getID(),s2.getName());
			l.addStu(s);
			
//			s2.addLesson(lesID);
//			DB.arrStu.set(rec.get(i), s2);
			
			
		}
		DB.arrLes.add(l);
		
		TeacherFileOperate.writeTeacher();
		StudentFileOperate.writeStudent();
		LessonFileOperate.writeLesson();
		
		JOptionPane.showMessageDialog(new JFrame(), "创建课程成功", "", JOptionPane.INFORMATION_MESSAGE);
	}
	
}








































