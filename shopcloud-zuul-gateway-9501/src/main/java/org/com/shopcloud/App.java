package org.com.shopcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 启动类
 * 注解@SpringBootApplication
 * 调用SpringApplication.run()方法
 * @author heyayun
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}