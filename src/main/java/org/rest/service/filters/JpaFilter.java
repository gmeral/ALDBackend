package org.rest.service.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;

public class JpaFilter implements Filter {
	private static final Logger LOG = LoggerFactory.getLogger(JpaFilter.class);
	private static EntityManagerFactory emf = null;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOG.info("INTERCEPT REQUEST");
		EntityManager em = null;
		try{ 
			em = emf.createEntityManager();
			JpaUtil.ENTITY_MANAGERS.set(em);
			 if(response instanceof HttpServletResponse){
	        HttpServletResponse alteredResponse = ((HttpServletResponse)response);

	        addHeadersFor200Response(alteredResponse);
	    }
			chain.doFilter(request,response);
			JpaUtil.ENTITY_MANAGERS.remove();
		}finally{
			try{
				if (em != null)
					em.close();
			} catch (Throwable t) {
				LOG.error("While closing an EntityManager",t);
			}
		}
	}

	 private void addHeadersFor200Response(HttpServletResponse response){
        //TODO: externalize the Allow-Origin
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
    }
	
	public void init(FilterConfig config) { 
		destroy();
		emf = Persistence.createEntityManagerFactory("Museum");
	}
	
	public void destroy(){
		if (emf != null)
			emf.close();
	}
}
