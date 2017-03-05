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
import esi.atl.g41163.uno.view.*;
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

    private Uno createUnoWithP(String[] players)
    {
        Uno game = new Uno();
        
        for (String player : players)
        {
            try
            {
                game.addPlayer(player);
            }
            catch (UnoIllegalException e){}
        }
        
        return game;
    }
    
    @Test
    public void drawCardTest()
    {
        String[] names = {"TestPlayer"};
        Uno game = createUnoWithP(names);
        
        game.start();
        game.drawCard();
        
        assertEquals(8, game.getCpHand().getList().size());
    }
    
    @Test
    public void start1PTest()
    {
        String[] names = {"TestPlayer"};
        Uno game = createUnoWithP(names);
        
        game.start();
        List<Card> p1Hand = game.getCpHand().getList();
        
        assertEquals(7, p1Hand.size());
    }
    
    @Test
    public void start2PTest()
    {
        String[] names = {"P1", "P2"};
        Uno game = createUnoWithP(names);
        
        game.start();
        List<Card> p1Hand = game.getCpHand().getList();
        game.nextTurn();
        List<Card> p2Hand = game.getCpHand().getList();
        
        
        assertEquals(p1Hand.size(), p2Hand.size());
    }
}
