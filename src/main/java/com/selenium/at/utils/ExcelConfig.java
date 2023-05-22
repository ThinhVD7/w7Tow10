package com.selenium.at.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelConfig {
    private XSSFWorkbook wb;
    private XSSFSheet sh;
    private FileInputStream fileIn;
    public ExcelConfig(String excelpath){
        try{
            File file = new File(excelpath);
            fileIn = new FileInputStream(file);
            wb = new XSSFWorkbook(fileIn);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public int getNumRow(){
        sh = wb.getSheetAt(0);
        return sh.getLastRowNum();
    }
    public int getColNum(){
        sh = wb.getSheetAt(0);
        return sh.getRow(0).getLastCellNum();
    }
    public String getDataValue(int rowNum, int colNum){
        sh = wb.getSheetAt(0);
        DataFormatter df = new DataFormatter();
        try{
            return df.formatCellValue(sh.getRow(rowNum).getCell(colNum));
        } catch (NullPointerException npe){
            return "";
        }
    }
    public Object[][] data(){
        int rowNum = getNumRow();
        int colNum = getColNum();
        Object[][] obj = new Object[rowNum][colNum];
        int currentRow = 0;
        for(int i=1 ; i<= rowNum ; i++){
            for (int j=0 ; j<colNum ; j ++){
                obj[currentRow][j] = getDataValue(i,j);
            }
            currentRow++;
        }
        return obj;
    }
}
