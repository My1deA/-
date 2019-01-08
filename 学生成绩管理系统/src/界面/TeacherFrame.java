package 界面;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class TeacherFrame extends JFrame {

	private JPanel contentPane;
	public static int index;
	
	public TeacherFrame(int index) {
		this.index=index;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u67E5\u770B\u6253\u5370\u6210\u7EE9");
		button.setBounds(28, 37, 136, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		button_1.setBounds(288, 37, 136, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u5F55\u5165\u5B66\u751F\u6210\u7EE9");
		button_2.setBounds(160, 37, 136, 23);
		contentPane.add(button_2);
		
		this.setLocationRelativeTo(null);
		this.setTitle("教师端");
		this.setVisible(true);
	}
}
