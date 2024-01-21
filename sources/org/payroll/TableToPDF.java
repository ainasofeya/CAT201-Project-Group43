package org.payroll;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;


public class TableToPDF {

    public void EmployeePDF ( Object[][] Newdata ) // Convert Jtable Employee into PDF file
    {

        try {
            Object[][] data = Newdata;
            String col[] = {"Employee ID", "First Name", "Last Name", "Email Address", "Position"};

            DefaultTableModel model = new DefaultTableModel(data, col);
            JTable table = new JTable(model); //create Jtable using the input Object [][] data ;

            int count = table.getRowCount();// get total table column
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream("Employee_List.PDF")); // specify path to download PDF
            document.open();
            float[] widths = {2, 3, 3, 5, 3}; // set the table column size porportion
            PdfPTable tab = new PdfPTable(widths);
            tab.setWidthPercentage(110); // set the table width
            tab.setSpacingBefore(10f); // add spacing before table
            tab.addCell("Employee ID");
            tab.addCell("First Name");
            tab.addCell("Last Name");
            tab.addCell("Email Address");
            tab.addCell("Position");

            for (int i = 0; i < count; i++) {

                Object obj1 = table.getValueAt(i, 0); //get the object value from Jtable
                Object obj2 = table.getValueAt(i, 1);
                Object obj3 = table.getValueAt(i, 2);
                Object obj4 = table.getValueAt(i, 3);
                Object obj5 = table.getValueAt(i, 4);

                String value1 = obj1.toString(); // convert the object value to string
                String value2 = obj2.toString();
                String value3 = obj3.toString();
                String value4 = obj4.toString();
                String value5 = obj5.toString();

                tab.addCell(value1); // add the string to cell in PDF file
                tab.addCell(value2);
                tab.addCell(value3);
                tab.addCell(value4);
                tab.addCell(value5);

            }
            document.add(tab); // add the table into pdf document
            document.close(); // close PDF document

        } catch(Exception e ){

        };

    }


    public void AttandancePDF( Object[][] newdata ){

        try {

            Object[][] data = newdata;
            String col[] ={"ID","Employee ID","Employee Full Name","Date","Clock In Time","Clock Out Time"};
            DefaultTableModel model = new DefaultTableModel(data, col);
            JTable table = new JTable(model);

            int count = table.getRowCount();
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream("Attendance_List.PDF"));
            document.open();
            float[] widths = {2, 2, 5, 3, 3 , 3};
            PdfPTable tab = new PdfPTable(widths);
            tab.setWidthPercentage(110);
            tab.setSpacingBefore(10f);
            tab.addCell("ID");
            tab.addCell("Employee ID");
            tab.addCell("Employee Full Name");
            tab.addCell("Date");
            tab.addCell("Clock In Time");
            tab.addCell("Clock Out Time");

            for (int i = 0; i < count; i++) {

                Object obj1 = table.getValueAt(i, 0);
                Object obj2 = table.getValueAt(i, 1);
                Object obj3 = table.getValueAt(i, 2);
                Object obj4 = table.getValueAt(i, 3);
                Object obj5 = table.getValueAt(i, 4);
                Object obj6 = table.getValueAt(i, 5);

                String value1 = obj1.toString();
                String value2 = obj2.toString();
                String value3 = obj3.toString();
                String value4 = obj4.toString();
                String value5 = obj5.toString();
                String value6 = obj5.toString();

                tab.addCell(value1);
                tab.addCell(value2);
                tab.addCell(value3);
                tab.addCell(value4);
                tab.addCell(value5);
                tab.addCell(value6);

            }
            document.add(tab);
            document.close();

        }catch (Exception e){

        };
    }

    public void SalaryPDF( Object[][] newdata ){

        try{

            Object[][] data = newdata;
            String col[] = {"Employee ID","Employee Full Name","Month","Year","Total Salary","Total Hours Worked"};
            DefaultTableModel model = new DefaultTableModel(data, col);
            JTable table = new JTable(model);

            int count = table.getRowCount();
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream("Salary_List.PDF"));
            document.open();
            float[] widths = {2, 5, 1, 1, 2 , 2};
            PdfPTable tab = new PdfPTable(widths);
            tab.setWidthPercentage(110);
            tab.setSpacingBefore(10f);
            tab.addCell("Employee ID");
            tab.addCell("Employee Full Name");
            tab.addCell("Month");
            tab.addCell("Year");
            tab.addCell("Total Salary");
            tab.addCell("Total Hours Worked");


            for (int i = 0; i < count; i++) {

                Object obj1 = table.getValueAt(i, 0);
                Object obj2 = table.getValueAt(i, 1);
                Object obj3 = table.getValueAt(i, 2);
                Object obj4 = table.getValueAt(i, 3);
                Object obj5 = table.getValueAt(i, 4);
                Object obj6 = table.getValueAt(i, 5);

                String value1 = obj1.toString();
                String value2 = obj2.toString();
                String value3 = obj3.toString();
                String value4 = obj4.toString();
                String value5 = obj5.toString();
                String value6 = obj6.toString();

                tab.addCell(value1);
                tab.addCell(value2);
                tab.addCell(value3);
                tab.addCell(value4);
                tab.addCell(value5);
                tab.addCell(value6);

            }
            document.add(tab);
            document.close();

        }catch(Exception e){

        };
    }

}
