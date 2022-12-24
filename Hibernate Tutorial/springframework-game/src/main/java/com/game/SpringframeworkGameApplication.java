package com.game;

import com.game.allgames.*;
import com.game.allgames.enterprise.example.MyWebController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.game")
public class SpringframeworkGameApplication {

	public static void main(String[] args) {

//		MarioGame game = new MarioGame();
//		SuperContraGame game = new SuperContraGame();
//		HitmanGame game = new HitmanGame();
//		GamingConsole game = new HitmanGame();
//		GameRunner runner = new GameRunner(game);
//		runner.run();

		ConfigurableApplicationContext context
				= SpringApplication.run(SpringframeworkGameApplication.class, args);

		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();

		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());
	}

}
