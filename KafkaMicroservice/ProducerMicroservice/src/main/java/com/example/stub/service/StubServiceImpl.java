package com.example.stub.service;

import com.example.stub.service.dto.StubDTO;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class StubServiceImpl implements StubService{

    private KafkaTemplate<String, StubDTO> kafkaTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public StubServiceImpl(KafkaTemplate<String, StubDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createdMassage(StubDTO stubDTO) throws ExecutionException, InterruptedException {

        String key = UUID.randomUUID().toString();


        //Отправляем сообщения в асинхронном режиме, ждем ответа от кафки успешно прошла запись или с ошибкой
        CompletableFuture<SendResult<String, StubDTO>> future = kafkaTemplate.send("product-created-events-topic", key, stubDTO);
        future.whenComplete((result, exception) -> {
            if (exception != null) {
                LOGGER.error("Failed to send message: {}", exception.getMessage());
            } else {
                LOGGER.info("Message sent successfully: {}", result.getRecordMetadata());
            }
        });

        //Если хотим сделать синхронный режим (простой вариант)
        //future.join();


        /*
        //Синхронный режим, правильный вариант
        SendResult<String, StubDTO>  result = kafkaTemplate
                .send("product-created-events-topic", key, stubDTO).get();
        LOGGER.info("Message sent successfully: {}", result.getRecordMetadata());
        LOGGER.info("Return: {}", key);

         */

        return key;
    }
}
