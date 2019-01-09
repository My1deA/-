package 界面;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherFrame extends JFrame {

	private JPanel contentPane;
	public static int index;
	
	public TeacherFrame(int index) {
		this.index=index;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 86, 414, 337);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1, 1);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button_3 = new JButton("\u7B2C\u4E00\u4E2A\u9762\u677F");
		button_3.setBounds(111, 132, 93, 23);
		panel_1.add(button_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 383, 317);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton button_4 = new JButton("\u7B2C\u4E8C\u4E2A\u9762\u677F");
		button_4.setBounds(136, 146, 93, 23);
		panel_2.add(button_4);
		
		
		//查看信息
		JButton button = new JButton("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(true);
				panel_2.setVisible(false);
			}
		});
		button.setBounds(10, 33, 136, 23);
		contentPane.add(button);
		
		//录入成绩
		JButton button_1 = new JButton("\u5F55\u5165\u5B66\u751F\u6210\u7EE9");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		
		//打印成绩
		JButton button_2 = new JButton("\u67E5\u770B\u6253\u5370\u6210\u7EE9");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(142, 33, 136, 23);
		contentPane.add(button_1);
		button_2.setBounds(275, 33, 136, 23);
		contentPane.add(button_2);
		
		
		this.setLocationRelativeTo(null);
		this.setTitle("教师端");
		this.setVisible(true);
	}
	

}
