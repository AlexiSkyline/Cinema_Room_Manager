package com.hyperskill.cinema;
import java.util.Scanner;

import static com.hyperskill.cinema.State.*;

public class Cinema {
    private final Scanner scanner = new Scanner(System.in);
    public State state = START;
    public MovieTheater movieTheater;

    public void start() {
        switch (this.state) {
            case START -> this.initializeGlobalValues();
            case SHOW_MENU -> this.showMenu();
            case SHOW -> {
                this.movieTheater.printSeatsAll();
                this.state = SHOW_MENU;
            }
            case STATISTICS -> {
                this.movieTheater.printStatistics();
                this.state = SHOW_MENU;
            }
            case BUY -> this.buyTicket();
        }
    }

    private void initializeGlobalValues() {
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        this.movieTheater = new MovieTheater(rows, seats);
        this.state = SHOW_MENU;
    }

    private void showMenu() {
        System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
        this.state = State.getType(scanner.next());
    }

    private void buyTicket() {
        System.out.println("\nEnter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();

        if (this.movieTheater.occupySeat( rowNumber, seatNumber )) {
            int price = this.movieTheater.calculateTicketPrice(rowNumber);
            System.out.print("\nTicket price: $" + price + "\n");
            this.state = SHOW_MENU;
            return;
        }
        this.state = BUY;
    }
}