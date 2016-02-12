import demo.*

class BootStrap {

    def init = { servletContext ->
        new Region(name: 'Bootstrap').save(flush: true)
    }
    def destroy = {
    }
}
