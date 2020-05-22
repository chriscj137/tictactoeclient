/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author chris
 */
public class Client {

    public Socket socket;
    public DataOutputStream dos;
    public DataInputStream dis;
    
    public String clientName;

    public Client(InetAddress ip, int port) throws IOException {
        socket = new Socket(ip, port);
        dos = new DataOutputStream(socket.getOutputStream());
        dis = new DataInputStream(socket.getInputStream());
        socket.setSoTimeout(3 * 1000);
    }
}
