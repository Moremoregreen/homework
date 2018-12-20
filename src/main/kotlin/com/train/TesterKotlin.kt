package com.train

import java.util.*

fun main(args: Array<String>) {
//    val ticketKotlin = TicketKotlin()
//    ticketKotlin.bookTicket()
    var total = 0
    var sc = Scanner(System.`in`)
    while (total != -1) {
        println("如要離開系統請在總票數輸入： -1 ")
        print("Please enter number of tickets: ")
        total = sc.nextDouble().toInt()
        if (total!=-1){print("How many round-trip tickets: ")
            var round = sc.nextDouble().toInt()
            val ticketKotlin = TicketKotlin(total, round)
            ticketKotlin.bookTicket()
            println()
        }

    }
    print("你已離開系統")

}