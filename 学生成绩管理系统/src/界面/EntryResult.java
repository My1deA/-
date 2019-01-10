package 界面;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import 文件.*;
import 各类.*;



public class EntryResult extends JFrame{

	private int index;
	private Lesson lesson;
	private JFrame frame;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JTable table;
	private JTable table2;
	private JScrollPane jsp1;
	private JScrollPane jsp2;
	private Font font1;
	private Font font2;
	private JButton button;//保存
	private JButton button2;//打印
	//panel1的标签
	private JLabel label1;//期末考试成绩单
	private JLabel label2;//课程
	private JLabel label3;//课程准确名称
	private JLabel label4;//教师
	private JLabel label5;//教师准确名称
	private JLabel label6;//班级
	private JLabel label7;//2017级 xxx专业 xx班
	
	private int count[]=new int[5];//90-100


	
	
	
	public EntryResult(int index) {
		this.index=index;
		lesson=DB.arrLes.get(index);
		
		
		font1=new Font("微软宋体", Font.BOLD, 24);
		font2=new Font("微软宋体", Font.BOLD, 18);
		
		frame=new JFrame("Test");
		frame.setBounds(10,10,700,900);
		frame.setLayout(null);
		
		panel1=new JPanel();
		panel1.setBounds(10, 10, 655, 200);
		panel1.setLayout(null);
		frame.add(panel1);
		
		label1=new JLabel("期末考试成绩单");
		label1.setFont(font1);
		label1.setBounds(225, 10, 200, 30);
		panel1.add(label1);
		/////////////////
		label2=new JLabel("课 程 ：");
		label2.setFont(font2);
		label2.setBounds(50,50,75,18);
		panel1.add(label2);
		
		label3=new JLabel(lesson.getName());
		label3.setFont(font2);
		label3.setBounds(275, 50, 150,18);
		panel1.add(label3);
		/////////////////
		label4=new JLabel("教 师 ：");
		label4.setFont(font2);
		label4.setBounds(50,100,75,18);
		panel1.add(label4);
		
		String tName = null;
		for(int i=0;i<DB.arrTea.size();i++) {
			if(lesson.getTeachID().equals(DB.arrTea.get(i).getID())) {
				tName=DB.arrTea.get(i).getName();
				break;
			}
		}
		
		label3=new JLabel(tName);
		label3.setFont(font2);
		label3.setBounds(275, 100, 150,18);
		panel1.add(label3);
		////////////////
		label4=new JLabel("班 级 ：");
		label4.setFont(font2);
		label4.setBounds(50,150,75,18);
		panel1.add(label4);
		
		String sID=lesson.getStu().get(0).getID();
		Student student=null;
		for(int i=0;i<DB.arrStu.size();i++) {
			if(sID.equals(DB.arrStu.get(i).getID())) {
				label3=new JLabel("2017级"+DB.arrStu.get(i).getMajor()+"专业"+DB.arrStu.get(i).getClassID()+"班");
				label3.setFont(font2);
				label3.setBounds(275, 150, 250,18);
				panel1.add(label3);
				break;
			}
		}
		////////////////
		
		
		panel2=new JPanel();
		panel2.setBounds(10,220,655,350);
		panel2.setLayout(new BorderLayout());
		frame.add(panel2);
		
		String [][] container=new String [30][7];
		String [] head= {"学号","姓名","考勤","测试","作业","期末","总评"};
		for(int i=0;i<30;i++) {
			if(i<lesson.getStu().size()) {
				container[i][0]=lesson.getStu().get(i).getID();
				container[i][1]=lesson.getStu().get(i).getName();
				if(lesson.getStu().get(i).getCWA()!=0) {
					container[i][2]=String.valueOf(lesson.getStu().get(i).getCWA());
				}
				if(lesson.getStu().get(i).getTEST()!=0) {
					container[i][3]=String.valueOf(lesson.getStu().get(i).getTEST());
				}
				if(lesson.getStu().get(i).getHW()!=0) {
					container[i][4]=String.valueOf(lesson.getStu().get(i).getHW());
				}
				if(lesson.getStu().get(i).getEOT()!=0) {
					container[i][5]=String.valueOf(lesson.getStu().get(i).getEOT());
				}
				if(lesson.getStu().get(i).getSUM()!=0) {
					container[i][6]=String.valueOf(lesson.getStu().get(i).getSUM());
				}
			}
		}
		
		DefaultTableModel tablemodel=new DefaultTableModel(container,head);
		table=new JTable(tablemodel);
		jsp1=new JScrollPane(table);
		panel2.add(jsp1,BorderLayout.CENTER);
		
		//表格的列
		TableColumn tablecomlum=table.getColumnModel().getColumn(0);
		tablecomlum.setMinWidth(150);
		tablecomlum=table.getColumnModel().getColumn(1);
		tablecomlum.setMinWidth(100);
		
		//表格的行
		table.setRowHeight(25);
		//表格的选中的元素
		table.setSelectionForeground(Color.BLUE);
		table.setSelectionBackground(Color.YELLOW);
//		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		// panel3
		panel3=new JPanel();
		panel3.setBounds(10,590,655,200);
		panel3.setLayout(new GridLayout(1,2));
		frame.add(panel3);
		
		panel4=new JPanel();
		panel5=new JPanel();
		panel4.setLayout(new BorderLayout());
		panel5.setLayout(null);
		panel3.add(panel4);
		panel3.add(panel5);
		
		//panel4
		String [][] container2= {{"90-100",null,null},{"80-89",null,null},{"70-79",null,null},{"60-69",null,null},{"0-59",null,null}};
		String [] head2= {"成绩区段","人数","百分比"};
		for(int j=0;j<lesson.getStu().size();j++) {
			String sum=(String)table.getModel().getValueAt(j, 6);
			
		    Double d=Double.parseDouble(sum);
			if(d<59) {
				count[4]++;
			}else if(d<69) {
					count[3]++;
			}
			else if(d<79){
				count[2]++;
			}else if(d<89) {
				count[1]++;
			}else {
				count[0]++;
			}
		}
		
		for(int i=0;i<5;i++) {
			container2[i][1]=String.valueOf(count[i]);
			double perent=(double)count[i]/lesson.getStu().size();
			container2[i][2]=String.valueOf(perent*100+"%");
		}
		
		DefaultTableModel tabelModel2=new DefaultTableModel(container2,head2);
		table2=new JTable(tabelModel2);
		jsp2=new JScrollPane(table2);
		panel4.add(jsp2);
		
		table2.setRowHeight(35);
		table2.setSelectionBackground(Color.YELLOW);
		table2.setSelectionForeground(Color.blue);
//		
//		TableColumn tableColumn2=table.getColumnModel().getColumn(0);
//		tableColumn2.setMinWidth(150);
		

		
		///panel5
		button=new JButton("保 存 数 据");
		button.setBounds(100,75,100,25);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String s;
				//Score score=new Score();
				for(int i=0;i<lesson.getStu().size();i++) {
					
					s=(String)table.getModel().getValueAt(i, 2);
					if(!s.equals("")) {
						System.out.println(table.getModel().getValueAt(i,2));
						lesson.getStu().get(i).setCWA(Double.parseDouble(s));
					}
					
					s=(String)table.getModel().getValueAt(i, 3);
					if(!s.equals("")) {
						System.out.println(table.getModel().getValueAt(i,3));
						lesson.getStu().get(i).setTEST(Double.parseDouble(s));
					}
					
					s=(String)table.getModel().getValueAt(i, 4);
					if(!s.equals("")) {
						System.out.println(table.getModel().getValueAt(i,4));
						lesson.getStu().get(i).setHW(Double.parseDouble(s));
					}
					
					s=(String)table.getModel().getValueAt(i, 5);
					if(!s.equals("")) {
						System.out.println(table.getModel().getValueAt(i,5));
						lesson.getStu().get(i).setEOT(Double.parseDouble(s));
					}
					lesson.getStu().get(i).setSUM();
				}
				DB.arrLes.set(index, lesson);
				LessonFileOperate.writeLesson();
				
				
			}
		});
		
		button2=new JButton("  返  回  ");
		button2.setBounds(100, 125, 100, 25);
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		

		panel5.add(button);
		panel5.add(button2);
		//frame.add(button);
		
		

		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
//	public static void main(String[] args) {
//		TeacherFileOperate.readTeacher();
//		StudentFileOperate.readStudent();
//		LessonFileOperate.readLesson();
//		EntryResult t=new EntryResult(0);
//	}
}




















