package org.payroll;

import java.util.ArrayList;
import java.io.*;
import java.sql.*;

public class DatabaseManager {

    String ConnectionString;

    Connection conn;
    Statement curs;

    public DatabaseManager(String db) {
        ConnectionString = "jdbc:sqlite:" + db;

        if (!((new File(db)).exists())) {
            connectToDatabase();
            initNewDatabase();

        } else {
            connectToDatabase();
        }
    }

    void connectToDatabase() {
        try {
            //Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(ConnectionString);
            curs = conn.createStatement();
            curs.setQueryTimeout(30);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // create table to hold data login id , customer service , detail and payment
    void initNewDatabase() {
        connectToDatabase();

        try {
            curs.executeUpdate(
                    "CREATE TABLE login_ids (id INTEGER NOT NULL PRIMARY KEY, username STRING NOT NULL, password STRING NOT NULL)"
            );
            curs.executeUpdate(
                    "INSERT INTO login_ids VALUES(null, \"admin\", \"1\")"
            );
            curs.executeUpdate(
                    "CREATE TABLE service(" +
                            "id INTEGER NOT NULL PRIMARY KEY," +
                            "serv_name VARCHAR(30) NOT NULL," +
                            "price INTEGER NOT NULL," +
                            "desc VARCHAR(200) NOT NULL)"

            );
            curs.executeUpdate(
                    "CREATE TABLE customers(" +
                            "id VARCHAR(30) NOT NULL PRIMARY KEY," +
                            "first_name VARCHAR(30) NOT NULL," +
                            "last_name VARCHAR(30) NOT NULL," +
                            "email VARCHAR(30) NOT NULL," +
                            "serv_name VARCHAR(30) NOT NULL," +
                            "session VARCHAR(30) NOT NULL)"

            );

            curs.executeUpdate(
                    "CREATE TABLE cus_payment(" +
                            "payment_id INTEGER NOT NULL PRIMARY KEY," +
                            "cus_id VARCHAR(30) NOT NULL," +
                            "cus_name VARCHAR(30) NOT NULL," +
                            "price_per_service DOUBLE  NOT NULL," +
                            "total_session DOUBLE NOT NULL)"
            );
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    //verify if password and username is correct for manager
    public Boolean verifyLoginId(String username, String password) {
        try {
            return curs.executeQuery(
                    "SELECT * FROM login_ids WHERE username=\"" + username + "\" AND password=\"" + password + "\""
            ).next();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public void newService(String serv_name, int price, String desc) {

        try {
            curs.executeUpdate("INSERT INTO service VALUES(" +
                    "null," +
                    "\"" + serv_name + "\"," +
                    Integer.toString(price) + "," +
                    "'" + desc + "'" +
                    ")"


            );
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


    //delete service and employee with that position
    public void deleteService(String serv_name) {
        try {
            curs.executeUpdate(
                    "DELETE FROM service WHERE serv_name=\"" + serv_name + "\""
            );

            ResultSet rs = curs.executeQuery(
                    "SELECT id FROM customers WHERE serv_name =\"" + serv_name + "\""
            );

            deleteService(rs.getString("id"));

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // saved and return array for all the services
    public ArrayList<String> getListOfServiceName() {
        ArrayList<String> Services = new ArrayList<String>();

        try {
            ResultSet rs = curs.executeQuery("SELECT serv_name FROM service");

            while (rs.next()) {
                Services.add(rs.getString("serv_name"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return Services;
    }

    // Retrieve all the data from position table and store it into Object position , then return array of object position
    // to be used in Jtable in Jframe
    public Object[][] getService() {
        ArrayList<Object[]> Services = new ArrayList<Object[]>();

        try {
            ResultSet rs = curs.executeQuery("SELECT * FROM service");

            while (rs.next()) {

                Object[] temp = {
                        rs.getInt("id"),
                        rs.getString("serv_name"),
                        rs.getInt("price"),
                        rs.getString("desc")


                };

                Services.add(temp);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return Services.toArray(new Object[Services.size()][]);
    }

    //Insert new customer data into table customer
    public void createCustomer(String Cusid, String fn, String ln, String email, String service, String session) {
        try {
            curs.executeUpdate("INSERT INTO customers VALUES(" +
                    "\"" + Cusid + "\"," +
                    "\"" + fn + "\"," +
                    "\"" + ln + "\"," +
                    "\"" + email + "\"," +
                    "\"" + service + "\"," +
                    "\"" + session + "\"" +
                    ")");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    //dah update
    //verify if customer ID exist
    public Boolean existsCustomerID(String Cusid) {
        try {
            return curs.executeQuery(
                    "SELECT * FROM customers WHERE id=\"" + Cusid + "\""
            ).next();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }


    //store all employee ID into array and return it
    public ArrayList<String> getCustomerID() {
        ArrayList<String> CustomerID = new ArrayList<String>();

        try {
            ResultSet rs = curs.executeQuery("SELECT id FROM customers");

            while (rs.next()) {
                CustomerID.add(rs.getString("id"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return CustomerID;
    }

    //delete employee data that match the input employee id as well as employee data in table attendance and
    //salary with same ID
    //dah update
    public void deleteCustomer(String Cusid) {
        try {
            curs.executeUpdate(
                    "DELETE FROM customers WHERE id=\"" + Cusid + "\""
            );

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    //dah update
    //update employee information
    public void updateCustomer(String Cusid, String fn, String ln, String email, String service, String session) {
        try {
            curs.executeUpdate(
                    "UPDATE customers SET " +
                            "first_name=\"" + fn + "\"," +
                            "last_name=\"" + ln + "\"," +
                            "email=\"" + email + "\"," +
                            "serv_name=\"" + service + "\", " +
                            "session=\"" + session + "\"" +
                            "WHERE id=\"" + Cusid + "\""
            );
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    //dah update
    //get all employee data and store into employee object . Store and return employee Object in an array of object
    //to be used in Jtable for Jframe
    public Object[][] getCustomer() {

        ArrayList<Object[]> customers = new ArrayList<Object[]>();
        ResultSet rs;

        try {
            rs = curs.executeQuery(
                    "SELECT * FROM customers"
            );

            while (rs.next()) {
                Object[] temp = {
                        rs.getString("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("serv_name"),
                        rs.getInt("session")
                };

                customers.add(temp);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return customers.toArray(new Object[customers.size()][]);
    }

    public Object[][] getCustomerPayment() {
        ArrayList<Object[]> customers_payment = new ArrayList<Object[]>();
        ResultSet rs;

        try {
            rs = curs.executeQuery(
                    "SELECT c.id , c.first_name, c.last_name, c.serv_name, " +
                            "(SELECT SUM(s.price * c.session) FROM service s WHERE s.serv_name = c.serv_name) AS total_payment " +
                            "FROM customers c" +
                            " GROUP BY c.id "
            );


            while (rs.next()) {
                Object[] temp = {
                        rs.getString("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("serv_name"),
                        rs.getDouble("total_payment")
                };

                // Calculate total payment by multiplying session with service price
                //double totalPayment = session * servicePrice;

                // Create an Object array with the retrieved values and total payment

                customers_payment.add(temp);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return customers_payment.toArray(new Object[customers_payment.size()][]);
    }

}





