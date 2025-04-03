package org.example.config;

import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Удаляем все старые строки
        userRepository.deleteAllUsers();

        // Добавляем новую строку
        userRepository.addUser("Иван Иванов", "ivan@example.com", "LOSE_WEIGHT", 180.0, 80.0, "MODERATELY_ACTIVE", "MALE");
    }
}
