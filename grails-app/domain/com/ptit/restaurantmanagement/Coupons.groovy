package com.ptit.restaurantmanagement

class Coupons {
    Date dateCreated
    int randomNumber
    String couponsCode
    Date dateExpiried
    static belongsTo = [categoryOfCoupon:CategoryOfCoupon]
    static hasMany = [bill:Bill]
    static constraints = {
        dateExpiried nullable: true
    }
}
