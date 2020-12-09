package com.data.dormitory.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.data.dormitory.dto.apply.ApplyMessageDto;
import com.data.dormitory.dto.apply.WarningMsgDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

    private static Logger LOGGER = LoggerFactory.getLogger(WebSocket.class);
    private Session session;

    /**
     * 在线人数
     */
    private static int onlineCount = 0;

    /**
     * 在线用户的Map集合，key：用户名，value：Session对象
     */
    private static Map<String, Session> sessionMap = new HashMap<String, Session>();

    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void openSocket(Session session) {
        this.session = session;
        LOGGER.info("新的连接建立");
        // 将新用户加入数组
        webSocketSet.add(this);
        LOGGER.info("[webSocket消息]连接总数:{}", webSocketSet.size());
    }

    @OnClose
    public void Onclose(){
        webSocketSet.remove(this);
        LOGGER.info("[webSocket消息]一条连接断开,总数:{}", webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message, Session session) {

        // 推送消息到在线的辅导员
        // 协议约定：发送json消息
        // 消息类型标识。   消息收信人标识。   同类型消息列表
        // {
        //      “kind” : "1.常规晚归、离校申请",
        //      “intrustoriid” : sx-9605,
        //      “ark”:
        //      {
        //          "":"",
        //      }
        // }
        // {
        //      “kind” ： 2 紧急消息,
        //      “insturctiid” ： “”,
        //      "warning"：{}
        // }
        LOGGER.info("[webSocket消息]收到来自客户端的消息:{}", message);
        JSONObject jsonObject = JSON.parseObject(message);
        int kind = Integer.parseInt(jsonObject.getString("kind"));
        if (kind == 1) {
            ApplyMessageDto applyMessageDto = JSON.parseObject(message, ApplyMessageDto.class);
        } else if (kind == 2) {
            WarningMsgDto warningMsgDto = JSON.parseObject(message, WarningMsgDto.class);
        }

    }

    /**
     * 私聊
     */
    private void privateChat(Session session, Map tarUser, HashMap hashMap) throws IOException {
        //获取目标用户的session
        Session tarUserSession = sessionMap.get(tarUser.get("username"));

        //如果不在线则发送“对方不在线”回来源用户
        if (tarUserSession == null) {
            session.getBasicRemote().sendText("{\"type\":\"0\",\"message\":\"对方不在线\"}");
        } else {
            hashMap.put("type", "1");
            tarUserSession.getBasicRemote().sendText(new ObjectMapper().writeValueAsString(hashMap));
        }
    }

    /**
     * 群聊
     */
    private void groupChat(Session session,HashMap hashMap) throws IOException {
        for (Map.Entry<String, Session> entry : sessionMap.entrySet()) {
            //自己就不用再发送消息了
            if (entry.getValue() != session) {
                hashMap.put("type", "2");
                entry.getValue().getBasicRemote().sendText(new ObjectMapper().writeValueAsString(hashMap));
            }
        }
    }

    // 群发通知消息
    public void sendMessage(String message){
        for (WebSocket webSocket : webSocketSet) {
            LOGGER.info("[webSocket消息]广播消息通知,message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
