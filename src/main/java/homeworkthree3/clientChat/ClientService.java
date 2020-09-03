package homeworkthree3.clientChat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientService implements Runnable {

    @FXML
    TextField loginField; // логин
    @FXML
    TextField passField; // пароль
    @FXML
    TextField msgField; // окно ввода сообщения
    @FXML
    TextArea chatArea; // окно чата
    @FXML
    Button loginButton; // кнопка авторизации
    @FXML
    Button sendButton; // кнопка отправки сообщение


    private Socket socket;
    private static DataInputStream dis; // читаем
    private static DataOutputStream dos; // отсылаем
    private String nick;

    @Override
    public void run() {
        nick = "";
        try {
            socket = new Socket( "localhost", 8189 );
            dis = new DataInputStream( socket.getInputStream() );
            dos = new DataOutputStream( socket.getOutputStream() );
            setAutorized( false );
            Thread t1 = new Thread( () -> {
                try {
                    while (true) {
                        // После авторизации от сервера приходит сообщение формата «/authOk nick»,
                        // клиент узнает, под каким ником авторизовался.
                        String strMsg = dis.readUTF();
                        if (strMsg.startsWith( "/authOk" )) {
                            setAutorized( true );
                            nick = strMsg.split( "\\s" )[1]; // берем ник
                            break;
                        }
                        chatArea.appendText( strMsg + "\n" );
                    }
                    while (true) {
                        String strMsg = dis.readUTF(); // читаем
                        if (strMsg.equals( "/exit" )) {
                            break;
                        }
                        chatArea.appendText( strMsg + "\n" );
                    }
                } catch (RuntimeException, IOException e) {
                    e.printStackTrace();
                    chatArea.appendText( "ОШИБКА СОЕДИНЕНИЯ" + "\n" );
                } finally {
                    try {
                        setAutorized( false );
                        chatArea.appendText( "ЧАТ ЗАКРЫТ" + "\n" );
                        socket.close();
                        nick = "";
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } );
            t1.setDaemon( true );
            t1.start();
        } catch (IOException e) {
            chatArea.appendText( "Не удалось подключиться к серверу" );
            e.printStackTrace();
        }
    }

    // действия кнопки отправки сообщения с датой
    public void sendMsgAction(ActionEvent actionEvent) {
        if(setAutorized( true )) {
            try {
                dos.writeUTF( msgField.getText() + "\n");
                chatArea.appendText(dis.readUTF());
                msgField.clear();
                msgField.requestFocus();
            } catch (IOException e) {
                chatArea.appendText( "СООБЩЕНИЕ НЕ УХОДИТ" + "\n");
            }
        } else {
            chatArea.appendText( "ВАМ НЕОБХОДИМО АВТОРИЗОВАТЬСЯ" );
            sendButton.setVisible( false );
            msgField.setVisible( false );
            loginField.requestFocus();
        }
    }

    // действия кнопки пароля-логина
    public void onAuthClickButton(ActionEvent actionEvent) throws NullPointerException {
        if (loginField.getText() != null && passField.getText() != null) {
            try {
                String logPass = loginField.getText() + "\\s" + passField.getText();
                dos.writeUTF( "/auth" + logPass + "\n" );
                passField.setVisible( false );
                loginField.setVisible( false );
                loginButton.setVisible( false );
                msgField.requestFocus();
            } catch (NullPointerException | IOException c) {
                chatArea.appendText( "НЕ ВЕРНО ВВЕДЕН ЛОГИН ПАРОЛЬ" );
                loginField.clear();
                passField.clear();
                loginField.requestFocus();
            }
        } else {
            setAutorized( false );
            loginField.clear();
            passField.clear();
            sendButton.setVisible( false );
            msgField.setVisible( false );
        }
        setAutorized(true);
    }

    private boolean setAutorized(boolean b) {
        return b;
    }

}