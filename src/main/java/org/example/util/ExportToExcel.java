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

        String query = "SELECT * FROM \"" + tableName + "\"";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(tableName);

            // Заголовки колонок
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("ИМЯ");
            headerRow.createCell(2).setCellValue("EMAIL");
            headerRow.createCell(3).setCellValue("ЦЕЛЬ");
            headerRow.createCell(4).setCellValue("рост (см)");
            headerRow.createCell(5).setCellValue("вес (кг)");
            headerRow.createCell(6).setCellValue("уровень активности");
            headerRow.createCell(7).setCellValue("ПОЛ");

            // Данные
            int rowIndex = 1;
            while (resultSet.next()) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(resultSet.getLong("ID"));
                row.createCell(1).setCellValue(resultSet.getString("ИМЯ"));
                row.createCell(2).setCellValue(resultSet.getString("EMAIL"));
                row.createCell(3).setCellValue(resultSet.getString("ЦЕЛЬ"));
                row.createCell(4).setCellValue(resultSet.getDouble("рост (см)"));
                row.createCell(5).setCellValue(resultSet.getDouble("вес (кг)"));
                row.createCell(6).setCellValue(resultSet.getString("уровень активности"));
                row.createCell(7).setCellValue(resultSet.getString("ПОЛ"));
            }

            // Сохранение в файл
            try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
                workbook.write(fileOut);
            }
            workbook.close();
        }
    }
}
