package org.payroll.Service;

import org.payroll.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Function: Form for user to fill in to add a new position
public class DeleteServices extends JFrame{

    //Declare the element of the frame
    private JPanel DeleteServicePanel;
    private JButton JBtnCancel;
    private JButton JBtnDelete;
    private JLabel JLblTitle;
    private JComboBox JCBoxService;
    private JLabel JLblNameServ;

    //declaring ArrayList<String> variable to store the data from the database
    ArrayList<String> services = Main.dbManager.getListOfServiceName();
    public DeleteServices() {
        //Set the size, layout and properties of the frame
        super();
        setTitle("SPA MANAGEMENT SYSTEM");
        setContentPane(DeleteServicePanel);
        setMinimumSize(new Dimension(550, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //Set the JComboBox based on the data from the databse
        JCBoxService.setModel(new DefaultComboBoxModel(services.toArray(new String[services.size()])));

        //Cancel button to call the previous function
        JBtnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new ServiceFrame()).setVisible(true);
                dispose();
            }
        });

        //Delete button action listener to delete the desired employee based on the
        // existing position in the database
        JBtnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String service = JCBoxService.getSelectedItem().toString();

                Main.dbManager.deleteService(service);

                JOptionPane.showMessageDialog(
                        null,
                        "Service Deleted",
                        "Service Deleted",
                        JOptionPane.INFORMATION_MESSAGE
                );
                (new ServiceFrame()).setVisible(true);
                dispose();
            }
        });
    }

}



