/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salon_project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Acer
 */
public class HistoryPanel extends JPanel{
    JPanel customerdb, ScroolForPane;
    JLabel namedb, datedb, servicedb, productdb, name, serv_charges, date, product_charges, total,
            dbTotal, endline;
    Connection con;
    
    Font f1 = new Font("TimesRoman", Font.BOLD, 18);
       Font f2 = new Font("TimesRoman", Font.PLAIN, 18);
       
       HistoryPanel() {
           this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
           this.setPreferredSize(new Dimension(735, 450));
           
           ScroolForPane = new JPanel();
           ScroolForPane.setLayout(new BoxLayout(ScroolForPane, BoxLayout.PAGE_AXIS));
           
           //Step 1: Add Drivers
                   try{
                       Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                   }catch(ClassNotFoundException e){
                       System.out.println(" Drivers not found");
                   }
                   
         //Step 2: Established Connection Database
                   try{
                       con=DriverManager.getConnection
                       ("jdbc:ucanaccess://E:\\SaloonDatabase.accdb");
                   }catch(SQLException e){
                       System.out.println("Database is not found");
                   }
                  
         //Step 3: Statement SQL
         String query = "Select* from Customer";
         try{
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query);
             
         //Step 4: Process result
             while(rs.next()){
                 customerdb = new JPanel();
                 customerdb.setLayout( new GridBagLayout());
                 customerdb.setPreferredSize(new Dimension(200, 150));
                 customerdb.setBackground(Color.WHITE);
                 
                 name = new JLabel(" Name " ); name.setFont(f1);
                 date = new JLabel(" Date "); date.setFont(f1);
                 serv_charges = new JLabel(" Service Charges "); serv_charges.setFont(f1);
                 product_charges = new JLabel(" Product Charges "); product_charges.setFont(f1);
                 total = new JLabel(" Total "); total.setFont(f1);
                 endline = new JLabel(" ************************"); endline.setFont(f1);
                 
                 namedb = new JLabel(); namedb.setFont(f2);
                 datedb = new JLabel(); namedb.setFont(f2);
                 servicedb = new JLabel(); namedb.setFont(f2);
                 productdb = new JLabel(); namedb.setFont(f2);
                 dbTotal = new JLabel(); namedb.setFont(f2);
                 
                 namedb.setText(rs.getObject("Name").toString());
                 datedb.setText(rs.getObject("Date").toString());
                 servicedb.setText(rs.getObject("ServiceCharges").toString());
                 productdb.setText(rs.getObject("ProductCharges").toString());
                 Double t;
                 t = Double.parseDouble(rs.getObject("ServiceCharges").toString()) + 
                         Double.parseDouble(rs.getObject("ProductCharges").toString());
                 dbTotal.setText("" + t);
                 
                 GridBagConstraints c = new GridBagConstraints();
                 c.anchor = GridBagConstraints.LINE_START;
                 c.insets = new Insets(5,20,0,20);
                 c.gridx = 0;  c.gridy = 0; customerdb.add(name, c);
                 c.gridx = 1;  c.gridy = 0; customerdb.add(namedb, c);
                 c.gridx = 0;  c.gridy = 1; customerdb.add(date, c);
                 c.gridx = 1;  c.gridy = 1; customerdb.add(datedb, c);
                 c.gridx = 0;  c.gridy = 2; customerdb.add(serv_charges , c);
                 c.gridx = 1;  c.gridy = 2; customerdb.add(servicedb, c);
                 c.gridx = 0;  c.gridy = 3; customerdb.add(product_charges, c);
                 c.gridx = 1;  c.gridy = 3; customerdb.add(productdb, c);
                  c.gridx = 0;  c.gridy = 4; customerdb.add(total, c);
                  c.gridx = 1;  c.gridy = 4; customerdb.add(dbTotal, c);
                  
                  ScroolForPane.setBackground(Color.WHITE);
                  ScroolForPane.add(customerdb);
                  ScroolForPane.add(endline);
             }
                  //step 5 connection and result process close
                  rs.close();  con.close();
                 
             
             
         }catch(SQLException e){
             e.printStackTrace();
             System.out.println("Query incorrect ");
         }
         
         JScrollPane scrollPane = new JScrollPane(ScroolForPane);
         scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
         scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         
         this.add(scrollPane);
         this.setBackground(Color.WHITE);
           
           
       }
}
