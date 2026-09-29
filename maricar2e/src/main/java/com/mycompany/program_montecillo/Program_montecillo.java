/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.program_montecillo;
import java.util.Scanner;
/**
 *
 * @author CL2-PC
 */
public class Program_montecillo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Airene Montecillo");
        System.out.println("Enter a number:");
        int x = input.nextInt();
        System.out.println("Enter a number:");
        int y = input.nextInt();
        int sum,diff,prod,div;
        
        sum = x + y;
        diff = x - y;
        prod = x * y;
        div = x / y;
        System.out.println("Sum is:"+ sum);
        System.out.println("Diff is:"+ diff);
        System.out.println("Prod is:"+ prod);
        System.out.println("Div is:"+ div);
        
        
        
    }
}
