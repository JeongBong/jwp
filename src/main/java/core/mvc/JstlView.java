package core.mvc;

import java.util.Map;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.web.filter.CharacterEncodingFilter;

public class JstlView implements View {
	private static final String DEFAULT_REDIRECT_PREFIX = "redirect:";
	
	private String viewName;

	public JstlView(String viewName) {
		this.viewName = viewName;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (viewName.startsWith(DEFAULT_REDIRECT_PREFIX)) {
			response.sendRedirect(viewName.substring(DEFAULT_REDIRECT_PREFIX.length()));
			return;
		}
				
		Set<String> keys = model.keySet();
		for (String key : keys) {
			request.setAttribute(key, model.get(key));
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
	}
}
