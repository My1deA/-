package 界面;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFrame2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame2 frame = new AdminFrame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 465, 403);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("注册老师", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("注册学生", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("创建课程", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u540D\u79F0:");
		label.setFont(new Font("宋体", Font.PLAIN, 13));
		label.setBounds(101, 29, 68, 15);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u7F16\u53F7:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 13));
		label_1.setBounds(101, 86, 68, 15);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("\u4EFB\u8BFE\u8001\u5E08\u8D26\u53F7:");
		label_2.setFont(new Font("宋体", Font.PLAIN, 13));
		label_2.setBounds(75, 145, 85, 15);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("\u6559\u5B66\u4E13\u4E1A:");
		label_3.setFont(new Font("宋体", Font.PLAIN, 13));
		label_3.setBounds(101, 197, 68, 15);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("\u6559\u5B66\u73ED\u7EA7:");
		label_4.setFont(new Font("宋体", Font.PLAIN, 13));
		label_4.setBounds(101, 245, 68, 15);
		panel_2.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(179, 26, 146, 21);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(179, 83, 146, 21);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(179, 142, 146, 21);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(179, 194, 146, 21);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(179, 242, 146, 21);
		panel_2.add(textField_4);
		//课程创建
		JButton button = new JButton("\u521B   \u5EFA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		button.setBounds(88, 325, 93, 23);
		panel_2.add(button);
		
		JButton button_1 = new JButton("\u8FD4   \u56DE");
		button_1.setBounds(296, 325, 93, 23);
		panel_2.add(button_1);
	}

}
