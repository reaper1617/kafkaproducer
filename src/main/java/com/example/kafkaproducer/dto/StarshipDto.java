package com.example.kafkaproducer.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class StarshipDto {
    private String name;
    private String field;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private String localDateTimeString = localDateTime.toString();
    private Integer count;
}
