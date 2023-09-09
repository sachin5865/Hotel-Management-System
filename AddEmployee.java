package hotel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname, tfemail, tfphone, tfage,tfsalary,tfaadhar;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox cbjob;
    
    AddEmployee(){
        setLayout(null);
        
        JLabel lb1name = new JLabel("Name");
        lb1name.setBounds(60, 30, 120, 30);
        lb1name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lb1name);
        
         tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);
        
        JLabel lb1age = new JLabel("AGE");
        lb1age.setBounds(60, 80, 120, 30);
        lb1age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lb1age);
        
         tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);
        
        JLabel lb1gender = new JLabel("GENDER");
        lb1gender.setBounds(60, 130, 120, 30);
        lb1gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lb1gender);
        
         rbmale = new JRadioButton("Male");
            rbmale.setBackground(Color.WHITE);
            rbmale.setBounds(200, 130, 70, 30);
            rbmale.setFont(new Font("Tahoma", Font.PLAIN,14));
            add(rbmale);
        
             rbfemale = new JRadioButton("Female");
            rbfemale.setBackground(Color.WHITE);
            rbfemale.setBounds(280, 130, 70, 30);
            rbmale.setFont(new Font("Tahoma", Font.PLAIN,14));
            add(rbfemale);
            
            ButtonGroup bg= new ButtonGroup();
            bg.add(rbmale);
            bg.add(rbfemale);
            
            JLabel lb1job = new JLabel("JOB");
        lb1job.setBounds(60, 180, 120, 30);
        lb1job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lb1job);
        
         String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
          cbjob = new JComboBox(str);
         cbjob.setBounds(200, 180, 150, 30);
         add(cbjob);
         
         JLabel lb1salary = new JLabel("SALARY");
        lb1salary.setBounds(60, 230, 120, 30);
        lb1salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lb1salary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);
        
        JLabel lb1phone = new JLabel("PHONE");
        lb1phone.setBounds(60, 280, 120, 30);
        lb1phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lb1phone);
        
         tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);
        
        JLabel lb1email = new JLabel("EMAIL");
        lb1email.setBounds(60, 330, 120, 30);
        lb1email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lb1email);
        
         tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);
        
        JLabel lb1aadhar = new JLabel("ADHAR");
        lb1aadhar.setBounds(60, 380, 120, 30);
        lb1aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lb1aadhar);
        
         tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 380, 150, 30);
        add(tfaadhar);
        
         submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,430, 150,30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 60,450,370);
        add(image);
        
        
        
         
         
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,300 ,850, 540);
        cbjob.setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();
        
        String gender = null;
        
        if (name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be empty" );
            return;
        }
        
        if(rbmale.isSelected()){
            gender = "Male";
        }else if (rbfemale.isSelected()){
            gender = "Female";
        }
        
        String job = (String) cbjob.getSelectedItem();
        
        try{
            Conn conn = new Conn();
                String query = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+email+"', '"+aadhar+"')";
                
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Employee added successfully");
                setVisible(false);
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new AddEmployee();
    }
    
}
