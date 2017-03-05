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
 *
 * @author Adrian Torres
 */
public class Main
{
    
    public static final String PROMPT = ">>> ";
    
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
        
        while (game.anyScoreOver() == null)
        {
            game.reset();
            game.start();
            matchWinner = matchCycle(game);
            
            System.out.println("Player " + matchWinner.getName() + " has won the match! Score: " + matchWinner.getScore());
        }
        
        gameWinner = game.anyScoreOver();
        
        System.out.println("Player " + gameWinner.getName() + " has won the game! Total Score: " + gameWinner.getScore());
    }
    
    private static Player matchCycle(Uno game)
    {
        int cardToPlay;
        boolean played;
        
        while (game.getGameState() == GameState.RUNNING)
        {
            played = false;
            
            displayBoard(game.getFlippedCard(), game.getCpHand());
            System.out.println("It's player " + game.getCurrentPlayer().getName() + "'s turn!");
            
            while (!played)
            {
                cardToPlay = getCardId(game.getCpHand().getList().size());

                if (cardToPlay == -1)
                {
                    game.drawCard();
                    played = true;
                }
                else
                {
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
        
        return game.getCurrentPlayer();
    }
    
    private static int getCardId(int size)
    {
        Scanner scanner = new Scanner(System.in);
        String errMsg = "You must insert a number between 1 and " + String.valueOf(size);
        int n;
        
        System.out.println("Choose a card by index (0 to draw)");
        System.out.print(PROMPT);
            
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
            
            while (names.contains(name))
            {
                System.out.println("A player with that name already exists! Please choose a different name!");
                System.out.print(PROMPT);
                name = scanner.next();
            }
            
            names.add(name);
        }
        
        return names;
    }
    
    private static Uno init()
    {
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
