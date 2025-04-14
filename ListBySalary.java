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
public class ListBySalary extends JFrame {

    ListBySalary(){

        setSize(800, 500);
        setTitle("LIST CONTACTS BY SALARY");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel header_panel = new JPanel(new GridLayout(1, 1));
        header_panel.setBackground(new Color(99, 149, 238));
        header_panel.setBorder(new EmptyBorder(20, 0, 20, 0));
        JLabel header = new JLabel("LIST CONTACTS BY SALARY", SwingConstants.CENTER);
        header.setBackground(new Color(99, 149, 238));
        header.setFont(new Font("Arial", Font.BOLD, 40));
        header.setForeground(Color.BLACK);
        header_panel.add(header);
        add(header_panel, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridBagLayout());
        center.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        center.add(ContactController.sortingBySalary(),gbc);
        add(center, BorderLayout.CENTER);

        JPanel main_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        main_panel.setBackground(Color.WHITE);
        main_panel.setPreferredSize(new Dimension(800, 100));
        JButton backButton = new JButton("Back To Home");
        backButton.setFont(new Font("Arial", Font.BOLD,20));
        backButton.setPreferredSize(new Dimension(180, 35));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        main_panel.add(backButton);
        add(main_panel, BorderLayout.SOUTH);
    }
    
}
