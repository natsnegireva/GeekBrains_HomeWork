package homeworkthree3.serverChat.impl;

import homeworkthree3.serverChat.handler.ClientHand;

public interface Server {
    int PORT = 8189;

    boolean isNickBusy(String nick); // проверка свободного ника

    void broadcastMsg(String msg); // рассылка сервера

    void subscribe(ClientHand client); // подписавшиеся клиенты

    void unsubscribe(ClientHand client); // отписавшиеся клиенты

    AuthService getAuthService(); // получаем список подписчиков

    void sendPrivateMsg(ClientHand clientHand, String nick, String clientStr); // формирование сообщения

    void sendMsgToClient(ClientHand from, String to, String msg); // отправка выбранному клиенту

    void broadcastClientList(); // рассылаем список подписчиков

}
