package net.xdclass.service;

import net.xdclass.model.UserDO;
import com.baomidou.mybatisplus.extension.service.IService;
import net.xdclass.request.UserLoginRequest;
import net.xdclass.util.JsonData;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hd
 * @since 2023-09-02
 */
public interface UserService {

    JsonData login(UserLoginRequest userLoginRequest);
}
