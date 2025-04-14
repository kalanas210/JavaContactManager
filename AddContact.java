import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.Option;

import java.awt.*;
import java.awt.event.*;

import java.awt.*;

public class AddContact extends JFrame {

    AddContact() {

        setSize(600, 700);
        setTitle("Add Contact");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel header_panel = new JPanel(new GridLayout(1, 1));
        header_panel.setBackground(new Color(99, 149, 238));
        header_panel.setBorder(new EmptyBorder(20, 0, 20, 0));
        JLabel header = new JLabel("ADD CONTACT", SwingConstants.CENTER);
        header.setBackground(new Color(99, 149, 238));
        header.setFont(new Font("Arial", Font.BOLD, 40));
        header.setForeground(Color.BLACK);
        header_panel.add(header);
        add(header_panel, BorderLayout.NORTH);

        JPanel center_panel = new JPanel(new BorderLayout());
        JPanel contactid = new JPanel(new GridLayout(1,1));
        contactid.setPreferredSize(new Dimension(600, 100));
        contactid.setBackground(Color.WHITE);
        JLabel contact_label = new JLabel();
        contact_label.setText("Contact ID - "+ContactController.setContactID());
        contact_label.setFont(new Font("1", Font.BOLD, 20));
        contact_label.setBorder(new EmptyBorder(30, 30, 0, 0));
        contact_label.setForeground(Color.BLACK);
        contact_label.setHorizontalAlignment(JLabel.LEFT);
        contactid.add(contact_label);
        center_panel.add(contactid,BorderLayout.NORTH);

        JPanel a = new JPanel(new GridLayout(5, 1));
        a.setPreferredSize(new Dimension(250, 450));
        a.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Arial", 1, 20));
        nameLabel.setBorder(new EmptyBorder(0, 30, 15, 0));
        a.add(nameLabel);

        JLabel contactLabel = new JLabel("Contact Number");
        contactLabel.setFont(new Font("Arial", 1, 20));
        contactLabel.setBorder(new EmptyBorder(0, 30, 10, 0));
        a.add(contactLabel);

        JLabel Company = new JLabel("Company");
        Company.setFont(new Font("Arial", 1, 20));
        Company.setBorder(new EmptyBorder(0, 30, 10, 0));
        a.add(Company);

        JLabel salary=new JLabel("Salary");
        salary.setFont(new Font("Arial", 1, 20));
        salary.setBorder(new EmptyBorder(0, 30, 10, 0));
        a.add(salary);

        JLabel birthday = new JLabel("Birthday");
        birthday.setFont(new Font("Arial", 1, 20));
        birthday.setBorder(new EmptyBorder(0, 30, 10, 0));
        a.add(birthday);

        JPanel b = new JPanel(new GridLayout(5, 1));
        b.setBackground(Color.WHITE);
        JPanel d1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        d1.setBackground(Color.WHITE);

        JTextField name = new JTextField(16);
        name.setFont(new Font("Arial", 1, 20));
        name.setPreferredSize(new Dimension(20, 30));
        d1.add(name);
        b.add(d1);

        JPanel d2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        d2.setBackground(Color.WHITE);
        JTextField phone = new JTextField(16);
        phone.setFont(new Font("Arial", 1, 20));
        phone.setPreferredSize(new Dimension(20, 30));
        phone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){

                boolean isValidPhoneNumber = ContactController.isValidPhoneNumber(phone.getText());
                if(!isValidPhoneNumber){
					int option = JOptionPane.showConfirmDialog(null, "Invalid Phone Number...Do You Want to add New Phone Number ?", "Error", option=JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
					if(option==JOptionPane.YES_OPTION){
                        phone.setText("");
                    }else{
                        //birthdaytxt.setText("");
				        //company.setText("");
				        name.setText("");
				        phone.setText("");
				        //salarytxt.setText("");
						dispose();
					}
				}
            }
        });
        d2.add(phone);
        b.add(d2);

        JPanel d3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        d3.setBackground(Color.WHITE);
        JTextField company = new JTextField(16);
        company.setFont(new Font("Arial", 1, 20));
        company.setPreferredSize(new Dimension(20, 30));
        d3.add(company);
        b.add(d3);

        JPanel d4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        d4.setBackground(Color.WHITE);
        JTextField salarytxt = new JTextField(12);
        salarytxt.setFont(new Font("Arial", 1, 20));
        salarytxt.setPreferredSize(new Dimension(20, 30));
        salarytxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                boolean isValidSalary = ContactController.isValidSalary(Double. parseDouble(salarytxt.getText()));
                if(!isValidSalary){
                    int option = JOptionPane.showConfirmDialog(null, "Invalid Salary...Do You Want to add New Salary?", "Error", option=JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
                    if(option==JOptionPane.YES_OPTION){
                        salarytxt.setText("");
                    }else{
                        //birthdaytxt.setText("");
				        company.setText("");
				        name.setText("");
				        phone.setText("");
				        salarytxt.setText("");
                        dispose();
                    }

                }
            }
        });
        d4.add(salarytxt);
        b.add(d4);

        JPanel d5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        d5.setBackground(Color.WHITE);
        JTextField birthdaytxt = new JTextField(12);
        birthdaytxt.setFont(new Font("Arial", 1, 20));
        birthdaytxt.setPreferredSize(new Dimension(20, 30));
        birthdaytxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                boolean isValidBirthday = ContactController.isValidBirthday(birthdaytxt.getText());
                if (!isValidBirthday) {
                    int option = JOptionPane.showConfirmDialog(null,
                            "Invalid Birthday...Do You Want to add New Birthday ?",
                            "Error", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        birthdaytxt.setText("");
                    } else {
                        birthdaytxt.setText("");
				        company.setText("");
				        name.setText("");
				        phone.setText("");
				        salarytxt.setText("");
                        dispose();
                    }
                }
            }
                
        });
        d5.add(birthdaytxt);
        b.add(d5);

        center_panel.add(b);
        center_panel.add(a, BorderLayout.WEST);

        add(center_panel, BorderLayout.CENTER);

        JPanel btn_panel = new JPanel(new BorderLayout());
        btn_panel.setPreferredSize(new Dimension(600, 150));

       
        JPanel left_panel = new JPanel(new GridLayout(1, 1));
        left_panel.setPreferredSize(new Dimension(250, 200));
        left_panel.setBackground(Color.WHITE);
        btn_panel.add(left_panel, BorderLayout.WEST);

      
        JPanel right_panel = new JPanel(new GridLayout(2, 1));
        right_panel.setPreferredSize(new Dimension(350, 200));

        
        JPanel north_row = new JPanel(new GridLayout(1, 2));
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(Color.WHITE);
        JButton addcontact = new JButton("ADD Contact");
        addcontact.setFont(new Font("Arial", Font.BOLD, 18));
        addcontact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                boolean isValidPhoneNumber = ContactController.isValidPhoneNumber(phone.getText());
                boolean isValidSalary = ContactController.isValidSalary(Double. parseDouble(salarytxt.getText()));
                boolean isValidBirthday = ContactController.isValidBirthday(birthdaytxt.getText());

                if(!isValidPhoneNumber){
					int option = JOptionPane.showConfirmDialog(null, "Invalid Phone Number...Do You Want to add New Phone Number ?", "Error", option=JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
					if(option==JOptionPane.YES_OPTION){
                        phone.setText("");
                    }else{
                        birthdaytxt.setText("");
				        company.setText("");
				        name.setText("");
				        phone.setText("");
				        salarytxt.setText("");
						dispose();
					}
				}else if(!isValidSalary){
                    int option = JOptionPane.showConfirmDialog(null, "Invalid Salary...Do You Want to add New Salary?", "Error", option=JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
                    if(option==JOptionPane.YES_OPTION){
                        salarytxt.setText("");
                    }else{
                        birthdaytxt.setText("");
				        company.setText("");
				        name.setText("");
				        phone.setText("");
				        salarytxt.setText("");
                        dispose();
                    }

                }else if(!isValidBirthday){
					int option = JOptionPane.showConfirmDialog(null, "Invalid Birthday...Do You Want to add New Birthday ?", "Error", option=JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
					if(option==JOptionPane.YES_OPTION){
                        birthdaytxt.setText("");
                    }else{
                        birthdaytxt.setText("");
				        company.setText("");
				        name.setText("");
				        phone.setText("");
				        salarytxt.setText("");
						dispose();
					}
				}else{
					String id =ContactController.setContactID();
                    String name1 =name.getText();
                    String phone1 =phone.getText();
                    String company1 =company.getText();
					double salary1 =Double. parseDouble(salarytxt.getText());
                    String birthday1 =birthdaytxt.getText();
                    Contact customer=new Contact(id,name1,phone1,company1,salary1,birthday1);
					ContactController.addContacts(customer);
					ContactController.contactID++;
					
					int lastoption = JOptionPane.showConfirmDialog(null, "Contact Add Successfully...Do You Want to Add another Contact ?", "Success", lastoption=JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
					contact_label.setText("Contact ID - "+ContactController.setContactID());

                    if(lastoption==JOptionPane.YES_OPTION){
						birthdaytxt.setText("");
						name.setText("");
						phone.setText("");
						company.setText("");
						salarytxt.setText("");
                        birthdaytxt.setText("");
						dispose();
						setVisible(true);
					}else{
                        birthdaytxt.setText("");
				        company.setText("");
				        name.setText("");
				        phone.setText("");
				        salarytxt.setText("");
						dispose();
					}
				}		
			}
            
        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        p.add(addcontact, gbc);
        north_row.add(p);

        JPanel p2 = new JPanel(new GridBagLayout());
        p2.setBackground(Color.WHITE);
        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD, 18));
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                birthdaytxt.setText("");
				company.setText("");
				name.setText("");
				phone.setText("");
				salarytxt.setText("");
            }
        });
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        p2.add(cancel, gbc);
        north_row.add(p2);

        JPanel south_row = new JPanel(new FlowLayout(FlowLayout.LEADING));
        south_row.setBackground(Color.WHITE);
        JButton back = new JButton("Back To HomePage");
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setPreferredSize(new Dimension(300, 40));
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                birthdaytxt.setText("");
				name.setText("");
				phone.setText("");
				company.setText("");
				salarytxt.setText("");
                birthdaytxt.setText("");
                dispose();
               
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        south_row.add(back, gbc);

        right_panel.add(north_row);
        right_panel.add(south_row);

        btn_panel.add(right_panel, BorderLayout.CENTER);

        add(btn_panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    
}
