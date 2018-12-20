package com.train


class TicketKotlin(var count: Int, var roundTirp: Int) {
    val discount = 0.9
    val singlePrice = 1000
    val roundPrice = singlePrice * 2 * discount

    fun bookTicket() {
        if (count < roundTirp || count < 0 || roundTirp < 0) {
            println(
                "\n" + "輸入票數錯誤:  \n" +
                        "Total: $count  \n" +
                        "Round-trip: $roundTirp  \n" +
                        "請重新輸入  \n"
            )
        } else {
            println(
                "\n" + "Total tickets: $count \n" +
                        "Round-trip: $roundTirp \n" +
                        "Total: ${totalPrice(count, roundTirp)} "
            )
        }
    }

    fun totalPrice(total: Int, round: Int): Double {
        val single = total - round
        return single * singlePrice + round * roundPrice
    }
}