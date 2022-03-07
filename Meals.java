package com.RRS;
 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.JTableHeader;


public class Meals {

	Meals()
	{
		JFrame jmeals=new JFrame("Indian Railways -- Meals");
	
		
		JLabel jtitle=new JLabel();
		jtitle.setText("List of Available Meals");
		jtitle.setBounds(165,30,500,50);
		jtitle.setFont(new Font("Consolas",Font.BOLD,30));
		jtitle.setForeground(Color.white);
		jtitle.addMouseListener(new LbHover());
		
	
		jmeals.add(jtitle);
		
		
		
		Vector<String> serialno = new Vector<>();
		Vector<String> mealitem = new Vector<>();
		Vector<String> mealprice = new Vector<>();
	
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from meal");
			
			while(rs.next())
			{
				serialno.add(rs.getString(1));
				mealitem.add(rs.getString(2));
				mealprice.add(rs.getString(3));
			}
			
			
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		
		
		String[][] jrow=new String[serialno.size()][3];
		
		
		for(int k=0;k<serialno.size();k++)
		{
			jrow[k][0]=serialno.elementAt(k);
			jrow[k][1]=mealitem.elementAt(k);
			jrow[k][2]=mealprice.elementAt(k);
		}
		
		String[] jcol= {"Meal number","Meal Items","Price(in rupees)"};
		
		JTable jtabmeal=new JTable(jrow,jcol);
			
	jtabmeal = new JTable(jrow,jcol) {
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
	      };
	    jtabmeal.setRowHeight(30);
	    jtabmeal.setFont(new Font("Dialog",Font.PLAIN,18));
		JScrollPane bjsp=new JScrollPane(jtabmeal);
		
		JTableHeader hd = jtabmeal.getTableHeader();
		hd.setFont(new Font("Dialog", Font.BOLD, 23));
//		hd.setBackground(Color.decode("#0e2433"));
		hd.setBackground(Color.decode("#bb4453"));
		hd.setForeground(Color.white);
		hd.setPreferredSize(new Dimension(960, 40));
		
		bjsp.setBounds(60,100,650,300);
		bjsp.getViewport().add(jtabmeal);
		
		jmeals.add(bjsp);
		
		
		JLabel jnote=new JLabel();
		jnote.setBounds(33,440,700,50);
		jnote.setText("Note: These meals are available for free in special trains");
		jnote.setForeground(Color.white);
		jnote.setFont(new Font("Consolas",Font.BOLD,22));
		jnote.addMouseListener(new LbHover());
		jmeals.add(jnote);
		
		
		jmeals.setLayout(null);
		jmeals.setSize(800,580);
		jmeals.getContentPane().setBackground(Color.decode("#333333"));
		jmeals.setResizable(false);
//		jmeals.setLocation(300,50);
		jmeals.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
	
           new Meals();
	}

}