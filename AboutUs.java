package com.RRS;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AboutUs {

	public static void about() {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				JFrame f = new JFrame("Indian Railways -- About Us");
				f.setSize(1000,515);
				f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				f.setVisible(true);
				f.setLayout(null);
				f.getContentPane().setBackground(Color.decode("#333333"));
				f.setResizable(false);
				
				JLabel head = new JLabel("MINI PROJECT 2020-2021");
				head.setFont(new Font("Monospaced",Font.BOLD,35));
				head.setForeground(Color.decode("#ffffaa"));
				head.setBounds(227,25,700,40);
				f.add(head);
				head.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						((JLabel) e.getSource()).setForeground(Color.decode("#ADD8E6"));
						head.setBounds(227,25,705,45);
					}

					public void mouseExited(MouseEvent e) {
						((JLabel) e.getSource()).setForeground(Color.decode("#ffffaa"));
						head.setBounds(227,25,700,40);
					}

				});
				
				JLabel head2 = new JLabel("RAILWAY RESERVATION SYSTEM");
				head2.setFont(new Font("Monospaced",Font.BOLD,35));
				head2.setForeground(Color.decode("#ffffaa"));
				head2.setBounds(190,80,700,40);
				f.add(head2);
				head2.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						((JLabel) e.getSource()).setForeground(Color.decode("#ADD8E6"));
						head2.setBounds(190,80,705,45);
					}

					public void mouseExited(MouseEvent e) {
						((JLabel) e.getSource()).setForeground(Color.decode("#ffffaa"));
						head2.setBounds(190,80,700,40);
					}

				});
				
				JLabel l = new JLabel("Made by the students of SE-6 for Semester 3");
				l.setForeground(Color.white);
				l.setFont(new Font("Consolas",Font.BOLD,24));
				l.setBounds(184,140,600,30);
				f.add(l);
				l.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						l.setBounds(184,140,605,35);
					}

					public void mouseExited(MouseEvent e) {
						l.setBounds(184,140,600,30);
					}

				});
				l.addMouseListener(new LbHover());
				
				
				String[][] jrow = {{"    1","     Shivam Prajapati","     39"},{"    2","     Sarim Qureshi","     40"},{"    3","     Yashas Rao","     42"}};
				
				String[] jcol= {"","Name","Roll Number"};
				
				JTable tb=new JTable(jrow,jcol);
					
			tb = new JTable(jrow,jcol) {
			         public boolean editCellAt(int row, int column, java.util.EventObject e) {
			            return false;
			         }
			      };
			    tb.setRowHeight(33);
			    tb.setFont(new Font("Dialog",Font.PLAIN,18));
				JScrollPane bjsp=new JScrollPane(tb);
				
				JTableHeader hd = tb.getTableHeader();
				hd.setFont(new Font("Dialog", Font.BOLD, 23));
				hd.setBackground(Color.decode("#bb4453"));
				hd.setForeground(Color.white);
				hd.setPreferredSize(new Dimension(960, 45));
				
				bjsp.setBounds(160,210,620,148);
				bjsp.getViewport().add(tb);
				
				tb.getColumnModel().getColumn(0).setPreferredWidth(6);
				tb.getColumnModel().getColumn(1).setPreferredWidth(300);
				tb.getColumnModel().getColumn(2).setPreferredWidth(200);
				
				f.add(bjsp);
				
				JLabel ll = new JLabel("Guided by Prof. Lukesh Kadu");
				ll.setForeground(Color.white);
				ll.setFont(new Font("Consolas",Font.BOLD,26));
				ll.setBounds(260,400,400,30);
				ll.addMouseListener(new LbHover());
				f.add(ll);
				ll.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						ll.setBounds(260,400,405,35);
					}

					public void mouseExited(MouseEvent e) {
						ll.setBounds(260,400,400,30);
					}

				});
				
				
