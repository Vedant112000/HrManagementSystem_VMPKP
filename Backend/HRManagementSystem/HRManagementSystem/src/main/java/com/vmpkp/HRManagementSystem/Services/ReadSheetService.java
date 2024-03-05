package com.vmpkp.HRManagementSystem.Services;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Iterator;

@Service
public class ReadSheetService {

    public String upload(MultipartFile file) throws IOException{


        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());

        // to get the sheet available at index 0
        Sheet sheet =  workbook.getSheetAt(0);

        //To convert value of cell into string format
        DataFormatter dataFormatter = new DataFormatter();

        Iterator<Row> rowIterator = sheet.rowIterator();
        int j = 0;
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            int i = 0;
            while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();

                String cellValue = dataFormatter.formatCellValue(cell);

                System.out.print("row: "+j+" cell: "+i+" "+cellValue + "\t");
                i++;
            }
            j++;
            System.out.println();
        }

        return "Ok";
    }
}
