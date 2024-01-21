package org.payroll.CustomerManagement;

import org.payroll.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Function: Form for user to fill in to delete a new employee

public class DeleteCustomerFrame extends JFrame{

    //Declare the element of the frame
    private JPanel DeleteCustomerPanel;
    private JLabel JLblTitle;
    private JTextField JTFldCusID;
    private JButton JBtnCancel;
    private JButton JBtnDelete;
    private JLabel JLblCusID;
    private JComboBox JCBoxDltCus;


    ArrayList<String> customers = Main.dbManager.getCustomerID();
    public DeleteCustomerFrame() {
        //Set the size, layout and properties of the frame
        super();
        setTitle("SPA MANAGEMENT SYSTEM");
        setContentPane(DeleteCustomerPanel);
        setMinimumSize(new Dimension(450, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        JCBoxDltCus.setModel(new DefaultComboBoxModel(customers.toArray(new String[customers.size()])));
        //Cancel button to call the previous function
        JBtnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new CustomerManagementFrame()).setVisible(true);
                dispose();
            }
        });

        //Delete button action listener to delete the desired employee based on employee id
        JBtnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Id = (String) JCBoxDltCus.getSelectedItem();
                if (Main.dbManager.existsCustomerID(Id)) {

                    Main.dbManager.deleteCustomer(Id);

                    JOptionPane.showMessageDialog(
                            null,
                            "Customer Deleted",
                            "Customer Deleted",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
                else{
                    JOptionPane.showMessageDialog(
                            null,
                            "Delete Customer Failed\nCannot confirm the customer ID",
                            "Delete customer failed",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
                (new CustomerManagementFrame()).setVisible(true);
                dispose();
            }
        });
    }
}

