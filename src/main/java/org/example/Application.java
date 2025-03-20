package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
//		Сайт, где смотреть результаты: http://localhost:8080/h2-console
//		При входе на страницу: http://localhost:8080/h2-console
//		Укажите следующие параметры:
//		Saved Settings: Generic H2 (Embedded)
//		Setting Name: Generic H2 (Embedded)
//		Driver Class: org.h2.Driver
//		JDBC URL: jdbc:h2:mem:testdb
//		User Name: sa
//		Password: (оставьте поле пустым)

		SpringApplication.run(Application.class, args);
	}

}
