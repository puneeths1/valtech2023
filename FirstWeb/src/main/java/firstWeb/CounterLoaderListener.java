package firstWeb;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CounterLoaderListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Context Destroyed...");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Context Initialized...");
		
	}

}
