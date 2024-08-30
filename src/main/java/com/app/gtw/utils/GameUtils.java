package com.app.gtw.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.app.gtw.service.GameService;

@Component
public class GameUtils {

	@Autowired
	ConfigurableApplicationContext applicationContext;

	public int MAX_TRIES = 5;

	public int reduce() {
		MAX_TRIES = MAX_TRIES - 1;

		return MAX_TRIES;
	}

	public int getRemainingTry() {
		return MAX_TRIES;
	}

	public GameService relod() {
		GameService gameService = applicationContext.getBean(GameService.class);

		return gameService;
	}

	public void resetTries() {
		MAX_TRIES = 5;

	}
}
