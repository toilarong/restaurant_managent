package com.ptit.restaurantmanagement

class Table {
    int status
    Date bookingTime
    static hasMany = [order:Order]
    static constraints = {
        status max: 4
        bookingTime nullable: true
        id generator: 'assigned'
    }
}
