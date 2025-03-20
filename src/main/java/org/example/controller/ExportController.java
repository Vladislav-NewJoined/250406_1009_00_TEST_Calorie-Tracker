package org.example.controller;

import org.example.service.ExcelExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/export")
public class ExportController {

    @Autowired
    private ExcelExportService excelExportService;

    @GetMapping("/excel")
    public String exportToExcel() {
        try {
            excelExportService.exportToExcel(); // Убрали параметр fileName
            return "Файл успешно экспортирован.";
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return "Ошибка при экспорте данных: " + e.getMessage();
        }
    }
}