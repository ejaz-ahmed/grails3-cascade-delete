package demo

class Region {
    String name

    static constraints = {
    }
    static hasMany = [deliverySchedule: DeliverySchedule]
}
