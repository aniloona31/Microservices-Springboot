package com.kafka.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.publishers.MessagePublisher;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessagePublisher messagePublisher;
	
	@Override
	public void produceMessage(String topic, String key, String value) throws IOException{
		messagePublisher.publish(topic,key,value);
	}

}
