package com.cxy.seckill.config;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**+
 * MVC配置类
 * @author 53429
 *
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private UserArgumentResolver userArgumentResolver;

	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
       resolvers.add(userArgumentResolver);
    }
	//一下这两个方法是防止thymlef模板加载失败
	   private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
	            "classpath:/META-INF/resources/", "classpath:/resources/",
	            "classpath:/static/", "classpath:/public/" };
	 
	 
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        if (!registry.hasMappingForPattern("/webjars/**")) {
	            registry.addResourceHandler("/webjars/**").addResourceLocations(
	                    "classpath:/META-INF/resources/webjars/");
	        }
	        if (!registry.hasMappingForPattern("/**")) {
	            registry.addResourceHandler("/**").addResourceLocations(
	                    CLASSPATH_RESOURCE_LOCATIONS);
	        }
	 
	    }
}
