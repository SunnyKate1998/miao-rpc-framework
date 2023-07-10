package top.miaofang.core.loadbalancer;

import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;

/**
 * @author miao
 */
public interface LoadBalancer {

    Instance select(List<Instance> instances);

}
