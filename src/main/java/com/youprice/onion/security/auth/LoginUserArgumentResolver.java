package com.youprice.onion.security.auth;

import com.youprice.onion.dto.member.SessionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
@Slf4j
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

//    private final HttpSession session;

    //@LoginUser 어노테이션이 붙어 있고, 파라미터 클래스 타입이 SessionDTO인가 판단 후 true 반환
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
        boolean isUserClass = SessionDTO.class.equals(parameter.getParameterType());
        return isLoginUserAnnotation && isUserClass;
    }

    //resolveArgument: 파라미터에 전달할 객체 생성
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			CustomUserDetails userDetails = (CustomUserDetails) principal;
			return userDetails.getSessionDTO();
		} catch (Exception e) {
			log.error("에러 : " + e.toString());
			return null;
		}
    }
}
