package ma.ehtp.projet_geoinfo.custom;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Base64ToPdfConverter {

    public static void convertBase64ToPdf(String base64String, String outputFolderPath, String outputFileName) throws IOException {
        byte[] pdfBytes = Base64.getDecoder().decode(base64String);

        Path outputPath = Paths.get(outputFolderPath, outputFileName);

        try (FileOutputStream fos = new FileOutputStream(outputPath.toFile())) {
            fos.write(pdfBytes);
            System.out.println("PDF saved to: " + outputPath.toString());
        }
    }

    public static void main(String[] args) {
        try {
            PdfToBase64Converter pdfToBase64Converter = new PdfToBase64Converter();
            String base64String  = pdfToBase64Converter.convertPdfToBase64("C:\\Users\\elazi\\Downloads\\Z643198.pdf");
            String outputFolderPath = "C:\\Users\\elazi\\Downloads";
            String outputFileName = "output.pdf";

            convertBase64ToPdf(base64String, outputFolderPath, outputFileName);
            System.out.println("Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
