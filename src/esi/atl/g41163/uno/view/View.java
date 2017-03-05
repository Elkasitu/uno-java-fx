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
public class View
{
    
    public static void displayHand(Hand hand)
    {
        StringBuilder buf = new StringBuilder();
        List<Card> list = hand.getList();
        
        String[] pieces = {
            "  ########  ",
            " #        # ",
            " #        # ",
            " #        # ",
            " #        # ",
            "  ########  "
        };
        
        for (int i = 0; i < pieces.length; i++)
        {
            String str = pieces[i];
            
            for (Card card : list)
            {
                if (i == 3)
                {
                    String value = String.valueOf(card.getValue());
                    char color = card.getColor().getConOut();
                    String data = " #   " + value + color + "   # ";
                    buf.append(data);
                    
                    if (list.indexOf(card) == list.size() - 1)
                    {
                        buf.append("\n");
                        
                        list.forEach((_item) ->
                        {
                            buf.append(str);
                        });
                    }
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
