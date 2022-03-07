package com.RRS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class homepage implements ActionListener {

	Font bf = new Font("Arial", Font.BOLD, 17);
	static JButton bt_login;
	static JButton bt_sign;
	homepage() {

		JFrame jf = new JFrame("Indian Railways");
		jf.setSize(1360, 730);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(null);
		jf.setResizable(false);

//		JLabel icon = new JLabel(new ImageIcon("C:\\Users\\Sarim Qureshi\\Downloads\\IconTrain.png"));
//		icon.setSize(100, 100);
//		icon.setForeground(Color.blue);
//		jf.add(icon);
		
		Font ft = new Font("Arial", Font.BOLD, 50);

		JLabel back_im = new JLabel(new ImageIcon("C:\\Users\\Sarim Qureshi\\Downloads\\Railway.jpg"));
		back_im.setBounds(0, 0, 1360, 730);
		back_im.setFont(ft);
		jf.add(back_im);

		JLabel back_txt = new JLabel("Welcome to Indian Railways");
		back_txt.setBounds(500, 280, 1000, 60);
		back_txt.setFont(ft);
		back_txt.setForeground(Color.white);
		back_im.add(back_txt);

		Font fext = new Font("Arial", Font.ITALIC, 25);
		JLabel extra_txt = new JLabel("SAFETY | SECURITY | PUNCTUALITY");
		extra_txt.setBounds(600, 320, 1000, 60);
		extra_txt.setFont(fext);
		extra_txt.setForeground(Color.white);
		back_im.add(extra_txt);

		JButton bt_tic = new JButton();
		bt_tic.setBounds(220, 1, 150, 50);
		bt_tic.setOpaque(true);
		bt_tic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt_tic.setText("Book Ticket");
		bt_tic.setContentAreaFilled(false);
		bt_tic.setBorderPainted(false);
		bt_tic.setForeground(Color.white);
		bt_tic.setFont(bf);
		bt_tic.addMouseListener(new BtHover());
		bt_tic.addActionListener(this);
		back_im.add(bt_tic);
		

		JButton bt_canl = new JButton();
		bt_canl.setBounds(220, 51, 150, 50);
		bt_canl.setOpaque(true);
		bt_canl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt_canl.setText("Cancel Ticket");
		bt_canl.setContentAreaFilled(false);
		bt_canl.setBorderPainted(false);
		bt_canl.setForeground(Color.white);
		bt_canl.setFont(bf);
		bt_canl.addActionListener(this);
		bt_canl.addMouseListener(new BtHover());

		back_im.add(bt_canl);

		JButton bt_pnr = new JButton();
		bt_pnr.setBounds(370, 1, 150, 50);
		bt_pnr.setText("PNR Enquiry");
		bt_pnr.setOpaque(true);
		bt_pnr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt_pnr.setContentAreaFilled(false);
		bt_pnr.setBorderPainted(false);
		bt_pnr.setForeground(Color.white);
		bt_pnr.setFont(bf);
		bt_pnr.addMouseListener(new BtHover());
		bt_pnr.addActionListener(this);

		back_im.add(bt_pnr);

		JButton bt_check = new JButton();
		bt_check.setBounds(370, 51, 150, 50);
		bt_check.setOpaque(true);
		bt_check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt_check.setText("Check Trains");
		bt_check.setContentAreaFilled(false);
		bt_check.setBorderPainted(false);
		bt_check.setForeground(Color.white);
		bt_check.setFont(bf);
		bt_check.addActionListener(this);
		bt_check.addMouseListener(new BtHover());

		back_im.add(bt_check);

		JButton bt_spec = new JButton();
		bt_spec.setBounds(525, 1, 150, 50);
		bt_spec.setOpaque(true);
		bt_spec.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt_spec.setText("Special Trains");
		bt_spec.setContentAreaFilled(false);
		bt_spec.setBorderPainted(false);
		bt_spec.setForeground(Color.white);
		bt_spec.setFont(bf);
		bt_spec.addMouseListener(new BtHover());
		bt_spec.addActionListener(this);

		back_im.add(bt_spec);

		JButton bt_track = new JButton();
		bt_track.setBounds(500, 51, 200, 50);
		bt_track.setOpaque(true);
		bt_track.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt_track.setText("Track your train");
		bt_track.setContentAreaFilled(false);
		bt_track.setBorderPainted(false);
		bt_track.setForeground(Color.white);
		bt_track.setFont(bf);
		bt_track.addMouseListener(new BtHover());
		bt_track.addActionListener(this);

		back_im.add(bt_track);

		JButton bt_meal = new JButton();
		bt_meal.setBounds(660, 1, 180, 50);
		bt_meal.setOpaque(true);
		bt_meal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt_meal.setText("Meals");
		bt_meal.setContentAreaFilled(false);
		bt_meal.setBorderPainted(false);
		bt_meal.setForeground(Color.white);
		bt_meal.setFont(bf);
		bt_meal.addActionListener(this);
		bt_meal.addMouseListener(new BtHover());

		back_im.add(bt_meal);

		JButton bt_alert = new JButton();
		bt_alert.setBounds(675, 51, 150, 50);
		bt_alert.setOpaque(true);
		bt_alert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt_alert.setText("Alerts");
		bt_alert.setContentAreaFilled(false);
		bt_alert.setBorderPainted(false);
		bt_alert.setForeground(Color.white);
		bt_alert.setFont(bf);
		bt_alert.addActionListener(this);
		bt_alert.addMouseListener(new BtHover());

		back_im.add(bt_alert);

		JButton bt_contact = new JButton();
		bt_contact.setBounds(820, 1, 150, 50);
		bt_contact.setOpaque(true);
		bt_contact.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt_contact.setText("Contact Us");
		bt_contact.setContentAreaFilled(false);
		bt_contact.setBorderPainted(false);
		bt_contact.setForeground(Color.white);
		bt_contact.setFont(bf);
		bt_contact.addMouseListener(new BtHover());
		bt_contact.addActionListener(this);

		back_im.add(bt_contact);

		JButton bt_about = new JButton();
		bt_about.setBounds(820, 51, 150, 50);
		bt_about.setOpaque(true);
		bt_about.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt_about.setText("About us");
		bt_about.setContentAreaFilled(false);
		bt_about.setBorderPainted(false);
		bt_about.setForeground(Color.white);
		bt_about.setFont(bf);
		bt_about.addMouseListener(new BtHover());
		bt_about.addActionListener(this);

		back_im.add(bt_about);

		bt_sign = new JButton();
		bt_sign.setBounds(935, 1, 200, 50);
		bt_sign.setOpaque(true);
		bt_sign.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt_sign.setText("Sign Up");
		bt_sign.setContentAreaFilled(false);
		bt_sign.setBorderPainted(false);
		bt_sign.setForeground(Color.white);
		bt_sign.setFont(bf);
		bt_sign.addMouseListener(new BtHover());
		bt_sign.addActionListener(this);

		back_im.add(bt_sign);

		bt_login = new JButton();
		bt_login.setBounds(960, 51, 150, 50);
		bt_login.setOpaque(true);
		bt_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt_login.setText("Login");
		bt_login.setContentAreaFilled(false);
		bt_login.setBorderPainted(false);
		bt_login.setForeground(Color.white);
		bt_login.setFont(bf);
		bt_login.addMouseListener(new BtHover());
		bt_login.addActionListener(this);

		back_im.add(bt_login);
		

		jf.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getActionCommand() == "Login") 
		{
			Login.login();
		}

		else if (ae.getActionCommand() == "Sign Up")
		{
			Signup.signup();
		}
		else if(ae.getActionCommand() == "Log Out")
		{
		   Logout.logout();
		}
		else if(ae.getActionCommand() == " Delete account") 
		{
			DelAcc.del();
		}
		else if(ae.getActionCommand() == "Special Trains")
		{
			Special.spec();
		}
		else if(ae.getActionCommand() == "Contact Us") {
			 new ContactUs();
		}
		else if(ae.getActionCommand() == "Book Ticket") {
				book2.mbook2();
		}
		else if(ae.getActionCommand() == "Cancel Ticket") {
			Cancel_tic.canc();
		}
		else if(ae.getActionCommand() == "Check Trains") {
			CheckTrains.check();
		}
		else if(ae.getActionCommand() == "PNR Enquiry") {
			Pnr_enq.pnr();
		}
		else if(ae.getActionCommand() == "Track your train") {
			Tracktrain.track();
		}
		else if(ae.getActionCommand() == "About us") {
			AboutUs.about();
		}
		else if(ae.getActionCommand() == "Alerts") {
			new Alerts();
		}
		else if(ae.getActionCommand() == "Meals") {
			new Meals();
		}
		
	}

	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new homepage();
				new Alerts();
			}
		});
	}
}

class BtHover extends MouseAdapter {

	public void mouseEntered(MouseEvent e) {
		((JButton) e.getSource()).setForeground(Color.decode("#ADD8E6"));
	}

	public void mouseExited(MouseEvent e) {
		((JButton) e.getSource()).setForeground(Color.white);
	}

}

class LbHover extends MouseAdapter {

	public void mouseEntered(MouseEvent e) {
		((JLabel) e.getSource()).setForeground(Color.decode("#ADD8E6"));
	}

	public void mouseExited(MouseEvent e) {
		((JLabel) e.getSource()).setForeground(Color.white);
	}

}

