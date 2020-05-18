/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToeSocket;

import Frame.IniciarSesion;
import Socket.Client;
import java.io.IOException;
import java.net.InetAddress;

/**
 *
 * @author chris
 */
public class Tictactoesocket {

    public static Client client;

    public static void main(String args[]) throws IOException {

        InetAddress ip = InetAddress.getByName("localhost");
        int port = 5056;
        client = new Client(ip, port);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new IniciarSesion().setVisible(true);
        });

    }
}
