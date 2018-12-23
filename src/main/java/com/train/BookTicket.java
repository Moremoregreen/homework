package com.train;

import java.util.Scanner;

public class BookTicket {
    private static final double VERSION = 1.2;
    private final Scanner sc;
    private int tickets = 0;
    private int roundTripTickets = -1;
    private int totalPrice = 0;

    public BookTicket(int tickets) {
        this.tickets = tickets;
        sc = new Scanner(System.in);
    }

    public void book() {
        System.out.print("請輸入有幾張是來回票(必須至少0張且小於" + tickets + "張):");
        roundTripTickets = check(tickets, sc.nextInt());
        while (roundTripTickets <= tickets && roundTripTickets >= 0) {
            printTotal(tickets, roundTripTickets);
            break;
        }
    }

    private int check(int tickets, int roundTripTickets) {
        while (roundTripTickets > tickets || roundTripTickets < 0) {
            System.out.println("請正確輸入來回票數:");
            roundTripTickets = sc.nextInt();
        }
        return roundTripTickets;
    }

    private void printTotal(int tickets, int roundTripTickets) {
        int oneWayTickets = tickets - roundTripTickets;
        totalPrice = new OneWayTicket().getFare() * oneWayTickets + new RoundTripTicket().getFare() * roundTripTickets;
        System.out.println("總票數: " + tickets + "\n" +
                "單程票: " + oneWayTickets + "\n" +
                "來回票: " + roundTripTickets + "\n" +
                "總金額為: " + totalPrice);
    }
}
