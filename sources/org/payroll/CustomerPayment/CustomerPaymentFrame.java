package org.payroll.CustomerPayment;

import org.payroll.Main;
import org.payroll.Manager.DashboardFrame;
import org.payroll.TableToPDF;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerPaymentFrame extends JFrame {
    private JButton JBtnBack;
    private JButton JBtnDownload;
    private JLabel JLblTitle;
    private JPanel CustomerPayPanel;
    private JScrollPane JSPnCusPayment;
    private JSplitPane CustomerPaymentPanel;
    private JTable JTblReport;


    public CustomerPaymentFrame() {
        super();
        setTitle("SPA MANAGEMENT SYSTEM");
        setContentPane(CustomerPaymentPanel);
        setMinimumSize(new Dimension(750, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);

        // Modify the column names and data array to include Total Payment
        Object[][] data = Main.dbManager.getCustomerPayment();
        String col[] = { "Customer ID", "Customer First Name", "Customer Last Name", "Service", "Total Payment"};
        JTblReport.setModel(new DefaultTableModel(data, col));

        JBtnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                (new DashboardFrame()).setVisible(true);
                dispose();
            }
        });
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
};

