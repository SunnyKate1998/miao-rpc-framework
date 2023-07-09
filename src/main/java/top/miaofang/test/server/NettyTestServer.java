package top.miaofang.test.server;

import top.miaofang.api.HelloService;
import top.miaofang.core.annotation.ServiceScan;
import top.miaofang.core.netty.server.NettyServer;
import top.miaofang.core.serializer.CommonSerializer;
import top.miaofang.core.serializer.KryoSerializer;
import top.miaofang.core.serializer.ProtobufSerializer;
import top.miaofang.core.registry.ServiceRegistry;
import top.miaofang.core.server.RpcServer;

/**
 * 测试用Netty服务提供者（服务端）
 * @author miao
 */
@ServiceScan
public class NettyTestServer {

    public static void main(String[] args) {
        RpcServer server = new NettyServer("127.0.0.1", 9999, CommonSerializer.KRYO_SERIALIZER);
        server.start();
    }

}
