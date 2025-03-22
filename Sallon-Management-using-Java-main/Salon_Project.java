/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salon_project;

//import com.sun.istack.internal.logging.Logger;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author Acer
 */
public class Salon_Project {
    public static void main(String[] args) {
        new Login();
    }
}

class SalonShop extends JFrame implements ActionListener{
     JToolBar tb;
     JButton cus_add, show_bill, login_back, history, sp1,sp2,sp3;
     JPanel p, pf;
    
     Customer cus = new Customer();
     Date d = new Date();
     Font f = new Font("TimesRoman", Font.BOLD, 25);
      Font f1 = new Font("TimesRoman", Font.BOLD, 18);
       Font f2 = new Font("TimesRoman", Font.PLAIN, 18);
       
       public SalonShop(){
           super.setLayout(new BorderLayout());
           tb = new JToolBar();
           
           cus_add = new JButton();  cus_add.addActionListener(this);
           show_bill = new JButton(); show_bill.addActionListener(this);
           history = new JButton();  history.addActionListener(this);
           login_back = new JButton(); login_back.addActionListener(this);
           
          cus_add.setBorder(BorderFactory.createEmptyBorder()); 
          ImageIcon imgc = new ImageIcon(((new ImageIcon("D:\\Pic\\addcustomerr.png").getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
        cus_add.setIcon(imgc);
        
        show_bill.setBorder(BorderFactory.createEmptyBorder());
         ImageIcon imgc2 = new ImageIcon(((new ImageIcon("D:\\Pic\\bill.jpeg").getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
        show_bill.setIcon(imgc2);
        
        history.setBorder(BorderFactory.createEmptyBorder());
          ImageIcon imgc3 = new ImageIcon(((new ImageIcon("D:\\Pic\\His.png").getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
        history.setIcon(imgc3);
        
        login_back.setBorder(BorderFactory.createEmptyBorder());
          ImageIcon imgc4 = new ImageIcon(((new ImageIcon("D:\\Pic\\llog.png").getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
        login_back.setIcon(imgc4);
        
        p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 0, 0, 10);
        c.gridx = 0; c.gridy = 0; p.add(cus_add, c);
        c.gridx = 1; c.gridy = 0; p.add(show_bill, c);
        c.gridx = 2; c.gridy = 0; p.add(history, c);
        c.gridx = 3; c.gridy = 0; p.add(login_back, c);
        
        p.setBackground(Color.WHITE);
        tb.setBackground(Color.WHITE);
        tb.add(p);
        
        //Final Panel 
        pf = new JPanel(); pf.setBackground(Color.WHITE);
        this.getContentPane().add(pf);
        
        super.add(tb, BorderLayout.NORTH);
        setTitle(" Salon Shop ");
        super.setSize(750, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
       }
       
       CustomerPanel cp;
       BillPanel bp;
       HistoryPanel hp;
       
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource().equals(cus_add)){
           pf.removeAll();
           pf.repaint();
           pf.revalidate();
           
           try{
               cp = new CustomerPanel(cus);
               pf.add(cp, BorderLayout.CENTER);
               pf.repaint();
               pf.revalidate();
           }catch(Exception e){
               
           }
       }
       else if(ae.getSource().equals(show_bill)){
           pf.removeAll();
           pf.repaint();
           pf.revalidate();
           
           try{
               bp = new BillPanel(cus);
               pf.add(bp, BorderLayout.CENTER);
               pf.repaint();
               pf.revalidate();
           }catch(Exception e){
               
           }
       }
       else if(ae.getSource().equals(history)){
           pf.removeAll();
           pf.repaint();
           pf.revalidate();
           
           try{
               hp = new HistoryPanel();
               pf.add(hp, BorderLayout.CENTER);
               pf.repaint();
               pf.revalidate();
           }catch(Exception ex){
               System.out.println(ex.getMessage());
           }
       }
       else if(ae.getSource().equals(login_back)){
           this.setVisible(false);
           new Login();
       }
    }
    
}
