/*
 * Almicke Navarro 
 * CST-323
 * January 26, 2021
 * I used source code from: https://stackoverflow.com/questions/37233069/heroku-unable-to-find-xml-config-file
 */
package CST323.KaraokeMachine.config;

import java.io.InputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="CST323.KaraokeMachine")
@EnableWebMvc
//@ImportResource(value = {"classpath:/CST323/KaraokeMachine/config/applicationConfiguration.xml"})
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
	//ClassLoader cl = this.getClass().getClassLoader();
	//InputStream inputStream = cl.getResourceAsStream("CST323/KaraokeMachine/config/applicationConfiguration.xml");

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}

	
}
