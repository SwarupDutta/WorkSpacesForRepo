from java.io import FileInputStream
import java.lang
import os
import string
propInputStream = FileInputStream("C:\WLST\Pause_Queue\domain.properties")
configProps = Properties()
configProps.load(propInputStream)
serverUrl = configProps.get("server.url")
Username = configProps.get("username")
Password = configProps.get("password")
tragatedServerName = configProps.get("tragated.server.name")
jmsServerName = configProps.get("jms.server.name")
systemModuleName = configProps.get("system.module.name")
queueName = configProps.get("queue.name")
connect(Username,Password,serverUrl)
serverRuntime()
cd('JMSRuntime/'+tragatedServerName+'.jms/JMSServers/'+jmsServerName+'/Destinations/'+systemModuleName +'!'+ queueName)
cmo.pauseProduction()
print 'Queue: "', queueName ,'" has been PRODUCTION Paused Successfully'