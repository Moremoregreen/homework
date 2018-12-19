package com.train;

import java.util.Scanner;

public class Ticket {
    final double discount = 0.9;
    final int singlePrice = 1000;
    final double roundPrice = singlePrice * 2 * discount;

    protected void bookTicket() {
        System.out.print("Please enter number of tickets: ");
        Scanner sc = new Scanner(System.in);
//        while (true) {
        int total = (int) sc.nextDouble();
        System.out.print("How many round-trip tickets: ");
        int round = (int) sc.nextDouble();
        if (round > total || total < 1 || round < 0) {
            System.out.println("輸入票數錯誤:" + "\n" +
                    "Total:" + total + "\n" +
                    "Round-trip:" + round + "\n" +
                    "請重新輸入" + "\n");
            bookTicket();
        } else {
            System.out.println("Total tickets:" + total + "\n" +
                    "Round-trip:" + round + "\n" +
                    "Total:" + totalPrice(total, round));
        }
        sc.close();
//        }
    }

    protected double totalPrice(int total, int round) {
        int single = total - round;
        return single * singlePrice + round * roundPrice;
    }
}
