package com.kafka.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.dto.MessageDto;
import com.kafka.service.MessageService;

@RestController
@RequestMapping("/message-producer")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	@PostMapping(value = "/messages", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> produceMessage(@RequestBody MessageDto message) throws IOException{
		messageService.produceMessage(message.getTopic(), message.getKey(), message.getValue());
		return new ResponseEntity<String>("Message Published",HttpStatus.OK);
	}
}
