package com.project.wavveline.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ClientServer {
    private ArrayList<PrintWriter> users = null;
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private PrintWriter p = null;
    private String message;

    public ClientServer() {
        users = new ArrayList<PrintWriter>();

        try {
            serverSocket = new ServerSocket(8000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                socket = serverSocket.accept();
                new Thread(new ClientListener(socket)).start();
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                users.add(printWriter);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void sendMessage(String message) {
        for (PrintWriter printWriter : users) {
            printWriter.println(message);
            printWriter.flush();
        }
    }
}
