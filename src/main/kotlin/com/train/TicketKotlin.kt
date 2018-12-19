package com.train

import java.util.*

class TicketKotlin {
    val discount = 0.9
    val singlePrice = 1000
    val roundPrice = singlePrice * 2 * discount

    fun bookTicket() {
        print("Please enter number of tickets: ")
        var sc = Scanner(System.`in`)
        val total = sc.nextDouble().toInt()

        print("How many round-trip tickets: ")
        val round = sc.nextDouble().toInt()
        if (round > total || total < 1 || round < 0) {
            println(
                "輸入票數錯誤:  \n" +
                        "Total: $total  \n" +
                        "Round-trip: $round  \n" +
                        "請重新輸入  \n"
            )
            bookTicket()
        } else {
            println(
                ("Total tickets: $total \n" +
                        "Round-trip: $round \n" +
                        "Total: ${totalPrice(total, round)} \n")
            )
        }
        sc.close()
    }

    fun totalPrice(total: Int, round: Int): Double {
        val single = total - round
        return single * singlePrice + round * roundPrice
    }
}