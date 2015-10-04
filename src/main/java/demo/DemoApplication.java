package demo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.apache.cxf.validation.BeanValidationFeature;
import org.apache.cxf.validation.BeanValidationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import service.EmployeeService;
import service.EmployeeServiceImpl;

@SpringBootApplication
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
@ComponentScan(basePackages={"model", "rest"})
public class DemoApplication {

//	@Autowired
//	private ApplicationContext applicationContext;
	
	@Autowired
	private Bus bus;
	
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
	    return new ServletRegistrationBean(new CXFServlet(), "/services/*");
	}
	
	@Bean
	public Endpoint endpoint() {
		EmployeeService impl = new EmployeeServiceImpl();
		EndpointImpl endpoint = new EndpointImpl(bus, impl);
		endpoint.setFeatures(featuresBean());
		endpoint.publish("/employee");
		return endpoint;
	}
	
	@Bean
	public List<AbstractFeature> featuresBean() {
		List<AbstractFeature> features = new ArrayList<AbstractFeature>();
	    features.add(beanValidationFeature());
	    return features;
	}
	
	@Bean
	public BeanValidationFeature beanValidationFeature() {
		BeanValidationFeature newBeanValidationFeature = new BeanValidationFeature();
		newBeanValidationFeature.setProvider(new BeanValidationProvider(localValidatorFactoryBean()));
		return newBeanValidationFeature;
	}
	
	@Bean
	public ValidatorFactory localValidatorFactoryBean() {
	   return new LocalValidatorFactoryBean();
	}
	
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
