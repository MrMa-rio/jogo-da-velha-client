package org.jogos.services.commandsService;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SendCommandService implements Runnable {

    Socket socket;
    public SendCommandService(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        Scanner keyboard = new Scanner(System.in);
        PrintStream exit; //
        try {
            exit = new PrintStream(socket.getOutputStream());
            while (keyboard.hasNextLine()) {
                String readLine = keyboard.nextLine();
                if (readLine.trim().isEmpty()) break;
                exit.println(readLine);
            }
            keyboard.close(); //
            exit.close(); //
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
