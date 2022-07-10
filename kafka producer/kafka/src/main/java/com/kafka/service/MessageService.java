package com.kafka.service;

import java.io.IOException;

public interface MessageService {
	
	public void produceMessage(String topic,String key,String value) throws IOException;
}
