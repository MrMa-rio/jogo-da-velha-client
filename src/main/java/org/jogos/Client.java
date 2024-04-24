package org.jogos;

import org.jogos.services.commandsService.ReceiveCommandService;
import org.jogos.services.commandsService.SendCommandService;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 4000); //Instanciou um ouvidor/ uma conexão
        System.out.println("Conectado ao servidor -> " + socket.getInetAddress().getHostAddress());

        Thread sendComandThread = new Thread(new SendCommandService(socket));

        Thread receiveComandThread = new Thread(new ReceiveCommandService(socket));

        receiveComandThread.start(); // iniciou a thread
        sendComandThread.start();// iniciou a thread

        sendComandThread.join();//Thread main aguarda essa thread finalizar o processo

        System.out.println("-----Fechando conexão-----");
        socket.close();
    }
}