package com.kafka.dto;

import lombok.Data;

@Data
public class MessageDto {
	private String topic;
	private String key;
	private String value;
}