//				JLabel l1 = new JLabel(new ImageIcon("C:\\Users\\Sarim Qureshi\\Downloads\\dummy.png"));
//				l1.setBounds(150,200,140,140);
//				f.add(l1);
//				l1.addMouseListener(new MouseAdapter() {
//					public void mouseEntered(MouseEvent e) {
//						
//						l1.setBounds(160,205,140,140);
//
//					}
//
//					public void mouseExited(MouseEvent e) {
//					
//						l1.setBounds(150,200,140,140);
//
//					}
//
//				});
//				
//				JLabel n1 = new JLabel("Shivam Prajapati");
//				JLabel r1 = new JLabel("Roll no 39");
//				n1.setForeground(Color.white);
//				r1.setForeground(Color.white);
//				n1.addMouseListener(new LbHover());
//				r1.addMouseListener(new LbHover());
//				n1.setFont(new Font("Consolas",Font.BOLD,20));
//				r1.setFont(new Font("Consolas",Font.BOLD,20));
//				n1.setBounds(150,350,200,30);
//				r1.setBounds(150,375,140,30);
//				f.add(n1);
//				f.add(r1);
//
//
//				JLabel l2 = new JLabel(new ImageIcon("C:\\Users\\Sarim Qureshi\\Downloads\\dummy2.jpg"));
//				l2.setBounds(400,200,140,140);
//				f.add(l2);
//				l2.addMouseListener(new MouseAdapter() {
//					public void mouseEntered(MouseEvent e) {
//						
//						l2.setBounds(410,205,140,140);
//
//					}
//
//					public void mouseExited(MouseEvent e) {
//					
//						l2.setBounds(400,200,140,140);
//
//					}
//
//				});
//				
//				JLabel n2 = new JLabel("Sarim Qureshi");
//				JLabel r2 = new JLabel("Roll no 40");
//				n2.setForeground(Color.white);
//				r2.setForeground(Color.white);
//				n2.addMouseListener(new LbHover());
//				r2.addMouseListener(new LbHover());
//				n2.setFont(new Font("Consolas",Font.BOLD,20));
//				r2.setFont(new Font("Consolas",Font.BOLD,20));
//				n2.setBounds(400,350,200,30);
//				r2.setBounds(400,375,140,30);
//				f.add(n2);
//				f.add(r2);
//				
//				JLabel l3 = new JLabel(new ImageIcon("C:\\Users\\Sarim Qureshi\\Downloads\\dummy3.jpg"));
//				l3.setBounds(650,200,140,140);
//				f.add(l3);
//				l3.addMouseListener(new MouseAdapter() {
//					public void mouseEntered(MouseEvent e) {
//						
//						l3.setBounds(660,205,140,140);
//
//					}
//
//					public void mouseExited(MouseEvent e) {
//					
//						l3.setBounds(650,200,140,140);
//
//					}
//
//				});
//
//				
//				JLabel n3 = new JLabel("Yashas Rao");
//				JLabel r3 = new JLabel("Roll no 42");
//				n3.setForeground(Color.white);
//				r3.setForeground(Color.white);
//				n3.addMouseListener(new LbHover());
//				r3.addMouseListener(new LbHover());
//				n3.setFont(new Font("Consolas",Font.BOLD,20));
//				r3.setFont(new Font("Consolas",Font.BOLD,20));
//				n3.setBounds(650,350,200,30);
//				r3.setBounds(650,375,140,30);
//				f.add(n3);
//				f.add(r3);
//				
//				JLabel ll = new JLabel("Guided by Lukesh Kadu");
//				ll.setForeground(Color.white);
//				ll.setFont(new Font("Consolas",Font.BOLD,26));
//				ll.setBounds(320,594,300,30);
//				ll.addMouseListener(new LbHover());
//				f.add(ll);
//			
//
//				
//				JLabel l4 = new JLabel(new ImageIcon("C:\\Users\\Sarim Qureshi\\Downloads\\dummy4.jpg"));
//				l4.setBounds(650,480,140,140);
//				f.add(l4);
//				l4.addMouseListener(new MouseAdapter() {
//					public void mouseEntered(MouseEvent e) {
//						
//						l4.setBounds(660,485,140,140);
//
//					}
//
//					public void mouseExited(MouseEvent e) {
//					
//						l4.setBounds(650,480,140,140);
//
//					}
//
//				});

				
			}
		});
	}
	public static void main(String[] args) {
		AboutUs.about();
	}

}
