package example.spring.core;

public class HelloService implements GreetingService {

	public HelloService() {
		System.out.println("Hello Service");
		
	}

	@Override
	public String sayGreeting() {
		
		return "Hello From Spring ";
	}

}
