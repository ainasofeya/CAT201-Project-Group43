package org.payroll.CustomerManagement;

import org.payroll.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddCustomerFrame extends JFrame{

    //Declare the element of the frame
    private JPanel AddCustomerPanel;
    private JLabel JTFldTitle;
    private JTextField JTFldCusID;
    private JTextField JTFldCusFirstName;
    private JTextField JTFldCusEmail;
    private JComboBox JCBoxService;
    private JButton JBtnAdd;
    private JButton JBtnCancel;
    private JLabel JLblCusID;
    private JLabel JLbldCusFirstName;
    private JLabel JLblCusEmail;
    private JLabel JLblCusService;
    private JLabel JLblLastName;
    private JTextField JTFldLastName;
    private JLabel JLblSession;
    private JTextField JTFlSession;

    //declaring ArrayList<String> variable to store the data from the database
    ArrayList<String> services = Main.dbManager.getListOfServiceName();


    public AddCustomerFrame() {
        //Set the size, layout and properties of the frame
        super();
        setTitle("SPA MANAGEMENT SYSTEM");
        setContentPane(AddCustomerPanel);
        setMinimumSize(new Dimension(550, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //Set the JComboBox based on the data from the database
        JCBoxService.setModel(new DefaultComboBoxModel(services.toArray(new String[services.size()])));

        //Cancel button to call the previous function
        JBtnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new CustomerManagementFrame()).setVisible(true);
                dispose();
            }
        });

        //Add button action listener to add all the detail user put into database
        JBtnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id, Fname, Lname, email, service, session;
                service = JCBoxService.getSelectedItem().toString();
                id = JTFldCusID.getText();
                email = JTFldCusEmail.getText();
                Fname = JTFldCusFirstName.getText();
                Lname = JTFldLastName.getText();
                session = JTFlSession.getText();

                Main.dbManager.createCustomer(id, Fname, Lname, email, service, session);

                JOptionPane.showMessageDialog(
                        null,
                        "New Customer Added",
                        "New Customer Added",
                        JOptionPane.INFORMATION_MESSAGE
                );
                (new CustomerManagementFrame()).setVisible(true);
                dispose();
            }
        });
    }

}
