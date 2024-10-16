package dev.KwadwoAK;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import dev.langchain4j.model.output.Response;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class GPT {
    private final static String MODEL_ENDPOINT = "https://api.openai.com/v1/models";
    private final static String APIKEY = System.getenv("OPENAI_API_KEY");
    private final ChatLanguageModel chatModel = OpenAiChatModel.builder()
            .apiKey(APIKEY)
            .modelName(OpenAiChatModelName.GPT_4_O_MINI)
            .build();

    public record Model(String id, Long created) {
    }

    public record ModelList(List<Model> data) {
    }

    // Gson parser to convert JSON to Java objects and back
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();


    /**
     * Fetches the list of available models from the OpenAI API.
     *
     * @return a ModelList object containing the list of models.
     * @throws RuntimeException if there is an error during the HTTP request.
     */
    public ModelList getModels() {
        try (var client = HttpClient.newHttpClient()) {
            // Create an HTTP Request, whose default access method is GET
            var request = HttpRequest.newBuilder()
                    // Parse the URL from the given string
                    .uri(URI.create(MODEL_ENDPOINT))
                    // Set the Authorization header to the API key
                    .header("Authorization", "Bearer " + APIKEY)
                    .header("Accept", "application/json")
                    .build();
            // Send the request and get the response (blocking query)
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("HTTP error: " + response.statusCode());
            }
            // Extract the body from the response and parse it into a ModelList object
            return gson.fromJson(response.body(), ModelList.class);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
    /**
     * Generates a response from the chat model using a String text message.
     *
     * @param message the input text message.
     */
    public String chatWithString(String message) {
        return chatModel.generate(message);

    }


    /**
     * Generates a response from the chat model using an image URL describing the contents of the image.
     * OpenAI vision chat can only take png, jpg, or webp images so images will be validated before sending.
     * @param imageUrl the URL of the image to analyze.
     */
    public String visionChat(String imageUrl) {
        Response<AiMessage> response = chatModel.generate(
                UserMessage.from(
                        ImageContent.from(imageUrl),
                        TextContent.from("What do you see?")
                )
        );
        return response.content().text();
    }
}

