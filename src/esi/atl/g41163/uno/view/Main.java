/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esi.atl.g41163.uno.view;

import esi.atl.g41163.uno.model.GameState;
import esi.atl.g41163.uno.model.Player;
import esi.atl.g41163.uno.model.Uno;
import esi.atl.g41163.uno.model.UnoIllegalException;
import static esi.atl.g41163.uno.view.Display.displayBoard;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class of the Uno application
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-05
 */
public class Main
{
    
    private static final String PROMPT = ">>> ";
    
    /**
     * Main class
     * @param args Command line arguments (not used) 
     */
    public static void main(String[] args)
    {
        Uno game = init();
        gameCycle(game);
        
        System.out.println("Thanks for playing!");
    }
    
    private static void gameCycle(Uno game)
    {
        Player matchWinner;
        Player gameWinner;
        
        // The game will run until any player's score reaches 100
        while (game.anyScoreOver() == null)
        {
            // The game object gets restarted after every match
            game.reset();
            game.start();
            matchWinner = matchCycle(game);
            
            System.out.println("Player " + matchWinner.getName() + " has won the match! Score: " + matchWinner.getScore());
        }
        
        gameWinner = game.anyScoreOver();
        
        // Announcing the game winner
        System.out.println("Player " + gameWinner.getName() + " has won the game! Total Score: " + gameWinner.getScore());
    }
    
    private static Player matchCycle(Uno game)
    {
        int cardToPlay;
        boolean played;
        
        // The match will run until the gameState flag gets changed to OVER
        while (game.getGameState() == GameState.RUNNING)
        {
            played = false;
            
            // Display the state of the match
            displayBoard(game.getFlippedCard(), game.getCpHand());
            System.out.println("It's player " + game.getCurrentPlayer().getName() + "'s turn!");
            
            // played flag is for input validation
            while (!played)
            {
                // Player input handling
                cardToPlay = getCardId(game.getCpHand().getList().size());

                // -1 is the drawCard flag
                if (cardToPlay == -1)
                {
                    game.drawCard();
                    played = true;
                }
                else
                {
                    // If the card can't be played, then it's an illegal play
                    try
                    {
                        game.playCard(cardToPlay);
                        played = true;
                    }
                    catch (UnoIllegalException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
            
            game.nextTurn();
        }
        
        // Returns the winner of the match
        return game.getCurrentPlayer();
    }
    
    private static int getCardId(int size)
    {
        Scanner scanner = new Scanner(System.in);
        String errMsg = "You must insert a number between 1 and " + String.valueOf(size);
        int n;
        
        System.out.println("Choose a card by index (0 to draw)");
        System.out.print(PROMPT);
        
        // Input validation
        do
        {
            try
            {
                String s = scanner.nextLine();
                n = Integer.parseInt(s);
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println(errMsg);
                System.out.print(PROMPT);
            }
            
        } while (true);
        
        // More input validation
        if (n < 0 || n > size)
        {
            return getCardId(size);  
        }
        else
        {
            return n - 1;
        }
        
    }
    
    private static int askForAmt()
    {
        Scanner scanner = new Scanner(System.in);
        int amt;
        
        System.out.println("Please input the amount of players");
        System.out.print(PROMPT);
        
        // Input validation
        do
        {
            try
            {
                String s = scanner.nextLine();
                amt = Integer.parseInt(s);
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("You must choose a number between 1 and 10!");
                System.out.print(PROMPT);
            }
        } while (true);
        
        return amt;
    }
    
    private static List<String> askForNames()
    {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList();
        int n = askForAmt();
        
        // Input validation
        while (n < 1 || n > 10)
        {
            System.out.println("You must choose a number between 1 and 10!");
            n = askForAmt();
        }
        
        for (int i = 0; i < n; i++)
        {
            System.out.println("Input Player " + (i + 1) + " name");
            System.out.print(PROMPT);
            
            String name = scanner.nextLine();
            
            while (names.contains(name) || name.length() < 1)
            {
                System.out.println("A player with that name already exists! Please choose a different name!");
                System.out.print(PROMPT);
                name = scanner.nextLine();
            }
            
            names.add(name);
        }
        
        return names;
    }
    
    private static Uno init()
    {
        // Initializes the game variables and players
        System.out.println("Welcome to the game of UNO!");
        List<String> names = askForNames();
        
        Uno game = new Uno();
        
        if (names.size() == 1)
        {
            //TODO: Add AI Player
        }
        else
        {
            for (String name : names)
            {
                try
                {
                    game.addPlayer(name);
                }
                catch (UnoIllegalException e){}
            }
        }
        
        return game;
    }
}
