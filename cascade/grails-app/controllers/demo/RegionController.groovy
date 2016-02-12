package demo

import grails.rest.RestfulController

class RegionController extends RestfulController {

    static responseFormats = ['json']
    
    RegionController() {
        super(Region)
    }
}
