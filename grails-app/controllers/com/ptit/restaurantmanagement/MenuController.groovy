package com.ptit.restaurantmanagement

import grails.converters.JSON

class MenuController extends BaseController{

    def menuService
    def createMenu(){
        def json = request.getJSON().toString();
        MenuDTO menuDTO = new MenuDTO()
        menuDTO = JSON.parse(json);
        renderResponse(menuService.createMenu(menuDTO))
    }

    def getAllMenu(){
        renderResponse(menuService.getAllMenu())
    }

    def getMenuById(){
        long id = params.id.toLong();
        renderResponse(menuService.getMenuById(id))
    }

    def deleteMenu(){
        long id = params.id.toLong();
        renderResponse(menuService.deleteMenuById(id))
    }

    def editMenuById(){
        long id = params.id.toLong();
        MenuDTO menuDTO = JSON.parse(request.getJSON().toString());
        renderResponse(menuService.editMenuById(id,menuDTO))
    }
}
