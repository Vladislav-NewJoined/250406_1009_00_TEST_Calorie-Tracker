package org.example.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ExcelExportService {

    // Метод для экспорта данных в Excel
    public void exportToExcel() throws SQLException, IOException {
        // Генерация имени файла с датой
        String fileName = "calorieTrackerData_" +
                LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) +
                ".xlsx";

        // Подключение к базе данных H2
        String jdbcUrl = "jdbc:h2:file:./calorieTrackerDB";
        String username = "sa";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Workbook workbook = new XSSFWorkbook()) {

            // Создаем лист в Excel
            Sheet sheet = workbook.createSheet("Calorie Data");

            // Выполняем запрос к базе данных
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MEAL");

            // Заголовки таблицы
            Row headerRow = sheet.createRow(0);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                Cell cell = headerRow.createCell(i - 1);
                cell.setCellValue(metaData.getColumnName(i));
            }

            // Данные из таблицы
            int rowIndex = 1;
            while (resultSet.next()) {
                Row row = sheet.createRow(rowIndex++);
                for (int i = 1; i <= columnCount; i++) {
                    Cell cell = row.createCell(i - 1);
                    cell.setCellValue(resultSet.getString(i));
                }
            }

            // Сохраняем файл Excel
            try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
                workbook.write(fileOut);
            }
        }
    }
}