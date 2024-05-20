package com.atguigu.commonutils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtils {
    public static final long EXPIRE = 1000 * 60 * 60 * 24;//设置过期时间 24小时
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";//密钥 公司根据一定规则生成的
    public static String getJwtToken(String id, String nickname){//根据id 昵称生成token

        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT") //设置jwt头信息
                .setHeaderParam("alg", "HS256")
                .setSubject("guli-user")//设置名称
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("id", id)//设置token主体部分 存储用户信息
                .claim("nickname", nickname)
                .signWith(SignatureAlgorithm.HS256, JwtUtils.APP_SECRET)//签名算法
                .compact();
        return JwtToken;
    }
    /**
     * 判断token是否存在与有效
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * 判断token是否存在与有效
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if(StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * 根据token获取会员id
     * @param request
     * @return
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request) {//根据token解析出id
        //cookie里面设置了 cookie.set('guli_token',response.data.data.token, { domain: 'localhost' })
        //request.js拦截器设置了config.headers['token'] = cookie.get('guli_token');//cookie的放到headers的token里面
        String jwtToken = request.getHeader("token");//获取token值
        if(StringUtils.isEmpty(jwtToken)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(JwtUtils.APP_SECRET).parseClaimsJws(jwtToken);//自己按照一定规则设置的密钥 token值
        Claims claims = claimsJws.getBody();
        System.out.println("********"+(String)claims.get("id"));
        return (String)claims.get("id");
    }
}