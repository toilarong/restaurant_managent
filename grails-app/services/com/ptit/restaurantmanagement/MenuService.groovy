package com.ptit.restaurantmanagement

import grails.transaction.Transactional

@Transactional
class MenuService extends BaseServices{

    def createMenu(MenuDTO menuDTO){
        ResultMessage resultMessage = new ResultMessage();
        Menu menu = new Menu();
        copyProperties(menuDTO,menu)
        if (menu.validate()){
            menu.save(failOnError:true)
            resultMessage.resultCode = ConstantsMessage.SUCCESS
        }else{
            resultMessage.resultCode = ConstantsMessage.ERROR
        }
        return resultMessage
    }

    def getMenuById(long id){
        Menu menu = Menu.findById(id)
        ResultMessage resultMessage = new ResultMessage();
        if (menu!=null){
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.properties.each {property->
                if (property.key!="class")
                    menuDTO.setProperty(property.key.toString(),menu.getProperty("$property.key"))
            }
            resultMessage.resultCode = ConstantsMessage.SUCCESS
            resultMessage.detailsData = menuDTO
        }else{
            resultMessage.resultCode = ConstantsMessage.ERROR
        }
        return resultMessage
    }
    def getAllMenu(){
        ResultMessage resultMessage = new ResultMessage();
        List<MenuDTO> menuDTOList = new ArrayList<>()
        Menu.findAll().each {Menu menu->
            if (menu!=null){
                MenuDTO menuDTO = new MenuDTO();
                menuDTO.properties.each {property->
                    if (property.key!="class")
                        menuDTO.setProperty(property.key.toString(),menu.getProperty("$property.key"))
                }
                menuDTO.id = menu.id
                menuDTOList.add(menuDTO)
            }
        }
        if (menuDTOList.size()>0){
            resultMessage.resultCode = ConstantsMessage.SUCCESS
            resultMessage.detailsData = menuDTOList
        }else{
            resultMessage.resultCode = ConstantsMessage.ERROR
        }
        return resultMessage;
    }

    def deleteMenuById(long id){
        ResultMessage resultMessage = new ResultMessage();
        Menu menu = Menu.findById(id);
        if (menu!=null){
            menu.delete(failOnError: true)
            resultMessage.resultCode = ConstantsMessage.SUCCESS
        }else{
            resultMessage.resultCode = ConstantsMessage.ERROR
        }
        return resultMessage
    }

    def editMenuById(long id,MenuDTO menuDTO){
        Menu menu = Menu.findById(id);
        ResultMessage resultMessage = new ResultMessage();
       copyProperties(menuDTO,menu)
        if (menu.validate()){
            menu.save(failOnError:true)
            resultMessage.resultCode = ConstantsMessage.SUCCESS
        }else{
            resultMessage.resultCode = ConstantsMessage.ERROR
        }
        return resultMessage
    }
}
