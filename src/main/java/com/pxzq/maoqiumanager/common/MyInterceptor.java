package com.pxzq.maoqiumanager.common;

import cn.hutool.jwt.JWT;
import com.pxzq.maoqiumanager.service.exception.JWTException;
import com.pxzq.maoqiumanager.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/28 20:29:45
 */

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        String token = request.getHeader("Token");
        if(token == null || token.isEmpty() || !JwtUtil.validateToken(token)){
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,@NonNull Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("Post-handle logic executed");
        // 在请求处理后执行的逻辑
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex)
            throws Exception {
        System.out.println("After-completion logic executed");
        // 在视图渲染之后执行的逻辑
    }
}
