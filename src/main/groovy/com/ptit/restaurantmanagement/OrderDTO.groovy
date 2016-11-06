package com.ptit.restaurantmanagement

/**
 * Created by pham on 05-Nov-2016.
 */
class OrderDTO {
    long id
    Map<MenuDTO,Integer> menuList
    int tableNo
    double totalPrice

}
