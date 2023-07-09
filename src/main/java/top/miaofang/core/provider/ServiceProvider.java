package top.miaofang.core.provider;

/**
 * 保存和提供服务实例对象
 * @author miao
 */
public interface ServiceProvider {


    <T> void addServiceProvider(T service, String serviceName);

    Object getServiceProvider(String serviceName);

}
