package ����;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class AdminFrame extends JFrame {

	private JPanel contentPane;

	public AdminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//ע���ʦ
		JButton button = new JButton("ע �� �� ʦ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RegisterTeacher t=new RegisterTeacher();
			}
		});
		button.setBounds(10, 150, 138, 35);
		contentPane.add(button);
		
		//ע��ѧ��
		JButton button_1 = new JButton("ע �� ѧ ��");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterStudent s=new RegisterStudent();
				dispose();
			}
		});
		button_1.setBounds(144, 150, 144, 35);
		contentPane.add(button_1);
		
		//ע��γ�
		JButton button_2 = new JButton("ע �� �� ��");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterLesson l=new RegisterLesson();
				dispose();
			}
		});
		button_2.setBounds(286, 150, 138, 35);
		contentPane.add(button_2);
		
		JLabel lblAdmin = new JLabel("��ӭ Admin ��¼");
		lblAdmin.setFont(new Font("����", Font.PLAIN, 14));
		lblAdmin.setBounds(10, 10, 114, 15);
		contentPane.add(lblAdmin);
		
		JLabel label = new JLabel("ѧ���ɼ�����ϵͳ��̨");
		label.setFont(new Font("����", Font.PLAIN, 28));
		label.setBounds(75, 55, 301, 66);
		contentPane.add(label);
		
		this.setLocationRelativeTo(null);
		this.setTitle("ѧ���ɼ�����ϵͳ��̨");
		this.setVisible(true);
	}
	
//	public static void main(String[] args) {
//		AdminFrame A=new AdminFrame();
//	}

}
