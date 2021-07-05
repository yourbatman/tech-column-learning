package cn.yourbatman.javaee.websocket;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * 用Main方法启动WebSocket的客户端，去连接服务端
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/7/4 16:35
 * @since 0.0.1
 */
public class App {

    private static URI uri = URI.create("ws://localhost:8080/websocket/chat");
    private static Session session;

    public static void main(String[] args) throws DeploymentException, IOException, InterruptedException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();

        // 顺序执行5次会话，端口后再建立新会话
        for (int i = 0; i < 3; i++) {
            session = container.connectToServer(WsClient.class, uri);
            session.close();
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
