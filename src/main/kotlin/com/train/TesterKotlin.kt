package com.train.kotlin

import java.util.*
private val VERSION = 1.2
fun main(args: Array<String>) {
    
    var total = 0
    var sc = Scanner(System.`in`)
    while (total != -1) {
        println("如要離開系統請在總票數輸入： -1 ")
        print("Please enter number of tickets: ")
        total = sc.nextDouble().toInt()
        if (total != -1) {
            var bookTicket = BookTicket(total)
            bookTicket.book()
            println()
        }
    }

    print("你已離開系統")

}
class BookTicket(val tickets:Int) {
    private var rouonTickets = -1;
    var sc = Scanner(System.`in`)

    fun book() {
        println("請輸入有幾張是來回票(必須至少0張且小於$tickets 張):")
        rouonTickets = sc.nextInt()
        rouonTickets = check(tickets,rouonTickets)
        printTotal(tickets,rouonTickets)

    }

    fun check(totalTickets: Int, roundTripTickets: Int): Int {
        var roundTripTickets = roundTripTickets
        while (roundTripTickets > totalTickets || roundTripTickets < 0) {
            println("請正確輸入來回票數:")
            roundTripTickets = sc.nextInt()
        }
        return roundTripTickets
    }

    fun printTotal(tickets: Int, roundTripTickets: Int) {
        val oneWayTickets = tickets - roundTripTickets
        val totalPrice = OneWayTicket().getFare() * oneWayTickets + RoundTripTicket().getFare() * roundTripTickets
        println(
            "總票數: " + tickets + "\n" +
                    "單程票: " + oneWayTickets + "\n" +
                    "來回票: " + roundTripTickets + "\n" +
                    "總金額為: " + totalPrice
        )

    }
}