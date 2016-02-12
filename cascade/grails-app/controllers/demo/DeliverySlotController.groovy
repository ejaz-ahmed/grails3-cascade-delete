package demo

import grails.rest.RestfulController

class DeliverySlotController extends RestfulController {

    static responseFormats = ['json']
    
    DeliverySlotController() {
        super(DeliverySlot)
    }
}
