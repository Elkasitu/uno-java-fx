/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esi.atl.g41163.uno.model;

import java.util.List;

/**
 * AI Wrapper class, represents a non-playing character
 * @author Adrian Torres
 */
public class AI extends Player
{
    public AI(String name)
    {
        super(name);
        this.ai = true;
    }
    
    Card playCard(Card stackCard)
    {
        List<Card> cList = this.getHand().cardList;
        for (Card card : cList)
        {
            if (card.getColor() == stackCard.getColor() || card.getValue() == stackCard.getValue())
            {
                return playCard(cList.indexOf(card));
            }
        }
        
        return null;
    }
}
