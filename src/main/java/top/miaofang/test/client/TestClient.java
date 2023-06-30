package top.miaofang.test.client;


import top.miaofang.api.HelloObject;
import top.miaofang.api.HelloService;
import top.miaofang.core.client.RpcClientProxy;

/**
 * 测试用消费者（客户端）
 * @author miao
 */
public class TestClient {

    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy("127.0.0.1", 9000);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);
    }

}
