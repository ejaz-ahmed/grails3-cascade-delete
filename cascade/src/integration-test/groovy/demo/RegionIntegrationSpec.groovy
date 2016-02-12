package demo


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*
import grails.converters.JSON
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse

@Integration
@Rollback
class RegionIntegrationSpec extends Specification {

    String appUrl = "http://localhost:8080/"
    String artifactUrl = appUrl +"regions"
    RestBuilder builder
    RestResponse response
    

    def setup() {
        builder = new RestBuilder()
    }
    
    void "Bootstrap data is available in integration test"(){
        when:
        response = builder.get(artifactUrl)
        
        then:
        response.status == 200
        response.name == 'Bootstrap'
    }

    void "Test region can be created with integration test "() {
        when:
        response = builder.post(artifactUrl){
            json{
                JSON.parse('{name: Region}')
            }
        }

        then:
        response.status == 201
        response.json.name == 'Region'
            
    }
}
