/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mmax;

/**
 *
 * @author Alumno
 */
//implements = interface (herencia multiple) metodos abstractos
public class Genetico2 implements Comparable<Genetico2>{
    String texto;
    int fitness;
    public Genetico2(){
        texto="";
        fitness=0;
    }
    public Genetico2(int tamaño){
        texto="";
        int n;
        for (int i=0;i<tamaño;i++){
            n=(int) (Math.random()*90)+32; // desde espacio hasta la z
            texto +=(char) n;
        }        
        fitness=0;
    }
    @Override
    public int compareTo(Genetico2 o){
        if(fitness<o.fitness){
            return -1;
        }
        if(fitness>o.fitness){
            return 1;
        }
        return 0;
    }
 
}
