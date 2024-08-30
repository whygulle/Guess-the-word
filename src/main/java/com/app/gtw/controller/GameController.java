package com.app.gtw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.gtw.service.GameService;
import com.app.gtw.utils.GameUtils;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;

	@Autowired
	private GameUtils gameUtils;

	@GetMapping("/game-home")
	public String showGameHomePage(@RequestParam(value = "guessedChar", required = false) String guessedChar,
			Model model) {

		System.out.println("captured guessed char is " + guessedChar);
		String randomWord = gameService.toString(); //This method will give me random value

		if (guessedChar != null) {
			boolean isGuessedCorrect = gameService.addCharacter(guessedChar.charAt(0));
			randomWord = gameService.toString();

			if (isGuessedCorrect == false) {
				int tries = gameUtils.reduce();
			}
		}
		int triesLeft = gameUtils.getRemainingTry();

		model.addAttribute("wordToDisplay", randomWord);
		model.addAttribute("triesLeft", triesLeft);
		return "game-home";
	}

	@GetMapping("/reload")
	public String reloadGame() {
		gameService = gameUtils.relod();

		// reset the tries

		gameUtils.resetTries();

		return "redirect:/game-home";
	}
}
