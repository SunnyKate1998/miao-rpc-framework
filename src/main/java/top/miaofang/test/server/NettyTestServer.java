package top.miaofang.test.server;

import top.miaofang.api.HelloService;
import top.miaofang.core.netty.server.NettyServer;
import top.miaofang.core.registry.DefaultServiceRegistry;
import top.miaofang.core.registry.ServiceRegistry;

/**
 * 测试用Netty服务提供者（服务端）
 * @author miao
 */
public class NettyTestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry registry = new DefaultServiceRegistry();
        registry.register(helloService);
        NettyServer server = new NettyServer();
        server.start(9999);
    }

}
