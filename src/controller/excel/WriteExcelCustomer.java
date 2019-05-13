/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.excel;

import Model.Customer;
import controller.DAO.CustomerDAO;
import java.awt.print.Book;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Quang Thái
 */
public class WriteExcelCustomer {

    public static final int COLUMN_INDEX_ID = 0;
    public static final int COLUMN_INDEX_FULLNAME = 1;
    public static final int COLUMN_INDEX_ADDRESS = 2;
    public static final int COLUMN_INDEX_PHONENUMBER = 3;
    public static final int COLUMN_INDEX_IDCARD = 4;
    private static CellStyle cellStyleFormatNumber = null;

    public static void main(String[] args) throws IOException {
        final String excelFilePath = "C:\\Users\\locxn\\Desktop\\SQA\\CustomersTest.xlsx";
        CustomerDAO dao = new CustomerDAO();
        writeExcel(dao.getListCustomer(), excelFilePath);

    }

    public static void writeExcel(List<Customer> customers, String excelFilePath) throws IOException {
        // Create Workbook
        Workbook workbook = getWorkbook(excelFilePath);

        // Create sheet
        Sheet sheet = workbook.createSheet("Customers"); // Create sheet with sheet name

        int rowIndex = 1;

        // Write header
        writeHeader(sheet, rowIndex);

        // Write data
        rowIndex++;
        for (Customer customer : customers) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(customer, row);
            rowIndex++;
        }

        // Write footer
        writeFooter(sheet, rowIndex);

        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(1).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);

        // Create file excel
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }

    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;
        workbook = new XSSFWorkbook();

//        if (excelFilePath.endsWith("xlsx")) {
//            workbook = new XSSFWorkbook();
//        } else if (excelFilePath.endsWith("xls")) {
//            workbook = new HSSFWorkbook();
//        } else {
//            throw new IllegalArgumentException("The specified file is not Excel file");
//        }
        return workbook;
    }

    private static void writeHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);

        // Create row
        Row row = sheet.createRow(rowIndex);

        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Id");

        cell = row.createCell(COLUMN_INDEX_FULLNAME);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Fullname");

        cell = row.createCell(COLUMN_INDEX_ADDRESS);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Address");

        cell = row.createCell(COLUMN_INDEX_PHONENUMBER);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("PhoneNumber");

        cell = row.createCell(COLUMN_INDEX_IDCARD);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("ID card");
    }

    private static void writeBook(Customer customer, Row row) {

        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workbook.createDataFormat();
            // short format = df.getFormat("#,##0");

            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }

        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellValue(customer.getId());

        cell = row.createCell(COLUMN_INDEX_FULLNAME);
        cell.setCellValue(customer.getFullName());

        cell = row.createCell(COLUMN_INDEX_ADDRESS);
        cell.setCellValue(customer.getAddress());
        cell.setCellStyle(cellStyleFormatNumber);

        cell = row.createCell(COLUMN_INDEX_PHONENUMBER);
        cell.setCellValue(customer.getPhoneNumber());

        // Create cell formula
        // totalMoney = price * quantity
        cell = row.createCell(COLUMN_INDEX_IDCARD);
        cell.setCellValue(customer.getIdCard());
        cell.setCellStyle(cellStyleFormatNumber);
        int currentRow = row.getRowNum() + 1;

    }

    private static void writeFooter(Sheet sheet, int rowIndex) {

    }

    private static void autosizeColumn(Sheet sheet, int numberOfColumn) {

        for (int columnIndex = 0; columnIndex < numberOfColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {

        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }

    private static CellStyle createStyleForHeader(Sheet sheet) {

        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

}
