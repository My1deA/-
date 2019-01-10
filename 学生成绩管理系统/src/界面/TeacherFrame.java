package 界面;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import 各类.Teacher;
import 文件.DB;

import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TeacherFrame extends JFrame {

	private JPanel contentPane;
	private int index;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeacherFrame2 frame = new TeacherFrame2();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TeacherFrame(int index) {
		this.index=index;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 425, 400);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("查看个人信息", null, panel, null);
		panel.setLayout(null);
		
		JLabel label_2 = new JLabel("\u8D26  \u53F7\uFF1A");
		label_2.setBounds(75, 84, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u59D3  \u540D\uFF1A");
		label_3.setBounds(75, 163, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u6240\u6559\u8BFE\u7A0B\uFF1A");
		label_4.setBounds(75, 245, 73, 15);
		panel.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(161, 81, 141, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(161, 160, 141, 21);
		panel.add(textField_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(161, 245, 141, 21);
		panel.add(comboBox_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("修改个人信息", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u59D3  \u540D\uFF1A");
		label.setBounds(94, 68, 69, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_1.setBounds(94, 117, 69, 15);
		panel_1.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(156, 65, 156, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(156, 114, 156, 21);
		panel_1.add(textField_1);
		
		JButton button = new JButton("\u786E   \u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(219, 183, 93, 23);
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("录入课程成绩", null, panel_2, null);
		panel_2.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(44, 140, 193, 21);
		panel_2.add(comboBox);
		Teacher t=DB.arrTea.get(index);
		for(int i=0;i<t.getLesson().size();i++) {
			comboBox.addItem(t.getLesson().get(i));
		}
		JButton btnNewButton = new JButton("\u5F55  \u5165");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=(String) comboBox.getSelectedItem();//得到java123
				for(int i=0;i<DB.arrLes.size();i++) {
					if(str.equals(DB.arrLes.get(i).getID())) {
						Test t=new Test(i);
						break;
					}
				}
			}
		});
		btnNewButton.setBounds(283, 139, 93, 23);
		panel_2.add(btnNewButton);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
