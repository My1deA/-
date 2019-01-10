package 界面;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import 文件.DB;
import 文件.LessonFileOperate;
import 文件.StudentFileOperate;
import 文件.TeacherFileOperate;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import 各类.*;

public class StudentFrame extends JFrame {

	private JPanel contentPane;
	public static int index;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Student student;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public StudentFrame(int index) {
		this.index=index;
		student=DB.arrStu.get(index);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 20, 414, 357);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("查看个人信息", null, panel, null);
		panel.setLayout(null);
		
		JLabel label = new JLabel("学生姓名:");
		label.setBounds(67, 44, 60, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("学生账号:");
		label_1.setBounds(67, 99, 60, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("学生专业:");
		label_2.setBounds(67, 155, 60, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("学生班级");
		label_3.setBounds(67, 213, 60, 15);
		panel.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(147, 41, 171, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 96, 171, 21);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 152, 171, 21);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(147, 210, 171, 21);
		panel.add(textField_3);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("修改个人信息", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_4 = new JLabel("学生姓名:");
		label_4.setBounds(55, 83, 70, 15);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("学生密码:");
		label_5.setBounds(55, 155, 70, 15);
		panel_1.add(label_5);
		
		
		
		
		textField_4 = new JTextField();
		textField_4.setBounds(144, 80, 164, 21);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(144, 152, 164, 21);
		panel_1.add(textField_5);
		
		JButton btnNewButton = new JButton("保  存");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student t=DB.arrStu.get(index);
				t.setName(textField_4.getText());
				t.setPassWord(textField_5.getText());
				DB.arrStu.set(index, t);
				StudentFileOperate.writeStudent();
			}
		});
		btnNewButton.setBounds(215, 230, 93, 23);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("查看课程成绩", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 10, 389, 187);
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout());
		//System.out.println(student.getLesson().size());
		String container[][]=new String[20][6];
		String head[]= {"课程","考勤","测试","作业","期末","总评"};
		for(int i=0;i<student.getLesson().size();i++) {
			for(int j=0;j<DB.arrLes.size();j++) {
				if(student.getLesson().get(i).equals(DB.arrLes.get(j).getID())) {
					container[i][0]=DB.arrLes.get(j).getName();
					//System.out.println(container[i][0]);
					for(int k=0;k<DB.arrLes.get(j).getStu().size();k++) {
						if(student.getID().equals(DB.arrLes.get(j).getStu().get(k).getID())) {
							container[i][1]=String.valueOf(DB.arrLes.get(j).getStu().get(k).getCWA());
							container[i][2]=String.valueOf(DB.arrLes.get(j).getStu().get(k).getTEST());
							container[i][3]=String.valueOf(DB.arrLes.get(j).getStu().get(k).getHW());
							container[i][4]=String.valueOf(DB.arrLes.get(j).getStu().get(k).getEOT());
							container[i][5]=String.valueOf(DB.arrLes.get(j).getStu().get(k).getSUM());
							break;
						}
					}
					break;
				}
			}
		}
		
		DefaultTableModel tableModel=new DefaultTableModel(container, head);
		table=new JTable(tableModel);
		JScrollPane jsp=new JScrollPane(table);
		panel_3.add(jsp,BorderLayout.CENTER);
		table.setSelectionBackground(Color.CYAN);
		TableColumn tableColmun=table.getColumnModel().getColumn(0);
		tableColmun.setMinWidth(65);
		
		
		
		
		this.setLocationRelativeTo(null);
		this.setTitle("学生端");
		this.setVisible(true);
	}
	public static void main(String[] args) {
		TeacherFileOperate.readTeacher();
		StudentFileOperate.readStudent();
		LessonFileOperate.readLesson();
		StudentFrame s=new StudentFrame(0);
	}
}
