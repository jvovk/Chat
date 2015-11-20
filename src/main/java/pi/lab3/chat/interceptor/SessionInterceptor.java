package pi.lab3.chat.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pi.lab3.chat.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Yuliia Vovk
 * 18.11.15
 */
public class SessionInterceptor implements HandlerInterceptor {

    private List<String> openUrls = Arrays.asList("/", "/login");

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        boolean isLoggedIn = user != null;
        String requestURI = httpServletRequest.getRequestURI();
        if (isLoggedIn) {
            return true;
        } else {
            if (openUrls.contains(requestURI)) {
                return true;
            }
            httpServletResponse.sendRedirect("/");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //no op
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //no op
    }
}
