/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Socket.Client;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import tictactoe.Models.GameUser;

/**
 *
 * @author Andres
 */
public class Dashboard extends javax.swing.JFrame {

    private final Client client;
    private final GameUser gameUser;

    private final ArrayList<GameUser> connectedGameUsers;

    /**
     * Creates new form Dashboard
     *
     * @param client
     * @param gameUser
     */
    public Dashboard(Client client, GameUser gameUser) throws IOException {
        this.client = client;
        this.gameUser = gameUser;
        connectedGameUsers = new ArrayList<>();

        initComponents();
        TableCellRenderer baseRenderer = jTable1.getTableHeader().getDefaultRenderer();
        jTable1.getTableHeader().setDefaultRenderer(new TableHeaderRenderer(baseRenderer));
        jTable1.getTableHeader().setFont(new Font("Leelawadee UI", Font.PLAIN, 14));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(241, 241, 241));
        jTable1.getTableHeader().setForeground(new Color(118, 117, 116));
        jTable1.getTableHeader().setPreferredSize(new Dimension(jTable1.getWidth(), 60));
        jTable1.setRowHeight(60);
        jTable1.setRowSelectionAllowed(false);

        baseRenderer = jTable2.getTableHeader().getDefaultRenderer();
        jTable2.getTableHeader().setDefaultRenderer(new TableHeaderRenderer(baseRenderer));
        jTable2.getTableHeader().setFont(new Font("Leelawadee UI", Font.PLAIN, 14));
        jTable2.getTableHeader().setOpaque(false);
        jTable2.getTableHeader().setBackground(new Color(241, 241, 241));
        jTable2.getTableHeader().setForeground(new Color(118, 117, 116));
        jTable2.getTableHeader().setPreferredSize(new Dimension(jTable2.getWidth(), 60));
        jTable2.setRowHeight(60);

        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Jugador");
        jTable1.setModel(dtm);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int dialog = JOptionPane.YES_NO_OPTION;
                int result = JOptionPane.showConfirmDialog(null, "Exit?", "Exit", dialog);
                if (result == 0) {
                    try {
                        client.dos.writeUTF("exit");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    System.exit(0);
                }
            }
        });
        getUsersConnected();
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow >= 0 && !e.getValueIsAdjusting()) {
                    try {
                        client.dos.writeUTF("duel");

                        GameUser challenged = connectedGameUsers.get(selectedRow);
                        client.dos.writeUTF(challenged.toString());

                        client.socket.setSoTimeout(0);

                        GameGraphics game = new GameGraphics(true, 'X', gameUser, challenged, true, client);
                        dispose();
                        game.setVisible(true);

                    } catch (IOException ex) {
                        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        //getHistory();
    }

    private void getHistory() {

        try {
            client.dos.writeUTF("history");
            int amount = client.dis.readInt();
            client.dos.writeBoolean(true);
            for (int i = 0; i < amount; i++) {
                System.out.println(client.dis.readUTF());
            }
        } catch (IOException ex) {
            System.out.println("LOL");
        }
    }

    private void getUsersConnected() throws IOException {
        client.dos.writeUTF("allGUCon");
        connectedGameUsers.clear();

        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dtm.addColumn("Jugador");

        int value = client.dis.readInt();

        for (int i = 0; i < value; i++) {
            GameUser gu = new GameUser(client.dis.readUTF());
            if (gu.idUser != gameUser.idUser) {
                connectedGameUsers.add(gu);
            }
        }

        for (GameUser gu : connectedGameUsers) {
            dtm.addRow(new Object[]{gu.username});
        }

        jTable1.setModel(dtm);
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
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 99, 71));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Angel33");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 210, 70));
        jLabel1.getAccessibleContext().setAccessibleDescription("");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 99, 71), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_User_96px_2.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 120, 140));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 150));

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("14");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 60, 30));

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Victorias");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 80, 30));

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("18");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 60, 30));

        jLabel11.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Derrotas");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 80, 30));

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("3");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 60, 30));

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Empates");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 80, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 440, 150));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Search_32px.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel15.setMaximumSize(new java.awt.Dimension(32, 32));
        jLabel15.setMinimumSize(new java.awt.Dimension(32, 32));
        jLabel15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel15MouseMoved(evt);
            }
        });
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 30, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(48, 46, 43));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Jugadores conectados");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reload.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel16.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel16MouseMoved(evt);
            }
        });
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 30, 40));

        jPanel6.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 271, 40));

        jTable1.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(94, 94, 94));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"     Mauricio"},
                {"    Angelito33"},
                {"    Meu"},
                {"    Cris"}
            },
            new String [] {
                "Jugador "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(237, 235, 234));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, 271, 430));

        jPanel3.setBackground(new java.awt.Color(241, 241, 241));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(118, 117, 116), 1, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(118, 117, 116));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Jugar contra la computadora");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 60));

        jPanel6.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 500, 270, 60));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 300, 580));

        jTable2.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(94, 94, 94));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"     Angel33", "     Mauricio", "     Victoria"},
                {"     Mauricio", "     Angel33", "     Empate"},
                {"     Cris", "     Angel33", "    Empate"},
                {"     Cris", "     Angel33", "     Derrota"},
                {"     Angel33", "     Cris", "    Victoria"},
                {"     Angel33", "     Mauricio", "    Derrota"}
            },
            new String [] {
                "Jugador X", "Jugador O", "Resultado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setFocusable(false);
        jTable2.setGridColor(new java.awt.Color(237, 235, 234));
        jTable2.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable2.setRowHeight(60);
        jTable2.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable2.setShowVerticalLines(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 220, 440, 340));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(48, 46, 43));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Historial");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 70, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        SelectPlayer select = new SelectPlayer(gameUser, client);
        select.setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel15MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseMoved
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
    }//GEN-LAST:event_jLabel15MouseMoved

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        try {
            if (client.dis.readUTF().equals("challenged")) {
                GameUser gu = new GameUser(client.dis.readUTF());
                client.socket.setSoTimeout(0);
                client.dos.writeUTF("challengeAccepted");
                client.dos.writeUTF(gameUser.toString());

                GameGraphics game = new GameGraphics(true, 'O', gu, gameUser, false, client);
                dispose();
                game.setVisible(true);
            }
        } catch (IOException ex) {
            int dialog = JOptionPane.INFORMATION_MESSAGE;
            JOptionPane.showMessageDialog(null, "No tienes retos disponibles", "Duelo", dialog);
        }
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel16MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseMoved

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        try {
            getUsersConnected();
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseExited

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
            java.util.logging.Logger.getLogger(Dashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard(client).setVisible(true);
            }
        });
         */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

}
