package top.miaofang.core.client;

import top.miaofang.common.entity.RpcRequest;
import top.miaofang.core.serializer.CommonSerializer;

public interface RpcClient {

    Object sendRequest(RpcRequest rpcRequest);
    void setSerializer(CommonSerializer serializer);

}
