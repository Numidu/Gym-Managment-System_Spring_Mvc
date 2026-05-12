package org.example.gym_managment_system.Websocket;


import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class TextHandler extends TextWebSocketHandler {

    private static final List<WebSocketSession> sessions =
            new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(
            WebSocketSession session)
            throws Exception {

        sessions.add(session);

        System.out.println("Connected : " + session);

        System.out.println(
                "Users : " + sessions.size()
        );
    }

    @Override
    public void afterConnectionClosed(
            WebSocketSession session,
            CloseStatus status)
            throws Exception {

        sessions.remove(session);

        System.out.println("Disconnected");
    }

    public static void sendToAll(String message)
            throws Exception {

        System.out.println(
                "Broadcast Users : "
                        + sessions.size()
        );

        for(WebSocketSession session : sessions){

            if(session.isOpen()){

                session.sendMessage(
                        new TextMessage(message)
                );
            }
        }
    }
}