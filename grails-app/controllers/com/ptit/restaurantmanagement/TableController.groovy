package com.ptit.restaurantmanagement

class TableController extends BaseController{
    def tableService
    def addTable(){
        renderResponse(tableService.addTable())
    }

    def deleteTable(){
        renderResponse(tableService.deleteTable())
    }

    def setTableStatus(){
        long id  = params.id.toLong()
        int status = request.getJSON().status
        renderResponse(tableService.setTableStatus(id,status))
    }

    def getAllTable(){
        renderResponse(tableService.getAllTable())
    }

    def bookTable(){
        long id  = params.id.toLong()
        renderResponse(tableService.bookTable(id))
    }

    def servingTable(){
        long id  = params.id.toLong()
        renderResponse(tableService.servingBookingTable(id))
    }
}
