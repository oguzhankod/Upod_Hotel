package service;

import model.Reservation;
import repository.ReservationRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final Scanner scanner = new Scanner(System.in);

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    public void addReservation() throws SQLException {
        Reservation reservation = createReservationFromUserInput();
        reservationRepository.addReservation(reservation);
        System.out.println("Rezervasyon başarıyla eklendi.");
    }

    public void checkOut() throws SQLException {
        System.out.print("Rezervasyon ID: ");
        int reservationId = scanner.nextInt();
        reservationRepository.checkOutReservation(reservationId);
        System.out.println("Check-out başarıyla yapıldı.");
    }

    private Reservation createReservationFromUserInput() {
        System.out.print("Oda ID: ");
        int roomId = scanner.nextInt();
        System.out.print("Müşteri ID: ");
        int customerId = scanner.nextInt();
        System.out.print("Hizmetler: ");
        scanner.nextLine(); // satır sonunu tüket
        String services = scanner.nextLine();

        // Mevcut tarih ve saat
        java.sql.Date checkIn = new java.sql.Date(System.currentTimeMillis());
        java.sql.Date checkOut = new java.sql.Date(System.currentTimeMillis() + 86400000L);

        return new Reservation(roomId, customerId, checkIn, checkOut, services);
    }
}

