package com.neusoft.controller;

import com.neusoft.po.Business;
import com.neusoft.po.CommonResult;
import com.neusoft.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/BusinessController")
public class BusinessController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/listBusinessByOrderTypeId/{orderTypeId}")
    public CommonResult<List> listBusinessByOrderTypeId(@PathVariable("orderTypeId") Integer
                                                                orderTypeId) throws Exception {
        List<Business> list = businessService.listBusinessByOrderTypeId(orderTypeId);
        return new CommonResult(200, "success（10200）", list);
    }

    @RequestMapping("/getBusinessById/{businessId}")
    public CommonResult<Business> getBusinessById(@PathVariable("businessId") Integer
                                                          businessId) throws Exception {
//通过服务提供者名（food-server）获取Eureka Server上的元数据
        List<ServiceInstance> instanceList = discoveryClient.getInstances("food-server");
//现在，元数据集合中只有一个服务信息（food-server）
        ServiceInstance instance = instanceList.get(0);
        Business business = businessService.getBusinessById(businessId);
//使用DiscoveryClient获取元数据，主机地址与端口就可以不硬编码了
        CommonResult<List> result =
                restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/FoodController/listFoodByBusinessId / "+businessId, CommonResult.class);
        if (result.getCode() == 200) {
            business.setFoodList(result.getResult());
        }
        return new CommonResult(200, "success（10200）", business);
    }
}