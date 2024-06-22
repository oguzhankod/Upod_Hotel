package queries;

public class SQLQueries {
    public static final String CREATE_ROOMS_TABLE = "CREATE TABLE IF NOT EXISTS Rooms (" +
            "room_id INT AUTO_INCREMENT PRIMARY KEY, " +
            "capacity INT NOT NULL, " +
            "description VARCHAR(255), " +
            "has_tv BOOLEAN DEFAULT TRUE, " +
            "has_bathroom BOOLEAN DEFAULT TRUE, " +
            "has_towel BOOLEAN DEFAULT TRUE, " +
            "sea_view BOOLEAN DEFAULT FALSE, " +
            "jacuzzi BOOLEAN DEFAULT FALSE, " +
            "safe BOOLEAN DEFAULT FALSE, " +
            "is_available BOOLEAN DEFAULT TRUE)";

    public static final String CREATE_CUSTOMERS_TABLE = "CREATE TABLE IF NOT EXISTS Customers (" +
            "customer_id INT AUTO_INCREMENT PRIMARY KEY, " +
            "name VARCHAR(100) NOT NULL, " +
            "surname VARCHAR(100) NOT NULL, " +
            "email VARCHAR(100) NOT NULL UNIQUE, " +
            "phone VARCHAR(20) NOT NULL)";

    public static final String CREATE_RESERVATIONS_TABLE = "CREATE TABLE IF NOT EXISTS Reservations (" +
            "reservation_id INT AUTO_INCREMENT PRIMARY KEY, " +
            "room_id INT NOT NULL, " +
            "customer_id INT NOT NULL, " +
            "check_in DATE NOT NULL, " +
            "check_out DATE NOT NULL, " +
            "check_in_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
            "check_out_time TIMESTAMP, " +
            "services VARCHAR(255), " +
            "FOREIGN KEY (room_id) REFERENCES Rooms(room_id), " +
            "FOREIGN KEY (customer_id) REFERENCES Customers(customer_id))";

    public static final String INSERT_ROOM = "INSERT INTO Rooms (capacity, description, sea_view, jacuzzi, safe) VALUES (?, ?, ?, ?, ?)";
    public static final String INSERT_CUSTOMER = "INSERT INTO Customers (name, surname, email, phone) VALUES (?, ?, ?, ?)";
    public static final String INSERT_RESERVATION = "INSERT INTO Reservations (room_id, customer_id, check_in, check_out, check_in_time, services) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_RESERVATION_CHECKOUT = "UPDATE Reservations SET check_out_time = ? WHERE reservation_id = ?";
}
