package demo

class DeliverySchedule {
    String name
    static constraints = {
    }
    
    static belongsTo=[region: Region, deliverySlot: DeliverySlot]
}
