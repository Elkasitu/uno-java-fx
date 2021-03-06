/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esi.atl.g41163.uno.view;

import esi.atl.g41163.uno.model.*;
import java.util.List;

/**
 * Class representing the Client's view of the game
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-05
 */
public class Display
{
    /**
     * Displays both the card at the top of the discard stack and the hand of the current player
     * @param card Card at the top of the discard stack
     * @param hand Hand of the current player
     */
    public static void displayBoard(Card card, Hand hand)
    {
        displayCard(card);
        displayHand(hand);
    }
    
    /**
     * Displays the card at the top of the discard stack
     * @param card Card at the top of the discard stack
     */
    public static void displayCard(Card card)
    {
        String value = String.valueOf(card.getValue());
        char color = card.getColor().getConOut();
        String data = " #   " + value + color + "   # \n";
        
        StringBuilder output = new StringBuilder();
        
        output.append("Stack: \n");
        output.append("  ########  \n");
        output.append(" #        # \n");
        output.append(" #        # \n");
        output.append(data);
        output.append(" #        # \n");
        output.append(" #        # \n");
        output.append("  ########  \n");
        
        System.out.println(output.toString());
    }
    
    /**
     * Displays the hand of the current player
     * @param hand Hand of the current player
     */
    public static void displayHand(Hand hand)
    {
        StringBuilder buf = new StringBuilder();
        List<Card> list = hand.getList();
        String value;
        char color;
        
        buf.append("Your hand: \n");
        
        String[] pieces = {
            "  ########  ",
            " #        # ",
            " #        # ",
            " #   %s%s   # ",
            " #        # ",
            " #        # ",
            "  ########  "
        };
        
        for (int i = 0; i < pieces.length; i++)
        {
            String str = pieces[i];
            
            for (Card card : list)
            {
                // 3 is the middle of the card, that's where the card information will
                if (i == 3)
                {
                    value = String.valueOf(card.getValue());
                    color = card.getColor().getConOut();
                    
                    String fStr = String.format(str, value, color);
                    
                    buf.append(fStr);
                }
                else
                {
                    buf.append(str);
                }

            }
            
            buf.append("\n");
        }
        
        System.out.println(buf.toString());
    }
}
