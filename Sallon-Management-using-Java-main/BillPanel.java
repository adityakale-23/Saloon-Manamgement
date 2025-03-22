/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salon_project;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Acer
 */
public class BillPanel extends JPanel{
    Date d = new Date();
     Font f = new Font("TimesRoman", Font.BOLD, 25);
      Font f1 = new Font("TimesRoman", Font.BOLD, 18);
       Font f2 = new Font("TimesRoman", Font.PLAIN, 18);
       
       public BillPanel(Customer cus){
           try{
               if(cus.getName().equals("")){
                   
               }
               else{
                   JTextArea print_Bill = new JTextArea(cus.printCustomerBill());
                   print_Bill.setFont(f2); print_Bill.setEditable(false);
                   this.setBackground(Color.WHITE);
                   this.add(print_Bill);
               }
           }catch(NullPointerException e){
               JLabel noFound = new JLabel(" No Customer Found !! "); 
               noFound.setFont(f2);
               this.add(noFound);
           }
       }
}
