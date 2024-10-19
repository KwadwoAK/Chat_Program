import dev.KwadwoAK.ImageToBase64;

import java.io.IOException;

public class ImageToBase64Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        String imageUrl = "https://www.gstatic.com/webp/gallery/1.sm.webp"; // Replace with your image URL
        String base64Image = ImageToBase64.DownloadImageAndConvertToBase64(imageUrl);
        System.out.println("Base64 Image String: " + base64Image);
    }
}
