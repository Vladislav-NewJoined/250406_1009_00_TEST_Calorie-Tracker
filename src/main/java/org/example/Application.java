package org.example;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.service.ExcelExportService;
import org.example.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"org.example", "org.example.config"})
public class Application {
	public static void main(String[] args) {

//		Сайт-консоль, где отображается база данных и результаты обработки базы данных: http://localhost:8080/h2-console
//		При входе на страницу: http://localhost:8080/h2-console
//		Укажите следующие параметры:
//		Saved Settings: Generic H2 (Embedded)
//		Setting Name: Generic H2 (Embedded)
//		Driver Class: org.h2.Driver
//		JDBC URL: jdbc:h2:mem:testdb
//		User Name: sa
//		Password: (оставьте поле пустым)
//		После запуска главного класса база данных экспортируется
//		в таблицу Excel, в корневую папку проекта. Таблица называется: calorieTrackerData_20250320.xlsx
//		Для экспорта таблицы Excel в корневую папку проекта, зайдите  в браузере по адресу:
//		http://localhost:8080/export/excel
//		Для извлечения/просмотра данных из таблицы, например "БЛЮДА", в "H2 Console" нужно использовать следующий SQL запрос:
//		SELECT * FROM "БЛЮДА";



		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(UserService userService, UserRepository userRepository, ExcelExportService excelExportService) {
//		return args -> {
//			// Создаем тестового пользователя
//			User user = new User();
//			user.setName("Иван Иванов");
//			user.setEmail("ivan@example.com");
//			user.setAge(30);
//			user.setWeight(80);
//			user.setHeight(180);
//			user.setGoal(User.Goal.LOSE_WEIGHT);
//			user.setGender(User.Gender.MALE);
//			user.setActivityLevel(User.ActivityLevel.MODERATELY_ACTIVE);
//
//			// Сохраняем пользователя в базу данных
//			userRepository.save(user);
//
//			// Рассчитываем дневную норму калорий
//			double dailyCalories = userService.calculateDailyCalories(user);
//			String formattedCalories = String.format("%.2f", dailyCalories);
//			System.out.println("Для пользователя: " + user.getName() + ", рассчитанная дневная норма калорий: " + formattedCalories + " калорий");
//
//			// Экспорт таблицы ПОЛЬЗОВАТЕЛИ в Excel
//			try {
//				excelExportService.exportToExcel();
//				System.out.println("Таблица ПОЛЬЗОВАТЕЛИ успешно экспортирована в Excel.");
//			} catch (Exception e) {
//				System.err.println("Ошибка при экспорте таблицы в Excel: " + e.getMessage());
//			}
//		};
//	}
}