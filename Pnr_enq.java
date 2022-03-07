package com.RRS;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.JTableHeader;


public class Pnr_enq {

	public static void pnr()
		{
			
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
			Font f = new Font("Arial", Font.BOLD, 17);
			Font t = new Font("Arial", Font.BOLD, 14);

			
			JFrame jpnr = new JFrame("Indian Railways -- PNR enquiry");
			jpnr.setSize(900,340);
			jpnr.getContentPane().setBackground(Color.decode("#333333"));
			jpnr.setLayout(null);
			jpnr.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			jpnr.setVisible(true);
			jpnr.setResizable(false);
			
			JLabel head = new JLabel("PNR enquiry");
			head.setForeground(Color.white);
			head.addMouseListener(new LbHover());
			head.setBounds(322, 10, 500, 40);
			head.setFont(new Font("Bookman", Font.BOLD, 30));
			jpnr.add(head);
			
			JLabel sticl = new JLabel();
			sticl.setText("Enter PNR Number");
			sticl.setBounds(110,65,200,30);
			sticl.setForeground(Color.white); 
			sticl.setFont(f);
			sticl.addMouseListener(new LbHover());
			jpnr.add(sticl);
			
			
			JTextField stic = new JTextField();
			stic.setBounds(110, 115, 150, 22);
			stic.setFont(t);
			jpnr.add(stic);
			
			JButton sbtic=new JButton("Search");
			sbtic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			sbtic.setBackground(Color.ORANGE);
			sbtic.setBounds(560,101,200,30);
			sbtic.setFont(f);
			sbtic.setForeground(Color.white);
			sbtic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			sbtic.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					sbtic.setBackground(Color.decode("#FD6A02"));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					sbtic.setBackground(Color.orange);
				}

			});
			
			jpnr.add(sbtic);
			
			Font fo = new Font("Consolas",Font.BOLD,15);
			
			JLabel sticl2 = new JLabel();
			sticl2.setText("Choose train");
			sticl2.setBounds(360,65,160,30);
			sticl2.addMouseListener(new LbHover());
			sticl2.setForeground(Color.white);
			sticl2.setFont(f);
			jpnr.add(sticl2);
			
			JRadioButton b1 = new JRadioButton("Regular train");
			JRadioButton b2 = new JRadioButton("Special train");
			b1.setFont(fo); b2.setFont(fo);
			b1.setBackground(Color.decode("#333333"));
			b2.setBackground(Color.decode("#333333"));
			b1.setForeground(Color.decode("#f2f3f4"));
			b2.setForeground(Color.decode("#f2f3f4"));
			b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b1.setBounds(340,105,200,20);
			b2.setBounds(340,125,180,20);
			jpnr.add(b1); jpnr.add(b2);
			
			ButtonGroup bg = new ButtonGroup();
			bg.add(b1); bg.add(b2);
			
			JLabel warn = new JLabel();
			warn.setFont(new Font("Arial", Font.BOLD, 40));
			warn.setForeground(Color.red);
			warn.setBounds(210,140,840,63);
			jpnr.add(warn);
			
			jpnr.repaint();
			

			
			if(User.getUsername()==null) {
				warn.setText("Login for PNR enquiry");
				warn.setFont(new Font("Arial", Font.BOLD, 38));
				warn.setForeground(Color.red);
				warn.setBounds(210,155,840,63);
				stic.setEditable(false);
				sbtic.setEnabled(false);
				jpnr.setSize(900,290);
			}
			else {
			sbtic.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent we)
			
				{
					jpnr.repaint();
					
					if(stic.getText().isEmpty() && !b1.isSelected() && !b2.isSelected()){
						warn.setText("Please fill the necessary fields");
						warn.setFont(new Font("Consolas", Font.BOLD, 28));
						warn.setForeground(Color.red);
						warn.setBounds(173,180,840,63);
					}
				  else if(stic.getText().isEmpty()){
						warn.setText("Enter PNR number");
						warn.setFont(new Font("Consolas", Font.BOLD, 33));
						warn.setForeground(Color.red);
						warn.setBounds(260,180,840,63);
					 }
				  else if(!b1.isSelected() && !b2.isSelected()) {
					    warn.setText("Select a train");
						warn.setFont(new Font("Consolas", Font.BOLD, 34));
						warn.setForeground(Color.red);
						warn.setBounds(260,180,840,63);
				     }
				  else{	  
					 
					  if(b1.isSelected()) {
						  
						  warn.setText("");
						  
						  String tn="", pnr="", tdt="", tp="", d="", fn="", ln="";
						  boolean flag = false; 
						  
						  try
							{
								Class.forName("com.mysql.cj.jdbc.Driver");
				    			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs","root","");
				    			Statement stmt=con.createStatement();
				    			String txt=stic.getText();
				    			ResultSet rs=stmt.executeQuery("select * from rpnr where pnrno="+txt);
				    			
				    			while(rs.next())
				    			{
				    				flag = true;
				    				tn = Integer.toString(rs.getInt(1));
				    				pnr = Integer.toString(rs.getInt(2));
				    				tdt = rs.getString(3);
				    				tp = Integer.toString(rs.getInt(4));
				    				d = rs.getString(5);
				    				fn = rs.getString(6);
				    				ln = rs.getString(7);
				    			}
				    			con.close();
				    		}
							catch(Exception re)
							{
								System.out.print(re);
							}
						  
							
						  if(flag) {
							  
						 
							String[] bcol= {"Train number","PNR number","Departure time","ticket price","Date","First name","Last name"};
							
							String[][] brow = new String[1][7];
							
								brow[0][0] = tn;
								brow[0][1] = pnr;
								brow[0][2] = tdt;
								brow[0][3] = tp;
								brow[0][4] = d;
								brow[0][5] = fn;
								brow[0][6] = ln;
						  
							    JTable bstab = new JTable(brow,bcol);
								
								bstab = new JTable(brow, bcol) {
							         public boolean editCellAt(int row, int column, java.util.EventObject e) {
							            return false;
							         }
							      };
								
								bstab.setFont(new Font("Dialog", Font.PLAIN, 13));
								bstab.setRowHeight(25);
								
								JTableHeader hd = bstab.getTableHeader();
								hd.setFont(new Font("Dialog", Font.BOLD, 16));
								hd.setBackground(Color.decode("#0e2433"));
								hd.setForeground(Color.white);
								hd.setPreferredSize(new Dimension(840, 35));

							    JScrollPane js = new JScrollPane();
								js.setBounds(20,190,840,63);
								js.getViewport().add(bstab);
								jpnr.add(js);
								sbtic.setEnabled(false);
								new java.util.Timer().schedule( 
								        new java.util.TimerTask() {
								            
								            public void run() {   
								            	jpnr.remove(js);
								            	sbtic.setEnabled(true);
								            }
								        }, 
								        100 
								);
								
						  }
						  else {
							    warn.setText("Enter correct PNR number");
								warn.setFont(new Font("Consolas", Font.BOLD, 28));
								warn.setForeground(Color.red);
								warn.setBounds(220,180,840,63);
						  }
						  
					  }
					  
                if(b2.isSelected()) {
                	
                	      warn.setText("");
						  
						  String tn="", pnr="", tdt="", tp="", d="", fn="", ln="";
						  boolean flag = false;
						  
						  try
							{
								Class.forName("com.mysql.cj.jdbc.Driver");
				    			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs","root","");
				    			Statement stmt=con.createStatement();
				    			String txt=stic.getText();
				    			ResultSet rs=stmt.executeQuery("select * from pnr where pnrno="+txt);
				    			
				    			while(rs.next())
				    			{
				    				flag = true;
				    				tn = rs.getString(1);
				    				pnr = Integer.toString(rs.getInt(2));
				    				tdt = rs.getString(3);
				    				tp = Integer.toString(rs.getInt(4));
				    				d = rs.getString(5);
				    				fn = rs.getString(6);
				    				ln = rs.getString(7);
				    			}
				    			con.close();
				    		}
							catch(Exception re)
							{
								System.out.print(re);
							}
						  
							if(flag) {
								
							String[] bcol= {"Train number","PNR number","Departure time","ticket price","Date","First name","Last name"};
							
							String[][] brow = new String[1][7];
							
								brow[0][0] = tn;
								brow[0][1] = pnr;
								brow[0][2] = tdt;
								brow[0][3] = tp;
								brow[0][4] = d;
								brow[0][5] = fn;
								brow[0][6] = ln;
						  
								JTable bstab =new JTable(brow,bcol);
								
								bstab = new JTable(brow, bcol) {
							         public boolean editCellAt(int row, int column, java.util.EventObject e) {
							            return false;
							         }
							      };
								
								bstab.setFont(new Font("Dialog", Font.PLAIN, 13));
								bstab.setRowHeight(25);
								
								JTableHeader hd = bstab.getTableHeader();
								hd.setFont(new Font("Dialog", Font.BOLD, 16));
								hd.setBackground(Color.decode("#0e2433"));
								hd.setForeground(Color.white);
								hd.setPreferredSize(new Dimension(840, 35));

								JScrollPane js = new JScrollPane();
								js.setBounds(20,190,840,63);
								js.getViewport().add(bstab);
								jpnr.add(js);
								sbtic.setEnabled(false);
								new java.util.Timer().schedule( 
								        new java.util.TimerTask() {
								            
								            public void run() {   
								            	jpnr.remove(js);
								            	sbtic.setEnabled(true);
								            }
								        }, 
								        100 
								);
								
							}else {
								
								warn.setText("Enter correct PNR number");
								warn.setFont(new Font("Consolas", Font.BOLD, 28));
								warn.setForeground(Color.red);
								warn.setBounds(220,180,840,63);
							}
						  
					  }

					  
				  }
					
					new java.util.Timer().schedule( 
					        new java.util.TimerTask() {
					            
					            public void run() {   
					            	warn.setText("");
					            }
					        }, 
					        6000 
					);
				}
	});
}
			}
		});
		
		}
	
	
	
	
	public static void main(String[] args) {
	
	Pnr_enq.pnr();
		
	}

}
