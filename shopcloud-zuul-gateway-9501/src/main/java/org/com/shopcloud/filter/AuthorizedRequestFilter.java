package org.com.shopcloud.filter;

import java.nio.charset.Charset;
import java.util.Base64;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AuthorizedRequestFilter extends ZuulFilter {
	//表示具体的过滤操作执行
	@Override
	public Object run() {
		//获取当前请求的上下文
		RequestContext currentContext = RequestContext.getCurrentContext();
		String auth = "shopjava:hello";//认证的原始信息
		byte[] encodeAuth = Base64.getEncoder()
				.encode(auth.getBytes(Charset.forName("US-ASCII")));
		//在授权头信息Basic后面空格注意
		String authHeader = "Basic " + new String(encodeAuth);
		currentContext.addZuulRequestHeader("Authorization", authHeader);
		return null;
	}
	//该filter是否执行
	@Override
	public boolean shouldFilter() {
		return true;
	}
	//设置优先级，数字越大优先级越低
	@Override
	public int filterOrder() {
		return 0;
	}
	//zuul过滤执行位置，请求前，请求后执行
	//1、pre：在请求前执行过滤，如果要进行访问，肯定要请求前设置头信息
	//2、route：在进行路由请求的是被调用
	//3、post：在路由之后发送请求信息的时候被调用
	//4、error：出现错误之后进行调用
	@Override
	public String filterType() {
		return "pre";
	}

}
