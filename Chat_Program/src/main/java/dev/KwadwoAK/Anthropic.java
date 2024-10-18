package dev.KwadwoAK;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.anthropic.AnthropicChatModel;
import dev.langchain4j.model.output.Response;

import static dev.langchain4j.model.anthropic.AnthropicChatModelName.CLAUDE_3_5_SONNET_20240620;

public class Anthropic {
    private final String APIKEY = System.getenv("ANTHROPIC_API_KEY");
    private final String MODEL_ENDPOINT = "https://api.anthropic.com/v1/models";

    AnthropicChatModel model = AnthropicChatModel.builder()
            .apiKey(APIKEY)
            .modelName(CLAUDE_3_5_SONNET_20240620)
            .build();


    public String ChatwithString(String message) {
        return model.generate(message);
    }

    public String visionChat(String imageUrl) {
        Response<AiMessage> response = model.generate(
                UserMessage.from(ImageContent.from(imageUrl),
                        TextContent.from("What do you see in this image?")
                )
        );
        return response.content().text();
    }


}
