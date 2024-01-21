package org.payroll.CustomerManagement;

import org.payroll.Manager.DashboardFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Function: Display the Employee Management menu frame for user to choose
// either add, delete or update the employee data

public class CustomerManagementFrame  extends JFrame {

    //Declare the element of the frame
    private JPanel CusManagementPanel;
    private JLabel JlblTitle;
    private JButton JBtnAddCus;
    private JButton JBtnDeleteCus;
    private JButton JBtnUpdateCustomer;
    private JButton JBtnBack;

    public CustomerManagementFrame() {
        //Set the size, layout and properties of the frame
        super();
        setTitle("SPA MANAGEMENT SYSTEM");
        setContentPane(CusManagementPanel);
        setMinimumSize(new Dimension(900, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //Declaring all the action listener for every button in the frame to call other function
        // displaying a form for user to fill in order to change the employee data
        JBtnAddCus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new AddCustomerFrame()).setVisible(true);
                dispose();
            }
        });

        JBtnDeleteCus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new DeleteCustomerFrame()).setVisible(true);
                dispose();
            }
        });

        JBtnUpdateCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new UpdateCustomerFrame()).setVisible(true);
                dispose();
            }
        });

        //Back action listener to call back the previous frame
        JBtnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                (new DashboardFrame()).setVisible(true);
                dispose();
            }
        });
    }

}
