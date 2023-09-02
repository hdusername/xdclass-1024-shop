package net.xdclass.service;

import net.xdclass.model.AddressDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 电商-公司收发货地址表 服务类
 * </p>
 *
 * @author hd
 * @since 2023-09-02
 */
public interface AddressService{

    public AddressDO detail(Long AddressId);
}
