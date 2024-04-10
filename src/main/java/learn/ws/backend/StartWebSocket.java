package learn.ws.backend;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

@ApplicationScoped
@ServerEndpoint("/ws/{name}")
public class StartWebSocket {

    @Inject 
    ObjectMapper objectMapper;

    @OnOpen
    public void onOpen(Session session, @PathParam("name") String name) {
        System.out.println("onOpen> " + name);
    }

    @OnClose
    public void onClose(Session session, @PathParam("name") String name) {
        System.out.println("onClose> " + name);
    }

    @OnError
    public void onError(Session session, @PathParam("name") String name, Throwable throwable) {
        System.out.println("onError> " + name + ": " + throwable);
    }

    @OnMessage
    public String onMessage(String message, @PathParam("name") String name) throws JsonProcessingException {
        System.out.println("onMessage> " + name + ": " + message);
        return objectMapper.writeValueAsString(Map.of("served-by", System.getenv("HOSTNAME"), "reply", message));
    }
}

