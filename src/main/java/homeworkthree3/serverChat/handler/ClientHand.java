package homeworkthree3.serverChat.handler;

import homeworkthree3.serverChat.impl.Server;
import homeworkthree3.serverChat.service.ServerService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHand {
    // За общение сервера с каждым отдельным клиентом отвечает обработчик - класс ClientHandler
    // Как только клиент подключается, создается новый объект ClientHandler,
    // который будет аутентифицировать клиента и получать от него сообщения.
    private Server server;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    private String nick;

    public String getNick() {
        return nick;
    }

    // создаем ClientHandler для каждого коиента свой
    public ClientHand(ServerService server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            this.nick = "";
            new Thread(() -> {
                try {
                    authentication();
                    readMessage();
                } catch (Throwable e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Проблемы при создании обработчика клиента");
        }
    }

    // отключение неавторизованных пользователей по таймауту (120 сек)
    private void authentication() throws Exception {
        long b = System.currentTimeMillis();
        do {
            String str = dis.readUTF();
            if (str.startsWith( "/auth" )) {
                String[] dataArray = str.split( "\\s" );
                String nick = server.getAuthService().getNick( dataArray[1], dataArray[2] );
                if (nick != null) {
                    if (!server.isNickBusy( nick )) {
                        sendMsg( "/authOk " + nick );
                        this.nick = nick;
                        server.broadcastMsg( this.nick + " Добро пожаловать в чат" );
                        server.subscribe( this );
                        return;
                    } else {
                        sendMsg( "Вы в системе" );
                    }
                } else {
                    sendMsg( "Не правильно введен логин и пароль" );
                }
            }
        } while (timeOutCount( b ));
        closeConnection();
    }

    // таймаут
    public boolean timeOutCount(long b) {
        final long timedOut = 120000;
        long endTime = b + timedOut;
        if (System.currentTimeMillis() < endTime) {
            return true;
        } else {
            return false;
        }
    }

    // отсылаем сообщения пользователю
    public void sendMsg(String msg) {
        try {
            dos.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // читаем сообщения пользователя, все сообщения начиная со / служебные
    // если введено /w - записываем ник и добавляе мк сообщению ОТ
    public void readMessage() throws IOException {
        while (true) {
            String clientStr = dis.readUTF();
            System.out.println("from " + this.nick + ": " + clientStr);
            if (clientStr.equals("/exit")) {
                return;
            }
            server.broadcastMsg(this.nick + ": " + clientStr);
        }
    }

    // закрываем соединение при выходе клиента
    // сообщение сервера всем участникам чата
    private void closeConnection() {
        server.unsubscribe(this);
        server.broadcastMsg(this.nick + ": out from chat");

        try {
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}