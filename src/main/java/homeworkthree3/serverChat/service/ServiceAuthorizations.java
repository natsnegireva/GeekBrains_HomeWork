package homeworkthree3.serverChat.service;


import homeworkthree3.serverChat.handler.NewUser;
import homeworkthree3.serverChat.impl.AuthService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ServiceAuthorizations implements AuthService {
    // Простейшая реализация этого интерфейса AuthService основана на использовании списка записей
    // логин-пароль-ник, поиск осуществляется перебором списка записей.
    // Сервис авторизации доработан для использования с базой данных

    // ДОБАВЛЕНЫ МЕТОДЫ УДАЛЕНИЯ ПО НИКУ, ЗАМЕНА НИКА, ПОЛУЧЕНИЕ ПО НИКУ, START-STOP
    private static Bdconn bdconn;
    private static PreparedStatement ps = null;
    private List<NewUser> usersList;

    public ServiceAuthorizations() throws SQLException {
        start();
        this.usersList = new LinkedList<>();

    }

    // добавляем пользователя
    public static void addUser(NewUser user) throws SQLException {
        ps = Bdconn
                .getInstance()
                .connection()
                .prepareStatement( "INSERT INTO users_t (login, pass, nick) VALUES (?, ?, ?)" );
        ps.setString( 1, user.getLogin() );
        ps.setString( 2, user.getPass() );
        ps.setString( 3, user.getNick() );
        int a = ps.executeUpdate(); // подготовка и проверка BD на ответ
    }

    // записываем добавленного в лист клиентов онлайн
    public List<NewUser> getUsersList() throws SQLException {
        List<NewUser> list = new ArrayList<>( 2 );
        ps = Bdconn
                .getInstance()
                .connection()
                .prepareStatement( "SELECT * FROM users_t" );

        ResultSet set = ps.executeQuery();

        while (set.next()) {
            NewUser user = new NewUser();
            user.setLogin( set.getString( "LOGIN" ) );
            user.setPass( set.getString( "PASS" ) );
            user.setNick( set.getString( "NICK" ) );
            list.add( user );
        }
        return list; // вернули значения списка
    }

    // меняем ник пользователя
    @Override
    public String changeNick(String nick, String newnick) throws SQLException {
        try {
            ps = Bdconn
                    .getInstance()
                    .connection()
                    .prepareStatement( "UPDATE users_t SET nick = newnick WHERE nick = ? LIMIT 1" );
            ps.setString( 1, nick );
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                return set.getString( 1 );
            }
            return nick;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // удалить пользователя по нику
    @Override
    public void deleteByNick(String nick) throws SQLException {
        try {
            ps = Bdconn
                    .getInstance()
                    .connection()
                    .prepareStatement( "DELETE FROM users WHERE nick = ?" );
            ps.setString( 1, nick );
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // получить ник по логину-паролю
    @Override
    public String getNick(String login, String pass) throws SQLException {
        String nick = "";
        try {
            ps = Bdconn
                    .getInstance()
                    .connection()
                    .prepareStatement( "SELECT nick FROM users_t WHERE login = ? AND pass = ? LIMIT 1" );
            ps.setString( 1, nick );
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                return set.getString( 1 );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // получаем пользователя по нику
    @Override
    public NewUser getUserByNick(String nick) throws SQLException {
        try {
            ps = Bdconn
                    .getInstance()
                    .connection()
                    .prepareStatement( "SELECT * FROM users_t WHERE nick = ?" ); // есть ли такой ник
            ps.setString( 1, nick );

            ResultSet set = ps.executeQuery(); // executeQuery() возвращает какой-то результат

            NewUser user = new NewUser(); // создать нового пользователя
            if (set.next()) { // получить из базы значения
                user.setLogin( set.getString( "LOGIN" ) ); // обращение по имени колонки, либо по ее номеру
                user.setPass( set.getString( "PASS" ) );
                user.setNick( set.getString( "NICK" ) );
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void start() throws SQLException {
        Bdconn.getInstance().connection();
        System.out.println( "Сервис аутентификации запущен" );
        NewUser user = new NewUser(); // создаем нового пользователя
        addUser( user ); // добавляем пользователя в БД
        Bdconn.getInstance().connection().commit(); // коммитим
    }

    @Override
    public void stop() {
        System.out.println( "Сервис аутентификации остановлен" );
        try {
            Bdconn.getInstance().connection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}