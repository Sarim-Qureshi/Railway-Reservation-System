package com.RRS;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Vector;

import javax.swing.*;

public class SpecialBook {

	public static void specbook() {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				JFrame jf = new JFrame("Indian Railways -- Special Trains");
				jf.setSize(900, 435);
				jf.setLayout(null);
				jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				jf.getContentPane().setBackground(Color.decode("#01608C"));	
				jf.setResizable(false);
				
				JLabel jl = new JLabel("Choose the date to book tickets");
				jl.setFont(new Font("Arial", Font.BOLD, 30));
				jl.setForeground(Color.white);
				jl.setBounds(200,40,700,30);
				jl.addMouseListener(new LbHover());
				jf.add(jl);
				
			    String arr[] = new String[7];
	        	LocalDate cd = java.time.LocalDate.now();
	        	arr[0] = cd.toString();
	  
	        	for(int i=1;i<7;i++)   arr[i] = cd.plusDays(i).toString();	 
	        		 	 
	            JComboBox<String> cb = new JComboBox<>(arr);
	            cb.setBounds(330,110,200,30);	
	            cb.setBorder(null);
	 		    cb.setFont(new Font("Arial", Font.PLAIN, 20));
	 		    cb.setForeground(Color.black);
	            jf.add(cb);

				JButton check = new JButton("Book");
				check.setForeground(Color.white);
				check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				check.setFont(new Font("DialogInput", Font.BOLD, 20));
				check.setBackground(Color.decode("#5BC236"));
	            check.setBounds(200,170,460,40);
	            jf.add(check);
	            
	            JLabel note = new JLabel("Note that special train tickets once booked cannot be cancelled");
	            note.setFont(new Font("Monospaced", Font.BOLD, 17));
				note.setForeground(Color.white);
				note.addMouseListener(new LbHover());
				note.setBounds(120,330,700,30);
				jf.add(note);
	            
	            JLabel temp = new JLabel();
    			temp.setFont(new Font("Arial", Font.BOLD, 30));
				temp.setForeground(Color.red);
				temp.setBounds(200,290,700,30);
				jf.add(temp);
				
				String spnum = SpecialTrain.getNumber().substring(0, SpecialTrain.getNumber().length()-3) + 
    					SpecialTrain.getNumber().substring(SpecialTrain.getNumber().length()-2, SpecialTrain.getNumber().length());
				
				String time = ""; int price = 0;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
					Statement stmt = con.createStatement();
					String sql = "select * from spt"+spnum +" where date=\'"+cb.getSelectedItem()+"\'";
					ResultSet rs = stmt.executeQuery(sql);
			
	               
					while (rs.next()) {
						time = rs.getString(1);
						price = rs.getInt(3);
		        	}
					
					con.close();
				} catch (Exception e1) {
					System.out.println(e1);
				}
				
	            
				JLabel info = new JLabel("You can book only one ticket. Price of the ticket will be Rs."+price+". Train will leave at "+time);
				info.setFont(new Font("Arial", Font.BOLD, 16));
				info.setForeground(Color.white);
				info.setBounds(100,245,800,30);
				info.addMouseListener(new LbHover());
				jf.add(info);
				
				JLabel succ = new JLabel();
				succ.setFont(new Font("Arial", Font.BOLD, 20));
				succ.setForeground(Color.green);
				succ.setBounds(155,300,700,30);
				jf.add(succ);
				
	            check.addMouseListener(new MouseAdapter() {
	            	
	            	public void mouseEntered(MouseEvent e) {
	            		check.setBackground(Color.decode("#006400"));
	            	}

	            	public void mouseExited(MouseEvent e) {
	            		check.setBackground(Color.decode("#5BC236"));
	            	}
	            	
	            });
	            
