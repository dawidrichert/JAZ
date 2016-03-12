package com.dawidrichert.servlets;

import com.dawidrichert.models.CreditData;
import com.dawidrichert.models.PaymentsScheduleItem;
import com.dawidrichert.services.CreditService;
import com.dawidrichert.utils.Mapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pdf")
public class PdfServlet extends HttpServlet {

    CreditService creditService = new CreditService();

    private static BaseFont baseFont;
    private static Font font;

    public PdfServlet() throws IOException, DocumentException {
        baseFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
        font = new Font(baseFont, 12, Font.NORMAL);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreditData creditData = Mapper.mapRequestToCreditData(req);
        List<PaymentsScheduleItem> paymentsScheduleItems = creditService.calculate(creditData);
        generatePdf(resp, paymentsScheduleItems);
    }

    private void generatePdf(HttpServletResponse resp, List<PaymentsScheduleItem> paymentsScheduleItems) {
        Document document = new Document(PageSize.A4, 0, 0, 30, 30);
        try {
            resp.setContentType("application/pdf");
            resp.setHeader("content-disposition","attachment; filename="+"Harmonogram.pdf");
            PdfWriter.getInstance(document, resp.getOutputStream());
            document.open();

            PdfPTable table = new PdfPTable(5);

            table.addCell(getHeaderCell("Nr raty"));
            table.addCell(getHeaderCell("Kwota Kapitału"));
            table.addCell(getHeaderCell("Kwota odsetek"));
            table.addCell(getHeaderCell("Opłaty stałe"));
            table.addCell(getHeaderCell("Całkowita kwota raty"));

            table.setHeaderRows(1);
            table.setWidths(new float[] {1, 2f, 2f, 2f, 3f });

            for(PaymentsScheduleItem item : paymentsScheduleItems) {
                table.addCell(String.valueOf(item.getInstallmentNumber()));
                table.addCell(String.valueOf(item.getCapitalAmount()));
                table.addCell(String.valueOf(item.getInterestAmount()));
                table.addCell(String.valueOf(item.getFixedFee()));
                table.addCell(String.valueOf(item.getTotalPaymentsAmount()));
            }
            document.add(table);

        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
    }

    private PdfPCell getHeaderCell(String text) {
        PdfPCell cell = new PdfPCell(new Paragraph(text, font));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setFixedHeight(30);
        return cell;
    }
}