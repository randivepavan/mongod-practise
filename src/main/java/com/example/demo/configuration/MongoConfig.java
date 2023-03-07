package com.example.demo.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient client()
    {
        final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/student");

        return MongoClients.create("mongodb://localhost:27017/student");
    }

    public MongoOperations operations()
    {
        final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/student");
        //return new MongoTemplate(MongoClients.create("mongodb://localhost:27017"),"student");
        return new MongoTemplate((MongoDatabaseFactory) MongoClients.create(MongoClientSettings.builder()
                        .applicationName("PavanRandiveApplication")
                        .applyConnectionString(connectionString)
                .build()));

    }



}
