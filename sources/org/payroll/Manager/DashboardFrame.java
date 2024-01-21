package org.payroll.Manager;

import org.payroll.CustomerDetail.CustomerDetailFrame;
import org.payroll.CustomerManagement.CustomerManagementFrame;
import org.payroll.CustomerPayment.CustomerPaymentFrame;
import org.payroll.Service.ServiceFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Function: Display the Dashboard menu frame for user to choose
// the activity frame that they want to do
public class DashboardFrame extends JFrame{

    //Declare the element of the frame
    private JPanel DashboardPanel;
    private JLabel JLblDashboard;
    private JButton JBtnCusManage;
    private JButton JBtnCusDetail;
    private JButton JBtnCustPayment;
    private JMenuBar JMBDashboard;
    //private JButton JBtnProfile;
    //private JButton JBtnHelp;
    private JButton JBtnQuit;
    private JButton JBtnService;

    public DashboardFrame() {
        //Set the size, layout and properties of the frame
        super();
        setTitle("SPA MANAGEMENT SYSTEM");
        setContentPane(DashboardPanel);
        setMinimumSize(new Dimension(900, 680));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //Declaring all the action listener for every button in the frame to call other function
        JBtnCusManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                (new CustomerManagementFrame()).setVisible(true);
            }
        });

        JBtnCusDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                (new CustomerDetailFrame()).setVisible(true);
            }
        });

        JBtnCustPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                (new CustomerPaymentFrame()).setVisible(true);
            }
        });

        JBtnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new ManagerLoginFrame()).setVisible(true);
                dispose();
            }
        });

        JBtnService.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new ServiceFrame()).setVisible(true);
                dispose();
            }
        });
    }
}

