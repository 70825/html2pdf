package itextpractice.demo.controller;

import com.lowagie.text.DocumentException;
import itextpractice.demo.service.iTextPdfService;
import itextpractice.demo.service.openPdfService;
import org.apache.pdfbox.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
public class PdfController {

    @Autowired
    private openPdfService openPdfService;

    @Autowired
    private iTextPdfService iTextPdfService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/generatePdfFileUsingOpenPDF")
    public void generatePdfFile(HttpServletResponse response, String contentOpenPDF) throws IOException, DocumentException {
        ByteArrayInputStream byteArrayInputStream = openPdfService.convertHtmlToPdf(contentOpenPDF);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=file.pdf");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());
    }

    @PostMapping("/generatePdfFileUsingIText")
    public void generatePdfFileUsingIText(HttpServletResponse response, String contentIText) throws IOException {
        ByteArrayInputStream byteArrayInputStream = iTextPdfService.createPdf(contentIText);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=file.pdf");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());
    }
}
