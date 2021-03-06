/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mmax;

import java.util.Arrays;

/**
 *
 * @author Alumno
 */
public class Genetico1 extends javax.swing.JFrame {

    /**
     * Creates new form Genetico1
     */
    String texto;
    int tamaño;
    int poblacion=500000;
    Genetico2 c[]=new Genetico2[poblacion];
    Genetico2 d[]=new Genetico2[poblacion];
    double elitismo=.20;
    double mutacion=.10;
    int generaciones=10000;
    public Genetico1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Algoritmo genetico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("Dice Arinobu que le gustan los chilaquiles DIVORCIADOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void Inicializa(){
        for (int i=0;i<poblacion;i++){
            c[i]= new Genetico2(tamaño);
            d[i]= new Genetico2();
        }
    }
    public void calculaFitness(){
        int f,c1,c2;
        for(int i=0;i<poblacion;i++){
            f=0;
            for (int j=0;j<tamaño;j++){
                c1=(int) texto.charAt(j);
                c2=(int) c[i].texto.charAt(j);
                f+=Math.abs(c1-c2);
            }
            c[i].fitness=f;
        }
    }
    public void ordenaPoblacion(){
        Arrays.sort(c);
    }
    public void Mutacion(int i){
        int p0=(int) ((Math.random()*35678)%tamaño);
        int m =(int) (Math.random()*90)+32;
        String temp = "";
        for (int j=0; j<tamaño; j++){
            if (i==j){
                temp+=(char) m;
            }else{
                //respeto el gen
                temp+=d[i].texto.charAt(j);
            }
        }
        //textoPrueba = textoPrueba.replace(textoPrueba.charAt(i), (char)m);
        //ya tengo el gen y ya tengo el cambio
    }
    public void Cruzamiento(){
        int e=(int) (poblacion*elitismo);
        int p1,p2,p0;
        String padre1,padre2,descendencia1,descendencia2;
        for (int i=0; i<e; i++){
            d[i].texto = c[i].texto;
            d[i].fitness = c[i].fitness;
        }
        for (int i=e;i<poblacion;i++){
            p1=(int) ((Math.random()*35678)%poblacion);
            p2=(int) ((Math.random()*35678)%poblacion);
            p0=(int) ((Math.random()*35678)%tamaño);
            padre1=c[p1].texto;
            padre2=c[p2].texto;
            descendencia1=padre1.substring(0,p0);
            descendencia2=padre2.substring(p0,tamaño);
            d[i].texto=descendencia1+descendencia2;
            
        }
        for (int i=0; i<poblacion; i++){
            if (Math.random()<mutacion){
                Mutacion(i);
           }
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println((char)92);
        texto=jTextField1.getText();
        tamaño=texto.length();
        Inicializa();
        for (int i=0;i<generaciones;i++){
            calculaFitness();
            ordenaPoblacion();
            if (c[0].fitness==0){
                System.out.println(c[0].texto);
                break;
            }else{
                System.out.println(c[0].texto+"="+c[0].fitness);
                Cruzamiento();
                //convierto la descendencia en la poblacion
                c=d;
            }
            //remplazamiento d a c
            
        }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Genetico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Genetico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Genetico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Genetico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Genetico1().setVisible(true);
            }
        });
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
