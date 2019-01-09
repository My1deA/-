package ����;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ����.Teacher;
import �ļ�.DB;
import �ļ�.TeacherFileOperate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterTeacher extends JFrame implements Check,CreateObject{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private boolean flag=true;
	
	public RegisterTeacher() {
		 
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6559\u5E08\u8D26\u53F7\uFF1A");
		label.setFont(new Font("����", Font.PLAIN, 14));
		label.setBounds(69, 63, 72, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(69, 116, 72, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label_2.setFont(new Font("����", Font.PLAIN, 14));
		label_2.setBounds(69, 13, 72, 15);
		contentPane.add(label_2);
		
		JLabel label_4 = new JLabel("\u6559\u5E08\u5BC6\u7801\uFF1A");
		label_4.setFont(new Font("����", Font.PLAIN, 14));
		label_4.setBounds(69, 160, 72, 15);
		contentPane.add(label_4);
		
		//name
		textField = new JTextField();//name
		textField.setBounds(151, 10, 137, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		//id
		textField_1 = new JTextField();//id
		textField_1.setColumns(10);
		textField_1.setBounds(151, 60, 137, 21);
		contentPane.add(textField_1);
		

		passwordField = new JPasswordField();//����1
		passwordField.setBounds(151, 113, 137, 21);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();//����2
		passwordField_1.setBounds(151, 157, 137, 21);
		contentPane.add(passwordField_1);
		
		
		//ע��
		JButton button = new JButton("\u6CE8  \u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")||textField_1.getText().equals("")||String.valueOf(passwordField.getPassword()).equals("")||String.valueOf(passwordField_1.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "����δ��д����Ϣ", "����", JOptionPane.WARNING_MESSAGE);
					
				}
				else if(!String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordField_1.getPassword()))) {
					JOptionPane.showMessageDialog(new JFrame(), "�����������벻һ��", "", JOptionPane.WARNING_MESSAGE);
				}else if(check()){
					JOptionPane.showMessageDialog(new JFrame(), "�Ѿ�����ͬID�Ľ�ʦ", "", JOptionPane.WARNING_MESSAGE);
				}else {
					
					
					create();

				}
			}

		});
		button.setBounds(76, 213, 93, 23);
		contentPane.add(button);
		
		//����
		JButton button_1 = new JButton("\u8FD4  \u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminFrame a=new AdminFrame();
			}
		});
		button_1.setBounds(255, 213, 93, 23);
		contentPane.add(button_1);
		
		
		this.setLocationRelativeTo(null);
		this.setTitle("ע���ʦ");
		this.setVisible(true);
	}
	
	public boolean check() {
		// TODO Auto-generated method stub
		String id=textField_1.getText();
		for(int i=0;i<DB.arrTea.size();i++) {
			Teacher t=DB.arrTea.get(i);
			if(id.equals(t.getID())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		Teacher t=new Teacher();
		t.setName(textField.getText());
		t.setID(textField_1.getText());
		t.setPassWord(String.valueOf(passwordField.getPassword()));
		
		DB.arrTea.add(t);
		TeacherFileOperate.writeTeacher();
		
		JOptionPane.showMessageDialog(new JFrame(), "ע��ɹ�", "", JOptionPane.INFORMATION_MESSAGE);

	}
}


