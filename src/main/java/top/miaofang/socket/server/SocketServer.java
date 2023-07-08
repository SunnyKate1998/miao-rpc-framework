package top.miaofang.socket.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.miaofang.common.exception.RpcException;
import top.miaofang.common.enumeration.RpcError;
import top.miaofang.core.provider.ServiceProvider;
import top.miaofang.core.registry.NacosServiceRegistry;
import top.miaofang.core.provider.ServiceProviderImpl;
import top.miaofang.core.registry.ServiceRegistry;
import top.miaofang.core.server.RequestHandler;
import top.miaofang.core.server.RequestHandlerThread;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.*;
import top.miaofang.core.serializer.CommonSerializer;
import top.miaofang.core.server.RpcServer;
import top.miaofang.common.util.ThreadPoolFactory;

public class SocketServer implements RpcServer {

    private static final Logger logger = LoggerFactory.getLogger(SocketServer.class);

    private final ExecutorService threadPool;;
    private final String host;
    private final int port;
    private CommonSerializer serializer;
    private RequestHandler requestHandler = new RequestHandler();

    private final ServiceRegistry serviceRegistry;
    private final ServiceProvider serviceProvider;

    public SocketServer(String host, int port) {
        this.host = host;
        this.port = port;
        threadPool = ThreadPoolFactory.createDefaultThreadPool("socket-rpc-server");
        this.serviceRegistry = new NacosServiceRegistry();
        this.serviceProvider = new ServiceProviderImpl();
    }

    @Override
    public <T> void publishService(Object service, Class<T> serviceClass) {
        if(serializer == null) {
            logger.error("未设置序列化器");
            throw new RpcException(RpcError.SERIALIZER_NOT_FOUND);
        }
        serviceProvider.addServiceProvider(service);
        serviceRegistry.register(serviceClass.getCanonicalName(), new InetSocketAddress(host, port));
        start();
    }

    @Override
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("服务器启动……");
            Socket socket;
            while ((socket = serverSocket.accept()) != null) {
                logger.info("消费者连接: {}:{}", socket.getInetAddress(), socket.getPort());
                threadPool.execute(new RequestHandlerThread(socket, requestHandler, serviceRegistry, serializer));
            }
            threadPool.shutdown();
        } catch (IOException e) {
            logger.error("服务器启动时有错误发生:", e);
        }
    }

    @Override
    public void setSerializer(CommonSerializer serializer) {
        this.serializer = serializer;
    }

}
