package org.payroll;

import org.payroll.Manager.ManagerLoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Function:To display user type menu for user to choose their account type
public class UserTypeFrame extends JFrame{

    //Declare the element of the frame
    private JPanel UserTypePanel;
    private JLabel JLblTitle;
    private JButton JBtnManager;
    private JButton JBtnCustomer;

    public UserTypeFrame(){

        //Set the size, layout and properties of the frame
        super();
        setTitle("SPA MANAGEMENT SYSTEM");
        setContentPane(UserTypePanel);
        setMinimumSize(new Dimension(700, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
/*
        //Action listener for button to call the EmployeeFrame function class
        JBtnCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                (new CustomerFrame()).setVisible(true);

            }
        });
*/
        //Action listener for button to call the ManagerLoginFrame function class
        JBtnManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                (new ManagerLoginFrame()).setVisible(true);
            }
        });
    }

}
