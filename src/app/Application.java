package app;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Birth Date: ");
        String bDate = scanner.nextLine();
        Date birth = sdf.parse(bDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String status = scanner.nextLine();
        System.out.print("How to many items to this order: ");
        int numberIt = scanner.nextInt();

        Date moment = Date.from(Instant.now());
        Order order1 = new Order(moment, OrderStatus.valueOf(status),
                new Client(name, email, birth));

        for (int i = 0; i < numberIt; i++){
            System.out.println("Enter data to #" + (i + 1) + ": ");
            System.out.print("Product name: " + "\n");
            String productName = scanner.next();
            System.out.print("Product price: ");
            double price = scanner.nextDouble();
            System.out.print("Product quantity: ");
            int quantity = scanner.nextInt();

            OrderItem orderItem = new OrderItem(quantity,new Product(productName, price));
            order1.addItem(orderItem);

        }
        System.out.println("  ORDER SUMARY  ");
        System.out.print(order1);
    }
}
