package com.RRS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckTrains {

	
	public static void check() {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
			
				JFrame f = new JFrame("Indian Railways -- Check Trains");
				f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				f.setSize(650, 450);
				f.setLayout(null);
				f.getContentPane().setBackground(Color.decode("#333333"));
				f.setVisible(true);

				JLabel jl = new JLabel("Which trains do you want to check ?");
				jl.setFont(new Font("Arial",Font.BOLD,30));
				jl.setForeground(Color.white);
				jl.addMouseListener(new LbHover());
				jl.setBounds(50,50,550,50);
				f.add(jl);
				
				Font fo = new Font("Consolas",Font.BOLD,20);
				
				JRadioButton b1 = new JRadioButton("Regular trains");
				JRadioButton b2 = new JRadioButton("Special trains");
				b1.setFont(fo); b2.setFont(fo);
				b1.setBackground(Color.decode("#333333"));
				b2.setBackground(Color.decode("#333333"));
				b1.setForeground(Color.decode("#f2f3f4"));
				b2.setForeground(Color.decode("#f2f3f4"));
				b1.setBounds(85,165,180,45);
				b2.setBounds(305,165,180,45);
				f.add(b1); f.add(b2);
				
				ButtonGroup bg = new ButtonGroup();
				bg.add(b1); bg.add(b2);
				
				JButton b = new JButton("Check");
				b.setBounds(60,290,490,40);
				b.setBackground(Color.decode("#d0312d"));
				b.setForeground(Color.white);
				b.setFont(new Font("Consolas",Font.BOLD,22));
				f.add(b);
				
				b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
				b.addMouseListener(new MouseAdapter() {

					public void mouseEntered(MouseEvent e) {
						b.setBackground(Color.decode("#900d09"));
					}

					public void mouseExited(java.awt.event.MouseEvent e) {
						b.setBackground(Color.decode("#d0312d"));
					}
				});
				
				b.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent ae) {
						
						if(b1.isSelected()) {
							book2.mbook2();
						}
						else if(b2.isSelected()) {
							Special.spec();
						}
					}
				});

			}	
		});
		
		
	}
	
	public static void main(String[] args) {
		CheckTrains.check();
	}

}
