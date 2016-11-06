package com.ptit.restaurantmanagement

class Menu {
    String name
    String description
    boolean status
    double price
    static hasMany = [orderMenu:OrderMenu]
    static constraints = {
        description nullable: true
        orderMenu nullable: true
    }
}
