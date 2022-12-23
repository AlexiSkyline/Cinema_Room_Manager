package com.hyperskill.cinema;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        while (cinema.state != State.EXIT) {
            cinema.start();
        }
    }
}