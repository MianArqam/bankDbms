package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class transaction extends JFrame implements ActionListener {

    JButton deposit, withdrawal, ministatement, pinchange, fastcash, enquiry, exit;
    String pinnumber;

    transaction(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(1200, 1200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(150, 120, 900, 18);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 22));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(150, 160, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(320, 160, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(150, 200, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(320, 200, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(150, 240, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        enquiry = new JButton("Balance Enquiry");
        enquiry.setBounds(320, 240, 150, 30);
        enquiry.addActionListener(this);
        image.add(enquiry);

        exit = new JButton("Exit");
        exit.setBounds(320, 280, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        boolean balanceenquiry = false;
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawal) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == ministatement) {
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
            
        } else if (ae.getSource() == pinchange) {
            new PinChange(pinnumber).setVisible(true);
            
        } else if (ae.getSource() == enquiry) {
            new BalanceEnquiry(pinnumber).setVisible(true);
          
        }
    }

    public static void main(String args[]) {
        new transaction("");
    }
}
