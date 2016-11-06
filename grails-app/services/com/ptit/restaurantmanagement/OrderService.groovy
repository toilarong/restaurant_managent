package com.ptit.restaurantmanagement

import grails.transaction.Transactional

@Transactional
class OrderService extends BaseServices {

    def getOrderById(long id){
        Order order = Order.findById(id)
        ResultMessage resultMessage = new ResultMessage();
        if (order!=null){
            OrderDTO orderDTO = new OrderDTO();
            order.orderMenu.each {OrderMenu orderMenu->
                MenuDTO menuDTO = new MenuDTO()
                copyProperties(orderMenu.menu,menuDTO)
                orderDTO.menuList.put(menuDTO,orderMenu.quantum);
                orderDTO.totalPrice+=menuDTO.price*orderMenu.quantum;
            }
            resultMessage.resultCode = ConstantsMessage.SUCCESS;
            orderDTO.tableNo = order.table.id
            resultMessage.detailsData = orderDTO
        }else{
            resultMessage.resultCode = ConstantsMessage.ERROR
        }
        return resultMessage
    }
}
