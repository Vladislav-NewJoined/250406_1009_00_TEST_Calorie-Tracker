package org.example.service;

import org.example.util.ExportToExcel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ExcelExportService {

    public void exportToExcel() throws SQLException, IOException {
        String jdbcUrl = "jdbc:h2:file:./calorieTrackerDB";
        String username = "sa";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Экспорт таблицы Users
            ExportToExcel.exportTableToExcel(connection, "Users", "Users.xlsx");
        }
    }
}
