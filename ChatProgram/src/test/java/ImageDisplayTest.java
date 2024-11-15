import dev.KwadwoAK.GPT;
import dev.KwadwoAK.Windows.ImageDisplay;

public class ImageDisplayTest {

        public static void main(String[] args) {
            GPT gpt = new GPT();
            //Create a new ImageDisplay object
            new ImageDisplay(gpt.ImageGeneration("A beautiful sunset over the ocean"));

        }
}
