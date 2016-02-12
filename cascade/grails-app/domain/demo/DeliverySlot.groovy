package demo


class DeliverySlot {
    String name

    static constraints = {
    }
    static hasMany = [deliverySchedule: DeliverySchedule]
    
    static mapping = {
//        deliverySchedule cascade: 'all'
    }
}
