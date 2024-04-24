package org.jogos.services.commandsService;

import java.net.Socket;
import java.util.Scanner;

public class ReceiveCommandService implements Runnable {

    Socket socket;
    public ReceiveCommandService(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        Scanner serverResponse;
        try {
            serverResponse = new Scanner(socket.getInputStream()); // Ao inves de pegar a entrada do sistema/usuario está pegando a do cliente?
            while(serverResponse.hasNextLine()){
                String readLine = serverResponse.nextLine();
                System.out.println(readLine);
            }
            serverResponse.close();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
