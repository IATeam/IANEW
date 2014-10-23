package uow.ia.springsecurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;

@Service("accessDeniedHandler")
public class MyAccessDeniedHandler implements AccessDeniedHandler {
	
	private String accessDeniedUrl = "/IANEW/403";
	
	public MyAccessDeniedHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public MyAccessDeniedHandler(String accessDeniedUrl) {

        this.accessDeniedUrl = accessDeniedUrl;

    }

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		boolean isAjax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
		
		if (isAjax) {
			
			//response.sendError(403);
			response.sendRedirect(accessDeniedUrl);
		}
	}

	public String getAccessDeniedUrl() {
		return accessDeniedUrl;
	}

	public void setAccessDeniedUrl(String accessDeniedUrl) {
		this.accessDeniedUrl = accessDeniedUrl;
	}
	
	
	
}
