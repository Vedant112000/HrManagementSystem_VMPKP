package com.vmpkp.HRManagementSystem.Services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.vmpkp.HRManagementSystem.DTO.PaySlipDto;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;


@Service
public class GeneratePdfService {

    public static byte[] generatePdf(PaySlipDto payslipData) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, baos);
        document.open();

        // Add content to the PDF
        addContentToPdf(document, payslipData);

        document.close();
        return baos.toByteArray();
    }

    private static void addContentToPdf(Document document, PaySlipDto payslipData) throws DocumentException {
        // Employee ID box
        PdfPTable idTable = new PdfPTable(1);
        idTable.setWidthPercentage(20);
        idTable.setHorizontalAlignment(Element.ALIGN_LEFT);
        PdfPCell idCell = new PdfPCell(new Phrase("Employee ID:" +payslipData.getEmployeeId()));
        idCell.setBorder(Rectangle.BOX);
        idTable.addCell(idCell);
        document.add(idTable);

        // Employee name and days present
        PdfPTable nameAndDaysTable = new PdfPTable(1);
        nameAndDaysTable.setWidthPercentage(80);
        nameAndDaysTable.setHorizontalAlignment(Element.ALIGN_RIGHT);
        PdfPCell nameAndDaysCell = new PdfPCell(new Phrase("Name: " + payslipData.getFirstName() + " " + payslipData.getLastName() +
                "\nDays Present: " + payslipData.getDays()));
        nameAndDaysCell.setBorder(Rectangle.NO_BORDER);
        nameAndDaysTable.addCell(nameAndDaysCell);
        document.add(nameAndDaysTable);

        // Add table for salary details
        PdfPTable salaryTable = new PdfPTable(3);
        salaryTable.setWidthPercentage(100);
        salaryTable.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell salaryCell1 = new PdfPCell(new Phrase("Salary Amount"));
        salaryCell1.setBorder(Rectangle.BOX);
        salaryTable.addCell(salaryCell1);
        PdfPCell salaryCell2 = new PdfPCell(new Phrase("Deduction"));
        salaryCell2.setBorder(Rectangle.BOX);
        salaryTable.addCell(salaryCell2);
        PdfPCell salaryCell3 = new PdfPCell(new Phrase("Net Payable"));
        salaryCell3.setBorder(Rectangle.BOX);
        salaryTable.addCell(salaryCell3);

        PdfPCell salaryValueCell1 = new PdfPCell(new Phrase(payslipData.getSalaryAmount().toString()));
        salaryValueCell1.setBorder(Rectangle.BOX);
        salaryTable.addCell(salaryValueCell1);
        PdfPCell salaryValueCell2 = new PdfPCell(new Phrase(Integer.toString(payslipData.getDeduction())));
        salaryValueCell2.setBorder(Rectangle.BOX);
        salaryTable.addCell(salaryValueCell2);
        PdfPCell salaryValueCell3 = new PdfPCell(new Phrase(Double.toString(payslipData.getPayable())));
        salaryValueCell3.setBorder(Rectangle.BOX);
        salaryTable.addCell(salaryValueCell3);

        document.add(salaryTable);
    }
}
