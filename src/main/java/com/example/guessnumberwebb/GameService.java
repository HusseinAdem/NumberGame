package com.example.guessnumberwebb;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Random;

@Service
@SessionScope
public class GameService {
    public double playedTimes = 0;
    public double totalGuessesSession = 0;

    public int randomNumber;
    public int nGuess;
    boolean gameFinished;

    //använd postconstruct ifall det skulle ha funnits ex repo som ska hämtas innan spel

    public GameService() {
        randomNumber = generateRandomNumber();
        nGuess = 0;
        gameFinished = false;
    }
    public int generateRandomNumber(){
        Random rand = new Random();
        return (rand.nextInt(100));
    }
    public String checkNumber(int number){
        if (number == getRandomNumber()){
            return "";
        } else {
            return String.valueOf(number);
        }
    }
    public void resetGame(){
        randomNumber = generateRandomNumber();
        totalGuessesSession += nGuess;
        playedTimes++;
        nGuess = 0;

    }

    public String checkInput(int number){
        if (getRandomNumber()>number){
            nGuess++;
            return "Högre";
        } else if (getRandomNumber()<number)    {
            nGuess++;
            return "Lägre";
        } else {
            nGuess++;
            gameFinished = true;
            return "Rätt";
        }

    }
    public double calculateAverage(){
        return totalGuessesSession / playedTimes;

    }


    public int getRandomNumber() {
        return randomNumber;
    }

    public int getnGuess() {
        return nGuess;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }
}
