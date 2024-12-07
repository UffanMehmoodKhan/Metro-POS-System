package org.example.metro_pos.Controllers.Cashier.Dashboard.Transaction;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ExcelService {

    private static final String[] COLUMN_HEADERS = {"Product Code", "Product Name", "Category", "Price", "Quantity"};
    private static final String FILE_PATH = "transactions_";
    private static final String FILE_EXTENSION = ".xlsx";

    public void writeTransactionsToExcel(List<CashierTransactionRequest.ProductTransaction> transactions) throws IOException {
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String filePath = FILE_PATH + currentDate + FILE_EXTENSION;

        Workbook workbook;
        Sheet sheet;
        int rowNum;

        File file = new File(filePath);
        double totalSum = 0;
        int totalProducts = 0;

        if (file.exists()) {
            workbook = new XSSFWorkbook(new FileInputStream(file));
            sheet = workbook.getSheetAt(0);
            rowNum = sheet.getLastRowNum();

            // Read existing totals
            Row lastRow = sheet.getRow(rowNum);
            if (lastRow != null && "Total".equals(lastRow.getCell(0).getStringCellValue())) {
                totalSum = lastRow.getCell(3).getNumericCellValue();
                totalProducts = (int) lastRow.getCell(4).getNumericCellValue();
                rowNum--; // Remove the total row
            }
        } else {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Transactions");
            rowNum = 0;

            // Create header row
            Row headerRow = sheet.createRow(rowNum++);
            for (int i = 0; i < COLUMN_HEADERS.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(COLUMN_HEADERS[i]);
            }
        }

        // Create data rows
        for (CashierTransactionRequest.ProductTransaction transaction : transactions) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(transaction.getProductCode());
            row.createCell(1).setCellValue(transaction.getProductName());
            row.createCell(2).setCellValue(transaction.getCategory());
            row.createCell(3).setCellValue(transaction.getPrice());
            row.createCell(4).setCellValue(transaction.getQuantity());

            totalSum += transaction.getPrice() * transaction.getQuantity();
            totalProducts += transaction.getQuantity();
        }

        // Add total sum and total products sold
        Row totalRow = sheet.createRow(rowNum++);
        totalRow.createCell(0).setCellValue("Total");
        totalRow.createCell(3).setCellValue(totalSum);
        totalRow.createCell(4).setCellValue(totalProducts);

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }

        workbook.close();

        // Set file to read and write
        Path path = Paths.get(filePath);
        Files.setAttribute(path, "dos:readonly", false);
    }
}