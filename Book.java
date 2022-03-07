package com.RRS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.Vector;

public class Book {

	Vector<String> src = new Vector<>();
	Vector<String> dest = new Vector<>();

	
	Book() {
	

		JFrame bkt = new JFrame("Indian Railways -- Check Trains");
		bkt.setSize(750, 540);
		
		
		//----------------
		// change to hide on close
		//---------------
		
		
		bkt.getContentPane().setBackground(Color.decode("#01608C"));
		

		Font mFt = new Font("TimesNewRoman", Font.BOLD, 40);
		JLabel mText = new JLabel("Check Trains");
		mText.setBounds(220, 2, 500, 100);
		mText.setFont(mFt);
		mText.setForeground(Color.white);
		mText.setFocusable(true);
		bkt.add(mText);
		
		Font mFrml = new Font("Arial", Font.PLAIN, 20);

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs","root","");
			Statement stmt=con.createStatement();
			Statement stmt2=con.createStatement();

			String sql = "select distinct trainsource from traindet";
			String sql2 = "select distinct traindest from traindet";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSet rs2 = stmt2.executeQuery(sql2);
			
			while (rs.next())  src.addElement(rs.getString(1));
			
			
			while(rs2.next())  dest.addElement(rs2.getString(1));
				
			
			con.close();
			
			
			
		}catch(Exception e) {}
		
		
		String arr1[] = new String[src.size()+1];
		arr1[0] = "from";
		
		int j=0;
		for(int i=0;i<src.size();i++)  arr1[++j] = src.elementAt(i);
	
		
		
		JComboBox<String> cb1 = new JComboBox<String>(arr1);
		cb1.setBounds(70, 150, 180, 26);
		cb1.setFont(new Font("Arial", Font.PLAIN, 18));
		cb1.setForeground(Color.black);
		cb1.setBorder(null);
		
		bkt.add(cb1);
		

		JButton b = new JButton("switch");
		b.setBounds(297, 150, 100, 25);
		b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setFont(mFrml);
        b.setBorder(BorderFactory.createLineBorder(Color.black));
        b.setBackground(Color.decode("#F3E5AB"));
        b.setForeground(Color.black);
        
        b.addMouseListener(new MouseAdapter() {
        
        	public void mouseEntered(MouseEvent e) {
        		b.setBackground(Color.decode("#59788E"));
        		b.setForeground(Color.white);
        	}

        	public void mouseExited(MouseEvent e) {
        		b.setForeground(Color.black);
        		b.setBackground(Color.decode("#F3E5AB"));
        	}
        });
        
        
		bkt.add(b);
		
		
		String arr2[] = new String[dest.size()+1];
		arr2[0] = "to";
		
		 j=0;
		for(int i=0;i<dest.size();i++)  arr2[++j] = dest.elementAt(i);
	
		
		
		JComboBox<String> cb2 = new JComboBox<String>(arr2);
		cb2.setBounds(440, 150, 180, 26);
		cb2.setFont(new Font("Arial", Font.PLAIN, 18));
		cb2.setForeground(Color.black);
		cb2.setBorder(null);
		
		bkt.add(cb2);


		JLabel temp = new JLabel("Cannot switch source and destination");
		
