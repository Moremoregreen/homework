package com.train;

import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ticketNo = -2;
            System.out.println("歡迎進入訂票系統: " + "\n");
            Ticket ticket = new Ticket();
            ticket.showFare();
        while (ticketNo != -1){
            System.out.println("如要離開訂票系統請輸入: -1 ");
            System.out.print("請輸入要購買幾張票: ");
            ticketNo = (int) sc.nextDouble();
            while (ticketNo >0){
                BookTicket bookTicket = new BookTicket(ticketNo);
                bookTicket.book();
                System.out.println();
                ticketNo = -2;
            }
        }
        System.out.println("你已離開系統");
    }
}
