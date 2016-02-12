package demo

import grails.rest.RestfulController

class DeliveryScheduleController extends RestfulController{

    static responseFormats = ['json']
    
    DeliveryScheduleController(){
        super(DeliverySchedule)
    }
    
}
