package com.KafkaConsumer.consumer;

import java.util.HashMap;
import java.util.Map;

//import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Component;

//import com.fasterxml.jackson.databind.deser.std.StringDeserializer;

@Component
@EnableKafka
public class MessageConsumer {
	
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
          "bootstrap.servers", 
          "localhost:9092");
        props.put(
          "key.deserializer", 
          "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(
          "value.deserializer", 
          "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("partitioner.class", "org.apache.kafka.clients.producer.internals.DefaultPartitioner");
        return new DefaultKafkaConsumerFactory<String,String>(props);
    }
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> 
    kafkaListenerContainerFactory() {
 
      ConcurrentKafkaListenerContainerFactory<String, String> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
      factory.setConsumerFactory(consumerFactory());
      return factory;
  }
	
	@KafkaListener(topics = "demo")
	public void listenGroupFoo(String message) {
	    System.out.println("Received Messages " + message);
	}
}