	            check.addActionListener(new ActionListener() {
	            	
	            	public void actionPerformed(ActionEvent e) {
	            		
	            		String dat = cb.getSelectedItem().toString();
	            		int passed=0;
	            		LocalTime sptime = LocalTime.of(15, 00, 00);
	            		
	            		if(dat.equals(LocalDate.now().toString())) {
	            		
	            			LocalTime now = LocalTime.now();
	            			
	            			passed = now.compareTo(sptime);
	            		  
	            		}
	            		
	            		if(passed>0) {
	            			
	            			temp.setText("Sorry, there are no trains today");
	            		}
	            		else {
	            			
	            			
	            			new java.util.Timer().schedule( 
							        new java.util.TimerTask() {
							            
							            public void run() {   
							            	temp.setText("");	
							            }
							        }, 
							        2200 
							);
	            			
	            			String spnum = SpecialTrain.getNumber().substring(0, SpecialTrain.getNumber().length()-3) + 
	            					SpecialTrain.getNumber().substring(SpecialTrain.getNumber().length()-2, SpecialTrain.getNumber().length());
	            			
	            			int tickets=0,price=0;
	            			String date="",time="";
	            			
	            			
	            			
	            			try {
	            				Class.forName("com.mysql.cj.jdbc.Driver");
	        					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
	        					Statement stmt = con.createStatement();
	        					String sql = "select * from spt"+spnum +" where date=\'"+cb.getSelectedItem()+"\'";
	        					ResultSet rs = stmt.executeQuery(sql);
	        			

	        					while (rs.next()) {
	        						time = rs.getString(1);
	        						tickets = rs.getInt(2);
	        						price = rs.getInt(3);
	        						date = rs.getString(4);
	        		        	}
	        					
	        					
	        					if(tickets==0)  temp.setText("    Sorry, all seats are booked");
	        					
	        					else {
	        						new java.util.Timer().schedule( 
	    							        new java.util.TimerTask() {
	    							            
	    							            public void run() {   
	    							            	temp.setText("");	
	    							            }
	    							        }, 
	    							        2200 
	    							);
	        						Details.specDet(tickets, spnum, price, date, time);
	     		
//	        							    tickets=tickets-1;
//	                        				String sql2 = "update spt"+spnum+" set tickets="+tickets+" where date=\'"+cb.getSelectedItem()+"\'";
//	    	        						PreparedStatement ps = con.prepareStatement(sql2);
//	    	        						int t = ps.executeUpdate();
//	    	        						
//	    	        						new java.util.Timer().schedule( 
//	    									        new java.util.TimerTask() {
//	    									            
//	    									            public void run() {   
//	    									            	temp.setText("");	
//	    									            }
//	    									        }, 
//	    									        100 
//	    									);
//	    	        						
//	    	        						if(t>0) {
//	    	        					
//	    	        							
//	    	        							
//	    	        							Random r = new Random();
//	    	        							int pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
//	    	        							
//	    	        							
//	    	        							String pnrc = "select pnrno from pnr";
//	    	        							Statement state = con.createStatement();
//	    	        							ResultSet rs2 = state.executeQuery(pnrc);
//	    	        							
//	    	        							while(rs2.next()) PNR.vec.add(rs2.getInt(1));
//	    	        							
//	    	        						
//	    	        							
//	    	        							while(PNR.vec.contains(pnrno)) {
//	    	        								pnrno = Integer.parseInt(String.format("%04d", r.nextInt(10000)));
//	    	        							}
//	    	        							
//	    	        							PNR.vec.addElement(pnrno);
//	    	        					
//	    	        						succ.setText("Successfully booked ticket, your PNR number will be "+pnrno);
//	    	        						
//	    	        						String sql3 = "insert into pnr(trainno,pnrno,traintime,ticketprice,date,firstname,lastname)"
//	    	        								+ " values(?,?,?,?,?,?,?)";
//	    	        						PreparedStatement ps2 = con.prepareStatement(sql3);
//	    	        						ps2.setString(1, SpecialTrain.getNumber());
//	    	        						ps2.setInt(2, pnrno);
//	    	        						ps2.setString(3, time);
//	    	        						ps2.setInt(4, price);
//	    	        						ps2.setString(5, date);
//	    	        						ps2.setString(6, User.getFirstname());
//	    	        						ps2.setString(7, User.getLastname());
//	    	        					    ps2.executeUpdate();
//	    	        					    
//	    	        					    new java.util.Timer().schedule( 
//	    									        new java.util.TimerTask() {
//	    									            
//	    									            public void run() {   
//	    									            	succ.setText("");
//	    									            }
//	    									        }, 
//	    									        5500 
//	    									);		
//	    	        						}
	    	        					
	        					}

	        					con.close();
	        				} catch (Exception ex) {
	        				 System.out.println(ex);
	            			}
	            			
	            		}
	            		
	            	}
	            });
	            
				jf.setVisible(true);
			}
			
		});
		
	}
	
	
	public static void main(String args[]) {
		SpecialBook.specbook();
	}
}

class PNR{
	
	static Vector<Integer> vec = new Vector<Integer>();
	
}
