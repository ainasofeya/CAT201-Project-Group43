package org.payroll.Service;

import org.payroll.Main;
import org.payroll.Manager.DashboardFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Function: Display the Position menu frame for user to choose
// either add, delete the positions data and the table of list of positions that exist in database

public class ServiceFrame extends JFrame {

    //Declare the element of the frame
    private JPanel JPnlServiceMenu;
    private JButton JBtnDelete;
    private JButton JBtnAdd;
    private JButton JBtnReload;
    private JButton JBtnBack;
    private JSplitPane ServicePanel;
    private JTable JTblListService;
    private JScrollPane JSPnlService;
    private JLabel JLblTitle;

    public ServiceFrame() {
        //Set the size, layout and properties of the frame
        super();
        setTitle("SPA MANAGEMENT SYSTEM");
        setContentPane(ServicePanel);
        setMinimumSize(new Dimension(700, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //declaring Object[][] variable to store the data from the database
        Object[][] data = Main.dbManager.getService();
        //Set the JTable based on the data from the database
        String col[] = {"Service ID","Service","Price","Description"};
        JTblListService.setModel(new DefaultTableModel(data,col));

        //Back action listener to call back the previous frame
        JBtnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                (new DashboardFrame()).setVisible(true);
                dispose();
            }
        });

        //Reload the table to get the position table
        JBtnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                (new ServiceFrame()).setVisible(true);
                dispose();
            }
        });

        //Declaring all the action listener for every button in the frame to call other function
        // displaying a form for user to fill in order to change the position data
        JBtnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                (new AddServices()).setVisible(true);
                dispose();
            }
        });

        JBtnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                (new DeleteServices()).setVisible(true);
                dispose();
            }
        });
    }

}

