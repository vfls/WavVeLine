package com.project.wavveline.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ClientListener implements Runnable {

    private Socket socket;
    private List<PrintWriter> users;
    private PrintWriter messages;
    private Scanner input;


    public ClientListener(Socket socket) {
        this.socket = socket;
        this.users = users;

        try {
            this.messages = new PrintWriter(socket.getOutputStream(), true);
            this.input = new Scanner(socket.getInputStream());
            synchronized (users) {
                users.add(messages);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = input.nextLine()) != null) {
                broadcastMessage(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            synchronized (users) {
                users.remove(messages); {
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    private void broadcastMessage(String message) {
        synchronized (users) {
            for (PrintWriter printWriter : users) {
                printWriter.println(message);
            }
        }
    }
}
