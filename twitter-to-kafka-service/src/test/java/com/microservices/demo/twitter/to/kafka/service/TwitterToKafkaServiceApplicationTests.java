package com.microservices.demo.twitter.to.kafka.service;

import com.microservices.demo.kafka.admin.client.KafkaAdminClient;
import com.microservices.demo.kafka.avro.model.TwitterAvroModel;
import com.microservices.demo.kafka.producer.config.service.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.mockito.Mockito.doNothing;

@SpringBootTest(classes = {MockSerdeConfig.class}, properties = {"spring.main.allow-bean-definition-overriding=true"})
@ActiveProfiles("test")
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
public class TwitterToKafkaServiceApplicationTests {

    @Autowired
    private KafkaProducer<Long, TwitterAvroModel> kafkaProducer;

    @MockBean
    private KafkaAdminClient kafkaAdminClient;

    @Test
    public void testKafka() throws InterruptedException {

       doNothing().when(kafkaAdminClient).checkSchemaRegistry();

        TwitterAvroModel twitterAvroModel = TwitterAvroModel.newBuilder()
                .setId(12345L)
                .setUserId(1234L)
                .setCreatedAt(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC))
                .setText("TEST")
                .build();
        kafkaProducer.send("twitter-topic", twitterAvroModel.getUserId(), twitterAvroModel);
        Thread.sleep(20000L);
    }
}
