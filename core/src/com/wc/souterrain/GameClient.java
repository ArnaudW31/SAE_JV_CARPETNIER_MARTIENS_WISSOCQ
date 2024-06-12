package com.wc.souterrain;


import java.io.*;
import java.net.*;

public class GameClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connecté au serveur. " + in.readLine());

            String userInput;
            while ((userInput = consoleInput.readLine()) != null) {
                out.println(userInput);
                System.out.println("Réponse du serveur: " + in.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
