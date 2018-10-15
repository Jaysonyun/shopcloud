package org.com.shopcloud.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
/**
 * 以组件的形式注入
 * zuul的失败处理类
 * @author heyayun
 *
 */
@Component
public class DeptProviderFallback implements ZuulFallbackProvider {

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {

			@Override
			public InputStream getBody() throws IOException {
				//字节流
				//当出现服务调用错误之后返回的数据内容
				return new ByteArrayInputStream("{\"deptno\":77777,\"dname\":\"【error】Zuul的失败回退\",\"loc\":\"Gateway客户端提供\"}".getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders httpHeaders = new HttpHeaders();
				httpHeaders.set("Content-Type", "text/html; charset=UTF-8");
				return httpHeaders;
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				//错误请求
				return HttpStatus.BAD_REQUEST;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST.value();
			}

			@Override
			public String getStatusText() throws IOException {
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}

			@Override
			public void close() {
				
			}};
	}

	@Override
	public String getRoute() {
		//设置好处理失败路由
		return "shopcloud-provider-dept";
	}

}
