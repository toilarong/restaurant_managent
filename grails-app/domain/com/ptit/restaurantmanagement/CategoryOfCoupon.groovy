package com.ptit.restaurantmanagement

class CategoryOfCoupon {
    String name
    Date dateCreated
    int price
    int pricePercent
    static hasMany = [coupons:Coupons]
    static constraints = {
        name nullable: true
        pricePercent max: 100
    }
}
