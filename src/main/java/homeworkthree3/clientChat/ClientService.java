package homeworkthree3.clientChat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
    @FXML
    TextField listArea; // поле для списка пользователей
    @FXML
    TextField nickField; // ПОЛЕ ДЛЯ ЛОГИНА


    private Socket socket;
    private static DataInputStream dis; // читаем
    private static DataOutputStream dos; // отсылаем
    private String Mynick;

    @Override
    public void run() {
        Mynick = nickField.getText();
        try {
            socket = new Socket( "localhost", 8173 );
            dis = new DataInputStream( socket.getInputStream() );
            dos = new DataOutputStream( socket.getOutputStream() );
            setAutorized( false );
            Thread t1 = new Thread( () -> {
                try {
                    while (socket.isConnected()) {
                        String strMsg = null;
                        strMsg = dis.readUTF();
                        if (strMsg.startsWith( "/authOk" )) {
                            setAutorized( true );
                            Mynick = strMsg.split( "\\s" )[1];
                            listArea.appendText( Mynick + "\n" );
                            getChat();
                            break;
                        } else {
                            addMessage( strMsg );
                        }
                        if (strMsg.equals( "/exit" )) {
                            saveChat();
                            addMessage( strMsg );
                            break;
                        }
                    }
                } catch (IOException e) {
                    chatArea.appendText( "ОШИБКА СОЕДИНЕНИЯ" + "\n" );
                } finally {
                    try {
                        setAutorized( false );
                        chatArea.appendText( "ЧАТ ЗАКРЫТ" + "\n" );
                        socket.close();
                        Mynick = "";
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } );
            t1.setDaemon( true );
            t1.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // действия кнопки отправки сообщения с датой
    public void sendMsgAction() {
        if (setAutorized( true )) {
            sendMessage( msgField.getText() );
            msgField.clear();
        } else {
            chatArea.appendText( "ВАМ НЕОБХОДИМО АВТОРИЗОВАТЬСЯ" + "\n" );
        }
    }

    // добавляем текст в поле чата
    public void addMessage(String msg) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "HH:mm:ss" );
        LocalDateTime now = LocalDateTime.now();
        chatArea.appendText( dtf.format( now ) + " : " + msg + "\n" );
        chatArea.selectPositionCaret( this.chatArea.getLength() );
    }

    // отсылает сообщение на сервер
    public static void sendMessage(String msg) throws NullPointerException {
        if (!msg.isEmpty()) {
            try {
                dos.writeUTF( msg + "\n" );
                dos.flush();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    // действия кнопки пароля-логина
    public void onAuthClickButton() throws NullPointerException {
        if (loginField.getText() != null && passField.getText() != null && nickField.getText() != null) {
            try {
                String msg = "/auth " + loginField.getText() + passField.getText() + nickField.getText();
                sendMessage(msg);
            } catch (NullPointerException e) {
                e.printStackTrace();
                chatArea.appendText( "НЕ ВЕРНО ВВЕДЕН ЛОГИН ПАРОЛЬ" + "\n" );
                loginField.clear();
                passField.clear();
            }
        } else {
            setAutorized( false );
            loginField.clear();
            passField.clear();
            String msg = "";
        }
    }

    public boolean setAutorized(boolean b) {
        return b;
    }


    // сохраняем историю поля чата
    private void saveChat() throws IOException {
        try {
            File history = new File( "/Chat.txt" );
            if (!history.exists()) {
                history.createNewFile();
            }
            PrintWriter fileWriter = new PrintWriter( new FileWriter( history, false ) );
            BufferedWriter bufferedWriter = new BufferedWriter( fileWriter );
            bufferedWriter.write( chatArea.getText() );
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // загружаем историю в поле чата
    private void getChat() throws IOException {
        int lengthStory = 100;
        File history = new File( "/Chat.txt" );
        List<String> historyList = new ArrayList<>();
        FileInputStream in = new FileInputStream( history );
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( in ) );

        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            historyList.add( temp );
        }

        if (historyList.size() > lengthStory) {
            for (int i = historyList.size() - lengthStory; i <= (historyList.size() - 1); i++) {
                chatArea.appendText( historyList.get( i ) + "\n" );
            }
        } else {
            for (int i = 0; i < lengthStory; i++) {
                System.out.println( historyList.get( i ) );
            }
        }
    }

}