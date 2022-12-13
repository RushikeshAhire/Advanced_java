package example.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import example.spring.core.GreetingService;

public class SpringMain {

	public static void main(String[] args) {
		String filePath="./src/main/resources/spring-config.xml";
		ApplicationContext tx=new FileSystemXmlApplicationContext(filePath);
		

		Object obj=tx.getBean("greet");
		GreetingService gs=(GreetingService )obj;
		
		String reply =gs.sayGreeting();
		System.out.println(reply);
		
	}

}
