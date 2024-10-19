import dev.KwadwoAK.ImageToBase64;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.anthropic.AnthropicChatModel;
import dev.langchain4j.model.output.Response;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static dev.langchain4j.model.anthropic.AnthropicChatModelName.CLAUDE_3_5_SONNET_20240620;

public class AnthropicTestPrompt {
    private final String APIKEY = System.getenv("ANTHROPIC_API_KEY");

    private final AnthropicChatModel model = AnthropicChatModel.builder()
            .apiKey(APIKEY)
            .modelName(CLAUDE_3_5_SONNET_20240620)
            .build();

    @Test
    void chatWithString() {
        String answer = model.generate("""
                name the fastest vehicle in the world currently?
                """);
        System.out.println(answer);
    }


    @Test
    void visionChat() throws IOException, InterruptedException {
        String imageUrl = "https://commondatastorage.googleapis.com/codeskulptor-assets/lathrop/explosion_alpha3.png";
        String base64 = ImageToBase64.DownloadImageAndConvertToBase64(imageUrl);
        Response<AiMessage> response = model.generate(
                UserMessage.from(
                        ImageContent.from(base64, "image/png/jpeg/webp"),
                        TextContent.from("What do you see?")
                )
        );
        System.out.println(response.content().text());
    }
}
