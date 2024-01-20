package net.xdclass.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能：登录拦截器
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

//    @Override
//    public boolean preHandle(HttpServletRequest
//                                     request, HttpServletResponse response, Object
//                                     handler) throws Exception {
//        try {
//            String accessToken = request.getHeader("token");
//            if (accessToken == null) {
//                accessToken = request.getParameter("token");
//            }
//            if
//            (StringUtils.isNotBlank(accessToken)) {
//                Claims claims = JWTUtil.checkJWT(accessToken);
//                if (claims == null) {
//                    //告诉登录过期，᯿新登录
//
//                    CommonUtil.sendJsonMessage(response,
//                            JsonData.buildError("登录过期，᯿新登录"));
//                    return false;
//                }
//                Long id = Long.valueOf(claims.get("id").toString());
//                String headImg = (String)
//                        claims.get("head_img");
//                String mail = (String)
//                        claims.get("mail");
//                String name = (String)
//                        claims.get("name");
//                //TODO ⽤户信息传递
//
//                return true;
//            }
//        } catch (Exception e) {
//            log.error("拦截器错误:{}",e);
//        }
//        CommonUtil.sendJsonMessage(response,
//                JsonData.buildError("token不存在，᯿新登录"));
//        return false;
//    }
//    @Override
//    public void postHandle(HttpServletRequest
//                                   request, HttpServletResponse response, Object
//                                   handler, ModelAndView modelAndView) throws
//            Exception {
//    }
//    @Override
//    public void
//    afterCompletion(HttpServletRequest request,
//                    HttpServletResponse response, Object handler,
//                    Exception ex) throws Exception {
//    }


}
