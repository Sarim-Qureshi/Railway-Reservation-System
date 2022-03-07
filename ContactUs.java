package com.RRS;
import javax.swing.*;
import java.awt.*;


import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ContactUs 
{

    ContactUs()
    {
    	
    	JLabel l1=new JLabel();
    	JLabel l2=new JLabel();
    	JLabel l3=new JLabel();
    	JLabel l4=new JLabel();
    	JLabel l5=new JLabel();
    	JLabel l6=new JLabel();
    	JLabel l7=new JLabel();
    	
    	JFrame jp=new JFrame();
        jp= new JFrame("Indian Railways -- Contact Us");
        Font ft=new Font("Bookman",Font.BOLD,33);
        l1 = new JLabel("<html><h1>CONTACT US</h1></html>");
        l1 = new JLabel("CONTACT US");
        l1.setFont(ft);
        l1.setForeground(Color.red);
        l1.setBounds(290,10,1500,100);
        jp.add(l1);
        
        
        
        
        Font f1=new Font("Bookman",Font.BOLD,20);
        l2 = new JLabel("FOR QUERIES REGARDING US ");
        l2.setFont(f1);
        l2.setForeground(Color.red);
        l2.setBounds(30,30,1000,200);
        jp.add(l2);
        
        String s = "<html>Dear commuters if you have question regarding us, our website or if you wish to know more<br>about us, then please contact us on given Toll Free numbers<br><br>XXX-XXX-XXXX<br>Mon-Sat 10am to 7pm</html>";
        Font f2=new Font("Arial",Font.BOLD,15);
        l3 = new JLabel(s);
        l3.setForeground(Color.white);
        l3.addMouseListener(new LbHover());
        l3.setBounds(30,90,1000,200);
        l3.setFont(f2);
        jp.add(l3);

       Font f3 = new Font("Bookman",Font.BOLD,17);
        l4 = new JLabel("BOOKING AND CANCELLATION");
        l4.setFont(f3);
        l4.setForeground(Color.red);
        l4.setBounds(30,170,1000,200);
        jp.add(l4);
        
        String s2 = "<html>For question regarding the booking and cancelation of trains or if you need more <br >information about our routes then please contact us on the given number<br><br>XYZ-YYXX-XZZ<br>Mon-Fri 9 am to 6 pm</html>";
        Font f4=new Font("Arial",Font.BOLD,15);
        l5 = new JLabel(s2);
        l5.setFont(f4);
        l5.setForeground(Color.WHITE);
        l5.setBounds(30,230,1000,200);
        l5.addMouseListener(new LbHover());
        jp.add(l5);
        
        Font f5 = new Font("Bookman",Font.BOLD,17);
        l6 = new JLabel("HELPLINE NUMBER");
        l6.setFont(f5);
        l6.setForeground(Color.red);
        l6.setBounds(30,310,1000,200);
        jp.add(l6);
        
        String s5 = "<html>This is the emergency help line number incase of requiring immediate assistance<br>Call on the given Toll Free number <br><br>XWY-XXXZ</html>";
        Font f6=new Font("Bookman",Font.BOLD,15);
        l5 = new JLabel(s5);
        l5.setFont(f6);
        l5.setForeground(Color.WHITE);
        l5.setBounds(30,370,1000,200);
        l5.addMouseListener(new LbHover());
        jp.add(l5);
        
        
        
        jp.setLayout(null);
        jp.getContentPane().setBackground(Color.decode("#01608C"));
        jp.getContentPane().setBackground(Color.decode("#333333"));
        jp.setExtendedState(JFrame.MAXIMIZED_HORIZ);
    
        jp.setResizable(false);
        jp.setVisible(true);
        jp.setBounds(300,50,860,600);
        jp.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
   
    }
    
    public static void main(String args[])
    {
        new ContactUs();
    }
}


//public class ContactUs 
//{   
//    public static void contact()
//    {
//    	
//	SwingUtilities.invokeLater(new Runnable() {
//			
//		public void run() {
//				
//		JFrame j;
//		JLabel l1,l2,l3,l4,l5,l6;
//        j= new JFrame("Indian Railways -- Contact Us");
//        Font ft=new Font("Times New Roman",Font.BOLD,25);
//        l1 = new JLabel("CONTACT US");
//        l1.setFont(ft);
//        l1.setForeground(Color.white);
//        l1.setBounds(250,10,1500,100);
//        j.add(l1);
//        
//        
//        Font f1=new Font("Times New Roman",Font.BOLD,20);
//        l2 = new JLabel("FOR QUERIES REGARDING US ");
//        l2.setFont(f1);
//        l2.setForeground(Color.WHITE);
//        l2.setBounds(40,30,1000,200);
//        j.add(l2);
//        
//        String s = "<html>Dear commuters if you have question regarding us, our website or if you wish to know more<br>about us,then please contact us on given toll Free numbers<br><br>XXX-XXX-XXXX<br>Mon-Sat 10am to 7pm</html>";
//        Font f2=new Font("Times New Roman",Font.BOLD,16);
//        l3 = new JLabel(s);
//        l3.setForeground(Color.WHITE);
//        l3.setBounds(40,90,1000,200);
//        l3.setFont(f2);
//        j.add(l3);
//
//       Font f3 = new Font("Times New Roman",Font.BOLD,20);
//        l4 = new JLabel("BOOKING AND CANCELATION");
//        l4.setFont(f3);
//        l4.setForeground(Color.WHITE);
//        l4.setBounds(40,170,1000,200);
//        j.add(l4);
//        
//        String s2 = "<html>For question regarding the booking and cancelation of trains or if you need more information<br >about our riutes the please contact us on the given number<br><br>XYZ-YYXX-XZZ<br>Mon-Fri 9 am to 6 pm</html>";
//        Font f4=new Font("Times New Roman",Font.BOLD,16);
//        l5 = new JLabel(s2);
//        l5.setFont(f4);
//        l5.setForeground(Color.WHITE);
//        l5.setBounds(40,230,1000,200);
//        j.add(l5);
//        
//        Font f5 = new Font("Times New Roman",Font.BOLD,20);
//        l6 = new JLabel("HELPLINE NUMBER");
//        l6.setFont(f5);
//        l6.setForeground(Color.WHITE);
//        l6.setBounds(40,310,1000,200);
//        j.add(l6);
//        
//        String s5 = "<html>This is the emergency help line number incase of requiring immediate assistance <br>Please call the given below number <br>Call on the given Toll Free number <br ><br>XWY-XXXZ</html>";
//        Font f6=new Font("Times New Roman",Font.BOLD,16);
//        l5 = new JLabel(s5);
//        l5.setFont(f6);
//        l5.setForeground(Color.WHITE);
//        l5.setBounds(40,400,1000,200);
//        j.add(l5);
//        
//        
//        
//        
//        j.setLayout(null);
//        j.getContentPane().setBackground(Color.decode("#333333"));
//        j.setExtendedState(JFrame.MAXIMIZED_HORIZ);
//        j.setResizable(false);
//        j.setVisible(true);
//        j.setBounds(0,30,710,660);
//        j.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//			}
//	});
//    }
//    
//    public static void main(String args[])
//    {
//         ContactUs.contact();
//    }
//}