package org.com.commons.config;


import org.springframework.context.annotation.Bean;

//import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
/**
 * 注意要放在主包扫描不到包下
 * @author heyayun
 *
 */
public class MyLoadBalanceConfig {
	@Bean
	public IRule ribbonRule() {//其中IRule就是所有规则的标准
		return new RandomRule();//随机访问策略
	}
}
