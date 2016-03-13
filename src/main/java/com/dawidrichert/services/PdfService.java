package com.dawidrichert.services;

import com.dawidrichert.models.PaymentsScheduleItem;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PdfService {

    private static final String fileName = "Harmonogram";
    private static final String[] columns = { "Nr raty", "Kwota Kapitału", "Kwota odsetek", "Opłaty stałe", "Całkowita kwota raty"};
    private static final float[] columnWidths = { 1, 2f, 2f, 2f, 3f };
    private static final float marginLeft = 0;
    private static final float marginTop = 30;
    private static final float marginRight = 0;
    private static final float marginBottom = 30;

    private static Font font;

    public PdfService() {
        try {
            BaseFont baseFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
            font = new Font(baseFont, 12, Font.NORMAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateDocument(HttpServletResponse resp, List<PaymentsScheduleItem> paymentsScheduleItems) {
        Document document = new Document(PageSize.A4, marginLeft, marginRight, marginTop, marginBottom);
        try {
            resp.setContentType("application/pdf");
            resp.setHeader("content-disposition","attachment; filename="+ fileName + ".pdf");
            PdfWriter.getInstance(document, resp.getOutputStream());
            document.open();

            PdfPTable table = generateTable(paymentsScheduleItems);

            document.add(table);
        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
    }

    private PdfPTable generateTable(List<PaymentsScheduleItem> paymentsScheduleItems) throws DocumentException {
        PdfPTable table = new PdfPTable(columns.length);
        for (String columnName : columns) {
            table.addCell(headerCell(columnName));
        }

        table.setHeaderRows(1);
        table.setWidths(columnWidths);

        for(PaymentsScheduleItem item : paymentsScheduleItems) {
            table.addCell(String.valueOf(item.getInstallmentNumber()));
            table.addCell(String.format("%.2f", item.getCapitalAmount()));
            table.addCell(String.format("%.2f", item.getInterestAmount()));
            table.addCell(String.format("%.2f", item.getFixedFee()));
            table.addCell(String.format("%.2f", item.getTotalPaymentsAmount()));
        }
        return table;
    }

    private PdfPCell headerCell(String text) {
        PdfPCell cell = new PdfPCell(new Paragraph(text, font));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setFixedHeight(30);
        return cell;
    }
}
