connect('swarup','swarup123','t3://localhost:8001')
servers = domainRuntimeService.getServerRuntimes();
if (len(servers) > 0):
	for server in servers:
		jmsRuntime = server.getJMSRuntime();
		jmsServers = jmsRuntime.getJMSServers();
		for jmsServer in jmsServers:
			destinations = jmsServer.getDestinations();
			for destination in destinations:
				print '  BytesCurrentCount           ' ,  destination.getBytesCurrentCount()
				print '  BytesHighCount              ' ,  destination.getBytesHighCount()
				print '  BytesPendingCount           ' ,  destination.getBytesPendingCount()
				print '  BytesReceivedCount          ' ,  destination.getBytesReceivedCount()
				print '  BytesThresholdTime          ' ,  destination.getBytesThresholdTime()
				print '  ConsumersCurrentCount       ' ,  destination.getConsumersCurrentCount()
				print '  ConsumersHighCount          ' ,  destination.getConsumersHighCount()
				print '  ConsumersTotalCount         ' ,  destination.getConsumersTotalCount()
				print '  ConsumptionPausedState      ' ,  destination.getConsumptionPausedState()
				print '  '
				print '  DestinationInfo             ' ,  destination.getDestinationInfo()
				print '  '
				print '  DestinationType             ' ,  destination.getDestinationType()
				print '  InsertionPaused             ' ,  destination.isInsertionPaused()
				print '  InsertionPausedState        ' ,  destination.getInsertionPausedState()
				print '  MessagesCurrentCount        ' ,  destination.getMessagesCurrentCount()
				print '  MessagesDeletedCurrentCount ' ,  destination.getMessagesDeletedCurrentCount()
				print '  MessagesHighCount           ' ,  destination.getMessagesHighCount()
				print '  MessagesMovedCurrentCount   ' ,  destination.getMessagesMovedCurrentCount()
				print '  MessagesPendingCount        ' ,  destination.getMessagesPendingCount()
				print '  MessagesReceivedCount       ' ,  destination.getMessagesReceivedCount()
				print '  MessagesThresholdTime       ' ,  destination.getMessagesThresholdTime()
				print '  Parent                      ' ,  destination.getParent()
				print '  Paused                      ' ,  destination.isPaused()
				print '  ProductionPaused            ' ,  destination.isProductionPaused()
				print '  ProductionPausedState       ' ,  destination.getProductionPausedState()
				print '  State                       ' ,  destination.getState()
				print '  Type                        ' ,  destination.getType()
