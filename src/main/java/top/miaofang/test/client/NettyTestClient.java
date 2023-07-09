package top.miaofang.test.client;

import top.miaofang.api.HelloObject;
import top.miaofang.api.HelloService;
import top.miaofang.core.client.RpcClient;
import top.miaofang.core.client.RpcClientProxy;
import top.miaofang.core.netty.client.NettyClient;
import top.miaofang.core.serializer.KryoSerializer;
import top.miaofang.test.server.HelloServiceImpl;


/**
 * 测试用Netty消费者
 * @author miao
 */
public class NettyTestClient {

    public static void main(String[] args) {
        RpcClient client = new NettyClient("127.0.0.1", 9999);
        client.setSerializer(new KryoSerializer());
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);

    }

}
