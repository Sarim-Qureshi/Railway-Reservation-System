package com.RRS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;


public class Alerts {

	Alerts()
	
	{
		JFrame jalert=new JFrame("Indian Railways -- Alerts");
//		jalert.getContentPane().setBackground(Color.decode("#01608C"));
		jalert.getContentPane().setBackground(Color.decode("#333333"));
		
		Font ft=new Font("Arial",Font.BOLD,15);
		
		JLabel para1=new JLabel();
		para1.setText("<html>Hon'ble Prime Minister message on \"Public Health Response to COVID-19: Campaign for COVID-Appropriate Behaviour\". Wear Mask, Follow Physical Distancing, Maintain Hand Hygine. </html>");
		para1.setBounds(10,10,750,55);
		para1.setForeground(Color.white);
		para1.addMouseListener(new LbHover());
		para1.setFont(ft);
		
		jalert.add(para1);
		
		JLabel para2=new JLabel();
		para2.setText("<html>For trains with Pantry Car, Cooked Food shall not be available in trains. Only Packed Items, Ready to eat, Packaged drinking water and Tea/Coffee/Beverages will be available on limited trains and station catering units.</html>");
		para2.setBounds(10,85,750,50);
		para2.setFont(new Font("Arial",Font.BOLD,14));
		para2.setForeground(Color.white);
		para2.addMouseListener(new LbHover());
		jalert.add(para2);
		
		JLabel para3=new JLabel();
		para3.setText("<html>For trains without Pantry Car, No food will be provided in train. Passengers should make their own arrangement for food and drinking water for rail travel.</html>");
		para3.setBounds(10,150,750,60);
		para3.setFont(ft);
		para3.setForeground(Color.white);
		para3.addMouseListener(new LbHover());
		jalert.add(para3);
		
		
		
		JLabel title=new JLabel("<html><h1>COVID-19 Alerts</h1><html>");
		title.setBounds(10,220,750,20);
		title.setForeground(Color.red);
		
		jalert.add(title);
	
		
		Font ft2=new Font("Andale Mono",Font.ITALIC | Font.BOLD,12);
		
		JLabel para4=new JLabel();
		para4.setText("<html><ul><li>All passengers are hereby informed that downloading of Aarogya Setu App on their mobile phone, that they are carrying along, is advisable.</li><br><li>All Passenger to kindly note that on arrival at their destination, the traveling passengers will have to adhere to such health protocols as are prescribed by the destination State/UT. Click Here to see state wise advisory on Arrival(As available). For other states, State Govt websites may be visited to ascertain the same.</li><br><li>For trains cancelled till 30th June 2020 by Indian Railways, full refund will be provided automatically by IRCTC. Users need not cancel their e-tickets. Full fare will be credited back into users accounts from which payment was made.</li><br><li>Catering Service is not available and catering charges not included in the fare.</li><br><li>No blanket and linen shall be provided in the train.</li><br><li>There are Maximum Waiting List Limits in the PRS booking system for which Waitlisted Tickets can be issued after all confirmed tickets are exhausted. Your ticket booking request may get declined as the Maximum Waiting List Limit may be reached in the booking system by the time payment success response is received from your bank. In such case, your deducted amount will be refunded back, without any deductions, to your bank account in 3-5 working days. Inconvenience caused is regretted.</li></ul></html>");
		para4.setBounds(10,250,750,300);
		para4.setFont(ft2);
		para4.setForeground(Color.white);
		para4.addMouseListener(new LbHover());
		jalert.add(para4);
		
		
		JButton jb=new JButton("OK");
		jb.setBounds(330,570,100,30);
		jb.setBackground(Color.decode("#ff0000"));
		jb.setForeground(Color.white);
		jb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		jb.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jb.setBackground(Color.decode("#E3242B"));
			}

			public void mouseExited(java.awt.event.MouseEvent e) {
				jb.setBackground(Color.decode("#bb0000"));
			}

		});
		
		jalert.add(jb);
		
	
		
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent re)
			{
				jalert.dispose();
			}
		});
		
		
		
		
		
		
	
		jalert.setLayout(null);
		jalert.setSize(800,650);
		jalert.setVisible(true);
		jalert.setLocation(300, 50);
		jalert.setResizable(false);
		
	
	}
	
	
	
	public static void main(String[] args) {
		
new Alerts();
	}

}