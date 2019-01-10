package ����;
import ����.*;
import �ļ�.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private ButtonGroup buttonGroup;
	
	public static int index;
	
	public Login() {
		LessonFileOperate.readLesson();
		StudentFileOperate.readStudent();
		TeacherFileOperate.readTeacher();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("�� ��:");
		label.setFont(new Font("����", Font.PLAIN, 12));
		label.setBounds(95, 38, 50, 33);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("�� ��:");
		label_1.setFont(new Font("����", Font.PLAIN, 12));
		label_1.setBounds(95, 81, 50, 33);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 87, 146, 21);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(164, 44, 146, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton radioButton = new JRadioButton("ѧ��");
		radioButton.setBounds(79, 143, 66, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("��ʦ");
		radioButton_1.setBounds(178, 143, 70, 23);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("�������");
		radioButton_2.setBounds(271, 143, 89, 23);
		contentPane.add(radioButton_2);
		
		buttonGroup=new ButtonGroup();
		buttonGroup.add(radioButton);
		buttonGroup.add(radioButton_1);
		buttonGroup.add(radioButton_2);
		
		JButton button = new JButton("��    ¼");
		
		//radioButton     		 ѧ��
		//radioButton_1     	��ʦ
		//radioButton_2 		����
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(check()) {
					JOptionPane.showMessageDialog(new JFrame(), "����δ��д����Ϣ", "", JOptionPane.WARNING_MESSAGE);
				}else if(exist()){
					JOptionPane.showMessageDialog(new JFrame(), "û����ID����", "", JOptionPane.WARNING_MESSAGE);
				}else {
					match();
				}
			}

			private void match() {
				// TODO Auto-generated method stub
				if(radioButton_2.isSelected()) {
					if(textField.getText().equals("Admin")&&String.valueOf(passwordField.getPassword()).equals("123")) {
						JOptionPane.showMessageDialog(new JFrame(), "��¼�ɹ�", "", JOptionPane.INFORMATION_MESSAGE);
						AdminFrame a=new AdminFrame();
						dispose();
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "�������", "", JOptionPane.WARNING_MESSAGE);
					}
				}
				
				///��ʦ��¼
				else if(radioButton_1.isSelected()) {
					if(String.valueOf(passwordField.getPassword()).equals(String.valueOf(DB.arrTea.get(index).getPassWord()))) {
						JOptionPane.showMessageDialog(new JFrame(), "��¼�ɹ�", "", JOptionPane.INFORMATION_MESSAGE);
						TeacherFrame t=new TeacherFrame(index);
						dispose();
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "�������", "", JOptionPane.WARNING_MESSAGE);
					}
				}
				
				///ѧ����¼
				else {
					if(String.valueOf(passwordField.getPassword()).equals(String.valueOf(DB.arrStu.get(index).getPassWord()))) {
						JOptionPane.showMessageDialog(new JFrame(), "��¼�ɹ�", "", JOptionPane.INFORMATION_MESSAGE);
						StudentFrame s=new StudentFrame(index);
						dispose();
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "�������", "", JOptionPane.WARNING_MESSAGE);
					}
				}
			}

			private boolean exist() {
				// TODO Auto-generated method stub
				if(radioButton_2.isSelected()) {//����
					if(!textField.getText().equals("Admin"))return true;
					
				}else if(radioButton_1.isSelected()) {//��ʦ
					for(int i=0;i<DB.arrTea.size();i++) {
						Teacher t=DB.arrTea.get(i);
						if(t.getID().equals(textField.getText())) {
							index=i;
							return false;
						}
					}
					return true;
				}else {//ѧ��
					for(int i=0;i<DB.arrStu.size();i++) {
						Student s=DB.arrStu.get(i);
						if(s.getID().equals(textField.getText())) {
							index=i;
							return false;
						}
					}
					return true;
					
				}
				return false;
			}

			private boolean check() {
				// TODO Auto-generated method stub
				if(textField.getText().equals("")||String.valueOf(passwordField.getPassword()).equals("")){
			       	return true;
				}
				return false;
			}
		});
		button.setBounds(79, 204, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("��    ��");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_1.setBounds(256, 204, 93, 23);
		contentPane.add(button_1);
		
		
		this.setLocationRelativeTo(null);
		this.setTitle("ѧ���ɼ�����ϵͳ");
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}















