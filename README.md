# Introduction
This a program made in Java that will allow you to programtically intereact with OPENAI's GPT-4o API. These Instructions will guide you through the steps of creating a API key with OPENAI and how to set that key as an environment variable on your local machine.

### Step 1: Create an account with OPENAI
Go to [OPENAI's website](https://platform.openai.com/signup) and create an account.

### Step 2: Create an API Key
Once you have created an account, go to the dashboard and go to the menu on the left where you will see API keys at the bottom.

![](https://i.postimg.cc/G29qxFmK/Edited-screen-1.jpg)

Click on the API keys and then click on the "Create API Key" button. Follow the instructions given to create an API key and save the key in a secure location.

![](https://i.postimg.cc/pXV4mFD0/API-KEY-1.jpg)

### Step 3: Set your API Key as an Environment Variable
On your local machine, open a terminal and type the following command to set the API key as an environment variable.

### Windows

1. **Command Prompt or PowerShell (Temporary Setting):**
    - Open Command Prompt or PowerShell.
    - Use the `set` command:
      ```cmd
      set OPEN_API_KEY=your-api-key-here
      ```
    - This sets the variable for the current session.

2. **System Properties (Permanent Setting):**
    - Search for "Environment Variables" in the Start menu and open it.
    - Under "System Properties," click on "Environment Variables."
    - In the "Environment Variables" dialog, click "New" under "System variables" or "User variables" (depending on whether you want it for all users or just your profile).
    - Enter `OPEN_API_KEY` as the "Variable name" and your API key as the "Variable value."
    - Click OK to save the changes.

### macOS and Linux

1. **Terminal (Temporary Setting):**
    - Open a terminal window.
    - Use the `export` command:
      ```bash
      export OPEN_API_KEY=your-api-key-here
      ```
    - This sets the variable for the current session of the terminal.

2. **Shell Configuration Files (Permanent Setting):**
    - Add the export command to your shell's configuration file to make it permanent.
    - For Bash, add the following line to `~/.bashrc` or `~/.bash_profile`:
      ```bash
      export OPEN_API_KEY=your-api-key-here
      ```
    - For Zsh, add the line to `~/.zshrc`:
      ```zsh
      export OPEN_API_KEY=your-api-key-here
      ```
    - After editing the file, apply the changes by running:
      ```bash
      source ~/.bashrc  # or ~/.bash_profile or ~/.zshrc depending on the file you edited
      ```
#### *Quick note*
To access the GPT-4o model with your API you will need to add some funds to your account. You can do this by going to the billing section of your account and adding funds there. 

![](https://i.postimg.cc/sgW54nzw/Billing-1.jpg)

## Using the Chat Program 
### Using Java Swing
-Go to the `src` folder and run the `ChatMain.Java` file. This will start the Java Swing user interface and you can start interacting with the GPT-4o model.
### Using the Terminal
Go to the `src` folder and run the `Main.java` file. This will start the program, and you can start interacting with the GPT-4o model through the terminal.

### Future Updates
I plan to add more features to this program in the future. Some of the features I plan to add are:
- Image Generation Model using DALL-E.
- Method for using an Anthropic API key instead of an OPENAI API key.

## Conclusion
As AI develops the way we interact with it will also change. This program is a small step towards that future. I hope you find this program useful and enjoy using it. If you have any questions or suggestions feel free to reach out to me. Thank you for taking the time to read to look through this project. 

## Open Source resources used:
- [OPENAI's API](https://platform.openai.com/docs/guides/authentication)
- [LangChain4j](https://docs.langchain4j.dev/) 

