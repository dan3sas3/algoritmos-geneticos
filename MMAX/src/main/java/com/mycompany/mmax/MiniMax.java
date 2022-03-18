/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mmax;

/**
 *
 * @author RLandeta
 */
public class MiniMax extends javax.swing.JFrame {

    /**
     * Creates new form MiniMax
     */
    Gato g = new Gato();
    Gato r = new Gato();
    private void leeGrafico(){
        //voy a leer los botones y pasarlos a la matriz
        if(jButton1.getText().equals("X")){
            g.matriz[0][0]=1;
        }else{
            if (jButton1.getText().equals("O")){
                g.matriz[0][0]=-1;
            }else{
                g.matriz[0][0]=0;
            }
        }
        if(jButton2.getText().equals("X")){
            g.matriz[0][1]=1;
        }else{
            if (jButton2.getText().equals("O")){
                g.matriz[0][1]=-1;
            }else{
                g.matriz[0][1]=0;
            }
        }
        if(jButton3.getText().equals("X")){
            g.matriz[0][2]=1;
        }else{
            if (jButton3.getText().equals("O")){
                g.matriz[0][2]=-1;
            }else{
                g.matriz[0][2]=0;
            }
        }
        if(jButton4.getText().equals("X")){
            g.matriz[1][0]=1;
        }else{
            if (jButton4.getText().equals("O")){
                g.matriz[1][0]=-1;
            }else{
                g.matriz[1][0]=0;
            }
        }
        if(jButton5.getText().equals("X")){
            g.matriz[1][1]=1;
        }else{
            if (jButton5.getText().equals("O")){
                g.matriz[1][1]=-1;
            }else{
                g.matriz[1][1]=0;
            }
        }
        if(jButton6.getText().equals("X")){
            g.matriz[1][2]=1;
        }else{
            if (jButton6.getText().equals("O")){
                g.matriz[1][2]=-1;
            }else{
                g.matriz[1][2]=0;
            }
        }
        if(jButton7.getText().equals("X")){
            g.matriz[2][0]=1;
        }else{
            if (jButton7.getText().equals("O")){
                g.matriz[2][0]=-1;
            }else{
                g.matriz[2][0]=0;
            }
        }
        if(jButton8.getText().equals("X")){
            g.matriz[2][1]=1;
        }else{
            if (jButton8.getText().equals("O")){
                g.matriz[2][1]=-1;
            }else{
                g.matriz[2][1]=0;
            }
        }
        if(jButton9.getText().equals("X")){
            g.matriz[2][2]=1;
        }else{
            if (jButton9.getText().equals("O")){
                g.matriz[2][2]=-1;
            }else{
                g.matriz[2][2]=0;
            }
        }
        
        
        
    }
    private int Ceros(Gato g){
        int ceros=1;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (g.matriz[i][j]==0){        
                    ceros++;
                }
            }
        }
        return ceros;
    }
    private int Evalua(Gato g){
        int v1=g.matriz[0][0]+g.matriz[1][0]+g.matriz[2][0];
        int v2=g.matriz[0][1]+g.matriz[1][1]+g.matriz[2][1];
        int v3=g.matriz[0][2]+g.matriz[1][2]+g.matriz[2][2];
        
        int h1=g.matriz[0][0]+g.matriz[0][1]+g.matriz[0][2];
        int h2=g.matriz[1][0]+g.matriz[1][1]+g.matriz[1][2];
        int h3=g.matriz[2][0]+g.matriz[2][1]+g.matriz[2][2];
        
        int d1=g.matriz[0][0]+g.matriz[1][1]+g.matriz[2][2];
        int d2=g.matriz[0][2]+g.matriz[1][1]+g.matriz[2][0];
        if(d1==3||d2==3||v1==3||v2==3||v3==3||h1==3||h2==3||h3==3){
            return 1*Ceros(g);
        }else{
            if(d1==-3||d2==-3||v1==-3||v2==-3||v3==-3||h1==-3||h2==-3||h3==-3){
                return -1*Ceros(g);
            }else{
                if (hayHuecos(g)){
                    return 11;
                }else{
                    return 0;
                }
            }
        }
    }
    private boolean hayHuecos(Gato g){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (g.matriz[i][j]==0){
                    return true;
                }
            }
        }
        return false;
    }
    private void Sucesores(Gato g,int quientira,Gato hijos[]){
        //necesito saber cuando hijos tiene g
        int n=0;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (g.matriz[i][j]==0){
                    //copiar g a hijos
                    for (int k=0;k<3;k++){
                        for (int m=0;m<3;m++){
                            hijos[n].matriz[k][m]=g.matriz[k][m];
                        }
                    }
                    //pongo quien tira en el hueco
                    hijos[n].matriz[i][j]=quientira;
                    n++;
                }
            }
        }
        g.hijos=n;
    }
    private void escribeGrafico(){
        //voy a leer r (gato resultado del minimax)
        //y lo paso a los botones
        if (r.matriz[0][0]==-1){
            jButton1.setText("O");
        }
        if (r.matriz[0][0]==1){
            jButton1.setText("X");
        }
        if (r.matriz[0][1]==-1){
            jButton2.setText("O");
        }
        if (r.matriz[0][1]==1){
            jButton2.setText("X");
        }        
        if (r.matriz[0][2]==-1){
            jButton3.setText("O");
        }
        if (r.matriz[0][2]==1){
            jButton3.setText("X");
        }        
        if (r.matriz[1][0]==-1){
            jButton4.setText("O");
        }
        if (r.matriz[1][0]==1){
            jButton4.setText("X");
        }
        if (r.matriz[1][1]==-1){
            jButton5.setText("O");
        }
        if (r.matriz[1][1]==1){
            jButton5.setText("X");
        }        
        if (r.matriz[1][2]==-1){
            jButton6.setText("O");
        }
        if (r.matriz[1][2]==1){
            jButton6.setText("X");
        }        
        if (r.matriz[2][0]==-1){
            jButton7.setText("O");
        }
        if (r.matriz[2][0]==1){
            jButton7.setText("X");
        }
        if (r.matriz[2][1]==-1){
            jButton8.setText("O");
        }
        if (r.matriz[2][1]==1){
            jButton8.setText("X");
        }        
        if (r.matriz[2][2]==-1){
            jButton9.setText("O");
        }
        if (r.matriz[2][2]==1){
            jButton9.setText("X");
        }                
    }
    public MiniMax() {
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("MiniMax");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jButton10)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jButton2.getText().equals("")){
            jButton2.setText("O");
        }        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jButton1.getText().equals("")){
            jButton1.setText("O");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(jButton3.getText().equals("")){
            jButton3.setText("O");
        }        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(jButton4.getText().equals("")){
            jButton4.setText("O");
        }        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(jButton5.getText().equals("")){
            jButton5.setText("O");
        }        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(jButton6.getText().equals("")){
            jButton6.setText("O");
        }        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if(jButton7.getText().equals("")){
            jButton7.setText("O");
        }        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(jButton8.getText().equals("")){
            jButton8.setText("O");
        }        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if(jButton9.getText().equals("")){
            jButton9.setText("O");
        }        
    }//GEN-LAST:event_jButton9ActionPerformed
    private int minimax(Gato g, int quientira,Gato r){
        int valor1,valor2,temp;
        Gato resultado2=new Gato();
        Gato hijos[]= new Gato[9];
        for (int i=0;i<9;i++){
            hijos[i] = new Gato();
        }
        valor1=Evalua(g);
        if (valor1>=-10&&valor1<=10){
            for(int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    r.matriz[i][j]=g.matriz[i][j];
                }
            }
        }else{
            temp=quientira%2;
            if(temp==0){
                Sucesores(g,1,hijos);
                //maximizar
                valor1=-11;
                for (int i=0;i<g.hijos;i++){
                    valor2=minimax(hijos[i],quientira+1,resultado2);
                    if (valor2>valor1){
                        valor1=valor2;
                        for(int m=0;m<3;m++){
                            for (int n=0;n<3;n++){
                                r.matriz[m][n]=hijos[i].matriz[m][n];
                            }
                        }
                    }
                }
            }else{
                //minimizar
                Sucesores(g,-1,hijos);
                valor1=11;
                for (int i=0;i<g.hijos;i++){
                    valor2=minimax(hijos[i],quientira+1,resultado2);
                    if (valor2<valor1){
                        valor1=valor2;
                        for(int m=0;m<3;m++){
                            for (int n=0;n<3;n++){
                                r.matriz[m][n]=hijos[i].matriz[m][n];
                            }
                        }
                    }
                }
            }
        }
        return valor1;
    }
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        //traduce los botones a una matriz 0,-1, 1
        leeGrafico();
        int x=minimax(g,0,r);
        escribeGrafico();
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(MiniMax.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiniMax.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiniMax.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiniMax.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiniMax().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    // End of variables declaration//GEN-END:variables
}
