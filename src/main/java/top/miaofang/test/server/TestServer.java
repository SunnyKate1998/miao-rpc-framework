package top.miaofang.test.server;

import top.miaofang.api.HelloService;
import top.miaofang.core.registry.DefaultServiceRegistry;
import top.miaofang.core.registry.ServiceRegistry;
import top.miaofang.core.server.RpcServer;

/**
 * 测试用服务提供方（服务端）
 * @author miao
 */

public class TestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry serviceRegistry = new DefaultServiceRegistry();
        serviceRegistry.register(helloService);
        RpcServer rpcServer = new RpcServer(serviceRegistry);
        rpcServer.start(9000);
    }
}
