hosts配置：
127.0.0.1 dept-8001.com
127.0.0.1 dept-8002.com
127.0.0.1 dept-8003.com
127.0.0.1 client.com
127.0.0.1 eureka-7001.com
127.0.0.1 eureka-7002.com
127.0.0.1 eureka-7003.com
127.0.0.1 dashboard.com
127.0.0.1 company-8101.com
127.0.0.1 trubine.com
127.0.0.1 gateway-9501.com
127.0.0.1 upload.com
127.0.0.1 consumer-upload.com
127.0.0.1 config-7101.com
1、fallback

2、服务降级（服务暂停）

3、http://dashboard.com:9001/hystrix

4、http://shopjava:hello@dept-8001.com:8001/hystrix.stream   2000   Dept-Service

5、	http://shopjava:hello@dept-8001.com:8001/dept/get/1
	http://shopjava:hello@dept-8002.com:8002/dept/get/1
	http://shopjava:hello@dept-8003.com:8003/dept/get/1

6、http://company-8101.com:8101/company/get/hello
http://company-8101.com:8101/hystrix.stream

7、http://edmin:shopjava@eureka-7001.com:7001
http://edmin:shopjava@eureka-7002.com:7002
http://edmin:shopjava@eureka-7003.com:7003

8、http://trubine.com:9101/turbine.stream

9、http://gateway-9501.com:9501/shopcloud-provider-company/company/get/hello
http://gateway-9501.com:9501/company-proxy/company/get/hello

10、http://gateway-9501.com:9501/shop-proxy/company-proxy/company/get/hello
“shop-proxy”：整个zuul的前缀
“/company-proxy”：是zuul中定义的映射文件
“/company/get/hello”：是微服务提供者提供的操作路径

11、http://gateway-9501.com:9501/shop-proxy/dept-proxy/dept/get/1

12、http://zdmin:shopjava@gateway-9501.com:9501/shop-proxy/dept-proxy/dept/get/1

13、curl -F "photo=@11.jpg" http://zdmin:shopjava@gateway-9501.com:9501/zuul/shop-proxy/upload-proxy/upload

14、http://shopjava:hello@config-7101.com:7101/shopcloud-config-client-beta.yml

15、https://github.com/Jaysonyun/shopconfig
https://springcloud.cc/spring-cloud-dalston.html#_spring_cloud_config


16、
C:\Program Files\Java\jdk1.8.0_161\jre\lib\security

加密
C:\Program Files\Git\mingw64\bin>curl -X POST http://shopjava:hello@config-7101.com:7101/encrypt -d root
5b5d79f985c964ab856b99dd0610b9a89443407dfd64e03cc5621f9383130c32
解密
C:\Program Files\Git\mingw64\bin>curl -X POST http://shopjava:hello@config-7101.com:7101/decrypt -d 5b5d79f985c964ab856b99dd0610b9a89443407dfd64e03cc5621f9383130c32
