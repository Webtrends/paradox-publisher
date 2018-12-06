package com.oracle.infy.qa.paradoxpublisher

/**
 * Parses the config file into a typesafe object
 */
class Config {
    Config() {
        ConfigSlurper slurper = new ConfigSlurper()
        def configFile = new File('conf/config.groovy')
        def config = slurper.parse(configFile.text)
        autoUrl = config.autoUrl
        couchUrl = config.couchUrl
        jiraUrl = config.jiraUrl
        scsUrl = config.scsUrl
        scsRequestType = config.scsRequestType
        scsPostBatchSize = config.scsPostBatchSize
        jiraUsername = config.jiraUsername
        jiraPassword = config.jiraPassword
        zapiUrl = config.zapiUrl
        jiraProjectKey = config.jiraProjectKey
        jiraProjectId = config.jiraProjectId
        hipchatToken = config.hipchatToken
        hipchatUrl = config.hipchatUrl
        hipchatRoomId = config.hipchatRoomId
        if (config.proxy) {
            proxy = [
                host: config.proxy.host,
                port: config.proxy.port,
                scheme: config.proxy.scheme
            ]
        } else {
            proxy = null
        }
    }

    String autoUrl
    String couchUrl
    String jiraUrl
    String scsUrl
    String scsRequestType
    int scsPostBatchSize
    String jiraUsername
    String jiraPassword
    String zapiUrl
    String jiraProjectKey
    String jiraProjectId
    String hipchatToken
    String hipchatUrl
    String hipchatRoomId
    Map<String, ?> proxy
}
