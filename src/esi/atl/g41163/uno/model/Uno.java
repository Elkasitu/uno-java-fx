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
     * Constructor for the Uno class, represents the GameMaster, initialises
     * all the needed variables for the game to start
     */
    public Uno()
    {
        this.gameState = GameState.INIT;
        this.deck = new Deck();
        this.stack = new Discarded();
        this.players = new ArrayList();
        this.currentPlayer = null;
    }
    
    /**
     * Tests this facade's methods
     * @param args command-line arguments (not used
     * @throws UnoIllegalException If an illegal play/action is done
     */
    public static void main(String[] args) throws UnoIllegalException
    {
        // Init
        Uno myGame = new Uno();
        myGame.addPlayer("Player 1");
        myGame.addPlayer("Player 2");

        myGame.start();
        // Running
        try
        {
            myGame.playCard(0);
        }
        catch(UnoIllegalException e)
        {
            myGame.drawCard();
        }
        myGame.nextTurn();
        
        myGame.drawCard();
        myGame.nextTurn();
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
        
        // When a player wins a match, its score gets increased by the sum of
        // all of the player's remaining cards
        for (Player player : players)
        {
            sum += player.getHand().getCount();
        }
        
        return sum;
    }
    
    private boolean isLegal(Card card)
    {
        // Can card be played?
        Card topCard = getFlippedCard();
        
        return card.getColor() == topCard.getColor() || card.getValue() == topCard.getValue();
    }
    
    private void checkAndRefill()
    {
        // Checking if the deck is empty and refilling it with the discard stack
        // if needed (except the top card)
        if (this.deck.isEmpty() && getGameState() != GameState.OVER)
        {
            this.deck.refill(this.stack);
        }
    }
    
    /**
     * Gets the current state of the game
     * @return A GameState representing the current state of the game
     */
    public GameState getGameState()
    {
        return this.gameState;
    }
    
    /**
     * Checks for a win condition and ends the game if true, otherwise
     * goes onto the next turn
     */
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
            checkAndRefill();
        }
    }
    
    /**
     * Gets the player that has a score at or over 100 or null if none does
     * @return The Player object with a score of 100+
     */
    public Player anyScoreOver()
    {
        for (Player player : players)
        {
            if (player.getScore() >= 100)
            {
                return player;
            }
        }
        
        return null;
    }
    
    /**
     * Starts the game by changing the gameState and handing every player 7 cards
     */
    public void start()
    {
        this.gameState = GameState.RUNNING;
        this.deck.generateDeck();
        this.currentPlayer = players.get(0);
        
        // Give each player a starting set of 7 cards
        for (int i = 0; i < players.size(); i++)
        {
            for (int j = 0; j < 7; j++)
            {
                drawCard();
            }
            
            nextPlayer();
        }
        
        // Draw one extra card for the discarded stack
        this.stack.addCard(this.deck.getCard());
    }
    
    /**
     * Resets the gameState, deck, stack as well as each player's hand
     */
    public void reset()
    {
        this.gameState = GameState.INIT;
        
        players.forEach((player) ->
        {
            player.flushHand();
        });
        
        this.deck.flush();
        this.stack.flush();
    }
    
    /**
     * Adds a Player player to the current game
     * @param name Name to be given to the player
     * @throws UnoIllegalException If there's already a player with the given name or the amount of max players has been attained
     */
    public void addPlayer(String name) throws UnoIllegalException
    {
        if (this.players.size() < 10)
        {
            for (Player player : players)
            {
                if (player.getName().equals(name))
                {
                    throw new UnoIllegalException("This name's already taken!");
                }
            }
            
            this.players.add(new Player(name));
        }
        else
        {
            throw new UnoIllegalException("There's no more room for new players!");
        }
        
    }
    
    /**
     * Gets the current player
     * @return The currentPlayer object
     */
    public Player getCurrentPlayer()
    {
        return this.currentPlayer;
    }
    
    /**
     * Gets a copy of the current player's hand
     * @return A new Hand object containing the same cards as the currentPlayer's hand
     */
    public Hand getCpHand()
    {
        return new Hand(this.currentPlayer.getHand());
    }
    
    /**
     * Plays the card of index i in the currentPlayer's hand
     * @param i Index of the card to be played
     * @throws UnoIllegalException If the card's color or number is different than the one of the card on top of the discard stack
     */
    public void playCard(int i) throws UnoIllegalException
    {
        Card playedCard = getCurrentPlayer().playCard(i);
        if (isLegal(playedCard))
        {
            stack.addCard(playedCard);
        }
        else
        {
            // We return the card to the player's hand if it's illegal
            getCurrentPlayer().drawCard(playedCard);
            throw new UnoIllegalException("That card can't be played!");
        }
        
    }
    
    /**
     * Gets the card at the top of the discarded stack
     * @return The Card object at the top of the discarded stack
     */
    public Card getFlippedCard()
    {
        return stack.getCard();
    }
    
    /**
     * Gives the currentPlayer the card at the top of the deck
     */
    public void drawCard()
    {
        this.currentPlayer.drawCard(this.deck.getCard());
    }
    
    /**
     * Adds an AI player to the game
     * @param name Name of the AI player
     */
    public void addAI(String name)
    {
        this.players.add(new AI(name));
    }
    
    /**
     * Gets called if the currentPlayer is an AI
     */
    public void playAI()
    {
        AI ai = (AI) this.getCurrentPlayer();
        Card card = ai.playCard(this.getFlippedCard());
        
        if (card == null)
        {
            drawCard();
        }
        else
        {
            stack.addCard(card);
            ai.getHand().getList().remove(card);
        }
    }
}
