package top.miaofang.core.server;

import top.miaofang.core.serializer.CommonSerializer;

public interface RpcServer {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    void start();

    <T> void publishService(T service, String serviceName);

}
