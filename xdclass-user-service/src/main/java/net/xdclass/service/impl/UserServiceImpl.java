package net.xdclass.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.xdclass.enums.BizCodeEnum;
import net.xdclass.mapper.AddressMapper;
import net.xdclass.model.AddressDO;
import net.xdclass.model.LoginUser;
import net.xdclass.model.UserDO;
import net.xdclass.mapper.UserMapper;
import net.xdclass.request.UserLoginRequest;
import net.xdclass.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.xdclass.util.JWTUtil;
import net.xdclass.util.JsonData;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hd
 * @since 2023-09-02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    /**
     * 功能：用户登录
     * @param userLoginRequest
     * @return
     */
    @Override
    public JsonData login(UserLoginRequest userLoginRequest) {
        List<UserDO> list = userMapper.selectList(new QueryWrapper<UserDO>().eq("mail", userLoginRequest.getMail()));
        if (list != null && list.size() == 1) {
            UserDO userDO = list.get(0);
            String cryptPwd = Md5Crypt.md5Crypt(userLoginRequest.getPwd().getBytes(), userDO.getSecret());
            if (cryptPwd.equals(userDO.getPwd())) {
                //⽣成token令牌

                LoginUser loginUser = new LoginUser();
                BeanUtils.copyProperties(userDO, loginUser);

                String token = JWTUtil.geneJsonWebToken(loginUser);


                return JsonData.buildSuccess(token);
            }
            //密码错误
            return JsonData.buildResult(BizCodeEnum.ACCOUNT_PWD_ERROR);
        } else {
            //未注册
            return JsonData.buildResult(BizCodeEnum.ACCOUNT_UNREGISTER);
        }
    }
}
