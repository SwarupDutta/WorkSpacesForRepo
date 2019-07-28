from java.io import FileInputStream
import java.lang
import os
import string
propInputStream = FileInputStream("C:\WLST\Move_Messages\domain.properties")
configProps = Properties()
configProps.load(propInputStream)
serverUrl = configProps.get("server.url")
Username = configProps.get("username")
Password = configProps.get("password")
systemModuleName = configProps.get("system.module.name")
oldServerName = configProps.get("old.server.name")
oldJmsServerName = configProps.get("old.jms.server.name")
oldQueueName = configProps.get("old.queue.name")
newTragatedServerName = configProps.get("new.tragated.server.name")
newJmsServerName = configProps.get("new.jms.server.name")
newQueueName = configProps.get("new.queue.name")
connect(Username,Password,serverUrl)
serverRuntime()
print 'Getting the traget...'
cd('/JMSRuntime/'+newTragatedServerName+'.jms/JMSServers/'+newJmsServerName+'/Destinations/'+systemModuleName +'!'+ newQueueName)
target = cmo.getDestinationInfo()
print 'Got the traget...'
cd('/JMSRuntime/'+oldServerName+'.jms/JMSServers/'+oldJmsServerName+'/Destinations/'+systemModuleName +'!'+ oldQueueName)
print 'Moving the messages to the new traget...'
cmo.moveMessages('',target)
print 'Messages have been moved to the traget Successfully !!!'
print '======================================='
print 'Messages from queue: "'+oldQueueName+'" have been moved to the new queue: "'+newQueueName+'" Successfully !!!'
print '======================================='