/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mmax;

/**
 *
 * @author RLandeta
 */
public class Gato {
    int matriz[][] = new int[3][3];
    int hijos;
    public Gato(){
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                matriz[i][j]=0;
            }
        }
        hijos=0;
    }
}
