/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esi.atl.g41163.uno.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Adrian Torres
 */
public class Main
{
    private int askForAmt()
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Please input the amount of players\n>>> ");
        while (!scanner.hasNextInt())
        {
            System.out.print("Please input a valid amount of players!\n>>> ");
        }
        
        return scanner.nextInt();
    }
    
    private List<String> askForNames()
    {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList();
        int n = askForAmt();
        
        while (n < 1 || n > 10)
        {
            System.out.println("You must choose a number between 1 and 10!");
            n = askForAmt();
        }
        
        for (int i = 0; i < n; i++)
        {
            System.out.println("Input Player " + i + " name\n>>> ");
            String name = scanner.next();
            while (names.contains(name))
            {
                System.out.println("A player with that name already exists! Please choose a different name!");
                System.out.print(">>> ");
                name = scanner.next();
            }
            
            names.add(name);
        }
        
        return names;
    }
    
    private void init()
    {
        System.out.println("Welcome to the game of UNO!");
        List<String> names = askForNames();
    }
}
