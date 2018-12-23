package com.train;

public class OneWayTicket extends Ticket{
    public OneWayTicket() {
        this.discount = 1;
        this.type = ONE_WAY_TICKET;
        this.fare = 1000;
    }
}
