package top.miaofang.core.client;

import top.miaofang.common.entity.RpcRequest;
import top.miaofang.core.serializer.CommonSerializer;

public interface RpcClient {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    Object sendRequest(RpcRequest rpcRequest);

}
