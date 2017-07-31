/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rolando
 */
enum HandSign {
    SCISSOR, PAPER, ROCK
}

enum WTL {
    WIN, TIE, LOST
}
class RPSGame {
    
    private final HandSign[]hsValues=HandSign.values();
    private final Random RANDOM = new Random();
    private HandSign playerHand;
    private HandSign computerHand;
    
    HandSign getComputerHand () {
        HandSign hs = hsValues[RANDOM.nextInt(hsValues.length)];
        
        //TODO code??
        return hs;
    }
    
    HandSign getPlayerHand(String userInput) {
        HandSign hs;
        
        switch (userInput) {
                case "R":
                case "r": {
                    hs = HandSign.ROCK;
                    break;
                }
                case "p":
                case "P": {
                    hs = HandSign.PAPER;
                    break;
                }
                case "S":
                case "s": {
                    hs = HandSign.SCISSOR;
                    break;
                }
                default: {
                    System.out.println("Invalid input, please enter again");
                    hs = null;
                    break;
                }
                
            }
        
        return hs;
        
        
    }
    
    String toStringHand(HandSign hs){
        
        switch (hs) {
            case PAPER: return "Paper";
            case ROCK: return "Rock";
            case SCISSOR: 
                
        }
        return "Scissor";
        
    }
    
  
    
    WTL evaluateHands () {
        WTL status = WTL.LOST;
        //Tie (e.g. paper and paper)
        if (playerHand == computerHand) {
            return WTL.TIE;
        }
        HandSign h = HandSign.PAPER;
     
       switch (playerHand) {
           case PAPER: {
               //Win if computer has rock
               if (computerHand==HandSign.PAPER){
                   
                   return WTL.WIN;
               }
               //Lost if computer has scissor
               else {
                   
                   return WTL.LOST;
               }
       
           }
           case ROCK: {
               //Win if computer has scissor
               if (computerHand==HandSign.SCISSOR){
                   return WTL.WIN;
               }
               //Lost if computer has paper
               else {
                   return WTL.LOST;
               }
               
               
           }
           case SCISSOR: {
               //Win if computer has paper
               if (computerHand==HandSign.PAPER){
                   return WTL.WIN;
               }
               
               //Lost if computer has rock
               else {
                   return WTL.LOST;
               }
               
           }
               
       }
        
        return status;
    }
    
    void printStatus (WTL status) {
        System.out.println("You have: " + toStringHand(playerHand));
        System.out.println("Computer has: " + toStringHand(computerHand));
        
        switch (status) {
            case WIN: System.out.println("You won!!"); break;
            case LOST: System.out.println("You lost!!"); break;
            case TIE: System.out.println("You've tied:  keep going"); break;
        }
    }
    
    

    void playGame () {
        boolean quit = false;
        Scanner s = new Scanner(System.in);
        WTL status = WTL.TIE;
        String userInput;
        
        System.out.println ("Let's play Rock Paper and Scissors:");
        
        while (!quit) {
            System.out.println ("Enter R: Rock, P: Paper, or S: Scissors:");
            userInput = s.next();
            //*************Getting user hand
            playerHand = getPlayerHand(userInput);
                        
            //if the user input is valid
            if (playerHand!=null) {
                
            
                //*************Getting computer hand
                computerHand = getComputerHand();
                
                //************Evalutate Hands
                status = evaluateHands();
                
                //Determine status (win, lost or tie)
                printStatus (status);
                
                //Ask user to play again, if status is not a tie
                
                if (status!=WTL.TIE){
                    System.out.println ("Do you wish to play again Y or N:");
                    userInput = s.next();

                    switch (userInput) {
                        case "N":
                        case "n": {
                            quit = true;
                            System.out.println("Quitting Game, thanks for playing");
                        } 

                    }
                }
                
                
                
                     
                
            }
            
            

            
            
            
                    
            
        }
        
    }
    
    
    
}

public class RockPaperScissors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RPSGame rps = new RPSGame ();
        
        rps.playGame();
        
    }
    
}
