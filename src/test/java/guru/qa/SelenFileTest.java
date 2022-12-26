package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;



public class SelenFileTest  {


    @Test
    void testPdf() throws Exception{
        ZipFile zif = new ZipFile("src/test/resources/zipfile.zip");
        Map<String, byte[]> map = new HashMap<>();
        Enumeration <? extends ZipEntry> entries = zif.entries();
            while (entries.hasMoreElements()){
                ZipEntry entry = (ZipEntry) entries.nextElement();
                try(InputStream is = zif.getInputStream(entry)){
                        map.put(entry.toString(), is.readAllBytes());
                }
            }
            PDF pdf = new PDF(map.get("sample.pdf"));
            assertThat(pdf.text).contains("Mechanics");
            XLS xls = new XLS(map.get("file_example_XLS_50.xls"));
            assertThat(xls.excel.getSheetAt(0).getRow(2).getCell(1).getStringCellValue()).contains("Mara");
            String str = new String(map.get("biostats.csv"));
            assertThat(str).contains("Alex");

    }


}
