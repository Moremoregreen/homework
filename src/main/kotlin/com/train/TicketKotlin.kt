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
//    fun bookTicket() {
//        if (count < roundTirp || count < 0 || roundTirp < 0) {
//            println(
//                "\n" + "輸入票數錯誤:  \n" +
//                        "Total: $count  \n" +
//                        "Round-trip: $roundTirp  \n" +
//                        "請重新輸入  \n"
//            )
//        } else {
//            println(
//                "\n" + "Total tickets: $count \n" +
//                        "Round-trip: $roundTirp \n" +
//                        "Total: ${totalPrice(count, roundTirp)} "
//            )
//        }
//    }
//
//    fun totalPrice(total: Int, round: Int): Double {
//        val single = total - round
//        return single * singlePrice + round * roundPrice
//    }
}