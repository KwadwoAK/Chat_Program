import org.example.ImageURLValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImageURLTest {
    public static void main(String[] args) {

        String pngUrl = "https://commondatastorage.googleapis.com/codeskulptor-assets/lathrop/explosion_alpha3.png";
        String jpgUrl = "https://plus.unsplash.com/premium_photo-1666672388644-2d99f3feb9f1?q=80&w=2970&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D.jpg";
        String webpUrl = "https://www.gstatic.com/webp/gallery/1.sm.webp";
        String invalidUrl = "https://example.com/image.pdf";

        //Asserts that the png image URL is valid
        assertTrue(ImageURLValidator.isValidImageUrl(pngUrl));

        //Asserts that the jpg image URL is valid
        assertTrue(ImageURLValidator.isValidImageUrl(jpgUrl));

        //Asserts that the webp image URL is valid
        assertTrue(ImageURLValidator.isValidImageUrl(webpUrl));

        //Asserts that the invalid image URL is invalid
        assertFalse(ImageURLValidator.isValidImageUrl(invalidUrl));



    }
}
