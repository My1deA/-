package 界面;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.ComboBox;
import 各类.Teacher;
import 文件.DB;
import 文件.TeacherFileOperate;

import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TeacherFrame extends JFrame {

	private JPanel contentPane;
	private int index;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Teacher teacher;
	private JTextField textField_4;

	public TeacherFrame(int index) {
		this.index=index;
		teacher=DB.arrTea.get(index);
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
		label_3.setBounds(75, 143, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u6240\u6559\u8BFE\u7A0B\uFF1A");
		label_4.setBounds(69, 278, 73, 15);
		panel.add(label_4);
		
		
		//查看账号
		textField_2 = new JTextField();
		textField_2.setBounds(161, 81, 141, 21);
		textField_2.setText(teacher.getID());
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		//查看姓名
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(161, 143, 141, 21);
		textField_3.setText(teacher.getName());
		panel.add(textField_3);
		
		
		//查看密码
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(161, 205, 141, 21);
		textField_4.setText(teacher.getPassWord());
		panel.add(textField_4);
		
		//查看课程
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(161, 275, 141, 21);
		panel.add(comboBox_1);
		for(int i=0;i<teacher.getLesson().size();i++) {
			comboBox_1.addItem(teacher.getLesson().get(i));
		}
		
		
		JLabel label_5 = new JLabel("\u5BC6   \u7801\uFF1A");
		label_5.setBounds(75, 208, 54, 15);
		panel.add(label_5);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("修改个人信息", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u59D3  \u540D\uFF1A");
		label.setBounds(94, 98, 69, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_1.setBounds(94, 187, 69, 15);
		panel_1.add(label_1);
		
		
		//修改个人信息 姓名
		textField = new JTextField();
		textField.setBounds(156, 95, 156, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		//修改个人密码
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(156, 184, 156, 21);
		panel_1.add(textField_1);
		
		JButton button = new JButton("\u786E   \u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().length()==0&&textField_1.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(new JFrame(), "还有未填写完的信息", "", JOptionPane.WARNING_MESSAGE);
				}else {
					teacher.setName(textField.getText());
					teacher.setPassWord(textField_1.getText());
					
					DB.arrTea.set(index, teacher);
					TeacherFileOperate.writeTeacher();
				}
			}
		});
		button.setBounds(219, 256, 93, 23);
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
						EntryResult entryRerult=new EntryResult(i);
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
