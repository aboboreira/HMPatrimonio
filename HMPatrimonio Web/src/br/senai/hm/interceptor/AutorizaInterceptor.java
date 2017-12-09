package br.senai.hm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AutorizaInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		System.out.println(uri);
		/*Libera��o da url que contenhas tais valores*/
		if (uri.contains("acessar")|| uri.contains("acesso") || uri.contains("resources")
				|| uri.contains("home") || uri.contains("erro")) {
			return true;
		}

		/*verifica o usu�rio que est� "pendurado" na sess�o*/
		Object usuario = request.getSession().getAttribute("usuario");

	

		
		

	
		/*esse return vale para tudo que n�o esteja validado acima*/
		return true;
	}
}
