package homeworkthree3.serverChat.impl;

import homeworkthree3.serverChat.handler.NewUser;

import java.sql.SQLException;

public interface AuthService {
    // Интерфейс AuthService описывает правила работы с сервисом авторизации

    void start() throws SQLException;

    String getNick(String login, String password) throws SQLException; // получаем пользователя по нику

    void deleteByNick(String nick) throws SQLException; // удаляем пользователя по нику

    String changeNick(String nick, String newnick) throws SQLException; // заменяем ник пользователя

    NewUser getUserByNick(String nick) throws SQLException; // получаем пользователя по нику

    void stop();
}