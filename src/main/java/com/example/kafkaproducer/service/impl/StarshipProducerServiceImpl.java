package com.example.kafkaproducer.service.impl;

import com.example.kafkaproducer.dto.StarshipDto;
import com.example.kafkaproducer.service.api.StarshipProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class StarshipProducerServiceImpl implements StarshipProducerService {

    private final KafkaTemplate<Long, StarshipDto> kafkaTemplate;

    @Autowired
    public StarshipProducerServiceImpl(KafkaTemplate<Long, StarshipDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Scheduled(initialDelay = 10000, fixedDelay = 5000)
    public void produce() {
        StarshipDto dto = new StarshipDto();
        dto.setName("Name_" + new Random().nextInt());
        dto.setField("Field_" + new Random().nextInt());
        dto.setCount(new Random().nextInt(200));
        log.info("Sending {}", dto);
        kafkaTemplate.send("server.starship", dto);
    }
}
