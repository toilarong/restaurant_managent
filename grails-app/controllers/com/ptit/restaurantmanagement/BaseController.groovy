package com.ptit.restaurantmanagement

import grails.converters.JSON
import grails.converters.XML

import javax.servlet.http.HttpServletResponse

class BaseController {
    protected renderResponse(ResultMessage resultMessage){
        if (resultMessage.resultCode == ConstantsMessage.SUCCESS){
            response.status = HttpServletResponse.SC_ACCEPTED
        }else {
            response.status = HttpServletResponse.SC_BAD_REQUEST
        }
        withFormat {
            json { render resultMessage as JSON }
            xml { render resultMessage as XML }
        }
    }
    protected renderAction(Object o){
        withFormat {
            json { render o as JSON }
            xml { render o as XML }
        }
    }

}