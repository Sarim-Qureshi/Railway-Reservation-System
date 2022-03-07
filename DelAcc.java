package com.RRS;


import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.util.Random;
import java.sql.*;
import javax.swing.*;


public class DelAcc {

	public static void del() {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				JFrame jf = new JFrame("Indian Railways -- Delete Account");
				Font f = new Font("Arial", Font.BOLD, 20);
				Font t = new Font("Arial", Font.BOLD, 17);

				jf.setSize(900, 610);
				jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				jf.getContentPane().setBackground(Color.decode("#333333"));
				jf.setLayout(null);
				jf.setResizable(false);
				
			    JLabel head = new JLabel("Enter your username and password to delete your account");
			    head.setFont(new Font("Arial", Font.BOLD, 26));
			    head.setForeground(Color.white);
			    head.setBounds(75,60,750,50);
			    head.addMouseListener(new LbHover());
			    jf.add(head);
			
				

				JLabel jn = new JLabel("Username");
				jn.setForeground(Color.white);
				jn.setBounds(240, 160, 100, 20);
				jn.setFont(f);
				jn.addMouseListener(new LbHover());
				jf.add(jn);

				JTextField n = new JTextField(20);
				n.setBounds(360, 156, 200, 28);
				n.setFont(t);
				jf.add(n);

				JLabel jp = new JLabel("Password");
				jp.setForeground(Color.white);
				jp.setBounds(240, 220, 100, 20);
				jf.add(jp);
				jp.addMouseListener(new LbHover());
				jp.setFont(f);

				JPasswordField p = new JPasswordField(20);
				p.setEchoChar('*');
				jf.add(p);
				p.setBounds(360, 215, 200, 28);
				p.setFont(t);

				
				JLabel vl = new JLabel("type the number in the box below to verify");
				vl.setFont(new Font("Arial", Font.BOLD, 20));
				vl.setForeground(Color.decode("#FB1B00"));
				vl.setBounds(200, 270, 500, 30);
				jf.add(vl);

				Random r = new Random();
				String s = String.format("%04d", r.nextInt(10000));

				JLabel jl = new JLabel(s);
				jl.setForeground(Color.white);
				jl.setFont(f);
				jl.addMouseListener(new LbHover());
				jl.setBounds(290, 320, 70, 40);
				jf.add(jl);

				JTextField v = new JTextField(4);
				v.setForeground(Color.black);
				v.setBounds(370, 326, 150, 25);
				v.setFont(t);
				jf.add(v);
				
				
				
				JCheckBox cb = new JCheckBox(" I agree to delete my account", false);
				
				cb.setFont(t);
				cb.setForeground(Color.white);
				cb.setBounds(280, 370, 300, 30);
				cb.setBackground(Color.decode("#333333"));
				cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

				jf.add(cb);

				JButton del = new JButton("Delete Account");
				del.setFont(f);
				del.setForeground(Color.white);
				del.setBackground(Color.decode("#ff0000"));
				del.setBounds(250, 420, 300, 35);
				del.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				del.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						del.setBackground(Color.decode("#E3242B"));
					}

					public void mouseExited(java.awt.event.MouseEvent e) {
						del.setBackground(Color.decode("#ff0000"));
					}

				});
				jf.add(del);

				JLabel warning = new JLabel();
				
				del.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent ae) {
						
						if (n.getText().isEmpty() && p.getPassword().length == 0) {
							warning.setText("username and password are required");
							warning.setFont(new Font("Arial", Font.BOLD, 30));
							warning.setForeground(Color.decode("#ff0000"));
							warning.setBounds(140, 460, 600, 120);
							
						} 
						else if (n.getText().isEmpty()) {
							warning.setFont(new Font("Arial", Font.BOLD, 34));
							warning.setBounds(230, 460, 600, 120);
							warning.setForeground(Color.decode("#ff0000"));
							warning.setText("username is required");
							
						}
						else if (p.getPassword().length == 0) {
							warning.setFont(new Font("Arial", Font.BOLD, 34));
							warning.setBounds(230, 460, 600, 120);
							warning.setForeground(Color.decode("#ff0000"));
							warning.setText("password is required");
						}
						else if(!cb.isSelected()) {
							warning.setFont(new Font("Arial", Font.BOLD, 28));
							warning.setBounds(120, 460, 600, 120);
							warning.setForeground(Color.decode("#ff0000"));
							warning.setText("You have not agreed to delete your account");
						}
						else if(!s.equals(v.getText())) {
							warning.setFont(new Font("Arial", Font.BOLD, 28));
							warning.setBounds(160, 460, 600, 120);
							warning.setForeground(Color.decode("#ff0000"));
							warning.setText("Enter the correct number in the box");
						}
						else {
														
						String username = n.getText(); 	
						String password = String.valueOf(p.getPassword());
							
						try {
								
							Class.forName("com.mysql.cj.jdbc.Driver");
							
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs","root","");
							
							String q = "delete from udata where username=? and password=?";
							
							PreparedStatement ps = con.prepareStatement(q);
							
							ps.setString(1, username);
							ps.setString(2, password);
							
							int res = ps.executeUpdate();
							
							if(res>0) {
								warning.setFont(new Font("Arial", Font.BOLD, 34));
								warning.setBounds(195, 460, 600, 120);
								warning.setForeground(Color.decode("#66ff00"));
								warning.setText("your account was deleted");
								
								
								if(User.getUsername().equals(username) && User.getPassword().equals(password))
								{
									
									new java.util.Timer().schedule( 
									        new java.util.TimerTask() {
									            
									            public void run() {   
									            	jf.setVisible(false);	
									            }
									        }, 
									        700 
									);	
									
									homepage.bt_login.setActionCommand("Login");
									homepage.bt_login.setText("Login");
									homepage.bt_sign.setActionCommand("Sign Up");
									homepage.bt_sign.setText("Sign Up");
									
								}
								else {
									
									new java.util.Timer().schedule( 
									        new java.util.TimerTask() {
									            
									            public void run() {   
									            	jf.setVisible(false);	
									            }
									        }, 
									        700 
									);	
									
								}
							}
							else {
								warning.setFont(new Font("Arial", Font.BOLD, 34));
								warning.setBounds(220, 460, 600, 120);
								warning.setForeground(Color.decode("#ff0000"));
								warning.setText("Enter valid credentials");
							}
								
								
							con.close();
							}catch(Exception exc) {}
						}
						
					}
				});
			    
				
				jf.add(warning);
				
				jf.setVisible(true);
			}
	});
	}

}
