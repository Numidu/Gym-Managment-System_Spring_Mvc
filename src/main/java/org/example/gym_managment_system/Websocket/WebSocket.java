package org.example.gym_managment_system.Websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@Configuration
@EnableWebSocket
public class WebSocket
        implements WebSocketConfigurer {

    @Autowired
    private TextHandler textHandler;

    @Override
    public void registerWebSocketHandlers(
            WebSocketHandlerRegistry registry) {

        registry.addHandler(
                textHandler,
                "/my-raw-ws"
        ).setAllowedOrigins("*");
    }
}

