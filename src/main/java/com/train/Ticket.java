package com.train;

import java.util.Scanner;

public class Ticket {
    private static final double VERSION = 1.2;
    public static final int ONE_WAY_TICKET = 1;
    public static final int ROUND_TRIP_TICKET = 2;

    double discount ;
    int type;
    int fare;
    public void showFare() {
        System.out.println("======今日票價======" + "\n" +
                "單程票: " + new OneWayTicket().getFare() + "\n" +
                "來回票: " + new RoundTripTicket().getFare() + "\n" +
                "====================");
    }
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFare() {
        return (int)(fare * discount);
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    //    public Ticket(int ticketCount, int roundTripTicketCount) {
//        this.roundTripTicketCount = roundTripTicketCount;
//        this.ticketCount = ticketCount;
//        this.singleTicketCount = ticketCount - roundTripTicketCount;
//    }

//    protected void bookTicket() {
//        if (roundTripTicketCount < ticketCount && ticketCount >= 0 && roundTripTicketCount >= 0) {
//            System.out.println("\n" + "Total tickets:" + ticketCount + "\n" +
//                    "Round-trip:" + roundTripTicketCount + "\n" +
//                    "Total:" + totalPrice(ticketCount, roundTripTicketCount) );
//        } else {
//            System.out.println("\n" + "輸入票數錯誤:" + "\n" +
//                    "Total:" + ticketCount + "\n" +
//                    "Round-trip:" + roundTripTicketCount + "\n" +
//                    "請重新輸入" + "\n");
//        }
//
//    }

//    protected double totalPrice(int total, int round) {
//        int single = total - round;
//        return single * singlePrice + round * roundPrice;
//    }
}
