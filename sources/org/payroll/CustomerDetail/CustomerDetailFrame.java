package org.payroll.CustomerDetail;

import org.payroll.Main;
import org.payroll.TableToPDF;
import org.payroll.Manager.DashboardFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Function: Display and download the employee personal detail table list

public class CustomerDetailFrame extends JFrame{

    //Declare the element of the frame
    private JPanel CustomerDetailPanel;
    private JButton JBtnReload;
    private JTable JTblCustomerDetail;
    private JSplitPane RootPanel;
    private JButton JBtnDownload;
    private JButton JBtnBack;
    private JScrollPane JSPnlCusDetail;
    private JLabel JLblTitle;

    public CustomerDetailFrame() {
        //Set the size, layout and properties of the frame
        super();
        setTitle("SPA MANAGEMENT SYSTEM");
        setContentPane(RootPanel);
        setMinimumSize(new Dimension(750, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //declaring Object[][] variable to store the data from the database
        Object[][] data = Main.dbManager.getCustomer();
        //Set the JTable based on the data from the chosen date in the database
        String col[] = {"Customer ID", "First Name", "Last Name", "Email Address", "Service", "Session"};
        JTblCustomerDetail.setModel(new DefaultTableModel(data,col));

        //Reload the table
        JBtnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                (new CustomerDetailFrame()).setVisible(true);
                dispose();
            }
        });

        //Add action listener to call back the previous frame
        JBtnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                (new DashboardFrame()).setVisible(true);
                dispose();
            }
        });

        //Calling the function to convert the data into pdf
        JBtnDownload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TableToPDF().EmployeePDF(data);
                JOptionPane.showMessageDialog(
                        null,
                        "Download Successful",
                        "Download Successful",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }

}

