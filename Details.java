package com.RRS;

import java.sql.*;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Details {
	public static void det(int atick,int tickets, int rnum, int price, String date, String time)
	{
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				Font t = new Font("Arial", Font.BOLD, 17);
				Font f = new Font("Arial", Font.BOLD, 24);
				
				JFrame jf = new JFrame("Indian Railways -- Book Tickets");
				jf.setLayout(null);
				jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				jf.getContentPane().setBackground(Color.decode("#01608C"));
				jf.setSize(980,700);
				jf.setVisible(true);
				jf.setResizable(false);
				
				JLabel head = new JLabel();
				head.setText("BOOK TICKETS");
				head.setForeground(Color.decode("#90ee90"));
				head.setBounds(330, 14, 800, 50);
				head.setFont(new Font("Bookman", Font.BOLD, 35));
				jf.add(head);

				JTextField tf1 = new JTextField(User.getFirstname());
				JTextField tl1 = new JTextField(User.getLastname());
				JTextField tf2 = new JTextField();
				JTextField tl2 = new JTextField();
				JTextField tf3 = new JTextField();
				JTextField tl3 = new JTextField();
				
				tf1.setBounds(60, 150, 140, 24);
				tl1.setBounds(300, 150, 140, 24);
				tf2.setBounds(60, 200, 140, 24);
				tl2.setBounds(300, 200, 140, 24);
				tf3.setBounds(60, 250, 140, 24);
				tl3.setBounds(300, 250, 140, 24);
				
				tf1.setFont(t);
				tl1.setFont(t);
				tf2.setFont(t);
				tl2.setFont(t);
				tf3.setFont(t);
				tl3.setFont(t);


				JLabel fn = new JLabel("First name");
				JLabel ln = new JLabel("Last name");
				fn.addMouseListener(new LbHover());
				ln.addMouseListener(new LbHover());
				fn.setForeground(Color.white);
				ln.setForeground(Color.white);
				fn.setFont(f);
				ln.setFont(f);
				fn.setBounds(60,100,140,25);
				ln.setBounds(300,100,140,25);
				jf.add(fn);
				jf.add(ln);

				
				JLabel l1 = new JLabel("Details of first person");
				JLabel l2 = new JLabel("Enter details of second person");
				JLabel l3 = new JLabel("Enter details of third person");
				l1.setForeground(Color.white);
				l2.setForeground(Color.white);
				l3.setForeground(Color.white);
				l1.setFont(f);
				l2.setFont(f);
				l3.setFont(f);
				l1.addMouseListener(new LbHover());
				l2.addMouseListener(new LbHover());
				l3.addMouseListener(new LbHover());
				l1.setBounds(540,150,360,25);
				l2.setBounds(540,200,360,25);
				l3.setBounds(540,250,360,25);

				JButton book = new JButton("Book");
				book.setFont(f);
				book.setForeground(Color.white);
				book.setBackground(Color.decode("#5BC236"));
				book.setBounds(300, 320, 300, 35);
				book.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				book.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						book.setBackground(Color.decode("#006400"));
					}

					public void mouseExited(java.awt.event.MouseEvent e) {
						book.setBackground(Color.decode("#5BC236"));
					}

				});
				jf.add(book);
				
				JLabel succ = new JLabel();
				succ.setFont(new Font("Arial", Font.BOLD, 18));
				succ.setForeground(Color.green);
				succ.setBounds(50,280,1000,30);
				jf.add(succ);
				
				JLabel succ2 = new JLabel();
				succ2.setFont(new Font("Arial", Font.BOLD, 18));
				succ2.setForeground(Color.green);
				succ2.setBounds(50,420,1000,30);
				jf.add(succ2);
				
				JLabel succ3 = new JLabel();
				succ3.setFont(new Font("Arial", Font.BOLD, 18));
				succ3.setForeground(Color.green);
				succ3.setBounds(50,420,1000,30);
				jf.add(succ3);
				
				
				if(tickets==1) {
					jf.add(tf1); jf.add(tl1); jf.add(l1);
					l1.setText("Details of the person");
					book.setBounds(300, 220, 300, 35);
					succ.setBounds(50,290,700,30);
					jf.setSize(980,400);
				}
				else if(tickets==2) {
					jf.add(tf1); jf.add(tl1); jf.add(l1);
					jf.add(tf2); jf.add(tl2); jf.add(l2);
					book.setBounds(300, 270, 300, 35);
					succ.setBounds(50,350,700,30);
					succ2.setBounds(50,420,700,30);
					jf.setSize(980,550);
				}
				else if(tickets==3) {
					jf.add(tf1); jf.add(tl1); jf.add(l1);
					jf.add(tf2); jf.add(tl2); jf.add(l2);
					jf.add(tf3); jf.add(tl3); jf.add(l3);
					book.setBounds(300, 320, 300, 35);
					succ.setBounds(50,400,700,30);
					succ2.setBounds(50,470,700,30);
					succ3.setBounds(50,540,700,30);
					jf.setSize(980,650);
				}
				
				book.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						((AbstractButton) e.getSource()).setEnabled(false);
						
						JDialog d = new JDialog();
						JLabel temp = new JLabel("Enter the fields to book tickets");
						temp.setFont(new Font("Consolas",Font.BOLD,18));
						temp.setForeground(Color.red);
						d.getContentPane().setBackground(Color.decode("#333333"));
						d.setSize(350,100);
						d.setLocation(285,250);
						d.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						d.add(temp);
						d.setVisible(false);
						
						if(tickets==1) {
							if(tf1.getText().isEmpty() || tl1.getText().isEmpty()) {
								d.setVisible(true);
								((AbstractButton) e.getSource()).setEnabled(true);
							}
							else {
							try {
							Class.forName("com.mysql.cj.jdbc.Driver");
        					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
            				String sql2 = "update rt"+rnum+" set tickets="+(atick-1)+" where date=\'"+date+"\'";
    						PreparedStatement ps = con.prepareStatement(sql2);
    						int t = ps.executeUpdate();
    						
    						
    						if(t>0) {
    					
    							Random r = new Random();
    							int pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
    							
    							
    							String pnrc = "select pnrno from rpnr";
    							Statement state = con.createStatement();
    							ResultSet rs2 = state.executeQuery(pnrc);
    							
    							while(rs2.next()) RPNR.vec.add(rs2.getInt(1));
    							
    						
    							
    							while(RPNR.vec.contains(pnrno)) {
    								pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
    							}
    							
    							RPNR.vec.addElement(pnrno);
    					
    						succ.setText("Successfully booked ticket for "+tf1.getText()+" "+tl1.getText()+", your PNR number will be "+pnrno);
    						
    						String sql3 = "insert into rpnr(trainno,pnrno,traindepttime,ticketprice,date,firstname,lastname)"
    								+ " values(?,?,?,?,?,?,?)";
    						PreparedStatement ps2 = con.prepareStatement(sql3);
    						ps2.setInt(1, rnum);
    						ps2.setInt(2, pnrno);
    						ps2.setString(3, time);
    						ps2.setInt(4, price);
    						ps2.setString(5, date);
    						ps2.setString(6, tf1.getText());
    					    ps2.setString(7, tl1.getText());
    					    ps2.executeUpdate();
    					 
    					   
    					    
    						}
    						con.close();
						}catch(Exception ee) {}	
							
							
							new java.util.Timer().schedule( 
							        new java.util.TimerTask() {
							            
							            public void run() {   
							            	jf.setVisible(false);	
							            }
							        }, 
							        3500 
							);
							
							}
							
							//End of if tick==1
						}
						
						if(tickets==2) {
							
								if(tf1.getText().isEmpty() || tl1.getText().isEmpty() || tf2.getText().isEmpty() || tl2.getText().isEmpty()) {
									d.setVisible(true);
									((AbstractButton) e.getSource()).setEnabled(true);
								}
								else {
							
							for(int i=1;i<=2;i++) {
								
								int a2tick = atick-1;
								
								if(i==1) {
									
									
									try {
										Class.forName("com.mysql.cj.jdbc.Driver");
			        					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
			            				String sql2 = "update rt"+rnum+" set tickets="+(atick-1)+" where date=\'"+date+"\'";
			            				
			    						PreparedStatement ps = con.prepareStatement(sql2);
			    						int t = ps.executeUpdate();
			    						
			    						
			    						if(t>0) {
			    					
			    							
			    							
			    							Random r = new Random();
			    							int pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
			    							
			    							
			    							String pnrc = "select pnrno from rpnr";
			    							Statement state = con.createStatement();
			    							ResultSet rs2 = state.executeQuery(pnrc);
			    							
			    							while(rs2.next()) RPNR.vec.add(rs2.getInt(1));
			    							
			    						
			    							
			    							while(RPNR.vec.contains(pnrno)) {
			    								pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
			    							}
			    							
			    							RPNR.vec.addElement(pnrno);
			    					
			    						succ.setText("Successfully booked ticket for "+tf1.getText()+" "+tl1.getText()+", your PNR number will be "+pnrno);
			    						
			    						String sql3 = "insert into rpnr(trainno,pnrno,traindepttime,ticketprice,date,firstname,lastname)"
			    								+ " values(?,?,?,?,?,?,?)";
			    						PreparedStatement ps2 = con.prepareStatement(sql3);
			    						ps2.setInt(1, rnum);
			    						ps2.setInt(2, pnrno);
			    						ps2.setString(3, time);
			    						ps2.setInt(4, price);
			    						ps2.setString(5, date);
			    						ps2.setString(6, tf1.getText());
			    					    ps2.setString(7, tl1.getText());
			    					    ps2.executeUpdate();
			    					 
			    					   
			    					    
			    						}
			    						con.close();
									}catch(Exception ee) {
										System.out.println(ee);
									}	
									
									
									
									
									//End of if i==1
								}
								
								if(i==2) {
									
									
									try {
										Class.forName("com.mysql.cj.jdbc.Driver");
			        					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
			            				String sql2 = "update rt"+rnum+" set tickets="+(a2tick-1)+" where date=\'"+date+"\'";
			    						PreparedStatement ps = con.prepareStatement(sql2);
			    						int t = ps.executeUpdate();
			    						
			    						
			    						if(t>0) {
			    					
			    							Random r = new Random();
			    							int pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
			    							
			    							
			    							String pnrc = "select pnrno from rpnr";
			    							Statement state = con.createStatement();
			    							ResultSet rs2 = state.executeQuery(pnrc);
			    							
			    							while(rs2.next()) RPNR.vec.add(rs2.getInt(1));
			    							
			    						
			    							
			    							while(RPNR.vec.contains(pnrno)) {
			    								pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
			    							}
			    							
			    							RPNR.vec.addElement(pnrno);
			    					
			    						succ2.setText("Successfully booked ticket for "+tf2.getText()+" "+tl2.getText()+", your PNR number will be "+pnrno);
			    						
			    						String sql3 = "insert into rpnr(trainno,pnrno,traindepttime,ticketprice,date,firstname,lastname)"
			    								+ " values(?,?,?,?,?,?,?)";
			    						PreparedStatement ps2 = con.prepareStatement(sql3);
			    						ps2.setInt(1, rnum);
			    						ps2.setInt(2, pnrno);
			    						ps2.setString(3, time);
			    						ps2.setInt(4, price);
			    						ps2.setString(5, date);
			    						ps2.setString(6, tf2.getText());
			    					    ps2.setString(7, tl2.getText());
			    					    ps2.executeUpdate();
			    					 
			    					   
			    					    
			    						}
			    						con.close();
									}catch(Exception ee) {
										System.out.println(ee);
									}	
									
									
									
									//End of if i==2
								}
							
								
								
								//End of for loop
							}
						
							new java.util.Timer().schedule( 
							        new java.util.TimerTask() {
							            
							            public void run() {   
							            	jf.setVisible(false);	
							            }
							        }, 
							        4500 
							);
							
								}
							
							//End of if tick==2
						}
						
						
	                if(tickets==3) {
							
	                	if(tf1.getText().isEmpty() || tl1.getText().isEmpty() || tf2.getText().isEmpty() || tl2.getText().isEmpty()
	                			|| tf3.getText().isEmpty() || tl3.getText().isEmpty()) {
							d.setVisible(true);
							((AbstractButton) e.getSource()).setEnabled(true);
						}
						else {
					
							
							for(int i=1;i<=3;i++) {
								
								int a2tick = atick-1;
								int a3tick = a2tick-1;
								
								if(i==1) {
									
									
									try {
										Class.forName("com.mysql.cj.jdbc.Driver");
			        					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
			            				String sql2 = "update rt"+rnum+" set tickets="+(atick-1)+" where date=\'"+date+"\'";
			            				
			    						PreparedStatement ps = con.prepareStatement(sql2);
			    						int t = ps.executeUpdate();
			    						
			    						
			    						if(t>0) {
			    					
			    							
			    							
			    							Random r = new Random();
			    							int pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
			    							
			    							
			    							String pnrc = "select pnrno from rpnr";
			    							Statement state = con.createStatement();
			    							ResultSet rs2 = state.executeQuery(pnrc);
			    							
			    							while(rs2.next()) RPNR.vec.add(rs2.getInt(1));
			    							
			    						
			    							
			    							while(RPNR.vec.contains(pnrno)) {
			    								pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
			    							}
			    							
			    							RPNR.vec.addElement(pnrno);
			    					
			    						succ.setText("Successfully booked ticket for "+tf1.getText()+" "+tl1.getText()+", your PNR number will be "+pnrno);
			    						
			    						String sql3 = "insert into rpnr(trainno,pnrno,traindepttime,ticketprice,date,firstname,lastname)"
			    								+ " values(?,?,?,?,?,?,?)";
			    						PreparedStatement ps2 = con.prepareStatement(sql3);
			    						ps2.setInt(1, rnum);
			    						ps2.setInt(2, pnrno);
			    						ps2.setString(3, time);
			    						ps2.setInt(4, price);
			    						ps2.setString(5, date);
			    						ps2.setString(6, tf1.getText());
			    					    ps2.setString(7, tl1.getText());
			    					    ps2.executeUpdate();
			    					 
			    					   
			    					    
			    						}
			    						con.close();
									}catch(Exception ee) {
										System.out.println(ee);
									}	
									
									
									
									
									//End of if i==1
								}
								
								if(i==2) {
									
									
									try {
										Class.forName("com.mysql.cj.jdbc.Driver");
			        					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
			            				String sql2 = "update rt"+rnum+" set tickets="+(a2tick-1)+" where date=\'"+date+"\'";
			    						PreparedStatement ps = con.prepareStatement(sql2);
			    						int t = ps.executeUpdate();
			    						
			    						
			    						if(t>0) {
			    					
			    							Random r = new Random();
			    							int pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
			    							
			    							
			    							String pnrc = "select pnrno from rpnr";
			    							Statement state = con.createStatement();
			    							ResultSet rs2 = state.executeQuery(pnrc);
			    							
			    							while(rs2.next()) RPNR.vec.add(rs2.getInt(1));
			    							
			    						
			    							
			    							while(RPNR.vec.contains(pnrno)) {
			    								pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
			    							}
			    							
			    							RPNR.vec.addElement(pnrno);
			    					
			    						succ2.setText("Successfully booked ticket for "+tf2.getText()+" "+tl2.getText()+", your PNR number will be "+pnrno);
			    						
			    						String sql3 = "insert into rpnr(trainno,pnrno,traindepttime,ticketprice,date,firstname,lastname)"
			    								+ " values(?,?,?,?,?,?,?)";
			    						PreparedStatement ps2 = con.prepareStatement(sql3);
			    						ps2.setInt(1, rnum);
			    						ps2.setInt(2, pnrno);
			    						ps2.setString(3, time);
			    						ps2.setInt(4, price);
			    						ps2.setString(5, date);
			    						ps2.setString(6, tf2.getText());
			    					    ps2.setString(7, tl2.getText());
			    					    ps2.executeUpdate();
			    					 
			    					   
			    					    
			    						}
			    						con.close();
									}catch(Exception ee) {
										System.out.println(ee);
									}	
									
									
									
									//End of if i==2
								}
							
								
								
								if(i==3) {
									
									
									try {
										Class.forName("com.mysql.cj.jdbc.Driver");
			        					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
			            				String sql2 = "update rt"+rnum+" set tickets="+(a3tick-1)+" where date=\'"+date+"\'";
			    						PreparedStatement ps = con.prepareStatement(sql2);
			    						int t = ps.executeUpdate();
			    						
			    						
			    						if(t>0) {
			    					
			    							Random r = new Random();
			    							int pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
			    							
			    							
			    							String pnrc = "select pnrno from rpnr";
			    							Statement state = con.createStatement();
			    							ResultSet rs2 = state.executeQuery(pnrc);
			    							
			    							while(rs2.next()) RPNR.vec.add(rs2.getInt(1));
			    							
			    						
			    							
			    							while(RPNR.vec.contains(pnrno)) {
			    								pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
			    							}
			    							
			    							RPNR.vec.addElement(pnrno);
			    					
			    						succ3.setText("Successfully booked ticket for "+tf3.getText()+" "+tl3.getText()+", your PNR number will be "+pnrno);
			    						
			    						String sql3 = "insert into rpnr(trainno,pnrno,traindepttime,ticketprice,date,firstname,lastname)"
			    								+ " values(?,?,?,?,?,?,?)";
			    						PreparedStatement ps2 = con.prepareStatement(sql3);
			    						ps2.setInt(1, rnum);
			    						ps2.setInt(2, pnrno);
			    						ps2.setString(3, time);
			    						ps2.setInt(4, price);
			    						ps2.setString(5, date);
			    						ps2.setString(6, tf3.getText());
			    					    ps2.setString(7, tl3.getText());
			    					    ps2.executeUpdate();
			    					 
			    					   
			    					    
			    						}
			    						con.close();
									}catch(Exception ee) {
										System.out.println(ee);
									}	
									
									
									
									
									
									//End of if i==3
								}
								
								
								//End of for loop
							}
							
							
							
							new java.util.Timer().schedule( 
							        new java.util.TimerTask() {
							            
							            public void run() {   
							            	jf.setVisible(false);	
							            }
							        }, 
							        5500 
							);
							
						}
							
							//End of if tick==3
						}
							
					}
				});
				
				

			}
		});
		
	}
	
	public static void specDet(int tickets, String spnum, int price, String date, String time ) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				Font t = new Font("Arial", Font.BOLD, 17);
				Font f = new Font("Arial", Font.BOLD, 24);
				
				JFrame jf = new JFrame("Indian Railways -- Book special train ticket");
				jf.setLayout(null);
				jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				jf.getContentPane().setBackground(Color.decode("#01608C"));
				jf.setSize(980,400);
				jf.setVisible(true);
				jf.setResizable(false);
				
				JLabel head = new JLabel();
				head.setText("BOOK TICKET FOR SPECIAL TRAIN");
				head.setForeground(Color.decode("#90ee90"));
				head.setBounds(200, 14, 800, 50);
				head.setFont(new Font("Bookman", Font.BOLD, 30));
				jf.add(head);

				JTextField t1 = new JTextField(User.getFirstname());
				JTextField t2 = new JTextField(User.getLastname());
				
				t1.setBounds(60, 150, 140, 24);
				t2.setBounds(300, 150, 140, 24);
				
				t1.setFont(t);
				t2.setFont(t);
				
				jf.add(t1); jf.add(t2);
				
				JLabel fn = new JLabel("First name");
				JLabel ln = new JLabel("Last name");
				fn.setForeground(Color.white);
				ln.setForeground(Color.white);
				fn.setFont(f);
				ln.setFont(f);
				fn.setBounds(60,100,140,25);
				ln.setBounds(300,100,140,25);
				jf.add(fn);
				jf.add(ln);
				
				JLabel l1 = new JLabel("Enter Correct Details");
				l1.setForeground(Color.white);
				l1.setFont(f);
				l1.setBounds(540,150,360,25);
				jf.add(l1);
				
				JButton book = new JButton("Book");
				book.setFont(f);
				book.setForeground(Color.white);
				book.setBackground(Color.decode("#5BC236"));
				book.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				book.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						book.setBackground(Color.decode("#006400"));
					}

					public void mouseExited(java.awt.event.MouseEvent e) {
						book.setBackground(Color.decode("#5BC236"));
					}

				});
				jf.add(book);
				
				JLabel succ = new JLabel();
				succ.setFont(new Font("Arial", Font.BOLD, 18));
				succ.setForeground(Color.green);
				jf.add(succ);
				
				book.setBounds(300, 220, 300, 35);
				succ.setBounds(50,290,1000,30);
				
				int tick = tickets-1;
				book.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent e) {
						
						((AbstractButton) e.getSource()).setEnabled(false);
						
						JDialog d = new JDialog();
						JLabel temp = new JLabel("Enter the fields to book ticket");
						temp.setFont(new Font("Consolas",Font.BOLD,18));
						temp.setForeground(Color.red);
						d.getContentPane().setBackground(Color.decode("#333333"));
						d.setSize(350,100);
						d.setLocation(285,250);
						d.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						d.add(temp);
						d.setVisible(false);
						
						if(t1.getText().isEmpty() || t2.getText().isEmpty()) {
							d.setVisible(true);
							((AbstractButton) e.getSource()).setEnabled(true);
						}
						else {
						try {
							 Class.forName("com.mysql.cj.jdbc.Driver");
							 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
						
        				String sql2 = "update spt"+spnum+" set tickets="+tick+" where date=\'"+date+"\'";
						PreparedStatement ps = con.prepareStatement(sql2);
						int t = ps.executeUpdate();
					
						
						if(t>0) {
					
							
							
							Random r = new Random();
							int pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
							
							
							String pnrc = "select pnrno from pnr";
							Statement state = con.createStatement();
							ResultSet rs2 = state.executeQuery(pnrc);
							
							while(rs2.next()) PNR.vec.add(rs2.getInt(1));
							
						
							
							while(PNR.vec.contains(pnrno)) {
								pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
							}
							
							PNR.vec.addElement(pnrno);
					
						succ.setText("Successfully booked ticket for "+t1.getText()+" "+t2.getText()+", your PNR number will be "+pnrno);
						
						String sql3 = "insert into pnr(trainno,pnrno,traintime,ticketprice,date,firstname,lastname)"
								+ " values(?,?,?,?,?,?,?)";
						PreparedStatement ps2 = con.prepareStatement(sql3);
						ps2.setString(1, SpecialTrain.getNumber());
						ps2.setInt(2, pnrno);
						ps2.setString(3, time);
						ps2.setInt(4, price);
						ps2.setString(5, date);
						ps2.setString(6, t1.getText());
						ps2.setString(7, t2.getText());
					    ps2.executeUpdate();
					    
					    new java.util.Timer().schedule( 
						        new java.util.TimerTask() {
						            
						            public void run() {   
						            	jf.setVisible(false);
						            }
						        }, 
						        3500 
						);
						
						}
					
					}
				catch (Exception e1) {
					
					e1.printStackTrace();
				} 
				}
					}
				});
			}		});
	}
	
	public static void main(String[] args) {

//           Details.det(10,1,11077,1500,"2020-12-07","17:20");
	
//		Details.specDet(2,"0101615",2500,"2020-12-04","03:00 PM");
	}

}