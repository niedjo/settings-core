package com.niedjo.settings_core;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin(origins = "*")

public class ScoreController {
    // define endpoints here

    static Score score = new Score(30, 20, 10);

    @PutMapping("/score")
    public Score replaceScore(@RequestBody Score newScore) {
        //TODO: process PUT request
        score = newScore;
        return score;
    }

    // replace an information, a property of an object in a database
    @PatchMapping("/score/wins")
    public Score updateWins(@RequestParam(name="new-value")int newValue) {
        score.wins = newValue;
        return score;
    }

    @GetMapping("/health-check")
    public String getHealyhCheck() {
        return new String("je suis cool daa");
    }

    /**
     *
     * curl.exe -X POST http://localhost:8080/score/wins 
     * */

    @PostMapping("/score/wins")
    public Score increaseWins() {
        //TODO: process POST request

        score.wins++;
        return score;
    }

    @PostMapping("/score/losses")
    public Score increaseLosses() {
        //TODO: process POST request

        score.losses++;
        return score;
    }

    @PostMapping("/score/ties")
    public Score increaseTies() {
        //TODO: process POST request

        score.ties++;
        return score;
    }

    @GetMapping("/score")
    public Score getScore() {
        return score;
    }

    @GetMapping("/score/{winlossesorties}")
    public int getWinsLossesOrTies (@PathVariable String winlossesorties) {
        if (winlossesorties.equalsIgnoreCase("wins")) {
            return score.wins;
        }
        if (winlossesorties.equalsIgnoreCase("ties")) {
            return score.ties;
        }
        return score.losses;
    }
    

    /*
    @GetMapping("/score")
    public Score getScore() {
        return score;
    }
    
    @GetMapping("/score/wins")
    public int getWins () {
        return score.wins;
    }
    
    @GetMapping("/score/losses")
    public int getLosses () {
        return score.losses;
    }
    
    @GetMapping("/score/losses")
    public int getTies () {
        return score.ties;
    }
    */
    
}