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

public class SearchContact extends JFrame {

    private JTextField id ;
    private JTextField name ;
    private JTextField phone ;
    private JTextField salarytxt ;
    private JTextField company;
    private JTextField birthdaytxt;

    SearchContact() {

        setSize(600, 790);
        setTitle("Search Contact");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel header_panel = new JPanel(new GridLayout(1, 1));
        header_panel.setBackground(new Color(99, 149, 238));
        header_panel.setBorder(new EmptyBorder(20, 0, 20, 0));
        JLabel header = new JLabel("SEARCH CONTACT", SwingConstants.CENTER);
        header.setBackground(new Color(99, 149, 238));
        header.setFont(new Font("Arial", Font.BOLD, 40));
        header.setForeground(Color.BLACK);
        header_panel.add(header);
        add(header_panel, BorderLayout.NORTH);

        JPanel center_panel = new JPanel(new BorderLayout());
        
        JPanel contactid = new JPanel(new BorderLayout());
        contactid.setPreferredSize(new Dimension(600, 100));
        contactid.setBackground(Color.BLUE);

        JPanel contact_panel_left = new JPanel(new GridBagLayout());
        contact_panel_left.setPreferredSize(new Dimension(350, 100));
        contact_panel_left.setBackground(Color.WHITE);
        JTextField searchtxt = new JTextField(16);
        searchtxt.setFont(new Font("Arial", 1, 20));
        GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
        contact_panel_left.add(searchtxt,gbc);
        contactid.add(contact_panel_left,BorderLayout.WEST);

        JPanel contact_panel_right = new JPanel(new GridBagLayout());
        contact_panel_right.setPreferredSize(new Dimension(250, 100));
        contact_panel_right.setBackground(Color.WHITE);
        JButton contact_btn = new JButton("Search");
        contact_btn.setPreferredSize(new Dimension(150, 30));
        contact_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){

                String contact_id = searchtxt.getText();
                ContactList contactList = DBConnection.getInstance().getContactList();
                int index = ContactController.searchContact(contact_id);
                if(contact_id.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a Name or Phone Number");
                    searchtxt.setText("");
                }else if(index!=-1){
                    id.setText(contactList.get(index).getId());
					name.setText(contactList.get(index).getName());
                    //System.out.println(contactList.get(index).getPhoneNumber());
					phone.setText(contactList.get(index).getPhoneNumber());
					company.setText(contactList.get(index).getCompanyName());
					salarytxt.setText(Double.toString(contactList.get(index).getSalary()));
					birthdaytxt.setText(contactList.get(index).getBirthday());

                }else{
                    int option=JOptionPane.showConfirmDialog(null, "Contact not found...Do You Want to Search new Contact", "Error", option=JOptionPane.YES_NO_OPTION);
					if(option==JOptionPane.YES_OPTION){
                        id.setText("");
                        searchtxt.setText("");
                        birthdaytxt.setText("");
				        name.setText("");
				        phone.setText("");
				        company.setText("");
				        salarytxt.setText("");
                        birthdaytxt.setText("");
					}else{
						dispose();
					}
                }

            }
        });
        contact_btn.setFont(new Font("Arial", 1, 20));
        gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
        contact_panel_right.add(contact_btn,gbc);
        contactid.add(contact_panel_right,BorderLayout.EAST);
        
        center_panel.add(contactid,BorderLayout.NORTH);

        JPanel a = new JPanel(new GridLayout(6, 1));
        a.setPreferredSize(new Dimension(250, 540));
        a.setBackground(Color.WHITE);

        JLabel idLabel = new JLabel("Contact ID");
        idLabel.setFont(new Font("Arial", 1, 20));
        idLabel.setBorder(new EmptyBorder(0, 30, 25, 0));
        a.add(idLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Arial", 1, 20));
        nameLabel.setBorder(new EmptyBorder(0, 30, 25, 0));
        a.add(nameLabel);

        JLabel contactLabel = new JLabel("Contact Number");
        contactLabel.setFont(new Font("Arial", 1, 20));
        contactLabel.setBorder(new EmptyBorder(0, 30, 25, 0));
        a.add(contactLabel);

        JLabel Company = new JLabel("Company");
        Company.setFont(new Font("Arial", 1, 20));
        Company.setBorder(new EmptyBorder(0, 30, 25, 0));
        a.add(Company);

        JLabel salary=new JLabel("Salary");
        salary.setFont(new Font("Arial", 1, 20));
        salary.setBorder(new EmptyBorder(0, 30, 25, 0));
        a.add(salary);

        JLabel birthday = new JLabel("Birthday");
        birthday.setFont(new Font("Arial", 1, 20));
        birthday.setBorder(new EmptyBorder(0, 30, 25, 0));
        a.add(birthday);

        JPanel b = new JPanel(new GridLayout(6, 1));
        b.setBackground(Color.WHITE);
        
        JPanel d = new JPanel(new FlowLayout(FlowLayout.LEFT));
        d.setBackground(Color.WHITE);
        id = new JTextField(16);
        id.setFont(new Font("Arial", 1, 20));
        id.setPreferredSize(new Dimension(20, 30));
        d.add(id);
        b.add(d);

        JPanel d1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        d1.setBackground(Color.WHITE);
        name = new JTextField(16);
        name.setFont(new Font("Arial", 1, 20));
        name.setPreferredSize(new Dimension(20, 30));
        d1.add(name);
        b.add(d1);

        JPanel d2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        d2.setBackground(Color.WHITE);
        phone = new JTextField(16);
        phone.setFont(new Font("Arial", 1, 20));
        phone.setPreferredSize(new Dimension(20, 30));
        d2.add(phone);
        b.add(d2);

        JPanel d3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        d3.setBackground(Color.WHITE);
        company = new JTextField(16);
        company.setFont(new Font("Arial", 1, 20));
        company.setPreferredSize(new Dimension(20, 30));
        d3.add(company);
        b.add(d3);

        JPanel d4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        d4.setBackground(Color.WHITE);
        salarytxt = new JTextField(12);
        salarytxt.setFont(new Font("Arial", 1, 20));
        salarytxt.setPreferredSize(new Dimension(20, 30));
        d4.add(salarytxt);
        b.add(d4);

        JPanel d5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        d5.setBackground(Color.WHITE);
        birthdaytxt = new JTextField(12);
        birthdaytxt.setFont(new Font("Arial", 1, 20));
        birthdaytxt.setPreferredSize(new Dimension(20, 30));
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
        north_row.setBackground(Color.WHITE);
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(Color.WHITE);
        JButton addcontact = new JButton("Search Contact");
        addcontact.setFont(new Font("Arial", Font.BOLD, 18));
        

        JPanel p2 = new JPanel(new GridBagLayout());
        p2.setBackground(Color.WHITE);
        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc = new GridBagConstraints();
        
        JPanel south_row = new JPanel(new FlowLayout(FlowLayout.LEADING));
        south_row.setBackground(Color.WHITE);
        JButton back = new JButton("Back To HomePage");
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setPreferredSize(new Dimension(300, 40));
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                id.setText("");
                searchtxt.setText("");
                birthdaytxt.setText("");
				name.setText("");
				phone.setText("");
				company.setText("");
				salarytxt.setText("");
                birthdaytxt.setText("");
                dispose();
               
            }
        });
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        south_row.add(back, gbc);

        right_panel.add(south_row);
        right_panel.add(north_row);

        btn_panel.add(right_panel, BorderLayout.CENTER);

        add(btn_panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    
}
