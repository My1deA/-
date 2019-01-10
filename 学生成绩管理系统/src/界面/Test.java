package 界面;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;

public class Test {
	
		private JPanel contentPane;
		private JTable table;
		private JTable table_1;
		private int index;

		/**
		 * Launch the application.
		 */
//		public static void main(String[] args) {
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						Test frame = new ;
//						frame.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		}

		/**
		 * Create the frame.
		 */
		 public Test(int index) {
			// TODO Auto-generated constructor stub
			 this.index=index;
			 JFrame jf=new JFrame();
			 
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setBounds(100, 100, 601, 779);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			jf.setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(10, 10, 565, 157);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel label = new JLabel("\u671F\u672B\u8003\u8BD5\u6210\u7EE9\u5355");
			label.setFont(new Font("宋体", Font.PLAIN, 20));
			label.setBounds(199, 10, 170, 30);
			panel.add(label);
			
			JLabel label_1 = new JLabel("\u8BFE \u7A0B\uFF1A");
			label_1.setFont(new Font("宋体", Font.PLAIN, 14));
			label_1.setBounds(38, 47, 54, 15);
			panel.add(label_1);
			
			JLabel label_2 = new JLabel("\u6559 \u5E08\uFF1A");
			label_2.setFont(new Font("宋体", Font.PLAIN, 14));
			label_2.setBounds(38, 82, 54, 15);
			panel.add(label_2);
			
			JLabel label_3 = new JLabel("\u73ED \u7EA7\uFF1A");
			label_3.setFont(new Font("宋体", Font.PLAIN, 14));
			label_3.setBounds(38, 116, 54, 15);
			panel.add(label_3);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
			lblNewLabel.setBounds(145, 47, 150, 15);
			panel.add(lblNewLabel);
			
			JLabel label_4 = new JLabel("");
			label_4.setFont(new Font("宋体", Font.PLAIN, 14));
			label_4.setBounds(145, 82, 150, 15);
			panel.add(label_4);
			
			JLabel label_5 = new JLabel("");
			label_5.setFont(new Font("宋体", Font.PLAIN, 14));
			label_5.setBounds(145, 116, 150, 15);
			panel.add(label_5);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 189, 565, 314);
			contentPane.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column", "New column", "New column"
				}
			));
			scrollPane.setViewportView(table);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(10, 513, 565, 118);
			contentPane.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			panel_2.add(scrollPane_1, BorderLayout.CENTER);
			
			table_1 = new JTable();
			table_1.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					"New column", "New column", "New column"
				}
			));
			scrollPane_1.setViewportView(table_1);
			jf.setVisible(true);
		}
		public static void main(String[] args) {
			EntryResult e=new EntryResult();
		}
}


