/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Play.Game;
import Play.Bot;
import Play.Move;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Andres Flores Perez
 */
public class GameGraphics extends javax.swing.JFrame {

    // Indicates if player is X or O
    //   X: Player is X
    //   O: Player is O
    private char player;
    private boolean isOnLine;
    private boolean turn;
    private Game game = new Game();
    private Bot bot;
    
    private String PlayerX;
    private String PlayerO;
    
    public GameGraphics()
    {
        player = 'X';
        bot = new Bot('O');
        turn = true;
    }
    
    /**
     * Create new form game
     * @param isOnLine Indicates if the play is against a computer or a human
     * @param player Indicates if player plays with X or O
     * @param turn Indicates if it turn of this player or not
     */
    public GameGraphics(boolean isOnLine, char player, String PlayerX, String PlayerO, boolean turn) 
    {
        initComponents();
        this.player = player;
        this.PlayerX = PlayerX;
        this.PlayerO = PlayerO;
        this.isOnLine = isOnLine;
        this.turn = turn;
        
        initWindow();
        
        if (!isOnLine) {
            initBot();
        }
    }
    
    private void initWindow() 
    {
        jLabel14.setText(PlayerX);
        jLabel16.setText(PlayerO);
    }
    
    private void setTurnText()
    { 
        if (turn) {
            jLabel12.setText("Your Turn");
        } else 
        {
            if (player == 'X') 
            {
                jLabel12.setText(PlayerO + "'s Turn");
            } else 
            {
                jLabel12.setText(PlayerX + "'s Turn");
            }
        }
    }
    
    private void initBot() {
        if (player == 'X')
            bot = new Bot('O');
        else
            bot = new Bot('X');
        
        if (!turn) {
            getMove();
        }
    }
    
    public void getMove() {   
        String resource = "/Images/cross.png";
        Move move = new Move();
        
        if (!isOnLine && !game.isOver()) {
            move = bot.findBestMove(game);
            game.move(move.getRow(), move.getCol(), bot.getPlayer());
        
            if (bot.getPlayer() == 'X')
                resource = "/Images/cross.png";
            else
                resource = "/Images/circle.png";
        }

        if (!game.isOver()) {
            if (move.getRow() == 0 && move.getCol() == 0) square0.setIcon(new javax.swing.ImageIcon(getClass().getResource(resource)));
            if (move.getRow() == 0 && move.getCol() == 1) square1.setIcon(new javax.swing.ImageIcon(getClass().getResource(resource)));
            if (move.getRow() == 0 && move.getCol() == 2) square2.setIcon(new javax.swing.ImageIcon(getClass().getResource(resource)));
            if (move.getRow() == 1 && move.getCol() == 0) square3.setIcon(new javax.swing.ImageIcon(getClass().getResource(resource)));
            if (move.getRow() == 1 && move.getCol() == 1) square4.setIcon(new javax.swing.ImageIcon(getClass().getResource(resource)));
            if (move.getRow() == 1 && move.getCol() == 2) square5.setIcon(new javax.swing.ImageIcon(getClass().getResource(resource)));
            if (move.getRow() == 2 && move.getCol() == 0) square6.setIcon(new javax.swing.ImageIcon(getClass().getResource(resource)));
            if (move.getRow() == 2 && move.getCol() == 1) square7.setIcon(new javax.swing.ImageIcon(getClass().getResource(resource)));
            if (move.getRow() == 2 && move.getCol() == 2) square8.setIcon(new javax.swing.ImageIcon(getClass().getResource(resource)));

            evaluateGame();
            turn = true;
            setTurnText();
        }
    }
    
