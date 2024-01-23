package org.payroll.CustomerManagement;

import org.payroll.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Function: Form for user to fill in to add a new employee

public class UpdateCustomerFrame extends JFrame{

    //Declare the element of the frame
    private JPanel UpdateCustomerPanel;
    private JLabel JLblTitle;
    private JComboBox JCBoxCusId;
    private JTextField JTFldCusFirstName;
    private JTextField JTFldCusEmail;
    private JButton JBtnCancel;
    private JButton JBtnUpdate;
    private JLabel JLblCusID;
    private JLabel JLblCusFirstName;
    private JLabel JLblEmail;
    private JLabel JLblServices;
    private JComboBox JCBoxCusServices;
    private JLabel JTFldCusLastName;
    private JTextField JTFldLastName;
    private JLabel JLblSession;
    private JTextField JTFlSession;

    //declaring ArrayList<String> variable to store the data from the database
    ArrayList<String> service = Main.dbManager.getListOfServiceName();
    ArrayList<String> id_cus = Main.dbManager.getCustomerID();


    public UpdateCustomerFrame() {
        //Set the size, layout and properties of the frame
        super();
        setTitle("SPA MANAGEMENT SYSTEM");
        setContentPane(UpdateCustomerPanel);
        setMinimumSize(new Dimension(550, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //Set the JComboBox based on the data from the databse
        JCBoxCusServices.setModel(new DefaultComboBoxModel(service.toArray(new String[service.size()])));
        JCBoxCusId.setModel(new DefaultComboBoxModel(id_cus.toArray(new String[id_cus.size()])));

        //Cancel button to call the previous function
        JBtnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                (new CustomerManagementFrame()).setVisible(true);
                dispose();
            }
        });

        //Update button action listener to update all the detail user put into database
        JBtnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id, Fname, Lname, email, service, session;
                service = JCBoxCusServices.getSelectedItem().toString();
                id = JCBoxCusId.getSelectedItem().toString();
                email = JTFldCusEmail.getText();
                Fname = JTFldCusFirstName.getText();
                Lname = JTFldLastName.getText();
                session = JTFlSession.getText();

                Main.dbManager.updateCustomer(id, Fname, Lname,email, service, session);

                JOptionPane.showMessageDialog(
                        null,
                        "Customer Updated",
                        "Customer Updated",
                        JOptionPane.INFORMATION_MESSAGE
                );

                (new CustomerManagementFrame()).setVisible(true);
                dispose();
            }
        });
    }
}

