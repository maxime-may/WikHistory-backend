package com.backend.util;

import com.backend.model.HistoryEvent;
import com.backend.repository.HistoryEventRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@Profile("test")
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(HistoryEventRepository repository, ObjectMapper mapper) {
        return args -> {
            InputStream inputStream = getClass().getResourceAsStream("/data.json");
            if (inputStream != null) {
                List<HistoryEvent> events = mapper.readValue(inputStream, new TypeReference<>() {});
                repository.saveAll(events);
                System.out.println("✅ Test data inserted!");
            } else {
                System.out.println("⚠️ JSON file not found");
            }
        };
    }
}
