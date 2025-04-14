import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class MainWindow extends JFrame{


    private JButton btnAddContact;
	private JButton btnSearchContact;
	private JButton btnDeleteContact;
	private JButton btnUpdateContact;
	private JButton btnViewContact;
	private JButton btnExit;
	
	private AddContact addContact;
	private ViewContact viewContact;
    private UpdateContact updatecontact;
    private SearchContact searchContact;
    private DeleteContact deleteContact;

    MainWindow() {
        
        setSize(1200,800);
		setTitle("Main Window");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1,2));

		JPanel mainPanel_1 = new JPanel(new GridLayout(1, 1));
		JLabel imgLabel = new JLabel();
		imgLabel.setSize(600, 800);
		ImageIcon img = new ImageIcon("3.png");
		Image img2 = img.getImage();
		Image newimg = img2.getScaledInstance(600, 800,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg2 = new ImageIcon(newimg);
		imgLabel.setIcon(newimg2);
		mainPanel_1.add(imgLabel);

		JPanel mainPanel_2 = new JPanel(new GridLayout(8, 1));
		mainPanel_2.setBackground(new Color(99, 149, 238));
		JLabel header = new JLabel("Home Page",SwingConstants.CENTER);
		header.setFont(new Font("1", Font.BOLD, 40));
		header.setForeground(Color.BLACK);
		mainPanel_2.add(header);

		JPanel panel1 = new JPanel(new GridBagLayout());
		panel1.setBackground(new Color(99, 149, 238));
		btnAddContact = new JButton("Add New Contact");
		btnAddContact.setFont(new Font("1", Font.BOLD, 20));
		btnAddContact.setPreferredSize(new Dimension(310, 35));
		btnAddContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				if(addContact == null){
					addContact = new AddContact();
				}
				addContact.setVisible(true);
			}
		});
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		panel1.add(btnAddContact, gbc);
		mainPanel_2.add(panel1);

		JPanel panel2 = new JPanel(new GridBagLayout());	
		panel2.setBackground(new Color(99, 149, 238));
		btnUpdateContact = new JButton("Update Contact");
		btnUpdateContact.setFont(new Font("1", Font.BOLD, 20));
		btnUpdateContact.setPreferredSize(new Dimension(310, 35));
		btnUpdateContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				if(updatecontact == null){
                    updatecontact = new UpdateContact();
                }
                updatecontact.setVisible(true);
			}
		});
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		panel2.add(btnUpdateContact, gbc);
		mainPanel_2.add(panel2);

		JPanel panel3 = new JPanel(new GridBagLayout());	
		panel3.setBackground(new Color(99, 149, 238));
		btnSearchContact = new JButton("Search Contact");
		btnSearchContact.setFont(new Font("1", Font.BOLD, 20));
		btnSearchContact.setPreferredSize(new Dimension(310, 35));
		btnSearchContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
                if(searchContact == null){
                    searchContact = new SearchContact();
                }
                searchContact.setVisible(true);
            }
		});
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		panel3.add(btnSearchContact, gbc);
		mainPanel_2.add(panel3);

		JPanel panel4 = new JPanel(new GridBagLayout());
		panel4.setBackground(new Color(99, 149, 238));
		btnDeleteContact = new JButton("Delete Contact");
		btnDeleteContact.setFont(new Font("1", Font.BOLD, 20));
		btnDeleteContact.setPreferredSize(new Dimension(310, 35));
		btnDeleteContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
                if(deleteContact == null){
                    deleteContact = new DeleteContact();
                }
                deleteContact.setVisible(true);
            }
		});
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		panel4.add(btnDeleteContact, gbc);
		mainPanel_2.add(panel4);

		JPanel panel5 = new JPanel(new GridBagLayout());
		panel5.setBackground(new Color(99, 149, 238));
		btnViewContact = new JButton("View Contact");
		btnViewContact.setFont(new Font("1", Font.BOLD, 20));
		btnViewContact.setPreferredSize(new Dimension(310, 35));
		btnViewContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
                if(viewContact == null){
                    viewContact = new ViewContact();
                }
                viewContact.setVisible(true);
            }
		});
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		panel5.add(btnViewContact, gbc);
		mainPanel_2.add(panel5);

		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(99, 149, 238));
		mainPanel_2.add(panel6);

		JPanel panel7 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel7.setBackground(new Color(99, 149, 238));
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("1", Font.BOLD, 20));
		btnExit.setPreferredSize(new Dimension(150, 35));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});
		panel7.add(btnExit);
		mainPanel_2.add(panel7);
		
        add("East",mainPanel_1);
		add("West",mainPanel_2);

		

    }
}