package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;

  BalanceEnquiry (String pinnumber){
    this.pinnumber = pinnumber;
    setLayout(null);
    
ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource ("icons/atm.png")) ;
Image i2 = i1.getImage().getScaledInstance(1200, 1200, Image.SCALE_DEFAULT) ;
ImageIcon i3 = new ImageIcon (i2) ;
JLabel image = new JLabel (i3);
image.setBounds (0, 0, 900, 900) ;
add(image);
back = new JButton("Back");
back.setBounds(300,320,150,30);
back.addActionListener(this);
image.add(back);

Conn c = new Conn();
        int balance = 0;
        try {
            java.sql.ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            
            while(rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            } catch (Exception e){
                    System.out.println(e);
                    }
            JLabel text = new JLabel("your curent account balance is Rs" + balance);
            text.setForeground(Color.WHITE);
            text.setFont(new Font("Raleway", Font.BOLD, 18));
            text.setBounds(135, 120, 400, 30);
            image.add(text);
            
JButton back = new JButton();

setSize (900, 900); 
setLocation(300, 0);
setUndecorated(true);
setVisible (true);
}
public void actionPerformed (ActionEvent ae){
setVisible (false);
new transaction(pinnumber).setVisible(true);
}
public static void main(String args[]) {
new BalanceEnquiry("");
        }
}