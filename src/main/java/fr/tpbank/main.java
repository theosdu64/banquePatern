package fr.tpbank;

import fr.tpbank.util.DatabaseConnection;

public class main {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println(db1 == db2);

    }
}
