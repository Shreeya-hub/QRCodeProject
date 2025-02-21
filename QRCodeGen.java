import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.FileSystems;

class QRCode {
    void generate(String text) throws Exception {
        int size = 300;
        BitMatrix matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, size, size);
        Path path = FileSystems.getDefault().getPath("QRCode.png");
        MatrixToImageWriter.writeToPath(matrix, "PNG", path);
        System.out.println("QR Code generated: QRCode.png");
    }
}

public class QRCodeGen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text for QR Code: ");
        String text = sc.nextLine();
        sc.close();

        QRCode qr = new QRCode();
        try {
            qr.generate(text);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
