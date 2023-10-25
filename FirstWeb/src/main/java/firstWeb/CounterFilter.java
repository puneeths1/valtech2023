package firstWeb;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.*;

public class CounterFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy of Counter filter...");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("DO Filter of Counter Filter");
		@SuppressWarnings("unchecked")
		Map<String,Integer> counters = (Map<String,Integer>)req.getServletContext().getAttribute("counters");
		HttpServletRequest request = (HttpServletRequest) req;
		String uri = request.getRequestURI(); //counters.put(uri,counters.containskey(uri)?counters.get(uri)+1:1;
		if(counters.containsKey(uri)) {
			counters.put(uri, counters.get(uri)+1); 
		}else {
			counters.put(uri, 1);
		}
		printCounters(counters);
		chain.doFilter(req,res);
	}

	private void printCounters(Map<String, Integer> counters) {
		// TODO Auto-generated method stub
		for(String s:counters.keySet()) {
			System.out.println("URI ="+s+"Counter ="+counters.get(s));
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Init of Counter Filter...");
		Map<String,Integer> counters = new HashMap<>();
		filterConfig.getServletContext().setAttribute("counters", counters);   //servletContext:Application
	}

}
