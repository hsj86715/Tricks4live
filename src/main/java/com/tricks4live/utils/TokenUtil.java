package com.tricks4live.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tricks4live.entries.User;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

public class TokenUtil {

    private static final String SECRET = "feedSystemback666";

    public static String createJWT(User user, String userAgent) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        String token = JWT.create()
                .withIssuer("tricks4live")
                .withIssuedAt(new Date())
                .withSubject("login")
                .withJWTId(user.getId().toString())
                .withAudience(userAgent)
                .withClaim("permission", user.getPermission())
                .withClaim("nickName", user.getNickName())
                .sign(algorithm);
        user.setToken(token);
        return token;
    }

    public static Boolean verifyJWT(String token, String nick, Integer permiss, String userAgent) {
        Boolean pass = false;
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        String issuer = jwt.getIssuer();
        String subject = jwt.getSubject();
        List<String> audiences = jwt.getAudience();
        Integer permission = jwt.getClaim("permission").asInt();
        String nickName = jwt.getClaim("nickName").asString();
        if (!StringUtils.isEmpty(issuer) && issuer.equals("tricks4live")
                && !StringUtils.isEmpty(subject) && subject.equals("login")
                && !StringUtils.isEmpty(nickName) && nickName.equals(nick)
                && permission != null && permission.equals(permiss)
                && audiences != null && !audiences.isEmpty()
                && audiences.get(0).equals(userAgent)) {
            pass = true;
        }
        return pass;
    }
}
