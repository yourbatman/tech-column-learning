package cn.yourbatman.javaee.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/7/4 16:17
 * @since 0.0.1
 */
@ServerEndpoint("/websocket/chat")
public class WsServer {


    // 当前连接上来的连接们（每一个连接都是一个WsServerDemo实例，包含一个Session会话）
    private static Set<WsServer> webSocketSet = new CopyOnWriteArraySet<>();
    // 会话
    private Session session;

    /**
     * 建连成功的回调
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this); // 保存当前连接
        System.out.println("Server有新连接加入！当前在线人数为" + webSocketSet.size());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        System.out.println("Server有一连接关闭！当前在线人数为" + webSocketSet.size());
    }

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String message) throws IOException {
        System.out.println("Server来自客户端的消息:" + message);
        sendMessage("会话[" + session.getId() + "]的消息已经收到，内容为：" + message);
        // // =======群发消息=========
        // for (WsServerDemo item : webSocketSet) {
        //     try {
        //         item.sendMessage(message);
        //     } catch (IOException e) {
        //         continue;
        //     }
        // }
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Throwable error) {
        System.out.println("Server发生错误：" + error.getMessage());
    }

    /**
     * 发送消息
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

}
