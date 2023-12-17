package ma.ehtp.projet_geoinfo.custom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class PdfToBase64Converter {

    public static String convertPdfToBase64(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] pdfBytes = Files.readAllBytes(path);

        // Convert the PDF bytes to a Base64 string
        byte[] base64Bytes = Base64.getEncoder().encode(pdfBytes);
        return new String(base64Bytes);
    }

    public static void main(String[] args) {
        try {
            String filePath = "C:\\Users\\elazi\\Downloads\\Z643198.pdf";
            String base64String = convertPdfToBase64(filePath);
            System.out.println("Base64 String: " + base64String);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
