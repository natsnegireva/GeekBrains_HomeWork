package homeworkthree3.serverChat.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class Bdconn {
    // singleton патерн неизменный и для одного обьекта conn
    private static Bdconn instance; // транзакция
    private static Connection conn; // соединение

    private Bdconn() throws SQLException {

        ResourceBundle rb = ResourceBundle.getBundle( "db" );
        String host = rb.getString( "host" );
        String port = rb.getString( "port" );
        String db = rb.getString( "db" );
        String user = rb.getString( "user" );
        String password = rb.getString( "password" );
        String jdbcURL = MessageFormat.format( "jdbc:mysql://{0}:{1}/{2}", host, port, db );
        conn = DriverManager.getConnection( jdbcURL, user, password );  // подключаем через драйвер менеджер
    }

    public static Bdconn getInstance() {
        if (instance == null) {  // если обьект Bdconn не создан
            try {
                instance = new Bdconn(); // создаем обьект Bdconn
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Connection connection() { // как инкапсуляция
        return conn;
    }
}
