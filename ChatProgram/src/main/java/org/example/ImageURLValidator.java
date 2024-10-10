package org.example;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageURLValidator {
    public static boolean isValidImageUrl(String url) {
        String regex = "https?://.*\\.(?:png|jpg|webp)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
