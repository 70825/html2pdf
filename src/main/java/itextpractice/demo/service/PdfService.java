package itextpractice.demo.service;

import com.lowagie.text.DocumentException;

import java.io.ByteArrayInputStream;

public interface PdfService {
    ByteArrayInputStream convertHtmlToPdf(String htmlContent) throws DocumentException;

    String htmlToXhtml(String html);
}
