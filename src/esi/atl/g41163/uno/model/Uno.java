/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g41163.uno.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Facade class that controls the game at a higher level
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-01
 */
public class Uno
{
    private GameState gameState;
    private final Deck deck;
    private final Discarded stack;
    private final List<Player> players;
    private Player currentPlayer;
    
    /**
     * Constructor for the Uno class, represents the GameMaster, initializes
     * all the needed variables for the game to start
     */
    public Uno()
    {
        this.gameState = GameState.INIT;
        this.deck = new Deck();
        this.deck.generateDeck();
        this.stack = new Discarded();
        this.players = new ArrayList();
        this.currentPlayer = null;
    }
    
    private void nextPlayer()
    {
    int cpIndex = players.indexOf(getCurrentPlayer());
    // We wrap around the list if we reach the end when fetching the next
    int nextInd = (cpIndex + 1) % players.size();
    this.currentPlayer = players.get(nextInd);
    }
    
    private int sumScore()
    {
        int sum = 0;
        
        for (Player player : players)
        {
            sum += player.getScore();
        }
        
        return sum;
    }
    
    private boolean isLegal(Card card)
    {
        Card topCard = getFlippedCard();
        
        return card.equals(topCard) || card.getColor() == topCard.getColor() || card.getValue() == topCard.getValue();
    }
    
    public GameState getGameState()
    {
        return this.gameState;
    }
    
    public void nextTurn()
    {   
        Player cp = getCurrentPlayer();
        
        if (cp.isDone())
        {
            cp.addScore(sumScore());
            this.gameState = GameState.OVER;
        }
        else
        {
            nextPlayer();
        }
    }
    
    public void start()
    {
        this.gameState = GameState.RUNNING;
        // We give each player a starting set of 7 cards
        for (Player player : players)
        {
            for (int i = 0; i < 7; i++)
            {
                player.drawCard(getFlippedCard());
            }
        }
    }
    
    public void addPlayer(Player player)
    {
        this.players.add(player);
    }
    
    public Player getCurrentPlayer()
    {
        return this.currentPlayer;
    }
    
    public void playCard(int i) throws UnoIllegalPlayException
    {
        Card playedCard = getCurrentPlayer().playCard(i);
        if (isLegal(playedCard))
        {
            stack.addCard(playedCard);
            nextPlayer();
        }
        else
        {
            // We return the card to the player's hand if it's illegal
            getCurrentPlayer().drawCard(playedCard);
            throw new UnoIllegalPlayException("That card can't be played!");
        }
        
    }
    
    public Card getFlippedCard()
    {
        return stack.getCard();
    }
    
    public void drawCard()
    {
        getCurrentPlayer().drawCard(this.deck.getCard());
        nextPlayer();
    }
    
}
