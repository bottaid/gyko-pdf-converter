package it.bottai.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.EventType;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.data.IEventData;
import com.itextpdf.kernel.pdf.canvas.parser.data.TextRenderInfo;
import com.itextpdf.kernel.pdf.canvas.parser.filter.TextRegionEventFilter;
import com.itextpdf.kernel.pdf.canvas.parser.listener.FilteredEventListener;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;


public class LettoreTabellaEsercizio {

    public static final String SRC = "./src/main/resources/pdfs/rom_nomefile.pdf";

    public ArrayList<String> parsePdf() throws IOException {
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC));
        Rectangle rect = new Rectangle(36, 750, 523, 56);

        FontFilter fontFilter = new FontFilter(rect);
        FilteredEventListener listener = new FilteredEventListener();
        LocationTextExtractionStrategy extractionStrategy = listener.attachEventListener(new LocationTextExtractionStrategy(), fontFilter);
        PdfCanvasProcessor parser = new PdfCanvasProcessor(extractionStrategy);
        parser.processPageContent(pdfDoc.getPage(2));


        String actualText = extractionStrategy.getResultantText();
        ArrayList<String> righeDocumento = new ArrayList<String>(Arrays.asList(actualText.split("\n")));

        pdfDoc.close();
        return righeDocumento;
    }
}
