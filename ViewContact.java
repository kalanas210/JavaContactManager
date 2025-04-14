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
public class ViewContact extends JFrame {

    ViewContact(){

        setSize(600, 600);
        setTitle("Add Contact");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel header_panel = new JPanel(new GridLayout(1, 1));
        header_panel.setBackground(new Color(99, 149, 238));
        header_panel.setBorder(new EmptyBorder(20, 0, 20, 0));
        JLabel header = new JLabel("VIEW CONTACT", SwingConstants.CENTER);
        header.setBackground(new Color(99, 149, 238));
        header.setFont(new Font("Arial", Font.BOLD, 40));
        header.setForeground(Color.BLACK);
        header_panel.add(header);
        add(header_panel, BorderLayout.NORTH);

        JPanel main = new JPanel(new GridLayout(4, 1));

        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBackground(Color.WHITE);
        JButton button1 = new JButton("List By Names");
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        button1.setPreferredSize(new Dimension(310, 35));
        button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				
				ListByName listbyname = new ListByName();
                listbyname.setVisible(true);
				
			}
		});
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel1.add(button1, gbc);
        main.add(panel1);

        JPanel panel2 = new JPanel(new GridBagLayout());
        panel2.setBackground(Color.WHITE);
        JButton button2 = new JButton("List By Salary");
        button2.setFont(new Font("Arial", Font.BOLD, 20));
        button2.setPreferredSize(new Dimension(310, 35));
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ListBySalary listbysalary = new ListBySalary();
                listbysalary.setVisible(true);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel2.add(button2, gbc);
        main.add(panel2);

        JPanel panel3 = new JPanel(new GridBagLayout());
        panel3.setBackground(Color.WHITE);
        JButton button3 = new JButton("List By Birthday");
        button3.setFont(new Font("Arial", Font.BOLD, 20));
        button3.setPreferredSize(new Dimension(310, 35));
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ListByBirthday listbybirthday = new ListByBirthday();
                listbybirthday.setVisible(true);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel3.add(button3, gbc);
        main.add(panel3);

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel4.setBackground(Color.WHITE);
        JButton button4 = new JButton("Cancel");
        button4.setFont(new Font("Arial", Font.BOLD, 20));
        button4.setPreferredSize(new Dimension(160, 35));
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel4.add(button4);
        main.add(panel4);

        add(main);
        

    }

}
