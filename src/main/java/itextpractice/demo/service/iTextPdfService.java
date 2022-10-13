package itextpractice.demo.service;

import java.io.ByteArrayInputStream;

public interface iTextPdfService {
    ByteArrayInputStream createPdf(String html);
}
