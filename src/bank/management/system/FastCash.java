package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdrawal, ministatement, pinchange, fastcash, enquiry, exit;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(1200, 1200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(150, 120, 900, 18);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 22));
        image.add(text);

        deposit = new JButton("Rs 500");
        deposit.setBounds(150, 160, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Rs 1000");
        withdrawal.setBounds(320, 160, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Rs 2500");
        fastcash.setBounds(150, 200, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 5000");
        ministatement.setBounds(320, 200, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs 10000");
        pinchange.setBounds(150, 240, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        enquiry = new JButton("Rs 50000");
        enquiry.setBounds(320, 240, 150, 30);
        enquiry.addActionListener(this);
        image.add(enquiry);

        exit = new JButton("BACK");
        exit.setBounds(320, 280, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == exit) {
        setVisible(false);
        new transaction(pinnumber).setVisible(true);
    } else {
        String amount = ((JButton)ae.getSource()).getText().substring(3);
        Conn c = new Conn();
        try {
            java.sql.ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            int balance = 0;
            while(rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
            if (ae.getSource() != exit && balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }
            
            String query = "INSERT INTO bank VALUES ('" + pinnumber + "', NOW(), 'withdraw', '" + amount + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Successfully");
            
            
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
                            
        } catch (Exception e){
            System.out.println(e);
        }
    } 
}

    public static void main(String args[]) {
        new FastCash("");
    }
}
