package mb.amazul.siscad;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
//@ComponentScan(basePackages="mb.amazul.siscad.controller")
@ComponentScan({"mb.amazul.siscad", "controller"})
public class SiscadApplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SiscadApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SiscadApplication.class, args);
	}
	
	
	  @Bean 
	  public Filter getCharacterEncodingFilter() { 
		  CharacterEncodingFilter  encodingFilter = new CharacterEncodingFilter();
		  encodingFilter.setEncoding("UTF-8"); 
		  encodingFilter.setForceEncoding(true);
	  
		  return encodingFilter; 
	  }
	 
	
	
	  private static final String LOCATION = "C:/mytemp/";
	  
	  private static final long MAX_FILE_SIZE = 1024 * 1024 * 25;//25MB
	  
	  private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 30;//30MB
	  
	  private static final int FILE_SIZE_THRESHOLD = 0;
	 
}
