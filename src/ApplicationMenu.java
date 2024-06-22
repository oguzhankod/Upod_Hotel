import repository.CustomerRepository;
import repository.ReservationRepository;
import repository.RoomRepository;
import service.CustomerService;
import service.ReservationService;
import service.RoomService;

import java.sql.SQLException;
import java.util.Scanner;

public class ApplicationMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final RoomService roomService = new RoomService(new RoomRepository());
    private final CustomerService customerService = new CustomerService(new CustomerRepository());
    private final ReservationService reservationService = new ReservationService(new ReservationRepository());

    public void start() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            executeUserChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("1. Oda Ekle");
        System.out.println("2. Müşteri Ekle");
        System.out.println("3. Rezervasyon Ekle");
        System.out.println("4. Check-out Yap");
        System.out.println("5. Çıkış");
        System.out.print("Seçiminiz: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void executeUserChoice(int choice) {
        try {
            switch (choice) {
                case 1:
                    roomService.addRoom();
                    break;
                case 2:
                    customerService.addCustomer();
                    break;
                case 3:
                    reservationService.addReservation();
                    break;
                case 4:
                    reservationService.checkOut();
                    break;
                case 5:
                    System.out.println("Çıkış yapılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
