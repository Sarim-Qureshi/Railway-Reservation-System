package com.RRS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.sql.*;

public class Signup {

	public static void signup() {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				JFrame jf = new JFrame("Indian Railways -- SignUp");
				Font f = new Font("Arial", Font.BOLD, 20);
				Font t = new Font("Arial", Font.BOLD, 17);

				jf.setSize(930, 570);
				jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				jf.getContentPane().setBackground(Color.decode("#333333"));
				jf.setLayout(null);
				jf.setResizable(false);

				JLabel head = new JLabel("CREATE AN ACCOUNT");
				head.setForeground(Color.white);
				head.setFont(new Font("DialogInput", Font.BOLD, 30));
				head.setBounds(290, 30, 400, 60);
				head.addMouseListener(new LbHover());
				jf.add(head);

				JLabel vl = new JLabel("Type the number in the adjacent box to verify");
				vl.setFont(new Font("Arial", Font.BOLD, 20));
				vl.setForeground(Color.decode("#FB1B00"));
				vl.setBounds(50, 125, 500, 30);
				jf.add(vl);

				Random r = new Random();
				String s = String.format("%04d", r.nextInt(10000));

				JLabel jl = new JLabel(s);
				jl.setForeground(Color.white);
				jl.setFont(f);
				jl.addMouseListener(new LbHover());
				jl.setBounds(570, 120, 70, 40);
				jf.add(jl);

				JTextField v = new JTextField(4);
				v.setForeground(Color.black);
				v.setBounds(670, 130, 150, 25);
				v.setFont(t);
				jf.add(v);

				JTextField fn = new JTextField("First Name", 20);
				fn.setForeground(Color.GRAY);
				fn.setBounds(100, 200, 250, 25);
				fn.setFont(t);
				fn.addFocusListener(new FocusListener() {

					public void focusGained(FocusEvent fe) {

						if (fn.getText().equals("First Name")) {
							fn.setText("");
							fn.setForeground(Color.black);
						}

					}

					public void focusLost(FocusEvent fe) {

						if (fn.getText().isEmpty()) {
							fn.setForeground(Color.GRAY);
							fn.setText("First Name");
						}
					}

				});
				jf.add(fn);

				JTextField ln = new JTextField("Last Name", 20);
				ln.setForeground(Color.GRAY);
				ln.setBounds(480, 200, 250, 25);
				ln.setFont(t);
				ln.addFocusListener(new FocusListener() {

					public void focusGained(FocusEvent fe) {

						if (ln.getText().equals("Last Name")) {
							ln.setText("");
							ln.setForeground(Color.black);
						}

					}

					public void focusLost(FocusEvent fe) {

						if (ln.getText().isEmpty()) {
							ln.setForeground(Color.GRAY);
							ln.setText("Last Name");
						}
					}

				});
				jf.add(ln);

				JTextField un = new JTextField("Username", 20);
				un.setForeground(Color.GRAY);
				un.setBounds(100, 280, 250, 25);
				un.setFont(t);
				un.addFocusListener(new FocusListener() {

					public void focusGained(FocusEvent fe) {

						if (un.getText().equals("Username")) {
							un.setText("");
							un.setForeground(Color.black);
						}

					}

					public void focusLost(FocusEvent fe) {

						if (un.getText().isEmpty()) {
							un.setForeground(Color.GRAY);
							un.setText("Username");
						}
					}

				});
				jf.add(un);

				TextField p = new TextField("Password", 20);
				p.setForeground(Color.GRAY);
				p.setBounds(480, 280, 250, 25);
				p.setFont(t);
				p.addFocusListener(new FocusListener() {

					public void focusGained(FocusEvent fe) {

						if (p.getText().equals("Password")) {
							p.setText("");
							p.setEchoChar('*');
							p.setForeground(Color.black);
						}

					}

					public void focusLost(FocusEvent fe) {

						if (p.getText().isEmpty()) {
							p.setForeground(Color.GRAY);
							p.setEchoChar((char) 0);
							p.setText("Password");
						}
					}

				});
				jf.add(p);

				TextField cp = new TextField("Confirm Password", 20);
				cp.setForeground(Color.GRAY);
				cp.setBounds(100, 360, 250, 25);
				cp.setFont(t);
				cp.addFocusListener(new FocusListener() {

					public void focusGained(FocusEvent fe) {

						if (cp.getText().equals("Confirm Password")) {
							cp.setText("");
							cp.setEchoChar('*');
							cp.setForeground(Color.black);
						}

					}

					public void focusLost(FocusEvent fe) {

						if (cp.getText().isEmpty()) {
							cp.setForeground(Color.GRAY);
							cp.setEchoChar((char) 0);
							cp.setText("Confirm Password");
						}
					}

				});
				jf.add(cp);

				JButton c = new JButton("Create Account");
				c.setForeground(Color.white);
				c.setBackground(Color.decode("#C7EA6"));
				c.setFont(f);
				c.setBounds(480, 360, 250, 25);
				c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

				c.addMouseListener(new MouseAdapter() {

					public void mouseEntered(MouseEvent e) {
						c.setBackground(Color.decode("#1338BE"));
					}

					public void mouseExited(java.awt.event.MouseEvent e) {
						c.setBackground(Color.decode("#C7EA6"));
					}

				});

				JLabel info = new JLabel("Make sure that the fields contain no more than 20 characters");
				info.setForeground(Color.white);
				info.addMouseListener(new LbHover());
				info.setFont(new Font("Monospaced", Font.BOLD, 18));
				info.setBounds(85, 400, 990, 35);
				jf.add(info);

				JLabel info2 = new JLabel("Only the first 20 characters will be considered");
				info2.setForeground(Color.white);
				info2.addMouseListener(new LbHover());
				info2.setFont(new Font("Monospaced", Font.BOLD, 18));
				info2.setBounds(142, 418, 990, 35);
				jf.add(info2);

				JLabel warning = new JLabel();

				c.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {

						if (fn.getText().equals("First Name") || ln.getText().equals("Last Name")
								|| un.getText().equals("Username") || p.getText().equals("Password")
								|| cp.getText().equals("Confirm Password") || v.getText().isEmpty()) 
						{
							
							warning.setText("All fields are required");
							warning.setForeground(Color.decode("#f32013"));
							warning.setFont(new Font("Arial", Font.BOLD, 35));
							warning.setBounds(250, 470, 400, 50);
						} 
						else if (!p.getText().equals(cp.getText()))
						{
							warning.setText("Passwords do not match");
							warning.setForeground(Color.decode("#f32013"));
							warning.setFont(new Font("Arial", Font.BOLD, 35));
							warning.setBounds(220, 470, 500, 50);
						}
						else if (!v.getText().equals(s))
						{
							warning.setText("Enter the correct number in the box");
							warning.setForeground(Color.decode("#f32013"));
							warning.setFont(new Font("Arial", Font.BOLD, 30));
							warning.setBounds(175, 470, 520, 50);
						} 
						else {
							String username = un.getText();
							String firstname = fn.getText();
							String lastname = ln.getText();
							String password = p.getText();

							try {
								Class.forName("com.mysql.cj.jdbc.Driver");
								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs","root", "");

								String fq = "select * from udata where username=\'" + username + "\'";

								Statement st = con.createStatement();
								ResultSet set = st.executeQuery(fq);

								int ct = 0;

								while (set.next())
									ct++;

								if (ct != 0) {
									warning.setText("Username already exists");
									warning.setForeground(Color.decode("#f32013"));
									warning.setFont(new Font("Arial", Font.BOLD, 34));
									warning.setBounds(235, 470, 420, 50);
								} 
								
								else {

									String sq = "insert into udata values(?,?,?,?)";

									PreparedStatement ps = con.prepareStatement(sq);

									ps.setString(1, username);
									ps.setString(2, firstname);
									ps.setString(3, lastname);
									ps.setString(4, password);

									int result = ps.executeUpdate();

									if (result > 0) {
										warning.setText("Your account has been created");
										warning.setForeground(Color.decode("#90ee90"));
										warning.setFont(new Font("Arial", Font.BOLD, 28));
										warning.setBounds(220, 470, 420, 50);
										
										new java.util.Timer().schedule( 
										        new java.util.TimerTask() {
										            
										            public void run() {   
										            	jf.setVisible(false);	
										            }
										        }, 
										        700 
										);
										
									} else {
										warning.setText("Account was not created");
										warning.setForeground(Color.decode("#f32013"));
										warning.setFont(new Font("Arial", Font.BOLD, 28));
										warning.setBounds(220, 470, 420, 50);
									}
								}

								con.close();

							} catch (Exception e) {}
						}
					}
				});

				jf.add(warning);
				jf.add(c);

				jf.setVisible(true);

			}
		});
	}

}
