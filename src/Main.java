import config.DatabaseSetup;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseSetup.createTables();
            ApplicationMenu appMenu = new ApplicationMenu();
            appMenu.start();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
