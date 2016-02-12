package demo

import grails.test.mixin.integration.Integration
import grails.transaction.*
import grails.converters.JSON
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse

import spock.lang.*
import geb.spock.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
class RegionFunctionalSpec extends GebSpec {

        String appUrl = "http://localhost:8080/"
        String artifactUrl = appUrl +"regions"
        RestBuilder builder
        RestResponse response


    def setup() {
        builder = new RestBuilder()
    }

    def cleanup() {
    }
    
    void "Bootstrap data is available in functional test"(){
        when:
        response = builder.get(artifactUrl)
        
        then:
        response.status == 200
        response.name == 'Bootstrap'
    }

    void "Test region can be created "() {
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
