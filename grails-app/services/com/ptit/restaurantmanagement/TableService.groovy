package com.ptit.restaurantmanagement

import grails.transaction.Transactional

@Transactional
class TableService extends BaseServices{

    def bookTable(long id){
        Table table = Table.get(id);
        ResultMessage resultMessage = new ResultMessage()
        if (table!=null&&table.status == StatusConstants.Table.READY){
            table.status = StatusConstants.Table.BOOKING
            table.bookingTime = new Date();
            table.save();
            resultMessage.resultCode = ConstantsMessage.SUCCESS
        }else{
            resultMessage.resultCode = ConstantsMessage.ERROR
        }
        return resultMessage
    }

    def servingBookingTable(long id){
        Table table = Table.get(id);
        ResultMessage resultMessage = new ResultMessage()
        if (table!=null&& table.status in [StatusConstants.Table.BOOKING,StatusConstants.Table.READY]){
            table.status = StatusConstants.Table.SERVING
            table.bookingTime = new Date();
            table.save();
            resultMessage.resultCode = ConstantsMessage.SUCCESS
        }else{
            resultMessage.resultCode = ConstantsMessage.ERROR
        }
        return resultMessage
    }

    def setTableStatus(long id,int status){
        Table table = Table.get(id);
        ResultMessage resultMessage = new ResultMessage()
        if (table!=null){
            table.status = status
            table.bookingTime = null
            resultMessage.resultCode = ConstantsMessage.SUCCESS
        }else{
            resultMessage.resultCode = ConstantsMessage.ERROR
        }
        return resultMessage
    }

    def addTable(){
        Table table = new Table()
        table.id = Table.findAll().size()+1;
        table.status = StatusConstants.Table.READY;
        table.save()
        ResultMessage resultMessage = new ResultMessage()
        resultMessage.resultCode = ConstantsMessage.SUCCESS;
        return resultMessage
    }

    def deleteTable(){
        def table = Table.findById(Table.findAll().size());
        ResultMessage resultMessage = new ResultMessage()
        if (table!=null ){
            Table.executeUpdate("Delete from Table where id = $table.id");
            resultMessage.resultCode = ConstantsMessage.SUCCESS;
        }else{
            resultMessage.resultCode = ConstantsMessage.ERROR
        }
        return resultMessage
    }

    def getAllTable(){
        ResultMessage resultMessage = new ResultMessage()
        List<TableDTO> tableDTOList = new ArrayList<>()
        Table.findAll().each {Table table->
            TableDTO tableDTO = new TableDTO()
            tableDTO.id = table.id;
            tableDTO.bookingTime = table.bookingTime?.format("DD/MM/YYYY HH:mm:ss")
            tableDTO.status = table.status;
            tableDTOList.add(tableDTO)
        }
        if (tableDTOList!=null && tableDTOList.size()!=0) {
            resultMessage.resultCode = ConstantsMessage.SUCCESS
            resultMessage.detailsData = tableDTOList;
        }else{
            resultMessage.resultCode = ConstantsMessage.ERROR
        }
        return resultMessage
    }
}
