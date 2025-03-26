package org.example.util;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportToExcel {

    public static void exportTableToExcel(Connection connection, String tableName, String fileName) throws SQLException, IOException {
        File file = new File(fileName);

        // Проверяем, доступен ли файл
        if (file.exists() && !FileUtils.isFileAvailable(file)) {
            throw new IOException("Файл занят другим процессом: " + fileName);
        }

        // Удаляем существующий файл, если он есть
        if (file.exists()) {
            if (!file.delete()) {
                throw new IOException("Не удалось удалить существующий файл: " + fileName);
            }
        }

        String query = "SELECT * FROM " + tableName;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Пользователи"); // Название листа на кириллице

            // Заголовки колонок на кириллице
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Имя");
            headerRow.createCell(2).setCellValue("Email");
            headerRow.createCell(3).setCellValue("Возраст");
            headerRow.createCell(4).setCellValue("Вес (кг)");
            headerRow.createCell(5).setCellValue("Рост (см)");
            headerRow.createCell(6).setCellValue("Цель");
            headerRow.createCell(7).setCellValue("Суточная норма калорий");

            // Данные
            int rowIndex = 1;
            while (resultSet.next()) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(resultSet.getLong("id"));
                row.createCell(1).setCellValue(resultSet.getString("name"));
                row.createCell(2).setCellValue(resultSet.getString("email"));
                row.createCell(3).setCellValue(resultSet.getInt("age"));
                row.createCell(4).setCellValue(resultSet.getDouble("weight"));
                row.createCell(5).setCellValue(resultSet.getDouble("height"));
                row.createCell(6).setCellValue(resultSet.getString("goal"));
                row.createCell(7).setCellValue(resultSet.getDouble("dailyCalorieIntake"));
            }

            // Сохранение в файл
            try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
                workbook.write(fileOut);
            }
            workbook.close();
        }
    }}
