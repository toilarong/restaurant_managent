package com.ptit.restaurantmanagement

class Order {
    static hasMany = [orderMenu:OrderMenu]
    static belongsTo = [table:Table]
    Bill bill
    static constraints = {
    }
}
