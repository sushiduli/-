package com.lgp.SpringBoot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class App 
{
	  @RequestMapping("/h")
	  public String home() {
	    return "Hello";
	  }
	
	  @RequestMapping("/w")
	  public String word() {
		return "World";
	  }
	  
    public static void main( String[] args )
    {
        System.out.println( "Hello World ! App!" );
        //SpringApplication.run(App.class, args);
        SpringApplication.run(UserController.class, args);
    }
    
    /* 
   @Bean
   public EmbeddedServletContainerFactory servletFactory(){
    	TomcatEmbeddedServletContainerFactory tomcatFactory = 
    			new TomcatEmbeddedServletContainerFactory();
    	tomcatFactory.setPort(8011);
    	Charset set = Charset.forName("UTF-8");
    	tomcatFactory.setUriEncoding(set);
    	tomcatFactory.setSessionTimeout(10,TimeUnit.SECONDS);
    	return tomcatFactory;
    	
    }*/
}