         b.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		Object o1 = cb1.getSelectedItem();
        		Object o2 = cb2.getSelectedItem();
   
        		
        		if(o1.equals(o2) || o1.equals("from") || o2.equals("to")) {
        			temp.setBounds(120,120,500,30);
        			temp.setFont(new Font("Consolas",Font.BOLD,22));
        			temp.setForeground(Color.decode("#FFCCCB"));
        			temp.setVisible(true);
        	
        		}
        		new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            
				            public void run() {   
				            	temp.setVisible(false);
				            }
				        }, 
				        2000 
				);
        		if(!o1.equals(o2) || !o1.equals("from") || !o2.equals("to")) {
        			
        		boolean isAnItem1 = false;
        		
        		for(int i=0;i<cb2.getItemCount();i++) {
        			
        			if(o1.equals(cb2.getItemAt(i))) {
        				isAnItem1 = true;
        				break;
        			}
        		}
        			
                boolean isAnItem2 = false;
        		
        		for(int i=0;i<cb1.getItemCount();i++) {
        			
        			if(o2.equals(cb1.getItemAt(i))) {
        				isAnItem2 = true;
        				break;
        			}
        		}
        			
        		if(isAnItem1 && isAnItem2) {
        	    cb2.setSelectedItem(o1);
        		cb1.setSelectedItem(o2);  
        		}
        		else {
        			temp.setBounds(120,120,500,30);
        			temp.setFont(new Font("Consolas",Font.BOLD,22));
        			temp.setForeground(Color.decode("#FFCCCB"));
        			temp.setVisible(true);
        		}
        		new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            
				            public void run() {   
				            	temp.setVisible(false);
				            }
				        }, 
				        2000 
				);
        		
        		}
        		
        	}
        });
		
         bkt.add(temp);
        
                  
        	 String arr[] = new String[30];
        	 LocalDate cd = java.time.LocalDate.now();
        	 arr[0] = cd.toString();
  
        	 for(int i=1;i<30;i++)   arr[i] = cd.plusDays(i).toString();	 
        		 	 
         JComboBox<String> cb3 = new JComboBox<>(arr);
         cb3.setBounds(70, 240, 180, 26);	
         cb3.setBorder(null);
 		 cb3.setFont(new Font("Arial", Font.PLAIN, 18));
 		 cb3.setForeground(Color.black);
         bkt.add(cb3);


		JLabel ldate = new JLabel("YYYY-MM-DD");
		ldate.setBounds(70, 270, 100, 20);
		ldate.setFont(new Font("Consolas",Font.BOLD,16));
		ldate.setForeground(Color.white);

		bkt.add(ldate);

		String item_class[] = { "All Classes", "First Class", "Second Class", "Sleeper" };

		JComboBox<String> dclass = new JComboBox<String>(item_class);
	
		dclass.setBounds(440, 240, 180, 26);
		dclass.setBorder(null);
		dclass.setBackground(Color.white);
		dclass.setFont(new Font("Arial", Font.PLAIN, 18));
		dclass.setForeground(Color.black);
		bkt.add(dclass);

		JCheckBox dflex = new JCheckBox("Flexible with Date");
		dflex.setSelected(true);
		dflex.setBounds(70, 300, 180, 26);
        dflex.setForeground(Color.white);
		dflex.setContentAreaFilled(false);
		dflex.setBackground(Color.gray);
		bkt.add(dflex);

		JButton btsub = new JButton();
		btsub.setBounds(100, 360, 500, 36);
		btsub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btsub.setText("CHECK");
		btsub.setBackground(Color.decode("#F3E5AB"));
		btsub.setBorder(BorderFactory.createLineBorder(Color.black));
		btsub.setForeground(Color.black);
		btsub.setFont(mFrml);
		bkt.add(btsub);

		 btsub.addMouseListener(new MouseAdapter() {
		        
	        	public void mouseEntered(MouseEvent e) {
	        		btsub.setBackground(Color.decode("#59788E"));
	        		btsub.setForeground(Color.white);
	        	}

	        	public void mouseExited(MouseEvent e) {
	        		btsub.setForeground(Color.black);
	        		btsub.setBackground(Color.decode("#F3E5AB"));
	        	}
	        });
		
		 JLabel warn = new JLabel();
		 
		btsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 
				if(cb1.getSelectedIndex()==0 && cb2.getSelectedIndex()==0) {
					warn.setVisible(true);
					warn.setBounds(105,420,500,30);
					warn.setFont(new Font("Consolas",Font.BOLD,30));
					warn.setForeground(Color.decode("#FF9E79"));
					warn.setText("select source and destination");
				}
				else if(cb1.getSelectedIndex()==0) {
					warn.setVisible(true);
					warn.setBounds(216,420,500,40);
					warn.setFont(new Font("Consolas",Font.BOLD,34));
					warn.setForeground(Color.decode("#FF9E79"));
					warn.setText("select source");
				}
				else if(cb2.getSelectedIndex()==0) {
					warn.setVisible(true);
					warn.setBounds(182,420,500,40);
					warn.setFont(new Font("Consolas",Font.BOLD,34));
					warn.setForeground(Color.decode("#FF9E79"));
					warn.setText("select destination");
				}
				else {
					    Train.setSource(cb1.getSelectedItem().toString());
					    Train.setDestination(cb2.getSelectedItem().toString());
					    Train.setDate(cb3.getSelectedItem().toString());
					    Train.setClass(dclass.getSelectedItem().toString());
				}
				new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            
				            public void run() {   
				            	warn.setVisible(false);
				            }
				        }, 
				        2000 
				);
				
			
			}
		});

		bkt.add(warn);
		bkt.setLayout(null);

		bkt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		bkt.setVisible(true);
		
	
	}

	public static void main(String[] args) {
		Book bk = new Book();

	}

}

class Train{
	
  private static String number, name, source, destination, date, tclass;
	
	public static String getNumber() {
		return number;
	}
	public static void setNumber(String number) {
		Train.number = number;
	}
	public static String getDate() {
		return date;
	}
	public static void setDate(String date) {
		Train.date = date;
	}
	public static String getTclass() {
		return tclass;
	}
	public static void setClass(String class1) {
		tclass = class1;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Train.name = name;
	}
	public static String getSource() {
		return source;
	}
	public static void setSource(String source) {
		Train.source = source;
	}
	public static String getDestination() {
		return destination;
	}
	public static void setDestination(String destination) {
		Train.destination = destination;
	}
	
}
