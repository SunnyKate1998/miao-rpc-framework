package top.miaofang.core.registry;

import java.net.InetSocketAddress;

/**
 * 服务注册表通用接口
 * @author miao
 */
public interface ServiceRegistry {

//    /**
//     * 将一个服务注册进注册表
//     * @param service 待注册的服务实体
//     * @param <T> 服务实体类
//     */
//    <T> void register(T service);

//    /**
//     * 根据服务名称获取服务实体
//     * @param serviceName 服务名称
//     * @return 服务实体
//     */
//    Object getService(String serviceName);
    /**
     * 将一个服务注册进注册表
     *
     * @param serviceName 服务名称
     * @param inetSocketAddress 提供服务的地址
     */
    void register(String serviceName, InetSocketAddress inetSocketAddress);

    /**
     * 根据服务名称查找服务实体
     *
     * @param serviceName 服务名称
     * @return 服务实体
     */
    InetSocketAddress lookupService(String serviceName);

}