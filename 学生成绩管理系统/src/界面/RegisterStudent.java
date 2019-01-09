package 界面;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import 各类.*;
import 文件.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	public RegisterStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5B66\u751F\u8D26\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(61, 37, 70, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5B66\u751F\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(61, 93, 70, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(61, 153, 70, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5B66\u751F\u73ED\u7EA7\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(61, 198, 70, 40);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u5B66\u751F\u4E13\u4E1A\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(61, 270, 70, 15);
		contentPane.add(label_4);
		
		//账号
		textField = new JTextField();//
		textField.setBounds(145, 34, 156, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		//姓名
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 150, 156, 21);
		contentPane.add(textField_1);
		//班级
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(145, 208, 156, 21);
		contentPane.add(textField_2);
		//专业
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(145, 267, 156, 21);
		contentPane.add(textField_3);
		//密码
		passwordField = new JPasswordField();
		passwordField.setBounds(145, 90, 156, 21);
		contentPane.add(passwordField);
		
		//注册学生
		JButton button = new JButton("\u6CE8   \u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||String.valueOf(passwordField.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "还有未填写信息", "",JOptionPane.WARNING_MESSAGE );
				}
				else if(check()) {
					JOptionPane.showMessageDialog(new JFrame(), "已经有相同id的学生", "",JOptionPane.WARNING_MESSAGE );
				}else {
					Student s=new Student();
					s.setID(textField.getText());
					s.setName(textField_1.getText());
					s.setClassID(textField_2.getText());
					s.setMajor(textField_3.getText());
					s.setPassWord(String.valueOf(passwordField.getPassword()));
					
					DB.arrStu.add(s);
					StudentFileOperate.writeStudent();
					
					JOptionPane.showMessageDialog(new JFrame(), "学生用户注册成功", "", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}

			private boolean check() {
				// TODO Auto-generated method stub
				String id=textField.getText();
				for(int i=0;i<DB.arrStu.size();i++) {
					if(DB.arrStu.get(i).equals(id))return true;
				}
				
				return false;
			}
		});
		button.setBounds(81, 363, 93, 23);
		contentPane.add(button);
		
		
		//返回
		JButton button_1 = new JButton("\u8FD4   \u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminFrame a=new AdminFrame();
				dispose();
			}
		});
		button_1.setBounds(276, 363, 93, 23);
		contentPane.add(button_1);
	}
}
