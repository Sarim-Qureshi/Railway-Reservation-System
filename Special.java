package com.RRS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class Special {

	public static void spec() {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				JFrame jf = new JFrame("Indian Railways -- Special Trains");
				jf.setSize(1360, 730);
				jf.setLayout(null);
				jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				jf.getContentPane().setBackground(Color.decode("#01608C"));
				jf.setResizable(false);

				JLabel jlab = new JLabel();
				jlab.setText("SPECIAL TRAINS");
				jlab.setForeground(Color.white);
				jlab.setBounds(480, 40, 800, 50);
				jlab.addMouseListener(new LbHover());
				jlab.setFont(new Font("Bookman", Font.BOLD, 40));
				jf.add(jlab);

				Vector<String> train_no = new Vector<>();
				Vector<String> train_name = new Vector<>();
				Vector<String> train_source = new Vector<>();
				Vector<String> train_dest = new Vector<>();

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayrs", "root", "");
					Statement stmt = con.createStatement();
					String sql = "select * from traindet";
					ResultSet rs = stmt.executeQuery(sql);

					while (rs.next()) {
						train_no.addElement(rs.getString(1));
						train_name.addElement(rs.getString(2));
						train_source.addElement(rs.getString(3));
						train_dest.addElement(rs.getString(4));
					}

					con.close();
				} catch (Exception e) {
				}

				String[] head = { "Train Number", "Train Name", "Source", "Destination" };

				String[][] rows = new String[train_no.size()][4];

				for (int i = 0; i < train_name.size(); i++) {
					rows[i][0] = train_no.elementAt(i);
					rows[i][1] = train_name.elementAt(i);
					rows[i][2] = train_source.elementAt(i);
					rows[i][3] = train_dest.elementAt(i);
				}
				
				
				DefaultTableModel tableModel = new DefaultTableModel(rows, head) {
				    public boolean isCellEditable(int row, int column) {
				       return false;
				    }
				};


				JTable tlist = new JTable(rows, head);
				tlist.setRowHeight(35);
				tlist.setFont(new Font("Dialog", Font.PLAIN, 18));
				tlist.setRowHeight(30);

				tlist.setModel(tableModel);
				tlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

				
				JTableHeader hd = tlist.getTableHeader();
				hd.setFont(new Font("Dialog", Font.BOLD, 22));
				hd.setBackground(Color.decode("#0e2433"));
				hd.setForeground(Color.white);
				hd.setPreferredSize(new Dimension(960, 40));

				JScrollPane js = new JScrollPane();
				js.setBounds(175, 130, 960, 400);
				js.getViewport().add(tlist);
				jf.add(js);

				JButton book = new JButton("Book");
				book.setBounds(450, 600, 400, 40);
				book.setBackground(Color.decode("#006400"));
				book.setFont(new Font("Arial", Font.BOLD, 30));
				book.setForeground(Color.white);
				book.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				book.addMouseListener(new MouseAdapter() {

					public void mouseEntered(MouseEvent e) {
						book.setBackground(Color.decode("#DBE9F4"));
						book.setForeground(Color.decode("#0e2433"));
					}

					public void mouseExited(MouseEvent e) {
						book.setBackground(Color.decode("#006400"));
						book.setForeground(Color.white);
					}

				});
		
				JLabel in = new JLabel();
				in.setBounds(392,550,520,40);
				in.setBackground(Color.decode("#006400"));
				in.setFont(new Font("Consolas", Font.BOLD, 30));
				in.setForeground(Color.decode("#F3E5AB"));
				jf.add(in);
				book.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

					if(tlist.getSelectedRow()==-1) {
						in.setText("Select a train to book tickets");
						
						new java.util.Timer().schedule( 
						        new java.util.TimerTask() {
						            
						            public void run() {   
						            	in.setText("");	
						            }
						        }, 
						        1100 
						);
						
					}
					else
					{
						int col = 0;
						int row = tlist.getSelectedRow();
						SpecialTrain.setNumber(tlist.getModel().getValueAt(row, col).toString());
						 SpecialBook.specbook();
					    
					}
						
					}
				});

			    JLabel warn = new JLabel("Login to book tickets");
				warn.setBounds(410,600,500,40);
				warn.setBackground(Color.decode("#006400"));
				warn.setFont(new Font("Consolas", Font.BOLD, 40));
				warn.setForeground(Color.decode("#F3E5AB"));
				
				if (User.getUsername() != null)
				{
					jf.add(book);
				}
				else
				{
					jf.add(warn);
				}
				
				jf.setVisible(true);
			}
		});
	}
}
class SpecialTrain{
	private static String number="";

	public static String getNumber() {
		return number;
	}

	public static void setNumber(String number) {
		SpecialTrain.number = number;
	}
}