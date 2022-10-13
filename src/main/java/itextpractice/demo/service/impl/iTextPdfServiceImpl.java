package itextpractice.demo.service.impl;


import com.itextpdf.html2pdf.HtmlConverter;
import itextpractice.demo.service.iTextPdfService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class iTextPdfServiceImpl implements iTextPdfService {

    @Override
    public ByteArrayInputStream createPdf(String html) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(html, outputStream);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        return inputStream;
    }

}
