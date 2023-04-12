# SpringCloud Project
## 项目简介
本项目为基于Spring Cloud架构开发的饿了么点餐平台，通过对项目进行分布式划分实现模块解耦，缩短单个任务执行时间以实现效率提升；又分别对每个微服务进行集群部署并搭配Ribbon/Feign负载均衡器和Hystrix断路熔断器以提高系统在高并发情况下的处理能力和容错能力。
## 团队成员
|Developer|Number|
|--|--|
|闫佑诚|3020244236|
|胡亿权|3020244251|
|韦唯佳|3020244234|
## 文件结构
```bash
.
├── springcloud_elm					//后端后端项目各微服务代码
│   ├── business_server_10300
│   ├── business_server_10301
│   ├── cart_server_10400
│   ├── cart_server_10401
│   ├── config_server_15000
│   ├── config_server_15001
│   ├── credits_server_10800
│   ├── credits_server_10801
│   ├── deliveryaddress_server_10500
│   ├── deliveryaddress_server_10501
│   ├── eureka_server_13000
│   ├── eureka_server_13001
│   ├── food_server_10200
│   ├── food_server_10201
│   ├── gateway_server_14000
│   ├── orders_server_10600
│   ├── orders_server_10601
│   ├── user_server_10100
│   ├── user_server_10101
│   ├── wallet_server_10700
│   └── wallet_server_10701
└── vue_elm									//前端项目代码
    ├── public
    └── src
        ├── assets
        ├── components
        ├── router
        ├── service
        └── views
```