package com.app.gtw.service;

import java.util.Arrays;
import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class GameService {

	private String randomChosenWord = null;

	private String[] randomWords = { "hello", "good morning", "welcome", "java", "python" };

	Random random = new Random();

	private char[] charactersOfRandomChoosenWord = null;

	public GameService() {
		randomChosenWord = randomWords[random.nextInt(randomWords.length)];

		System.out.println("Randomly chosen word " + randomChosenWord);

		charactersOfRandomChoosenWord = new char[randomChosenWord.length()];
	}

	@Override
	public String toString() {

		String result = "";

		for (char c : charactersOfRandomChoosenWord) {
			if (c == '\u0000')
				result = result + "_";
			else
				result = result + c;

			result = result + " ";
		}
		return result;
	}

	public boolean addCharacter(char guessedChar) {

		boolean isGuessCorrect = false;
		for (int i = 0; i < randomChosenWord.length(); i++) {
			if (guessedChar == randomChosenWord.charAt(i)) {
				charactersOfRandomChoosenWord[i] = guessedChar;
				isGuessCorrect = true;
			}
		}

		System.out.println(Arrays.toString(charactersOfRandomChoosenWord));

		return isGuessCorrect;
	}

}
