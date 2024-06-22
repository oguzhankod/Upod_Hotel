package service;

import model.Customer;
import repository.CustomerRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerService {
    private final CustomerRepository customerRepository;
    private final Scanner scanner = new Scanner(System.in);

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer() throws SQLException {
        Customer customer = createCustomerFromUserInput();
        customerRepository.addCustomer(customer);
        System.out.println("Müşteri başarıyla eklendi.");
    }

    private Customer createCustomerFromUserInput() {
        System.out.print("Müşteri Adı: ");
        String name = scanner.next();
        System.out.print("Müşteri Soyadı: ");
        String surname = scanner.next();
        System.out.print("E-posta: ");
        String email = scanner.next();
        System.out.print("Telefon: ");
        String phone = scanner.next();

        return new Customer(name, surname, email, phone);
    }
}
