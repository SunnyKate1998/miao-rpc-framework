package top.miaofang.core.client;

import top.miaofang.common.entity.RpcRequest;

public interface RpcClient {

    Object sendRequest(RpcRequest rpcRequest);

}
