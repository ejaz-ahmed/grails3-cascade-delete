class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        
        "/deliverySchedules"(resources: 'deliverySchedule')
        "/deliverySlots"(resources: 'deliverySlot')
        "/regions"(resources: 'region')

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
