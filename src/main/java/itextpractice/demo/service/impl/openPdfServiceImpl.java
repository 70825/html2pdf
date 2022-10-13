package itextpractice.demo.service.impl;

import com.lowagie.text.DocumentException;
import itextpractice.demo.service.openPdfService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class openPdfServiceImpl implements openPdfService {

    @Override
    public ByteArrayInputStream convertHtmlToPdf(String htmlContent) throws DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        String html = htmlToXhtml(htmlContent);
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream, false);
        renderer.finishPDF();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        return inputStream;
    }

    @Override
    public String htmlToXhtml(String html) {
        Document document = Jsoup.parse(html);
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        return document.html();
    }
}
