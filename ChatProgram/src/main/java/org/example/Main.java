package org.example;

import java.util.Scanner;

import static org.example.ImageURLValidator.isValidImageUrl;

public class Main {
    public static void main(String[] args) {
        int game = 0;
        while (game == 0) {
            System.out.println("Hello, Welcome to the Chat Program Which model would you like to use?");

            int choice = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("1. OpenAI Chat Model");
            System.out.println("2. Vision Chat Model");

            System.out.println("Enter your choice between 1-2: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a choice between 1-2: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();
            while (choice < 1 || choice > 2) {
                System.out.println("Invalid choice. Please enter a choice between 1-2: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid choice. Please enter a choice between 1-2: ");
                    sc.next();
                }
                choice = sc.nextInt();
                sc.nextLine();
            }

            if (choice == 1) {
                System.out.println("You have selected OpenAI Chat Model");
                System.out.println("Enter your message: ");
                String message = sc.nextLine();
                GPT gpt = new GPT();
                gpt.chatWithString(message);
            } else {
                System.out.println("You have selected Vision Chat Model");
                System.out.println("Please enter a valid image URL, either a png or jpg or webp file example(https://example.com/image.png: ");
                String imageUrl = sc.nextLine();
                while (!isValidImageUrl(imageUrl)) {
                    System.out.println("Invalid URL. Please enter a valid image URL, either a png or jpg or webp file example(https://example.com/image.png: ");
                    System.out.println("If you are having trouble with image, make sure your URL ends with .png, .jpg, or .webp ");
                    System.out.println("If you are using a valid format check your URL and add the correct format as .png, .jpg, or .webp at the end ");
                    System.out.println("If you are still having trouble, try using a different image URL");
                    imageUrl = sc.nextLine();
                }
                GPT gpt = new GPT();
                gpt.visionChat(imageUrl);
            }
            System.out.println("Do you want to play again? Enter 0 to play again or any other number to exit: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number: ");
                sc.next();
            }
            game = sc.nextInt();
        }
    }
}