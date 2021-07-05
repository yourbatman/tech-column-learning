package cn.yourbatman.javaee.websocket;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/7/4 16:29
 * @since 0.0.1
 */
@ClientEndpoint
public class WsClient {

    // 会话（与服务端建立的会话）
    private Session session;

    /**
     * 建连成功的回调
     */
    @OnOpen
    public void onOpen(Session session) throws IOException {
        this.session = session;
        System.out.println("Client连接到服务端成功，会话ID：" + session.getId());
        sendMessage("这是一条来自Client端，会话["+session.getId()+"]的消息");
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Client端收到消息: " + message);
    }

    @OnClose
    public void onClose() {
        System.out.println("Client会话" + session.getId() + "已断开");
    }

    /**
     * 发送消息
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
}
