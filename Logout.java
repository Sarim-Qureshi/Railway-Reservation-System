package com.RRS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Logout {

	public static void logout() {
	SwingUtilities.invokeLater(new Runnable() {
		
		public void run() {
			
			JFrame jf = new JFrame("Indian Railways -- Log Out");
			
			
			jf.setSize(475, 400);
			jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			jf.setLayout(null);
			jf.getContentPane().setBackground(Color.decode("#333333"));
			jf.setResizable(false);
			
			JLabel jl = new JLabel("Are you sure you want to logout ?");
	
			jl.setFont(new Font("Arial",Font.BOLD,22));
			jl.setForeground(Color.white);
			jl.addMouseListener(new LbHover());
			jl.setBounds(50, 50, 400, 100);
			
			jf.add(jl);
			
			JRadioButton b1 = new JRadioButton("Yes");
			JRadioButton b2 = new JRadioButton("No",true);
			
			b1.setBackground(Color.decode("#333333"));
			b2.setBackground(Color.decode("#333333"));

			b1.setForeground(Color.white);
			b2.setForeground(Color.white);
			
			ButtonGroup bg = new ButtonGroup();
			bg.add(b1);
			bg.add(b2);
			
			b1.setBounds(140, 140, 90, 50);
			b2.setBounds(230, 140, 90, 50);
			
			b1.setFont(new Font("Monospaced",Font.BOLD,17));
			b2.setFont(new Font("Monospaced",Font.BOLD,17));

            b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			jf.add(b1);
			jf.add(b2);
			
			JButton jb = new JButton("Log Out");
			jb.setBackground(Color.decode("#ff0000"));
			jb.setFont(new Font("Arial",Font.BOLD,20));
			jb.setForeground(Color.white);
			jb.setBounds(80, 230, 280, 30);
			jb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jb.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					jb.setBackground(Color.decode("#E3242B"));
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					jb.setBackground(Color.decode("#ff0000"));
				}

			});

			jb.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					if(b1.isSelected())
					{
					
		
						new java.util.Timer().schedule( 
						        new java.util.TimerTask() {
						            
						            public void run() {   
						            	jf.dispose();	
						            }
						        }, 
						        700 
						);
						
						User.setFirstname(null);
						User.setLastname(null);
						User.setUsername(null);
						User.setPassword(null);
						
						homepage.bt_login.setActionCommand("Login");
						homepage.bt_login.setText("Login");
						homepage.bt_sign.setActionCommand("Sign Up");
						homepage.bt_sign.setText("Sign Up");
					}
				}
			});
			
			jf.add(jb);
			
			jf.setVisible(true);
			

		}
	});
}	
}
