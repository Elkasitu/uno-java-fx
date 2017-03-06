/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import esi.atl.g41163.uno.model.*;
import java.util.List;

/**
 * Tests the public methods of the Uno class
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-05
 */
public class UnoTests
{
    
    public UnoTests()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    private Uno generateUnoPlayers(int n)
    {
        Uno game = new Uno();
        
        for (int i = 0; i < n; i++)
        {
            try
            {
                game.addPlayer("CPU" + (i + 1));
            }
            catch (UnoIllegalException e){}
        }
        
        return game;
    }
    
    @Test(expected=UnoIllegalException.class)
    public void addPlayerTest() throws UnoIllegalException
    {
        Uno game = generateUnoPlayers(10);
        game.addPlayer("CPU11");
    }
    
    @Test
    public void nextTurnTest()
    {
        Uno game = generateUnoPlayers(2);
        game.start();
        String fPlayerName = game.getCurrentPlayer().getName();
        game.nextTurn();
        String sPlayerName = game.getCurrentPlayer().getName();
        
        assertNotEquals(fPlayerName, sPlayerName);
    }
    
    @Test
    public void drawCardTest()
    {
        Uno game = generateUnoPlayers(1);
        
        game.start();
        game.drawCard();
        
        assertEquals(8, game.getCpHand().getList().size());
    }
    
    @Test
    public void start1PTest()
    {
        Uno game = generateUnoPlayers(1);
        
        game.start();
        List<Card> p1Hand = game.getCpHand().getList();
        
        assertEquals(7, p1Hand.size());
    }
    
    @Test
    public void start2PTest()
    {
        Uno game = generateUnoPlayers(2);
        
        game.start();
        List<Card> p1Hand = game.getCpHand().getList();
        game.nextTurn();
        List<Card> p2Hand = game.getCpHand().getList();
        
        
        assertEquals(p1Hand.size(), p2Hand.size());
    }
    
    @Test
    public void startMaxPTest()
    {
        List<Card> prevHand;
        List<Card> currHand;
        
        Uno game = generateUnoPlayers(10);
        
        game.start();
        
        prevHand = game.getCpHand().getList();
        
        game.nextTurn();
        
        for (int i = 0; i < 9; i++)
        {
            currHand = game.getCpHand().getList();
            
            assertEquals(prevHand.size(), currHand.size());
            
            prevHand = currHand;
            game.nextTurn();
        }
    }
    
    @Test
    public void getGameStateTest()
    {
        Uno game = generateUnoPlayers(1);
        GameState state1 = game.getGameState();
        
        game.start();
        GameState state2 = game.getGameState();
        
        assertEquals(state1, GameState.INIT);
        assertEquals(state2, GameState.RUNNING);
    }
    
    @Test
    public void anyScoreOverTest()
    {
        Uno game = generateUnoPlayers(2);
        
        assertEquals(game.anyScoreOver(), null);
    }
    
    @Test
    public void resetTest()
    {
        Uno game = generateUnoPlayers(1);
        game.start();
        game.reset();
        
        assertEquals(game.getCpHand().getList().size(), 0);
        assertEquals(game.getGameState(), GameState.INIT);
    }
    
    @Test
    public void playCardSuccessTest()
    {
        Uno game = generateUnoPlayers(1);
        game.start();
        List<Card> cpHand = game.getCpHand().getList();
        Card fc = game.getFlippedCard();
        Card playedCard = null;
        
        while (playedCard == null)
        {
            for (Card card : cpHand)
            {
                if (card.getColor() == fc.getColor() || card.getValue() == fc.getValue())
                {
                    try
                    {
                        playedCard = card;
                        game.playCard(cpHand.indexOf(card));
                    }
                    catch (UnoIllegalException e)
                    {
                        playedCard = null;
                    }
                    break;
                }
            }
            
            game.drawCard();
        }
        
        
        assertEquals(playedCard, game.getFlippedCard());
    }
    
    @Test
    public void aiConstructTest()
    {
        AI ai = new AI("CPU001");
        
        assertTrue(ai.isAI());
    }
    
    @Test
    public void aiPlayTest()
    {
        Uno game = new Uno();
        game.addAI("Test");
        game.start();
        game.playAI();
        
        int size = game.getCpHand().getList().size();
        
        assertTrue(size == 6 || size == 8);
    }
}
