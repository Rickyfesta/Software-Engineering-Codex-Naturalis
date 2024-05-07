package Controller;

import java.io.*;
import java.net.Socket;

//handles the connections between clients and server

public class ClientHandler implements Runnable {
    private Socket socket;
    private ClientDisconnectListener listener;

    public interface ClientDisconnectListener {
        void onClientDisconnect();
    }

    public ClientHandler(Socket socket, ClientDisconnectListener listener) {
        this.socket = socket;
        this.listener = listener;
    }
    public static void makeTurn(String currentPlayer) {
    }

    @Override
    public void run() {
        try (InputStream input = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input));
             OutputStream output = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(output, true)) {

            // Listening for client
            String line;
            while ((line = reader.readLine()) != null) {
            }
        } catch (IOException ex) {
            System.out.println("Error in ClientHandler: " + ex.getMessage());
        } finally {
            listener.onClientDisconnect(); // Notify server about the disconnection
            closeResources();
        }
    }

    private void closeResources() {
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Failed to close socket");
        }
    }
}


