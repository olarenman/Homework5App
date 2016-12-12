package orenman.homework5app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Connection {

    private static Connection instance = new Connection();

    private boolean isConnected = false;
    private ObjectInputStream fromServer;
    private ObjectOutputStream toServer;
    private Socket socket;

    private Connection() {
    }

    public static Connection getInstance() {
        return instance;
    }

    public void openConnection(String host, int port) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(host, port), 2000);
        fromServer = new ObjectInputStream(socket.getInputStream());
        toServer = new ObjectOutputStream(socket.getOutputStream());
        isConnected = true;
    }

    public void closeConnection() throws IOException {
        fromServer.close();
        toServer.close();
        socket.close();
        isConnected = false;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void sendMessage(String message) throws IOException {
        toServer.writeObject(message);
        toServer.flush();
    }
}
