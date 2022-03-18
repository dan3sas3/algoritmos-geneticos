/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mmax;

/**
 *
 * @author RLandeta
 */
public class hanoi {
    public static void hanoi(int n,String A,String B,String C){
        if (n==1){
            System.out.println("Muevo de "+A+"->"+C);
        }else{
            
            hanoi(n-1,B,A,C);
            System.out.println("Muevo de "+A+"->"+C);
            hanoi(n-1,A,C,B);
        }
    }
    public static void main(String arg[]){
        hanoi(3,"izq","cen","der");
    }
}
