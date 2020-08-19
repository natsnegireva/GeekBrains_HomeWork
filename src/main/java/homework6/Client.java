package homework6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {


    // ПОЛЬЗОВАТЕЛЬ может писать сообщения, как на клиентской стороне, так и на серверной
    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        try {
            Socket socket = null;
            socket = new Socket("localhost", 8959);

            Scanner sc = new Scanner(System.in);
            Scanner dis =  new Scanner(socket.getInputStream());
            PrintWriter dos = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Вы соеденены с сервером..." + "\n");

            Socket finalSocket = socket;
            Thread thread = new Thread( (Runnable) () -> {
                while (true) {
                    try {
                    String msg = dis.nextLine();
                    System.out.println("Сервер: " + msg);
                    } catch (NoSuchElementException e) {
                        break;
                    }
                }
            });
            thread.setDaemon(true);
            thread.start();

            while (true) {
                String msg = sc.nextLine();
                if (msg.equals("exit")) {
                    sc.close();
                    break;
                }
                dos.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

