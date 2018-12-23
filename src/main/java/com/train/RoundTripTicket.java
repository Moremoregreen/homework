package com.train;

public class RoundTripTicket extends Ticket{
    public RoundTripTicket() {
        this.discount = 0.9;
        this.type = ROUND_TRIP_TICKET;
        this.fare = 2000;
    }
}
