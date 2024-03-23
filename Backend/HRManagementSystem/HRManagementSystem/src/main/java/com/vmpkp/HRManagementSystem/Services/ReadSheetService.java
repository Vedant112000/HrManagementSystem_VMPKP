package com.vmpkp.HRManagementSystem.Services;

import com.vmpkp.HRManagementSystem.Models.Attendance;
import com.vmpkp.HRManagementSystem.Models.Employee;
import com.vmpkp.HRManagementSystem.Repository.AttendanceRepository;
import com.vmpkp.HRManagementSystem.Repository.EmployeeRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ReadSheetService {


    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public ReadSheetService(AttendanceRepository attendanceRepository, EmployeeRepository employeeRepository) {
        this.attendanceRepository = attendanceRepository;
        this.employeeRepository = employeeRepository;
    }

    LocalDate date = LocalDate.now();

    public String upload(MultipartFile file) throws IOException{


        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());

        // to get the sheet available at index 0
        Sheet sheet =  workbook.getSheetAt(0);

        //To convert value of cell into string format
        DataFormatter dataFormatter = new DataFormatter();

        List<Attendance> attendanceList = new ArrayList<>();

        Iterator<Row> rowIterator = sheet.rowIterator();
        int j = 0;
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();


            //to skip first row

            if(j == 0){
                j++;
                continue;
            }

            Iterator<Cell> cellIterator = row.cellIterator();
            int i = 0;

            Long emp_id = 0L;
            double present_days = 0;


            while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();

                String cellValue = dataFormatter.formatCellValue(cell);

                //get and store employeeId

                 if(i == 0 && j > 0){
                     emp_id = Long.parseLong(cellValue);
                 }

                //to store totalNo of days present for specific row ex. for single employee

                    if(cellValue.equals("p") || cellValue.equals("P")){
                        present_days += 1;
                    }
                    else if(cellValue.equals("h") || cellValue.equals("H")){
                        present_days = present_days + 0.5;
                    }

//                System.out.print("row: "+j+" cell: "+i+" "+cellValue + "\t");
                i++;
            }

            Employee employee = employeeRepository.findById(emp_id).orElseThrow(() -> new IllegalArgumentException("Employee not found with ID"));

            Attendance attendanceTemp = new Attendance();
            attendanceTemp.setEmployee(employee);
            attendanceTemp.setDate(date);
            attendanceTemp.setDays(present_days);
            attendanceList.add(attendanceTemp);

            j++;
            System.out.println();
        }

        attendanceRepository.saveAll(attendanceList);

        return "stored all present days in database for each employee";
    }
}
