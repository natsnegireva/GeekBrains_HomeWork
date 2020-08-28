package homework8.server.handler;

import homework8.server.inter.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
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

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.dis = new DataInputStream( socket.getInputStream() );
            this.dos = new DataOutputStream( socket.getOutputStream() );
            this.nick = "";
            new Thread( () -> {
                try {
                    authentication();
                    readMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            } ).start();
        } catch (IOException e) {
            throw new RuntimeException( "Проблемы при создании обработчика клиента" );
        }
    }

    // ДЗ Добавить отключение неавторизованных пользователей по таймауту (120 сек)
    // ждём после подключения клиента, и если он не авторизовался за это время, закрываем соединение
    // добавлен метод timeOutCount(), изменен метод authentication()

    private void authentication() throws IOException {
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

    public boolean timeOutCount(long b) {
        final long timedOut = 120000;
        long endTime = b + timedOut;
        if (System.currentTimeMillis() < endTime) {
            return true;
        } else {
            return false;
        }
    }

    public void sendMsg(String msg) {
        try {
            dos.writeUTF( msg );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessage() throws IOException {
        while (true) {
            String clientStr = dis.readUTF();
            if (clientStr.startsWith( "/" )) {
                if (clientStr.equals( "/exit" )) {
                    return;
                }
                if (clientStr.startsWith( "/w" )) {
                    String[] strArray = clientStr.split( "\\s" );
                    String nickName = strArray[1];
                    String msg = clientStr.substring( 4 + nickName.length() );
                }
                continue;
            }
            server.broadcastMsg( this.nick + ": " + clientStr );
        }
    }

    private void closeConnection() {
        server.unsubscribe( this );
        server.broadcastMsg( this.nick + ": вышел из чата" );
        try {
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
