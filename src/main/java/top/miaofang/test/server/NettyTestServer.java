package top.miaofang.test.server;

import top.miaofang.api.HelloService;
import top.miaofang.core.netty.server.NettyServer;
import top.miaofang.core.serializer.KryoSerializer;
import top.miaofang.core.serializer.ProtobufSerializer;
import top.miaofang.core.registry.ServiceRegistry;

/**
 * 测试用Netty服务提供者（服务端）
 * @author miao
 */
public class NettyTestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        NettyServer server = new NettyServer("127.0.0.1", 9999);
        server.setSerializer(new KryoSerializer());
        server.publishService(helloService, HelloService.class);
    }

}
