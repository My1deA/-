package 界面;

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
		//注册教师
		JButton button = new JButton("注 册 老 师");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RegisterTeacher t=new RegisterTeacher();
			}
		});
		button.setBounds(10, 150, 138, 35);
		contentPane.add(button);
		
		//注册学生
		JButton button_1 = new JButton("注 册 学 生");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterStudent s=new RegisterStudent();
				dispose();
			}
		});
		button_1.setBounds(144, 150, 144, 35);
		contentPane.add(button_1);
		
		//注册课程
		JButton button_2 = new JButton("注 册 课 程");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterLesson l=new RegisterLesson();
				dispose();
			}
		});
		button_2.setBounds(286, 150, 138, 35);
		contentPane.add(button_2);
		
		JLabel lblAdmin = new JLabel("欢迎 Admin 登录");
		lblAdmin.setFont(new Font("宋体", Font.PLAIN, 14));
		lblAdmin.setBounds(10, 10, 114, 15);
		contentPane.add(lblAdmin);
		
		JLabel label = new JLabel("学生成绩管理系统后台");
		label.setFont(new Font("宋体", Font.PLAIN, 28));
		label.setBounds(75, 55, 301, 66);
		contentPane.add(label);
		
		this.setLocationRelativeTo(null);
		this.setTitle("学生成绩管理系统后台");
		this.setVisible(true);
	}
	
//	public static void main(String[] args) {
//		AdminFrame A=new AdminFrame();
//	}

}
