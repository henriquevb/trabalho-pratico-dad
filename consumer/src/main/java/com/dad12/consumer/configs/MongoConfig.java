package com.dad12.consumer.configs;

import com.dad12.consumer.repositories.PedidoRepository;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableMongoRepositories(basePackageClasses = PedidoRepository.class)
public class MongoConfig {

    @Bean
    MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "test-rabbit");
    }

    @Bean
    MongoClient mongoClient() {
        ConnectionString connectionString
                = new ConnectionString("mongodb://test:senha@localhost/?directConnection=true&serverSelectionTimeoutMS=2000");

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .applyToConnectionPoolSettings(builder -> builder.maxSize(20)
                        .minSize(10)
                        .maxWaitTime(2000, TimeUnit.MILLISECONDS)
                        .build())
                .build();

        return MongoClients.create(mongoClientSettings);
    }
}