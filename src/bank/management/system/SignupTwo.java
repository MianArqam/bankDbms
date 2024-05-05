package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField pan, CNIC;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    String formno;
    
    SignupTwo(String formno) {
        this.formno= formno;
        setLayout(null);
        
        setTitle ("NEW ACCOUNT APPLICATION FORM - PAGE 2"); 
        
        JLabel additionalDetails = new JLabel("Page NO 1: Additional Details" );
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
     
        JLabel name = new JLabel("Religion:" );
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
         religion = new JComboBox (valReligion) ;
religion.setBounds (300, 140, 400, 30) ;
add (religion) ;
     
     
        JLabel fname = new JLabel("Category:" );
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
     
       String valcategory[] = {"General", "ОВС", "SC", "ST", "Other"};
       category = new JComboBox (valcategory) ;
category.setBounds (300, 190, 100, 30); 
category.setBackground (Color.WHITE) ;
add (category);
        JLabel dob = new JLabel("Income:" );
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
     
        String incomecategory[] = {"Null", "< 1,50,000", "< 2,50,0000", "< 5,00,000", "Upto 10,00,000"};
         income = new JComboBox (incomecategory); 
        income. setBounds (300, 240, 400, 30); 
        income. setBackground (Color. WHITE) ;
        add (income) ;

       JLabel gender = new JLabel ("Educational:") ;
       gender.setFont(new Font ("Raleway", Font. BOLD, 20)) ; 
       gender. setBounds (100, 290, 200, 30);
       add (gender) ;   
        
        
        JLabel email = new JLabel("Qualification:" );
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,315,200,30);
        add(email);
     String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Others"};
 education = new JComboBox (educationValues) ;
education.setBounds (300, 385, 400, 30) ; 
education.setBackground (Color. WHITE) ;
add (education) ;
        
     
        JLabel marital = new JLabel("Ocupation:" );
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,400,30);
        add(marital); 
     String occupationValues[] = {"Salaried", "Self-Employed", "Bussiness", "Student.","Retired","Other"};
 occupation = new JComboBox (occupationValues) ;
occupation.setBounds (300, 315, 400, 30) ;
occupation. setBackground (Color. WHITE) ;
add (occupation);
     
        JLabel address = new JLabel("Pan Number:" );
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address); 
     
        pan = new JTextField();
       pan.setFont (new Font ("Raleway", Font. BOLD, 14)) ; 
       pan.setBounds (300, 440, 400, 30);
       add (pan) ;

        JLabel city = new JLabel("CNIC:" );
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
     
       CNIC= new JTextField() ;
       CNIC.setFont (new Font ("Raleway", Font. BOLD, 14)) ;
       CNIC.setBounds (300, 490, 400, 30) ;
       add (CNIC) ;
     
        JLabel district = new JLabel("Senior Citizen:" );
        district.setFont(new Font("Raleway", Font.BOLD, 20));
        district.setBounds(100 ,540 ,200,30);                        
        add(district);
        
        syes = new JRadioButton ("Yes") ;
       syes.setBounds (300, 540, 100, 30) ; 
       syes.setBackground (Color. WHITE) ;
       add (syes) ;

       sno = new JRadioButton ("No") ;
      sno.setBounds (450, 540, 100, 30); 
      sno.setBackground (Color. WHITE) ;
      add (sno);

      JLabel pincode = new JLabel (" ") ;
      pincode.setFont (new Font("Raleway", Font.BOLD, 20)); 
      pincode. setBounds (100, 590, 200, 30) ; 
      add (pincode);
    
        eyes = new JRadioButton ("Yes") ;
       eyes.setBounds (300, 590, 100, 30) ; 
       eyes.setBackground (Color. WHITE) ;
       add (eyes) ;

       eno = new JRadioButton ("No") ;
      eno.setBounds (450, 590, 100, 30); 
      eno.setBackground (Color. WHITE) ;
      add (eno);
      
      ButtonGroup emaritalgroup = new ButtonGroup () ;
emaritalgroup.add(syes) ;
emaritalgroup. add(sno) ;
     
        JLabel zipCode = new JLabel("Existing Account:" );
        zipCode.setFont(new Font("Raleway", Font.BOLD, 20));
        zipCode.setBounds(100 ,590 ,200,30);
        add(zipCode);
     
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
     
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sreligion = (String) religion.getSelectedItem(); 
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation= (String) education.getSelectedItem();
        String sOcupation= (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()){
            seniorcitizen = "Yes";
        } else if (sno.isSelected()){
            seniorcitizen = "No";
        }
        
       
        String existingaccount = null;
        if (eyes.isSelected()){
            existingaccount = "Yes";
        } else if (eno.isSelected()){
            existingaccount = "No";
        } 
        
        String span=pan.getText();
        String sCNIC = CNIC.getText();
        
        try {
          
                Conn c = new Conn();
                String query  = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+sOcupation+"', '"+span+"', '"+sCNIC+"', '"+seniorcitizen+"', '"+existingaccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signup3(formno).setVisible(true);
        } catch (Exception ae){
            System.out.println(ae);
        }
        
 
    }
    
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
