package top.miaofang.test.server;

import top.miaofang.api.ByeService;
import top.miaofang.core.annotation.Service;
/**
 * @author miao
 */
@Service
public class ByeServiceImpl implements ByeService {

    @Override
    public String bye(String name) {
        return "bye, " + name;
    }
}
