package com.example.stub.service;

import com.example.stub.service.dto.StubDTO;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StubServiceImpl implements StubService{

    private KafkaTemplate<String, StubDTO> kafkaTemplate;

    public StubServiceImpl(KafkaTemplate<String, StubDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createdMassage(StubDTO stubDTO) {

        String key = UUID.randomUUID().toString();

        kafkaTemplate.send("product-created-events-topic", key, stubDTO);

        return key;
    }
}
