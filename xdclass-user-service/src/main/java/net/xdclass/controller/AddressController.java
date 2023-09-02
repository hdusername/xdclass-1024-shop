package net.xdclass.controller;


import net.xdclass.service.AddressService;
import net.xdclass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 电商-公司收发货地址表 前端控制器
 * </p>
 *
 * @author hd
 * @since 2023-09-02
 */
@RestController
@RequestMapping("/api/address/v1/")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/find/{address_id}")
    public  Object detail(@PathVariable("address_id") long addressId){
        return addressService.detail(addressId);
    }

}

