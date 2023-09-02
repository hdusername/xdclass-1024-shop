package net.xdclass.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import net.xdclass.model.AddressDO;
import net.xdclass.mapper.AddressMapper;
import net.xdclass.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电商-公司收发货地址表 服务实现类
 * </p>
 *
 * @author hd
 * @since 2023-09-02
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    public AddressDO detail(Long addressId){
        return addressMapper.selectOne(new QueryWrapper<AddressDO>().eq("id", addressId));

    }
}
