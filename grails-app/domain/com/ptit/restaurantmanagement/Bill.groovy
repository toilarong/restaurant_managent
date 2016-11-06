package com.ptit.restaurantmanagement

class Bill {
    boolean status
    Date dateCreated
    Coupons coupons
    Order order
    int totalPrice
    int finalPrice
    static constraints = {
    }
}
