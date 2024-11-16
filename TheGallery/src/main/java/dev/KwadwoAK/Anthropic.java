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

    AnthropicChatModel model = AnthropicChatModel.builder()
            .apiKey(APIKEY)
            .modelName(CLAUDE_3_5_SONNET_20240620)
            .build();


    public String themeBuilder(String theme) {
        return model.generate("Pretend you are a British presenter at an art gallery and you are introducing a new exhibit. The theme of the exhibit is " + theme + ".");
    }

    public String titleBuilder(String base64) {
        Response<AiMessage> response = model.generate(
                UserMessage.from(ImageContent.from(base64),
                        TextContent.from("Give a tile to this image as if it were an art piece.")
                )
        );
        return response.content().text();
    }

    public String DescribeImage(String base64) {
        Response<AiMessage> response = model.generate(
                UserMessage.from(ImageContent.from(base64),
                        TextContent.from("Describe this image as if you are a British presenter at an art Gallery showing off a new piece and is very enthusiastic about it.")
                )
        );
        return response.content().text();
    }
}
