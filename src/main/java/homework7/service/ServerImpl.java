package homework7.service;

import homework7.handler.ClientHandler;
import homework7.inter.AuthService;
import homework7.inter.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ServerImpl implements Server {

    private List<ClientHandler> clients;
    private AuthService authService;

    public ServerImpl() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            authService = new AuthServiceImpl();
            authService.start();
            clients = new LinkedList<>();
            while (true) {
                System.out.println("Wait join clients");
                Socket socket = serverSocket.accept();
                System.out.println("Client join");
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            System.out.println("Problem in server");
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public synchronized void sendMsgToClient(ClientHandler from, String nickTo, String msg) {
        for (ClientHandler c : clients) {
            if (c.getNick().equals(nickTo)) {
                c.sendMsg("от " + from.getNick() + ": " + msg);
                from.sendMsg("клиенту " + nickTo + ": " + msg);
                return;
            }
        }
        from.sendMsg(nickTo + " нет сейчас в чат-комнате");
    }

// Реализовать личные сообщения, если клиент пишет «/w nick3 Привет»,
// то только клиенту с ником nick3 должно прийти сообщение «Привет»
    public synchronized void broadcastClientsList() {
        StringBuilder sb = new StringBuilder("/w ");
        for (ClientHandler c : clients) {
            sb.append(c.getNick() + " ");
        }
        broadcastMsg(sb.toString());
    }

    @Override
    public synchronized boolean isNickBusy(String nick) {
        for (ClientHandler c : clients) {
            if (c.getNick() != null && c.getNick().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public synchronized void broadcastMsg(String msg) {
        for (ClientHandler c : clients) {
            c.sendMsg(msg);
        }
    }

    @Override
    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    @Override
    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    @Override
    public AuthService getAuthService() {
        return authService;
    }
}