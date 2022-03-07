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
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.JTableHeader;

public class Tracktrain {
	
	
	
	public static void track()
	{
		
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			
		Font f = new Font("Arial", Font.BOLD, 17);
		Font t = new Font("Arial", Font.BOLD, 14);

		
		JFrame jf = new JFrame("Indian Railways -- Track your train");
		jf.setSize(980,340);
		jf.getContentPane().setBackground(Color.decode("#333333"));
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jf.setVisible(true);
		jf.setResizable(false);
		
		JLabel head = new JLabel("Track your train");
		head.setForeground(Color.white);
		head.setBounds(322, 10, 500, 40);
		head.setFont(new Font("Bookman", Font.BOLD, 30));
		head.addMouseListener(new LbHover());
		jf.add(head);
		
		JLabel sticl = new JLabel();
		sticl.setText("Enter PNR Number");
		sticl.setBounds(110,65,200,30);
		sticl.setForeground(Color.white); 
		sticl.setFont(f);
		sticl.addMouseListener(new LbHover());
		jf.add(sticl);
		
		
		JTextField stic = new JTextField();
		stic.setBounds(110, 115, 150, 22);
		stic.setFont(t);
		jf.add(stic);
		
		JButton sbtic=new JButton("Search");
		sbtic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sbtic.setBackground(Color.decode("#A1045A"));
		sbtic.setBounds(560,101,200,30);
		sbtic.setFont(f);
		sbtic.setForeground(Color.white);
		sbtic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sbtic.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				sbtic.setBackground(Color.decode("#601A35"));
			}

