package ����;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import �ļ�.DB;
import �ļ�.LessonFileOperate;
import �ļ�.StudentFileOperate;
import �ļ�.TeacherFileOperate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import ����.*;


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
		
		JLabel label = new JLabel("�γ�����:");
		label.setFont(new Font("����", Font.PLAIN, 13));
		label.setBounds(68, 57, 68, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("�γ̱��:");
		label_1.setFont(new Font("����", Font.PLAIN, 13));
		label_1.setBounds(68, 114, 68, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("�ο���ʦ�˺�:");
		label_2.setFont(new Font("����", Font.PLAIN, 13));
		label_2.setBounds(42, 173, 85, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("��ѧרҵ:");
		label_3.setFont(new Font("����", Font.PLAIN, 13));
		label_3.setBounds(68, 225, 68, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("��ѧ�༶:");
		label_4.setFont(new Font("����", Font.PLAIN, 13));
		label_4.setBounds(68, 273, 68, 15);
		contentPane.add(label_4);
		
		//��������
		textField = new JTextField();
		textField.setBounds(146, 54, 146, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		//�γ�id
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(146, 111, 146, 21);
		contentPane.add(textField_1);
		//��ʦid
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(146, 170, 146, 21);
		contentPane.add(textField_2);
		//רҵ
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(146, 222, 146, 21);
		contentPane.add(textField_3);
		//�༶
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(146, 270, 146, 21);
		contentPane.add(textField_4);
		
		
		//�����γ�
		JButton btnNewButton = new JButton("��   ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||
						textField_3.getText().equals("")||textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(new JFrame(),"����δ��д����Ϣ", "", JOptionPane.WARNING_MESSAGE);
				}else if(check()){
					
				}else {
					create();
				}
				
			}

//			private boolean check() {
			
		});
		btnNewButton.setBounds(55, 353, 93, 23);
		contentPane.add(btnNewButton);
		
		
		//����
		JButton button = new JButton("��   ��");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				AdminFrame a=new AdminFrame();
				dispose();
			}
		});
		button.setBounds(263, 353, 93, 23);
		contentPane.add(button);
		
		this.setLocationRelativeTo(null);
		this.setTitle("�����γ�");
		this.setVisible(true);
	}
	
	public boolean check() {
		// TODO Auto-generated method stub\
		//���γ��Ƿ����
		String lid=textField_1.getText();
		for(int i=0;i<DB.arrLes.size();i++) {
			if(lid.equals(DB.arrLes.get(i).getID())) {
				JOptionPane.showMessageDialog(new JFrame(), "�Ѿ�����ͬ�γ̱��","", JOptionPane.WARNING_MESSAGE);
				return true;
			}
		}
		//�����ʦid�Ƿ����
		String tid=textField_2.getText();
		boolean flag=false;
		for(int i=0;i<DB.arrTea.size();i++) {
			if(tid.equals(DB.arrTea.get(i).getID())) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			JOptionPane.showMessageDialog(new JFrame(), "û����Ӧ�Ľ�ʦ","", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		
		//���ѧ���Ƿ����
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
			 JOptionPane.showMessageDialog(new JFrame(), "û����Ӧ��ѧ��", "", JOptionPane.WARNING_MESSAGE);
			 return true;
		 }

		return false;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		String lesName=textField.getText();//�γ�����
		String lesID=textField_1.getText();//�γ̱��
		String teaID=textField_2.getText();//�γ��ο���ʦid
		String major=textField_3.getText();//רҵ
		String clazz=textField_4.getText();//�༶
		
		//�����γ�
		Lesson l=new Lesson();
		l.setTeachID(teaID);
		l.setName(lesName);
		l.setID(lesID);
		
		/**
		 * �ֽ���-----------------------------
		 */

		//��ʦ����Ϣ
		for(int i=0;i<DB.arrTea.size();i++) {
			Teacher t=DB.arrTea.get(i);
			if(t.getID().equals(teaID)) {
				t.addLesson(lesID);
				DB.arrTea.set(i, t);
				break;
			}
		}
		

		//ѧ������Ϣ�޸�
		ArrayList<Integer> rec=new ArrayList<Integer>();//��¼���ٸ�ѧ��
				
		for(int i=0;i<DB.arrStu.size();i++) {
			Student s=DB.arrStu.get(i);
			if(s.getClassID().equals(clazz)&&s.getMajor().equals(major)) {
				s.addLesson(lesID);
				DB.arrStu.set(i, s);
				rec.add(i);
			}
		}
		
		/**
		 *  ���γ������޸�
		 */
		
		//�γ���Ϣ�޸� ��ѧ���ϵĿ��޸�
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
		
		JOptionPane.showMessageDialog(new JFrame(), "�����γ̳ɹ�", "", JOptionPane.INFORMATION_MESSAGE);
	}
	
}








































