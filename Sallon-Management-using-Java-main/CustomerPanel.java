/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salon_project;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Acer
 */
public class CustomerPanel extends JPanel{
    JButton add, sp1, sp2, sp3;
    JTextField t_name, t_servCharges;
    JLabel cus_name, serv_charges, select_style, detail, date;
    JRadioButton rb1, rb2, rb3;
    ButtonGroup g1;
    JPanel p2;
    
    Connection con;
    Date d = new Date();
     Font f = new Font("TimesRoman", Font.BOLD, 25);
      Font f1 = new Font("TimesRoman", Font.BOLD, 18);
       Font f2 = new Font("TimesRoman", Font.PLAIN, 18);
       
       public CustomerPanel(Customer cus){
           detail = new JLabel(" Customer Details ");
           date= new JLabel();  date.setText(cus.getDate());
           cus_name = new JLabel(" Customer Name ");
           t_name = new JTextField(15);
           serv_charges = new JLabel(" Service Charges ");
           t_servCharges = new JTextField(8);
           select_style = new JLabel(" Select Hair Style ");
           rb1 = new JRadioButton(" 150 "); rb1.setBackground(Color.WHITE);
            rb2 = new JRadioButton(" 100 "); rb2.setBackground(Color.WHITE);
            rb3 = new JRadioButton(" 70 "); rb3.setBackground(Color.WHITE);
            g1 = new ButtonGroup();
            g1.add(rb1); g1.add(rb2); g1.add(rb3);
            add = new JButton(" Add ");
            //ActionListener in add button
            add.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent ae) {
                   cus.setName(t_name.getText());
                   cus.setProductCharges(Double.parseDouble(t_servCharges.getText()));
                   
                   //Checked Selected Radio Button
                   String radioB_select="";
                   if(rb1.isSelected()){ radioB_select= rb1.getText(); }
                   if(rb2.isSelected()){ radioB_select= rb2.getText(); }
                   if(rb3.isSelected()){ radioB_select= rb3.getText(); }
                   cus.setServiceCharges(Double.parseDouble(radioB_select));
                   
                   //Step 1: Add Drivers
                   try{
                       Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                   }catch(ClassNotFoundException e){
                       System.out.println(" Drivers not found");
                   }
                   
                   //Step 2: Established Connection Database
                   try{
                       con=DriverManager.getConnection
                       ("jdbc:ucanaccess://D:\\saloon database.accdb");
                   }catch(SQLException e){
                       System.out.println("Database is not found");
                   }
                   //Step 3: Statement SQL
                   String query = "insert into Customer(Name, Date, ServiceCharges, ProductCharges)" +
                           "values(?,?,?,?)";
                   
                   //Step 4: Insert Data
                   try{
                       PreparedStatement pst = con.prepareStatement(query);
                       pst.setString(1, cus.getName());
                       pst.setString(2, cus.getDate());
                       pst.setDouble(3, cus.getServiceCharges());
                       pst.setDouble(4, cus.getProductCharges());
                       pst.executeUpdate();
                       
                       //Step 5 Connection Close
                       con.close();
                       
                   }catch (SQLException ex){
                       System.out.println(ex.getMessage() + "paramettrrr");
                   }
                   
                   t_name.setText("");
                   t_servCharges.setText("");
                   g1.clearSelection();
                  
               }
                
            });
            
            
            sp1 = new JButton(); sp2 = new JButton(); sp3 = new JButton();
            
            //Hair Icon Add
            sp1.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon im1 = new ImageIcon(((new ImageIcon("D:\\Pic\\H6.jfif").getImage()
                .getScaledInstance(45, 45, Image.SCALE_SMOOTH))));
        sp1.setIcon(im1);
        
        sp2.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon im2 = new ImageIcon(((new ImageIcon("D:\\Pic\\H5.jfif").getImage()
                .getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
        sp2.setIcon(im2);
           
        sp3.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon im3 = new ImageIcon(((new ImageIcon("D:\\Pic\\H6.jfif").getImage()
                .getScaledInstance(45, 45, Image.SCALE_SMOOTH))));
        sp3.setIcon(im3);
        
        detail.setFont(f);
        date.setFont(f1);
        cus_name.setFont(f1);
        serv_charges.setFont(f1);
        select_style.setFont(f1);
        add.setFont(f1);  add.setBackground(Color.CYAN);
        t_name.setFont(f1);
        t_servCharges.setFont(f1);
        
        this.setLayout(new GridBagLayout());
        p2 = new JPanel();
        
        p2.add(rb1); p2.add(sp1);
        p2.add(rb2); p2.add(sp2);
        p2.add(rb3); p2.add(sp3);
        p2.setBackground(Color.white);
        
        GridBagConstraints c1 = new GridBagConstraints();
        c1.insets = new Insets(20,0,0,0);
        c1.anchor = GridBagConstraints.LINE_START;
        c1.gridx = 0; c1.gridy = 0;  this.add(detail, c1);
        c1.gridx = 0; c1.gridy = 1;  this.add(date, c1);
        c1.gridx = 0; c1.gridy = 2;  this.add(cus_name, c1);
        c1.gridx = 1; c1.gridy = 2;   this.add(t_name, c1);
        c1.gridx = 0; c1.gridy = 3; this.add(select_style, c1);
       c1.gridx = 1; c1.gridy = 3;  this.add(p2, c1);
       c1.gridx = 0; c1.gridy = 4;  this.add(serv_charges, c1);
       c1.gridx = 1; c1.gridy = 4;  this.add(t_servCharges, c1);
        c1.gridx = 1; c1.gridy = 5;  this.add(add, c1);
        this.setBackground(Color.WHITE);
       }
       
}
