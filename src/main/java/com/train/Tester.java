package com.train;

import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
//        Ticket ticket = new Ticket();
//        ticket.bookTicket();

        Scanner sc = new Scanner(System.in);
        int ticketNo = -2;
        while (ticketNo != -1) {
            System.out.println("如要離開訂票系統請輸入: -1 ");
            System.out.print("Please enter number of tickets: ");
            ticketNo = (int) sc.nextDouble();
            if (ticketNo != -1){
                System.out.print("How many round-trip tickets: ");
                int roundTripTicketCount = (int) sc.nextDouble();
                Ticket ticket = new Ticket(ticketNo, roundTripTicketCount);
                ticket.bookTicket();
                System.out.println();
//                System.out.println("\n" + "是否訂票完畢?" + "\n" + "訂好了 : -1" + "\n" + "還沒請輸入其他任意數字");
//                ticketNo = sc.nextInt();
            }
        }
        System.out.println("你已離開系統");
    }
}
