package com.train;

import java.util.Scanner;

public class Ticket {
    final double discount = 0.9;
    final int singlePrice = 1000;
    final double roundPrice = singlePrice * 2 * discount;
    private int singleTicketCount;
    private int roundTripTicketCount = 0;
    private int ticketCount = 0;
    boolean check = true;

    public Ticket(int ticketCount, int roundTripTicketCount) {
        this.roundTripTicketCount = roundTripTicketCount;
        this.ticketCount = ticketCount;
        this.singleTicketCount = ticketCount - roundTripTicketCount;
    }

    public Ticket() {
    }

    protected void bookTicket() {
        if (roundTripTicketCount < ticketCount && ticketCount >= 0 && roundTripTicketCount >= 0) {
            System.out.println("\n" + "Total tickets:" + ticketCount + "\n" +
                    "Round-trip:" + roundTripTicketCount + "\n" +
                    "Total:" + totalPrice(ticketCount, roundTripTicketCount) );
        } else {
            System.out.println("\n" + "輸入票數錯誤:" + "\n" +
                    "Total:" + ticketCount + "\n" +
                    "Round-trip:" + roundTripTicketCount + "\n" +
                    "請重新輸入" + "\n");
        }

    }

    protected double totalPrice(int total, int round) {
        int single = total - round;
        return single * singlePrice + round * roundPrice;
    }
}
