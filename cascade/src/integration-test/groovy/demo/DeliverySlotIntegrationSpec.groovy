package demo


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class DeliverySlotIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test deliverySlot can be created"(){
        when:
        def dsl = new DeliverySlot(name: "slot").save(flush: true)
        
        then:
        DeliverySlot.exists(dsl.id)

    }
    
    void "test deleting deliverySlot deletes deliverySchedule"() {
        given:
        def dsl = new DeliverySlot(name: "slot").save(flush: true)
        def rgn = new Region(name: "region").save(flush: true)
        def ds = new DeliverySchedule(name: "schedule")
        ds.region = rgn
        ds.deliverySlot = dsl
        ds.save(flush: true)
        
        when:
        DeliverySlot.findById(dsl.id).delete(flush: true)
        
        then:
        !DeliverySlot.exists(dsl.id)
        !DeliverySchedule.exists(ds.id)       
    }
}
