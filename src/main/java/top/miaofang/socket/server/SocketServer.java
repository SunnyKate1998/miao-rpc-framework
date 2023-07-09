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


//public class SocketServer extends AbstractRpcServer {
//
//    private final ExecutorService threadPool;
//    private final CommonSerializer serializer;
//    private final RequestHandler requestHandler = new RequestHandler();
//
//    public SocketServer(String host, int port) {
//        this(host, port, DEFAULT_SERIALIZER);
//    }
//
//    public SocketServer(String host, int port, Integer serializer) {
//        this.host = host;
//        this.port = port;
//        threadPool = ThreadPoolFactory.createDefaultThreadPool("socket-rpc-server");
//        this.serviceRegistry = new NacosServiceRegistry();
//        this.serviceProvider = new ServiceProviderImpl();
//        this.serializer = CommonSerializer.getByCode(serializer);
//        scanServices();
//    }
//
//    @Override
//    public void start() {
//        try (ServerSocket serverSocket = new ServerSocket()) {
//            serverSocket.bind(new InetSocketAddress(host, port));
//            logger.info("服务器启动……");
//            ShutdownHook.getShutdownHook().addClearAllHook();
//            Socket socket;
//            while ((socket = serverSocket.accept()) != null) {
//                logger.info("消费者连接: {}:{}", socket.getInetAddress(), socket.getPort());
//                threadPool.execute(new SocketRequestHandlerThread(socket, requestHandler, serializer));
//            }
//            threadPool.shutdown();
//        } catch (IOException e) {
//            logger.error("服务器启动时有错误发生:", e);
//        }
//    }
//
//}
