package com.example.guessnumberwebb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
    @Autowired
    GameService gameService;


    @GetMapping("/gamesite")
    public String spela1(){
        System.out.println(gameService.getRandomNumber());
        return "gamesite";
    }
    @PostMapping("/guessnumber")
    public String guessNumber(@RequestParam("number") String number, Model model){
        String feed = gameService.checkInput(Integer.parseInt(number));
        String checkIfEqual = gameService.checkNumber(Integer.parseInt(number));


        int ng = gameService.getnGuess();

        if (feed.equals("Rätt")){
            model.addAttribute("correct_answer", number);
            model.addAttribute("number_guesses", ng);

            gameService.resetGame();
            String av = String.valueOf(gameService.calculateAverage());
            model.addAttribute("average", av);
            return "resultpage";
        } else {
            model.addAttribute("user_guess", checkIfEqual);
            model.addAttribute("feedback", feed);
            model.addAttribute("number_guesses", ng);

            return "gamesite";
        }



    }

}
