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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Acer
 */
public class Login extends JFrame  implements ActionListener, KeyListener, FocusListener{
    JButton ok,image;
    JLabel login_username, login_password, error;
    JTextField text_username;
    JPasswordField text_password;
    JPanel p1, p2, pf;
    
    Login(){
        setSize(600, 300);
        setTitle("Login");
        ok = new JButton("Login");  ok.addActionListener(this); ok.addKeyListener(this);
        image = new JButton();
        
        image.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon imgs = new ImageIcon(((new ImageIcon("D:\\Pic\\barber.jpg").getImage()
                .getScaledInstance(160, 180, Image.SCALE_SMOOTH))));
        image.setIcon(imgs);
        
        error = new JLabel(); error.setForeground(Color.RED);
        login_username = new JLabel(" Username "); 
        login_password = new JLabel(" Password ");
        
       text_username = new JTextField(15); text_username.addKeyListener(this);
       text_username.addFocusListener(this);
       text_password = new JPasswordField(15); text_password.setEchoChar('*');
       text_password.addFocusListener(this);
       
       Font f1 = new Font("TimesRoman", Font.BOLD, 18);
       Font f2 = new Font("TimesRoman", Font.PLAIN, 18);
       
       login_username.setFont(f1); login_username.setForeground(Color.darkGray);
       login_password.setFont(f1);  login_password.setForeground(Color.darkGray);
       text_username.setFont(f2);
       text_password.setFont(f2);
       ok.setFont(f1); ok.setForeground(Color.darkGray); ok.setBackground(Color.CYAN);
       
       p1 = new JPanel();
       p2 = new JPanel(new GridBagLayout());
       pf = new JPanel(new GridBagLayout());
       
       GridBagConstraints c = new GridBagConstraints();
       p1.add(image);
       
       c.insets = new Insets(20,0,0,0);
       c.gridx = 0; c.gridy = 0; p2.add(login_username, c);
       c.gridx = 1; c.gridy = 0; p2.add(text_username, c);
       c.gridx = 0; c.gridy = 1; p2.add(login_password, c);
       c.gridx = 1; c.gridy = 1; p2.add(text_password, c);
       c.gridx = 1; c.gridy = 2; c.anchor= GridBagConstraints.CENTER; p2.add(ok, c);
       c.gridx = 1; c.gridy = 3; p2.add(error, c);
       
       p1.setBackground(Color.white);
       p2.setBackground(Color.white);
       pf.setBackground(Color.white);
       pf.add(p1); pf.add(p2);
       
       this.getContentPane().add(pf);
       setVisible(true);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == ok){
            String user = text_username.getText();
            String pass = text_password.getText();
            if(user.equals("admin") && pass.equals("1234"))
            {
                this.setVisible(false);
                new SalonShop();
            }
            else 
            {
                error.setText("Username or Password is not correct");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        char ch;
        ch = ke.getKeyChar();
        if((ch < 'a' || ch > 'z') && (ch != '\b')){
            ke.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       if(ke.getSource() == ok){
           if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
               ok.doClick();
           }
       }
    }

    @Override
    public void keyReleased(KeyEvent ke) {  }

    @Override
    public void focusGained(FocusEvent fe) {
        if(fe.getSource().equals(text_username) || fe.getSource().equals(text_password)){
            error.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {   }
}
