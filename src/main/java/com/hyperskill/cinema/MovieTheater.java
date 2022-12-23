package com.hyperskill.cinema;

public class MovieTheater {
    private int tickets;
    private int purchasedTickets;
    private double percentage = 0.0000d;
    private int currentIncome;
    private int totalIncome;
    private final String[][] allSeats;
    private final int rows;
    private final int seats;

    public MovieTheater(int rows, int seats) {
        this.rows = rows;
        this.seats = seats;
        this.allSeats = new String[rows][seats];
        this.fillSetasAll();
        this.calculateTickets();
        this.calculateTotalIncome();
    }

    private void fillSetasAll() {
        for (int i = 0; i < this.allSeats.length; i++) {
            for (int j = 0; j < this.allSeats[0].length; j++) {
                this.allSeats[i][j] = "S";
            }
        }
    }

    public void printSeatsAll() {
        System.out.println("\nCinema:");
        for (int i = 0; i <= this.allSeats[0].length; i++) {
            if (i == 0) {
                System.out.print(" ");
            } else {
                System.out.print(" " + (i));
            }
        }
        System.out.println();
        for (int i = 0; i < this.allSeats.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < this.allSeats[0].length; j++) {
                System.out.print(" " + this.allSeats[i][j]);
            }
            System.out.println();
        }
    }

    public boolean occupySeat(int row, int seatNumber) {
        if (this.rows < row || this.seats < seatNumber) {
            System.out.println("\nWrong input!");
            return false;
        }

        for (int i = 0; i < row; i++) {
            if (row - 1 == i) {
                if (this.allSeats[i][seatNumber - 1].equals("B")) {
                    System.out.println("\nThat ticket has already been purchased!");
                    return false;
                }
                this.allSeats[i][seatNumber - 1] = "B";
            }
        }
        return true;
    }

    private void calculateTickets() {
        this.tickets = this.rows * this.seats;
    }

    private void calculateTotalIncome() {
        if (this.tickets < 60) {
            this.totalIncome = this.tickets * 10;
        } else {
            int mid = this.rows/2;
            this.totalIncome = ((mid * seats) * 10) + (((this.rows - mid) * seats) * 8);
        }
    }

    public int calculateTicketPrice(int rowNumber) {
        int price = 0;
        if (this.tickets < 60) {
            price = 10;
        } else {
            int mid = this.rows/2;
            price = ((rowNumber <= mid) ? 10 : 8);
        }
        this.calculateStatistics(price);
        return price;
    }

    private void calculateStatistics(int price) {
        this.purchasedTickets++;
        this.currentIncome += price;
        this.percentage = (double) (this.purchasedTickets * 100)/this.tickets;
    }

    public void printStatistics() {
        String messageStatistics = "\nNumber of purchased tickets: %d \nPercentage: %.2f%s \nCurrent income: $%d \nTotal income: $%d\n";
        System.out.printf(messageStatistics, this.purchasedTickets, this.percentage, "%", this.currentIncome, this.totalIncome);
    }
}