			public void mouseExited(java.awt.event.MouseEvent e) {
				sbtic.setBackground(Color.decode("#A1045A"));
			}

		});
		
		jf.add(sbtic);
		
		Font fo = new Font("Consolas",Font.BOLD,15);
		
		JLabel sticl2 = new JLabel();
		sticl2.setText("Choose train");
		sticl2.setBounds(360,65,160,30);
		sticl2.setForeground(Color.white);
		sticl2.addMouseListener(new LbHover());
		sticl2.setFont(f);
		jf.add(sticl2);
		
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
		jf.add(b1); jf.add(b2);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(b1); bg.add(b2);
		
		JLabel warn = new JLabel();
		warn.setFont(new Font("Arial", Font.BOLD, 40));
		warn.setForeground(Color.red);
		warn.setBounds(210,140,840,63);
		jf.add(warn);
		
		JLabel succ = new JLabel();
		succ.setFont(new Font("Consolas", Font.BOLD, 25));
		succ.setForeground(Color.white);
		succ.setBounds(10,180,875,63);
		jf.add(succ);
		
		JLabel succ2 = new JLabel();
		succ2.setFont(new Font("Consolas", Font.BOLD, 20));
		succ2.setForeground(Color.white);
		succ2.setBounds(10,240,875,40);
		jf.add(succ2);

		JLabel succ3 = new JLabel();
		succ3.setFont(new Font("Consolas", Font.BOLD, 20));
		succ3.setForeground(Color.white);
		succ3.setBounds(10,290,875,40);
		jf.add(succ3);		
		jf.repaint();

		
		if(User.getUsername()==null) {
			warn.setText("Login to track your train");
			warn.setFont(new Font("Arial", Font.BOLD, 38));
			warn.setForeground(Color.red);
			warn.setBounds(195,155,840,63);
			stic.setEditable(false);
			sbtic.setEnabled(false);
			jf.setSize(900,290);
		}
		else {
		sbtic.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent we)
		
			{
				jf.repaint();
				succ.setText("");
				succ2.setText("");
				succ3.setText("");
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
					  
					  String tn="", tdt="", d="", tname="", tat="";
					  boolean flag = false; 
					  
					  try
						{
							Class.forName("com.mysql.cj.jdbc.Driver");
			    			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs","root","");
			    			Statement stmt=con.createStatement();
			    			String txt=stic.getText();
			    			ResultSet rs=stmt.executeQuery("select trainno, traindepttime, date from rpnr where pnrno="+txt);
			    			
			    			while(rs.next())
			    			{
			    				flag = true;
			    				tn = Integer.toString(rs.getInt(1));
			    				tdt = rs.getString(2);
			    				d = rs.getString(3);
			    			}
			    			
			    			if(flag) {
			    			Statement stmt2=con.createStatement();
			    			ResultSet rs2=stmt2.executeQuery("select Train_name, Arri_time from train_list where Train_no="+tn);
			    			
			    			while(rs2.next()) {
			    				
			    				tname = rs2.getString(1);
			    				tat = rs2.getString(2);
			    			}
			    			}
			    			con.close();
			    		}
						catch(Exception re)
						{
							System.out.print(re);
						}
					  
						
					  if(flag) {
						  
						  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
						  LocalDate localDate = LocalDate.parse(d, formatter);
						  
						  LocalTime dept = LocalTime.parse(tdt,
		     	    	            DateTimeFormatter.ofPattern("kk:mm"));
						  
						  LocalTime arr = LocalTime.parse(tat,
		     	    	            DateTimeFormatter.ofPattern("kk:mm"));
						  
                          int comp = dept.compareTo(arr);
                          
                          LocalDate plus = localDate.plusDays(1);
                            
						  if(LocalDate.now().compareTo(localDate)>0) {
							  
							  succ.setBounds(100,180,875,63);
							  succ.setText(tname);
							  succ2.setBounds(100,225,875,40);
							  succ2.setText("Train number "+tn+", departed on "+d+" at "+tdt);
							  succ3.setBounds(100,255,875,40);
							  if(comp<0)
							  succ3.setText("Train reached its destination at "+tat);
							  else
						      succ3.setText("Train reached its destination on "+plus+" at "+tat);
						  }
						  else if(LocalDate.now().compareTo(localDate)==0) {
							  
							  if(LocalTime.now().compareTo(dept)<0) {
								  
								  succ.setBounds(100,180,875,63);
								  succ.setText(tname);
								  succ2.setBounds(100,225,875,40);
								  succ2.setText("Train number "+tn+", will depart today at "+tdt);
								  succ3.setBounds(100,255,875,40);
								  if(comp<0)
								  succ3.setText("Train will reach its destination at "+tat);
								  else
								  succ3.setText("Train will reach its destination tomorrow at "+tat);


							  }
							  else if(LocalTime.now().compareTo(dept)>0) {
								  
								  succ.setBounds(100,180,875,63);
								  succ.setText(tname);
								  succ2.setBounds(100,225,875,40);
								  succ2.setText("Train number "+tn+", departed today at "+tdt);
								  succ3.setBounds(100,255,875,40);
								  if(comp<0)
								  succ3.setText("Train is scheduled to reach its destination at "+tat);
								  else
							      succ3.setText("Train is scheduled to reach its destination tomorrow at "+tat);
  
							  }		  
						  }
						  else {
							  
							  succ.setBounds(100,180,875,63);
							  succ.setText(tname);
							  succ2.setBounds(100,225,875,40);
							  succ2.setText("Train number "+tn+", will depart on "+d+" at "+tdt);
							  succ3.setBounds(100,255,875,40);
							  if(comp<0)
							  succ3.setText("Train will reach its destination at "+tat);
							  else
						      succ3.setText("Train will reach its destination on "+plus+" at "+tat);
  
						  }
						
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
				  
				  String tn="", tt="", d="", tname="", ts="", td="";
				  boolean flag = false; 
				  
				  try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
		    			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs","root","");
		    			Statement stmt=con.createStatement();
		    			String txt=stic.getText();
		    			ResultSet rs=stmt.executeQuery("select trainno, traintime, date from pnr where pnrno="+txt);
		    			
		    			while(rs.next())
		    			{
		    				flag = true;
		    				tn = rs.getString(1);
		    				tt = rs.getString(2);
		    				d = rs.getString(3);
		    			}
		    			
		    			if(flag) {
		    			Statement stmt2=con.createStatement();
		    			ResultSet rs2=stmt2.executeQuery("select trainname, trainsource, traindest from traindet where trainnum=\'"+tn+"\'");
		    			
		    			while(rs2.next()) {
		    				
		    				tname = rs2.getString(1);
		    				ts = rs2.getString(2);
		    				td = rs2.getString(3);
		    			}
		    			}
		    			con.close();
		    		}
					catch(Exception re)
					{
						System.out.print(re);
					}
				  
					
				  if(flag) {
					  
					  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
					  LocalDate localDate = LocalDate.parse(d, formatter);
					  
					  LocalTime dept = LocalTime.of(15, 00);
  
					  if(LocalDate.now().compareTo(localDate)>0) {
						  
						  succ.setBounds(100,180,875,63);
						  succ.setText(tname);
						  succ2.setBounds(100,225,875,40);
						  succ2.setText("Train will travel from "+ts+" to "+td);
						  succ3.setBounds(100,255,875,40);
						  succ3.setText("Special Train number "+tn+", departed on "+d+" at "+tt);

					  }
					  else if(LocalDate.now().compareTo(localDate)==0) {
						  
						  if(LocalTime.now().compareTo(dept)<0) {
							  
							  succ.setBounds(100,180,875,63);
							  succ.setText(tname);
							  succ2.setBounds(100,225,875,40);
							  succ2.setText("Train will travel from "+ts+" to "+td);
							  succ3.setBounds(100,255,875,40);
							  succ3.setText("Special Train number "+tn+", will depart today at "+tt);

						  }
						  else if(LocalTime.now().compareTo(dept)>0) {
							  
							  succ.setBounds(100,180,875,63);
							  succ.setText(tname);
							  succ2.setBounds(100,225,875,40);
							  succ2.setText("Train will travel from "+ts+" to "+td);
							  succ3.setBounds(100,255,875,40);
							  succ3.setText("Special Train number "+tn+", departed today at "+tt);
						  }		  
					  }
					  else {
						  
						  succ.setBounds(100,180,875,63);
						  succ.setText(tname);
						  succ2.setBounds(100,225,875,40);
						  succ2.setText("Train will travel from "+ts+" to "+td);
						  succ3.setBounds(100,255,875,40);
						  succ3.setText("Special Train number "+tn+", will depart on "+d+" at "+tt);
					  }
				  }
				  else {
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
		
            Tracktrain.track();
	}
}