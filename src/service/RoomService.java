package service;

import model.Room;
import repository.RoomRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class RoomService {
    private final RoomRepository roomRepository;
    private final Scanner scanner = new Scanner(System.in);

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public void addRoom() throws SQLException {
        Room room = createRoomFromUserInput();
        roomRepository.addRoom(room);
        System.out.println("Oda başarıyla eklendi.");
    }

    private Room createRoomFromUserInput() {
        System.out.print("Oda kapasitesi: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // satır sonunu tüket
        System.out.print("Açıklama: ");
        String description = scanner.nextLine();
        System.out.print("Deniz Manzarası (true/false): ");
        boolean seaView = scanner.nextBoolean();
        System.out.print("Jakuzi (true/false): ");
        boolean jacuzzi = scanner.nextBoolean();
        System.out.print("Kasa (true/false): ");
        boolean safe = scanner.nextBoolean();

        return new Room(capacity, description, seaView, jacuzzi, safe);
    }
}

