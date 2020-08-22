package homework6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        Server server = new Server();
    }
    public Server() {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8959);
            System.out.println("Сервер запущен...");
            socket = server.accept();
            System.out.println("Клиент присоединился");

            Scanner sc = new Scanner(System.in);
            Scanner dis =  new Scanner(socket.getInputStream());
            PrintWriter dos = new PrintWriter(socket.getOutputStream(), true);

            Thread thread = new Thread( (Runnable) () -> {
                    while (true) {
                        String msg = sc.nextLine();
                        if (msg.equals("exit")) {
                            break;
                        }
                        dos.println(msg);
                    }
            });            
            thread.start();

            while (true) {
                try {
                    String msg = dis.nextLine();
                    System.out.println("Клиент: " + msg);
                } catch (NoSuchElementException e) {
                    System.out.println("Клиент отсоединился");
                    break;
                }
            }
            sc.close(); // Поправка когда клиент отключается, то на сервере сканер не должен закрываться 
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
