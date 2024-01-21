package org.payroll.Service;


import org.payroll.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Function: Form for user to fill in to add a new position
public class AddServices extends JFrame{

    //Declare the element of the frame
    private JPanel AddServicesPanel;
    private JTextField JTFldNameServ;
    private JTextField JTFldPrice;
    private JTextField JTFldSession;
    private JButton JBtnCancel;
    private JButton JBtnAdd;
    private JLabel JLblTitle;
    private JLabel JLblNameServ;
    private JLabel JLblPrice;
    private JLabel JLblOvertimeRate;

    public AddServices() {
        //Set the size, layout and properties of the frame
        super();
        setTitle("SPA MANAGEMENT SYSTEM");
        setContentPane(AddServicesPanel);
        setMinimumSize(new Dimension(550, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        JBtnAdd.addActionListener(new ActionListener() {
            //Add button action listener to add all the detail user put into database
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JTFldNameServ.getText();
                int price = Integer.parseInt(JTFldPrice.getText());
                String desc = JTFldSession.getText();

                Main.dbManager.newService(name, price, desc);

                JOptionPane.showMessageDialog(
                        null,
                        "Service Added",
                        "Service Added",
                        JOptionPane.INFORMATION_MESSAGE
                );

                setVisible(false);
                (new ServiceFrame()).setVisible(true);
                dispose();
            }
        });

        //Cancel button to call the previous function
        JBtnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                (new ServiceFrame()).setVisible(true);
                dispose();
            }
        });
    }
}

