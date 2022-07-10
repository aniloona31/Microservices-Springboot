package com.kafka.publishers;


public interface MessagePublisher {
	
	public void publish(String topic,String key,String value);
}
