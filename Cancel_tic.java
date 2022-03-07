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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.JTableHeader;
public class Cancel_tic {
	public static void canc()
	
	{
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				
				Font f = new Font("Arial", Font.BOLD, 17);
				Font t = new Font("Arial", Font.BOLD, 14);

				
			
		JFrame jcnl=new JFrame("Indian Railways -- Cancel Tickets");
		jcnl.setLayout(null);
		jcnl.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jcnl.getContentPane().setBackground(Color.decode("#333333"));
		jcnl.setSize(900,450);
		jcnl.setVisible(true);
		jcnl.setResizable(false);
		
		JLabel warn = new JLabel();
		warn.setFont(new Font("Arial", Font.BOLD, 40));
		warn.setForeground(Color.red);
		warn.setBounds(210,140,840,63);
		jcnl.add(warn);

		JLabel warn2 = new JLabel();
		warn2.setFont(new Font("Monospaced", Font.BOLD, 30));
		warn2.setForeground(Color.red);
		warn2.setBounds(210,290,840,63);
		jcnl.add(warn2);
		
		JLabel head = new JLabel("Cancel Tickets");
		head.setForeground(Color.white);
		head.setBounds(300, 10, 500, 40);
		head.setFont(new Font("Bookman", Font.BOLD, 30));
		head.addMouseListener(new LbHover());
		jcnl.add(head);
		
		JLabel sticl=new JLabel();
		sticl.setText("Enter PNR number");
		sticl.setBounds(115,70,200,30);
		sticl.setForeground(Color.white);
		sticl.setFont(f);
		sticl.addMouseListener(new LbHover());
		jcnl.add(sticl);
		
		JTextField stic=new JTextField();
		stic.setBounds(307, 70, 200, 28);
		stic.setFont(t);
		jcnl.add(stic);
		
		JButton sbtic=new JButton("Search");
		sbtic.setBounds(550,70,200,30);
		sbtic.setFont(f);
		sbtic.setForeground(Color.white);
		sbtic.setBackground(Color.decode("#5BC236"));
		sbtic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sbtic.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				sbtic.setBackground(Color.decode("#006400"));
			}

			public void mouseExited(java.awt.event.MouseEvent e) {
				sbtic.setBackground(Color.decode("#5BC236"));
			}

		});
		jcnl.add(sbtic);
		
	
		if(User.getUsername()==null) {
			warn.setText("Login to cancel tickets");
			warn.setFont(new Font("Arial", Font.BOLD, 40));
			warn.setForeground(Color.red);
			warn.setBounds(210,140,840,63);
			jcnl.add(warn);
			stic.setEditable(false);
			sbtic.setEnabled(false);
			jcnl.setSize(900,290);
		}
		else {
			
		sbtic.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int tno=0,tp=0;
				String time="", date="", fn="",ln="";
				boolean flag = false;
					
					try
					{
						
						
						Class.forName("com.mysql.cj.jdbc.Driver");
		    			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs","root","");
		    			Statement stmt=con.createStatement();
		    			ResultSet rs=stmt.executeQuery("select * from rpnr where pnrno="+stic.getText());
		    			
		    			
		    			while(rs.next())
		    			{
		    			flag = true;
		    			tno = rs.getInt(1);
		    			time = rs.getString(3);
		    			tp = rs.getInt(4);
		    			date = rs.getString(5);
		    			fn = rs.getString(6);
		    			ln = rs.getString(7);
		    			}
		    			con.close();
		    		}
					catch(Exception re)
					{
						System.out.print(re);
					}
				
					if(flag==false && stic.getText().isEmpty()) {
						
						warn.setText("Enter PNR number");
						warn.setFont(new Font("Arial", Font.BOLD, 35));
						warn.setForeground(Color.red);
						warn.setBounds(260,140,840,63);
						jcnl.add(warn);
					}
					else if(flag==false && !stic.getText().isEmpty()) {
						
						warn.setText("Enter correct PNR number");
						warn.setFont(new Font("Arial", Font.BOLD, 35));
						warn.setForeground(Color.red);
						warn.setBounds(210,140,840,63);
						jcnl.add(warn);
					}
					
					else if(flag){
						
					warn.setText("");						
						
					String[] bcol= {"Train number","Departure time","ticket price","Date","First name","Last name"};
					
					String[][] brow = new String[1][6];
					
						brow[0][0] = Integer.toString(tno);
						brow[0][1] = time;
						brow[0][2] = Integer.toString(tp);
						brow[0][3] = date;
						brow[0][4] = fn;
						brow[0][5] = ln;
						

						  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
						  LocalDate localDate = LocalDate.parse(date, formatter);

						  
						  
						
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
					js.setBounds(20,150,840,63);
					js.getViewport().add(bstab);
					jcnl.add(js);
					
					
					JButton b = new JButton("Cancel");
					b.setFont(f);
					b.setForeground(Color.white);
					b.setBackground(Color.decode("#ff0000"));
					b.setBounds(270, 240, 300, 35);
					b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					b.setVisible(true);
					b.addMouseListener(new MouseAdapter() {
						public void mouseEntered(MouseEvent e) {
							b.setBackground(Color.decode("#E3242B"));
						}

						public void mouseExited(java.awt.event.MouseEvent e) {
							b.setBackground(Color.decode("#ff0000"));
						}

					});
					jcnl.add(b);
					jcnl.repaint();
					
					b.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
			
							 LocalTime a = LocalTime.parse(brow[0][1],
			     	    	            DateTimeFormatter.ofPattern("kk:mm"));
							 
							if(LocalDate.now().toString().equals(brow[0][3]) && LocalTime.now().compareTo(a)>0) {
								warn2.setText("Train already departed");
								warn2.setBounds(225,295,840,63);
								warn2.setForeground(Color.red);
							}
							else if(LocalDate.now().compareTo(localDate)>0) {
								warn2.setText("Ticket cannot be cancelled");
								warn2.setBounds(190,295,840,63);
								warn2.setForeground(Color.red);
							}
							else {
								int res=0;
								try {
									
									Class.forName("com.mysql.cj.jdbc.Driver");
		        					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
		    						PreparedStatement ps = con.prepareStatement("delete from rpnr where pnrno="+stic.getText());
		    						res = ps.executeUpdate();
									con.close();
								}catch(Exception ex) {
									System.out.println(ex);
								}
							
							if(res>0) {
								warn2.setText("Your ticket was cancelled");
								warn2.setBounds(197,295,840,63);
								warn2.setForeground(Color.green);
								
                                 try {	
									Class.forName("com.mysql.cj.jdbc.Driver");
		        					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
		    						PreparedStatement ps = con.prepareStatement("update rt"+brow[0][0]+" set tickets=tickets+1 where date=\'"+brow[0][3]+"\'");
		    						res = ps.executeUpdate();
									con.close();
								}catch(Exception ex) {
									System.out.println(ex);
								}
								
							}
							else {
								warn2.setText("Could not cancel ticket");
								warn2.setBounds(217,295,840,63);
								warn2.setForeground(Color.red);
							
							}
							
							}
							
							new java.util.Timer().schedule( 
							        new java.util.TimerTask() {
							            
							            public void run() {   
							            	warn2.setText("");	
							            }
							        }, 
							        2700 
							);
							
						}
					});
					
					
					
					}
					
					
					
				}
			
		});
	
		
		}
		
			}
		});
		}
	
	

	public static void main(String[] args) {
             Cancel_tic.canc();
	}

}