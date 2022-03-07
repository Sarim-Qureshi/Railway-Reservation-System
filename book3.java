package com.RRS;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Vector;

import javax.swing.*;



public class book3 {
	public static void mbook3() {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				
				
				
				JFrame jf = new JFrame("Indian Railways -- Book Tickets");
				jf.setSize(900, 440);
				jf.setLayout(null);
				jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				jf.getContentPane().setBackground(Color.decode("#01608C"));	
				jf.setVisible(true);	
				jf.setResizable(false);
				
				
				JLabel jl = new JLabel("Choose the date to book tickets");
				jl.setFont(new Font("Arial", Font.BOLD, 30));
				jl.setForeground(Color.white);
				jl.setBounds(200,40,700,30);
				jf.add(jl);
				jl.addMouseListener(new LbHover());
				
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
				check.setBounds(190,280,460,40);
	            jf.add(check);
	            
	           
				int rnum = RegularTrain.getNumber();
				
				String depttime = ""; int price = 0;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
					Statement stmt = con.createStatement();
					String sql = "select * from rt"+rnum +" where date=\'"+cb.getSelectedItem()+"\'";
					ResultSet rs = stmt.executeQuery(sql);
			
	               
					while (rs.next()) {
						depttime = rs.getString(1);
						price = rs.getInt(4);
		        	}
					
					con.close();
				} catch (Exception e1) {
					System.out.println(e1);
				}
				
	            
				JLabel info = new JLabel("Price of a ticket will be Rs."+price+". Train will leave at "+depttime);
//				JLabel info = new JLabel("Price of the ticket will be Rs.1500. Train will leave at 17:20");
				info.addMouseListener(new LbHover());
				info.setFont(new Font("Consolas", Font.BOLD, 17));
				info.setBounds(160,170,800,30); 
				info.setForeground(Color.white);
				jf.add(info);
				
				JLabel succ = new JLabel();
				succ.setFont(new Font("Arial", Font.BOLD, 20));
				succ.setForeground(Color.green);
				succ.setBounds(155,340,700,30);
				jf.add(succ);
				
				JLabel temp = new JLabel();
	    		temp.setFont(new Font("Arial", Font.BOLD, 30));
				temp.setForeground(Color.red);
				temp.setBounds(200,340,700,30);
				jf.add(temp);
				
				JLabel tin = new JLabel("Choose the number of tickets");
	    		tin.setFont(new Font("Consolas", Font.BOLD, 17));
				tin.setForeground(Color.white);
				tin.setBounds(225,220,300,30);
				tin.addMouseListener(new LbHover());
				jf.add(tin);
				
				String tarr[] = {"1","2","3"};
				JComboBox<String> cb2 = new JComboBox<String>(tarr);
				cb2.setBorder(null);
		 		cb2.setFont(new Font("Arial", Font.PLAIN, 15));
		 		cb2.setForeground(Color.black);
		 		cb2.setBounds(515,222,90,22);
		        jf.add(cb2);
					
				
	            check.addMouseListener(new MouseAdapter() {
	            	
	            	public void mouseEntered(MouseEvent e) {
	            		check.setBackground(Color.decode("#006400"));
	            	}

	            	public void mouseExited(MouseEvent e) {
	            		check.setBackground(Color.decode("#5BC236"));
	            	}
	            	
	            });
	            
	        	String dt = depttime;
	            
	            check.addActionListener(new ActionListener() {
	            	
	            
	            	public void actionPerformed(ActionEvent e) {
	            		
	            		
	            		/*
	            		 *  CHNAGE THE LOCALTIME TO DT !!!!!!!
	            		 */
	            		
	            		
	            		 LocalTime a = LocalTime.parse(dt,
	     	    	            DateTimeFormatter.ofPattern("kk:mm"));
	     	            
	     	            String d = cb.getSelectedItem().toString();
	     	            
	     	            
	     	            if(d.equals(LocalDate.now().toString()) && LocalTime.now().compareTo(a)>0) {
	     	            	
	     	            	temp.setText("Sorry, there are no trains today");	
	     	            }
	     	            else {

	            			new java.util.Timer().schedule( 
							        new java.util.TimerTask() {
							            
							            public void run() {   
							            	temp.setText("");	
							            }
							        }, 
							        4300 
							);
	            			
	            			
	            			int utick = Integer.parseInt(cb2.getSelectedItem().toString());
	            			
	            			
	            			int rnum = RegularTrain.getNumber();
	            			
	            			int tickets=0,price=0;
	            			String date="",time="";
	            			
	            			
	            			
	            			try {
	            				Class.forName("com.mysql.cj.jdbc.Driver");
	        					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
	        					Statement stmt = con.createStatement();
	        					String sql = "select * from rt"+rnum +" where date=\'"+cb.getSelectedItem()+"\'";
	        					ResultSet rs = stmt.executeQuery(sql);
	        			

	        					while (rs.next()) {
	        						time = rs.getString(1);
	        						tickets = rs.getInt(3);
	        						price = rs.getInt(4);
	        						date = rs.getString(5);
	        		        	}
	        					
	        					
	        					if(tickets==0)  temp.setText("    Sorry, all seats are booked");
	        					
	        					else {
	        						    new java.util.Timer().schedule( 
									        new java.util.TimerTask() {
									            
									            public void run() {   
									            	temp.setText("");	
									            }
									        }, 
									        4300 
									     );
	        						
	        						
	        							    tickets=tickets-utick;
	        							    if(tickets<0) {
	        							    	tickets=tickets+utick;
	        							    	temp.setText("     Sorry, not enough seats");
	        							    }
	        							    else {
	        							    	
	        							    	tickets=tickets+utick;
	        							    	 	
	        							    	Details.det(tickets, utick, rnum, price, date, time);
	        							   
	        					}
	        					}
	        					con.close();
	        				} catch (Exception ex) {
	        				 System.out.println(ex);
	            			}
	            			
	            		}
	            		
	            	}
	            });
	        	
	            			
	  	         }
	      	
		});
	    
	}
	


	public static void main(String[] args) {
		
	 book3.mbook3();
	}

}


class RPNR{
	static Vector<Integer> vec = new Vector<Integer>();
}
