package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(1200, 1200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 15));
         text.setBounds(150, 120, 900, 18);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(140, 200, 320, 20);
        image.add(amount);
        
        withdraw = new JButton("Withdrawl");
        withdraw.setBounds(320, 240, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(320, 280, 150, 30);
        back.addActionListener(this);
        image.add(back);

        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }
    
   public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == withdraw) {
        String number = amount.getText();
        if (number.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
        } else { 
            try {
                Conn conn = new Conn();
                String query = "INSERT INTO bank VALUES ('" + pinnumber + "', NOW(), 'withdraw', '" + number + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"RS"+number+ "withdraw successful");
                setVisible(false);
                new transaction(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    } else if (ae.getSource() == back) {
        setVisible(false);
        new transaction(pinnumber).setVisible(true);
    }
}

    
    public static void main(String args[]){
        new Withdrawl("");
    }
    
}
