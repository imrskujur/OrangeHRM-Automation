package utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;

public class PDFUtil {
    public static void saveOrderConfirmation(String confirmationText) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("screenshots/order_confirmation.pdf"));
        document.open();
        document.add(new Paragraph("Order Confirmation"));
        document.add(new Paragraph(confirmationText));
        document.close();
    }
}