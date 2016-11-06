package com.ptit.restaurantmanagement

class OrderMenu {
    static belongsTo = [menu:Menu,order:Order]
    int quantum
    boolean status
    static constraints = {
    }
}
