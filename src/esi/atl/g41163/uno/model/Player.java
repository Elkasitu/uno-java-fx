/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g41163.uno.model;


/**
 * This class represents a Player in the game of UNO
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-01
 */
public class Player
{
    private final String name;
    private int score;
    private final Hand hand;
    
    /**
     * Constructor for the Player class
     * @param name Name of the player
     */
    Player(String name)
    {
        this.name = name;
        this.score = 0;
        this.hand = new Hand();
    }
    
    /**
     * Gets the hand of the player
     * @return A Hand object representing the player's hand
     */
    Hand getHand()
    {
        return this.hand;
    }
    
    /**
     * Adds n to the Player's score
     * @param n Amount to be added to the player's score
     */
    void addScore(int n)
    {
        this.score += n;
    }
    
    /**
     * Gets the player's score
     * @return An integer representing the player's score
     */
    public int getScore()
    {
        return this.score;
    }
    
    /**
     * Gets the player's name
     * @return A string representing the player's name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Adds a card to the player's hand
     * @param card The Card object to be added
     */
    void drawCard(Card card)
    {
        this.hand.addCard(card);
    }
    
    /**
     * Plays a card and removes it from the player's hand
     * @param i Index of the card in the hand
     * @return The Card object to be played
     */
    Card playCard(int i)
    {
        return this.hand.getCard(i);
    }
    
    /**
     * Gets a boolean representing if the player has finished playing
     * @return True if the player has finished playing, false otherwise
     */
    boolean isDone()
    {
        return this.hand.isEmpty();
    }
    
    void flushHand()
    {
        this.hand.flush();
    }
    
}
