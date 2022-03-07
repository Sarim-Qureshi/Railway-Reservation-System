package com.RRS;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;

public class book2 {
	public static void mbook2() {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				JFrame train = new JFrame("Indian Railways -- Book tickets");
				train.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				train.setSize(1360, 730);
				train.setLayout(null);
				train.getContentPane().setBackground(Color.decode("#01608C"));
				train.setVisible(true);
				train.setResizable(false);

				JLabel head = new JLabel();
				head.setText("BOOK TICKETS");
				head.setForeground(Color.white);
				head.setBounds(495, 40, 800, 50);
				head.setFont(new Font("Bookman", Font.BOLD, 40));
				train.add(head);
				head.addMouseListener(new LbHover());
				
				JLabel jlab = new JLabel();
				jlab.setText("Double click on the row of selected train to book tickets");
				jlab.setForeground(Color.white);
				jlab.setBounds(270, 580, 800, 50);
				jlab.setFont(new Font("Monospaced", Font.BOLD, 22));
				train.add(jlab);
				jlab.addMouseListener(new LbHover());
				


				Vector<String> tno = new Vector<>();
				Vector<String> tname = new Vector<>();
				Vector<String> ttype = new Vector<>();
				Vector<String> tdept = new Vector<>();
				Vector<String> tarri = new Vector<>();

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
					Statement stmt = con.createStatement();

					ResultSet rs = stmt.executeQuery("select * from train_list");

					while (rs.next()) {
	                    	String t_no = rs.getString(1);
							String t_name = rs.getString(2);
							String t_type = rs.getString(3);
							String t_dept = rs.getString(4);
							String t_arri = rs.getString(5);

							tno.addElement(t_no);
							tname.addElement(t_name);
							ttype.addElement(t_type);
							tdept.addElement(t_dept);
							tarri.addElement(t_arri);
						}
					
					 con.close();
				}

				catch (Exception e) {
					System.out.println(e);
				}

				String[][] rows = new String[tno.size()][6];
				for (int k = 0; k < tno.size(); k++) {
					rows[k][0] = tno.elementAt(k);
					rows[k][1] = tname.elementAt(k);
					rows[k][2] = ttype.elementAt(k);
					rows[k][3] = tdept.elementAt(k);
					rows[k][4] = tarri.elementAt(k);
				}
				
				String[] column = { "Train number", "Train name", "Train type", "Departure time",
						"Arrival time" };

			    JTable tb = new JTable(rows, column);

				tb = new JTable(rows, column) {
					public boolean editCellAt(int row, int column, java.util.EventObject e) {
						return false;
					}
				};
			
				
				tb.setFont(new Font("Dialog", Font.PLAIN, 16));
				tb.setRowHeight(50);

				tb.getColumnModel().getColumn(0).setPreferredWidth(5);
				tb.getColumnModel().getColumn(1).setPreferredWidth(350);
				tb.getColumnModel().getColumn(2).setPreferredWidth(5);
				tb.getColumnModel().getColumn(3).setPreferredWidth(5);
				tb.getColumnModel().getColumn(4).setPreferredWidth(5);
			
				tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
							
						

				
				JTableHeader hd = tb.getTableHeader();
				hd.setFont(new Font("Dialog", Font.BOLD, 22));
				hd.setBackground(Color.decode("#0e2433"));
				hd.setForeground(Color.white);
				hd.setPreferredSize(new Dimension(960, 80));

				JScrollPane js = new JScrollPane();
				js.setBounds(100, 130, 1135, 400);
				js.getViewport().add(tb);
				train.add(js);
				
				if(User.getUsername()!=null) {
					jlab.setForeground(Color.white);
					jlab.setText("Double click on the row of selected train to book tickets");
					jlab.setBounds(270, 580, 800, 50);
					
					JTable t = tb;
					
					tb.addMouseListener(new MouseAdapter() {

						public void mouseClicked(MouseEvent me) {
	
							if (me.getClickCount() == 2) {
								int col = 0;
								int row = t.getSelectedRow();
								RegularTrain.setNumber(Integer.parseInt(t.getModel().getValueAt(row, col).toString()));
								book3.mbook3();
							}
						}

					});
				}
				else {
					
					jlab.setText("Login to book tickets");
					jlab.setBackground(Color.decode("#006400"));
					jlab.setFont(new Font("Consolas", Font.BOLD, 40));
					jlab.setForeground(Color.decode("#F3E5AB"));
					jlab.setBounds(400, 580, 800, 50);
				
				
				}

				
			}
		});

		
		}
		
	public static void main(String[] args) {
		book2.mbook2();

	}
}

class RegularTrain{
	
	private static int number = 0;

	public static int getNumber() {
		return number;
	}

	public static void setNumber(int number) {
		RegularTrain.number = number;
	}
}
