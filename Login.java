package com.RRS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login {
	

	public static void login() {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame jf = new JFrame("Indian Railways -- Login");
				Font f = new Font("Arial", Font.BOLD, 20);
				Font t = new Font("Arial", Font.BOLD, 17);

				jf.setSize(390, 513);
				jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				jf.getContentPane().setBackground(Color.decode("#333333"));
				jf.setLayout(null);
				jf.setResizable(false);

				JLabel head = new JLabel("LOGIN TO CONTINUE");
				head.setForeground(Color.decode("#FF6961"));
				head.setFont(new Font("DialogInput", Font.BOLD, 28));
				head.setBounds(40, 7, 360, 120);
				jf.add(head);

				JLabel jn = new JLabel("Username");
				jn.setForeground(Color.white);
				jn.addMouseListener(new LbHover());
				jn.setBounds(20, 130, 100, 20);
				jn.setFont(f);
				jf.add(jn);

				JTextField n = new JTextField(20);
				n.setBounds(140, 126, 200, 28);
				n.setFont(t);
				jf.add(n);

				JLabel jp = new JLabel("Password");
				jp.setForeground(Color.white);
				jp.addMouseListener(new LbHover());
				jp.setBounds(20, 185, 100, 20);
				jf.add(jp);
				jp.setFont(f);

				JPasswordField p = new JPasswordField(20);
				p.setEchoChar('*');
				jf.add(p);
				p.setBounds(140, 180, 200, 28);
				p.setFont(t);

				JCheckBox cb = new JCheckBox("show password", false);
				cb.addItemListener(e -> {
					if (cb.isSelected())
						p.setEchoChar((char) 0);
					else
						p.setEchoChar('*');
				});
				jf.add(cb);
				cb.setFont(f);
				cb.setForeground(Color.white);
				cb.setBounds(140, 220, 200, 30);
				cb.setBackground(Color.decode("#333333"));
				cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


				JButton log = new JButton("Login");
				log.setFont(f);
				log.setForeground(Color.white);
				log.setBackground(Color.decode("#5BC236"));
				log.setBounds(25, 265, 300, 35);
				log.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				log.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent e) {
						log.setBackground(Color.decode("#006400"));
					}

					public void mouseExited(java.awt.event.MouseEvent e) {
						log.setBackground(Color.decode("#5BC236"));
					}

				});

				log.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						if (n.getText().isEmpty() && p.getPassword().length == 0) {
							head.setText("username and password are required");
							head.setFont(new Font("Arial", Font.BOLD, 20));
							head.setForeground(Color.decode("#FF6961"));
							head.setBounds(14, 7, 360, 120);
							
						} else if (n.getText().isEmpty()) {
							head.setFont(new Font("Arial", Font.BOLD, 28));
							head.setBounds(40, 7, 360, 120);
							head.setForeground(Color.decode("#FF6961"));
							head.setText("username is required");
							
						} else if (p.getPassword().length == 0) {
							head.setFont(new Font("Arial", Font.BOLD, 28));
							head.setBounds(40, 7, 360, 120);
							head.setForeground(Color.decode("#FF6961"));
							head.setText("password is required");
							
						} else {

							String username = n.getText();
							char[] ps = p.getPassword();
							String password = String.valueOf(ps);

							String uname="";
							String passw="";
							String firstname = "";
							String lastname = "";
							try {
								Class.forName("com.mysql.cj.jdbc.Driver");

								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs","root", "");

								String q = "select * from udata where username=\'"+username+"\' and password=\'"+password+"\'";
								String qu = "select * from udata where username=\'"+username+"\'";

								Statement st = con.createStatement();
								ResultSet set = st.executeQuery(q);

								Statement st2 = con.createStatement();
								ResultSet set2 = st2.executeQuery(qu);

								int ct = 0;
								int ct2 = 0;

								while (set.next()) {
									ct++;
									uname = set.getString(1);
									firstname = set.getString(2);
									lastname = set.getString(3);
									passw = set.getString(4);
								}

								while (set2.next())
									ct2++;

								if (ct == 0 && ct2 == 0) 
								{
									head.setFont(new Font("Arial", Font.BOLD, 28));
									head.setBounds(30, 7, 360, 120);
									head.setForeground(Color.decode("#FF6961"));
									head.setText("account does not exist");
									
								}
								else if (ct == 0 && ct2 != 0)
								{
									head.setFont(new Font("Arial", Font.BOLD, 28));
									head.setBounds(70, 7, 360, 120);
									head.setForeground(Color.decode("#FF6961"));
									head.setText("Invalid password");
									
								} 
								else
								{
									head.setText("you are logged in");
									head.setFont(new Font("DialogInput", Font.BOLD, 25));
									head.setBounds(54, 7, 385, 120);
									head.setForeground(Color.decode("#90ee90"));
									
									User.setFirstname(firstname);
									User.setLastname(lastname);
									User.setUsername(uname);
									User.setPassword(passw);
									
									new java.util.Timer().schedule( 
									        new java.util.TimerTask() {
									            
									            public void run() {   
									            	jf.dispose();
									            }
									        }, 
									        700 
									);
									homepage.bt_login.setActionCommand("Log Out");
									homepage.bt_login.setText("Log Out");
									homepage.bt_sign.setActionCommand(" Delete account");
									homepage.bt_sign.setText("Delete account");
								}

								con.close();
							} catch (Exception ex) {}
						}
					}
				});

				jf.add(log);

				JLabel foot = new JLabel("Don't have an account yet? Sign Up");
				foot.setForeground(Color.white);
				foot.addMouseListener(new LbHover());
				foot.setFont(new Font("DialogInput", Font.BOLD, 16));
				foot.setBounds(15, 310, 480, 80);
				jf.add(foot);

				JButton sign = new JButton("Sign Up");
				sign.setFont(f);
				sign.setForeground(Color.white);
				sign.setBackground(Color.decode("#C7EA6"));
				sign.setBounds(25, 390, 300, 35);
				sign.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				sign.addMouseListener(new MouseAdapter() {

					public void mouseEntered(MouseEvent e) {
						sign.setBackground(Color.decode("#1338BE"));
					}

					public void mouseExited(java.awt.event.MouseEvent e) {
						sign.setBackground(Color.decode("#C7EA6"));
					}
				});
				sign.addActionListener(e -> {
					Signup.signup();
				});
				
				jf.add(sign);

				jf.setVisible(true);
			}
		});
	}
}

class User{
  private static String Username;
  private static String Firstname;
  private static String Lastname;
  private static String Password;

public static String getUsername() {
	return Username;
}
public static void setUsername(String username) {
	Username = username;
}
public static String getFirstname() {
	return Firstname;
}
public static void setFirstname(String firstname) {
	Firstname = firstname;
}
public static String getLastname() {
	return Lastname;
}
public static void setLastname(String lastname) {
	Lastname = lastname;
}
public static String getPassword() {
	return Password;
}
public static void setPassword(String password) {
	Password = password;
}
}
