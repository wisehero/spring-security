package com.prgrms.devcourse.springsecuritymasterclass.user;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    public UserRestController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    /*
     *  보호받는 엔드포인트 - ROLE_USER 또는 USER_ADMIN 권한 필요
     * @return 사용자명
     */


    /**
     * 주어진 JWT 토큰 디코딩 결과를 출력함
     *
     * @param token Jwt 토큰
     * @return JWT 디코드 결과
     */
//    @GetMapping(path = "/user/token/verify")
//    public Map<String, Object> verify(@RequestHeader("token") String token) {
//        return jwt.verify(token).asMap();
//    }


}