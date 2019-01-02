package com.train.kotlin


open class TicketKotlin(var fare:Int?, var discount:Double?) {
    private val VERSION = 1.2
    val ONE_WAY_TICKET = 1
    val ROUND_TRIP_TICKET = 2

    fun showFare() {
        println(
            "======今日票價======" + "\n" +
                    "單程票: " + OneWayTicket().fare  + "\n" +
                    "來回票: " + RoundTripTicket().fare + "\n" +
                    "===================="
        )
    }
    fun getFare(): Double {
        return fare!! * discount!!
    }

}