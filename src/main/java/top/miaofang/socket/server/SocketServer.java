package top.miaofang.socket.server;


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
