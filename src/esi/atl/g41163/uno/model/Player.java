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
    
    /**
     * Constructor for the Player class
     * @param name Name of the player
     */
    public Player(String name)
    {
        this.name = name;
        this.score = 0;
    }
    
    /**
     * Adds n to the Player's score
     * @param n Amount to be added to the player's score
     */
    public void addScore(int n)
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
    
}
