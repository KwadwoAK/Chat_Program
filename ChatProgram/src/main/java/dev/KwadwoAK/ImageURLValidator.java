package dev.KwadwoAK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageURLValidator {

    //Validates an image URL making sure that it is a valid URL and that it ends with a valid image extension
    public static boolean isValidImageUrl(String url) {
        String regex = "https?://.*\\.(?:png|jpg|webp)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
