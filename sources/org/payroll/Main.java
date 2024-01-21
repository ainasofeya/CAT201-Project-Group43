package org.payroll;

public class Main {
    public static DatabaseManager dbManager;	// shared database manager

    public static void main(String[] args) {
        dbManager = new DatabaseManager("PayrollDatabase.db");
        // If "the path to database file" is empty, a temporary in-memory database is opened.


        new UserTypeFrame().setVisible(true);

    }
}

