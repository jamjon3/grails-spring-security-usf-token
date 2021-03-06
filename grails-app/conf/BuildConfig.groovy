grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility
    repositories {
        grailsCentral()
        mavenCentral()
        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        compile('org.springframework.security:org.springframework.security.cas:3.0.4.RELEASE') {
            transitive = false
        }
        compile 'org.codehaus.jackson:jackson-core-asl:1.8.3'
        compile 'org.codehaus.jackson:jackson-mapper-asl:1.8.3'
        compile 'com.nimbusds:nimbus-jose-jwt:3.1.1'
        compile 'org.codehaus.groovy.modules.http-builder:http-builder:0.7.2'
    }

    plugins {
        build(":tomcat:$grailsVersion",
              ":release:2.2.1",
              ":rest-client-builder:1.0.3") {
            export = false
        }
        compile ':spring-security-core:1.2.7.3'
        compile ":spring-security-acl:1.1.1"
        provided ":webxml:1.4.1"
        runtime ":cors:1.1.6"
    }
}
