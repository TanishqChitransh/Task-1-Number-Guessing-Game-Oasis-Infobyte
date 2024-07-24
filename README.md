# Task-1-Number-Guessing-Game-Oasis-Infobyte
# Number Guessing Game

## Overview

The **Number Guessing Game** is an interactive console-based game developed in Java. The game challenges users to guess a randomly generated number within a specified range. Players have a limited number of attempts to guess the number, and their performance is scored based on the number of attempts remaining.

This project was developed during my internship at **Oasis Infobyte** under the **Java Development** domain. It demonstrates proficiency in Java Swing for GUI development, user input handling, and game logic implementation.

## Features

- **Random Number Generation**: The system generates a random number between 1 and 100.
- **Guess Input**: Users can input their guesses through a text field.
- **Feedback Mechanism**: Provides real-time feedback on whether the guessed number is higher, lower, or correct.
- **Score Calculation**: Scores are calculated based on remaining attempts after a correct guess.
- **Limited Attempts**: Players have a maximum of 10 attempts per round.
- **Restart Functionality**: Option to restart the game after completion.

## Technologies

- **Language**: Java (JDK 17)
- **GUI Framework**: Java Swing
- **Development Environment**: IntelliJ IDEA

## Installation

To set up and run the Number Guessing Game on your local machine, follow these steps:

1. **Clone the Repository**:

    ```bash
    git clone https://github.com/yourusername/number-guessing-game.git
    ```

2. **Navigate to the Project Directory**:

    ```bash
    cd number-guessing-game
    ```

3. **Compile the Java Files**:

    Ensure you have JDK 17 installed. Compile the project using:

    ```bash
    javac src/*.java
    ```

4. **Run the Application**:

    Execute the application with:

    ```bash
    java -cp src Number_guessing
    ```

## Usage

1. **Starting the Game**: Run the application using the command above.
2. **Gameplay**:
   - **Enter a Guess**: Input a number between 1 and 100 in the text field and click "Guess".
   - **Receive Feedback**: The system will indicate whether your guess is too high, too low, or correct.
   - **Attempts**: You have 10 attempts to guess the number correctly. Your remaining attempts are displayed.
   - **Score**: The score is updated based on the number of remaining attempts after a correct guess.
   - **Restart**: Click the "Restart" button to start a new game.


