/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salon_project;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Acer
 */
public class Customer {
    private String name;
    private double serviceCharges;
    private double productCharges;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date date = new Date();
    
    public Customer(String name, Date date, double serviceCharges, double productCharges){
        this.name = name;
        this.date = date;
        this.serviceCharges = serviceCharges;
        this.productCharges = productCharges;
        
    }
    public Customer(){  }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public String getDate(){
        return formatter.format(date);
    }
    public void setServiceCharges(double serviceCharges){
        this.serviceCharges = serviceCharges;
    }
    public double getServiceCharges(){
        return serviceCharges;
    }
    public void setProductCharges(double productCharges){
        this.productCharges = productCharges;
    }
    public double getProductCharges(){
        return productCharges;
    }
    
   public double getTotalExpense(){
       return getProductCharges() + getServiceCharges();
   }
   public String toString(){
       return " Customer Name:  " + name + 
               "\n MemberShip: Customer " + "\nDate: " + getDate() + "\n Service Charges " + 
               getServiceCharges() + "\nProduct Charges: " + getProductCharges();
   }
   public String printCustomerBill(){
       return toString() + "\n Total = " + getTotalExpense() + 
               "\n________________________________________________\n";
   }
}