    public void evaluateGame() 
    {
        if (game.evaluation() != 0 || game.isOver()) 
        {
            if (game.evaluation() == -1)
            {
                if (player == 'O') 
                {
                    JOptionPane.showMessageDialog(this, "Ganaste");
                } else 
                {
                    JOptionPane.showMessageDialog(this, "Perdiste");
                }
            } else if (game.evaluation() == 1)
            {
                if (player == 'X') 
                {
                    JOptionPane.showMessageDialog(this, "Ganaste");
                } else 
                {
                    JOptionPane.showMessageDialog(this, "Perdiste");
                }
            } else if (game.isOver() && (game.evaluation() != 1 && game.evaluation() != -1)) {
                JOptionPane.showMessageDialog(this, "Es un empate");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        square0 = new javax.swing.JLabel();
        square1 = new javax.swing.JLabel();
        square2 = new javax.swing.JLabel();
        square3 = new javax.swing.JLabel();
        square4 = new javax.swing.JLabel();
        square5 = new javax.swing.JLabel();
        square6 = new javax.swing.JLabel();
        square7 = new javax.swing.JLabel();
        square8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 99, 71));

        jLabel12.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setAlignmentX(0.5F);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        square0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        square0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                square0MouseClicked(evt);
            }
        });
        jPanel2.add(square0, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 110, 110));

        square1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        square1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                square1MouseClicked(evt);
            }
        });
        jPanel2.add(square1, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 40, 110, 110));

        square2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        square2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                square2MouseClicked(evt);
            }
        });
        jPanel2.add(square2, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 40, 110, 110));

        square3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        square3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                square3MouseClicked(evt);
            }
        });
        jPanel2.add(square3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 157, 110, 110));

        square4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        square4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                square4MouseClicked(evt);
            }
        });
        jPanel2.add(square4, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 157, 110, 110));

        square5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        square5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                square5MouseClicked(evt);
            }
        });
        jPanel2.add(square5, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 157, 110, 110));

        square6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        square6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                square6MouseClicked(evt);
            }
        });
        jPanel2.add(square6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 274, 110, 110));

        square7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        square7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                square7MouseClicked(evt);
            }
        });
        jPanel2.add(square7, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 274, 110, 110));

        square8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        square8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                square8MouseClicked(evt);
            }
        });
        jPanel2.add(square8, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 274, 110, 110));

        jPanel3.setBackground(new java.awt.Color(255, 99, 71));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 40, 3, 345));

        jPanel4.setBackground(new java.awt.Color(255, 99, 71));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 40, 3, 345));

        jPanel5.setBackground(new java.awt.Color(255, 99, 71));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 269, 345, 3));

        jPanel6.setBackground(new java.awt.Color(255, 99, 71));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 152, 345, 3));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tie.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 64, 64));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/resign.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 64, 64));

        jLabel13.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(105, 124, 147));
        jLabel13.setText("Players");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 90, 50));

        jPanel7.setBackground(new java.awt.Color(105, 124, 147));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 200, 1));

        jLabel14.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(105, 124, 147));
        jLabel14.setText("You");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 140, 40));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crossPlayer.png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 105, 28, 28));

        jLabel16.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(105, 124, 147));
        jLabel16.setText("Angel");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 140, 40));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circlePlayer.png"))); // NOI18N
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 165, 28, 28));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 680, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void square0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_square0MouseClicked

        if (game.isEmpty(0, 0) && turn)  
        {
            game.move(0, 0, player);
            
            if (player == 'O') 
            {
                square0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle.png")));
            } else {
                square0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cross.png")));
            }
            
            turn = false;
            setTurnText();
            getMove();
        }
        
    }//GEN-LAST:event_square0MouseClicked

    private void square1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_square1MouseClicked
        // TODO add your handling code here:
        if (game.isEmpty(0, 1) && turn)  
        {
            game.move(0, 1, player);
            
            if (player == 'O') 
            {
                square1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle.png")));
            } else {
                square1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cross.png")));
            }
            
            turn = false;
            setTurnText();
            evaluateGame();
            getMove();
        }
    }//GEN-LAST:event_square1MouseClicked

    private void square2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_square2MouseClicked
        // TODO add your handling code here:
        if (game.isEmpty(0, 2) && turn)  
        {
            game.move(0, 2, player);
            
            if (player == 'O') 
            {
                square2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle.png")));
            } else {
                square2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cross.png")));
            }
            
            turn = false;
            setTurnText();
            evaluateGame();
            getMove();
        }
    }//GEN-LAST:event_square2MouseClicked

    private void square3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_square3MouseClicked
        // TODO add your handling code here:
        if (game.isEmpty(1, 0) && turn)  
        {
            game.move(1, 0, player);
            
            if (player == 'O') 
            {
                square3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle.png")));
            } else {
                square3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cross.png")));
            }
            
            turn = false;
            setTurnText();
            evaluateGame();
            getMove();
        }
    }//GEN-LAST:event_square3MouseClicked

    private void square4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_square4MouseClicked
        // TODO add your handling code here:
        if (game.isEmpty(1, 1) && turn)  
        {
            game.move(1, 1, player);
            
            if (player == 'O') 
            {
                square4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle.png")));
            } else {
                square4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cross.png")));
            }
            
            turn = false;
            setTurnText();
            evaluateGame();
            getMove();
        }
    }//GEN-LAST:event_square4MouseClicked

    private void square5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_square5MouseClicked
        // TODO add your handling code here:
        if (game.isEmpty(1, 2) && turn)  
        {
            game.move(1, 2, player);
            
            if (player == 'O') 
            {
                square5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle.png")));
            } else {
                square5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cross.png")));
            }
            
            turn = false;
            setTurnText();
            evaluateGame();
            getMove();
        }
    }//GEN-LAST:event_square5MouseClicked

    private void square6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_square6MouseClicked
        // TODO add your handling code here:
        if (game.isEmpty(2, 0) && turn)  
        {
            game.move(2, 0, player);
            
            if (player == 'O') 
            {
                square6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle.png")));
            } else {
                square6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cross.png")));
            }
            
            turn = false;
            setTurnText();
            evaluateGame();
            getMove();
        }
    }//GEN-LAST:event_square6MouseClicked

    private void square7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_square7MouseClicked
        // TODO add your handling code here:
        if (game.isEmpty(2, 1) && turn)  
        {
            game.move(2, 1, player);
            
            if (player == 'O') 
            {
                square7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle.png")));
            } else {
                square7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cross.png")));
            }
            
            turn = false;
            setTurnText();
            evaluateGame();
            getMove();
        }
    }//GEN-LAST:event_square7MouseClicked

    private void square8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_square8MouseClicked
        // TODO add your handling code here:
        if (game.isEmpty(2, 2) && turn)  
        {
            game.move(2, 2, player);
            
            if (player == 'O') 
            {
                square8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle.png")));
            } else {
                square8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cross.png")));
            }
            
            turn = false;
            setTurnText();
            evaluateGame();
            getMove();
        }
    }//GEN-LAST:event_square8MouseClicked

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
            java.util.logging.Logger.getLogger(GameGraphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameGraphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameGraphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameGraphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameGraphics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel square0;
    private javax.swing.JLabel square1;
    private javax.swing.JLabel square2;
    private javax.swing.JLabel square3;
    private javax.swing.JLabel square4;
    private javax.swing.JLabel square5;
    private javax.swing.JLabel square6;
    private javax.swing.JLabel square7;
    private javax.swing.JLabel square8;
    // End of variables declaration//GEN-END:variables
}
