package top.miaofang.core.registry;

import com.alibaba.nacos.api.exception.NacosException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.miaofang.common.enumeration.RpcError;
import top.miaofang.common.exception.RpcException;
import top.miaofang.common.util.NacosUtil;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * Nacos服务注册中心
 * @author miao
 */
public class NacosServiceRegistry implements ServiceRegistry {

    private static final Logger logger = LoggerFactory.getLogger(NacosServiceRegistry.class);

    @Override
    public void register(String serviceName, InetSocketAddress inetSocketAddress) {
        try {
            NacosUtil.registerService(serviceName, inetSocketAddress);
        } catch (NacosException e) {
            logger.error("注册服务时有错误发生:", e);
            throw new RpcException(RpcError.REGISTER_SERVICE_FAILED);
        }
    }

}
