/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g41163.uno.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Facade class that controls the game at a higher level
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-01
 */
public class Uno
{
    private Player currentPlayer;
    private final List<Player> players;
    private final List<Card> deck;
    private final List<Card> graveyard;
    
    public Uno()
    {
        this.deck = new ArrayList();
        this.graveyard = new ArrayList();
        this.players = new ArrayList();
        this.currentPlayer = null;
    }
    
    private void generateDeck()
    {
        for (Color color : Color.values())
        {
            for (int i = 0; i < 10; i++)
            {
                if (i == 0)
                {
                    this.deck.add(new Card(color, i));
                }
                else
                {
                    this.deck.add(new Card(color, i));
                    this.deck.add(new Card(color, i));
                }
                
            }
        }
    }
    
    public void shuffleDeck()
    {
        Collections.shuffle(this.deck);
    }
    
    public void createPlayer(String playerName)
    {
        this.players.add(new Player(playerName));
    }
    
    public Player getCurrentPlayer()
    {
        return this.currentPlayer;
    }
    
    public void nextTurn()
    {
        int cIndex = this.players.indexOf(getCurrentPlayer());
        int playerCount = this.players.size();
        // This will get the next player in the order that they're in the
        // players ArrayList and wrap around if they're the last player in it
        Player nxtPlayer = this.players.get((cIndex + 1) % playerCount);
        
        this.currentPlayer = nxtPlayer;
    }
}
