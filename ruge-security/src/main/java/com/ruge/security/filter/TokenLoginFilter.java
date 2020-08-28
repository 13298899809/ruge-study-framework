package com.ruge.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruge.security.config.RsaKeyProperties;
import com.ruge.security.entity.SecurityAuthorities;
import com.ruge.security.entity.SecurityUsers;
import com.ruge.security.util.JwtUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName TokenLoginFilter 自定义token认证过滤器
 * @date 2020.07.21 14:17
 */

@NoArgsConstructor
@AllArgsConstructor
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private RsaKeyProperties prop;


    /**
     * 接收并解析用户凭证，出現错误时，返回json数据前端
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        UsernamePasswordAuthenticationToken authRequest = null;
        try {
            //将json格式请求体转成JavaBean对象
            SecurityUsers user = new ObjectMapper().readValue(request.getInputStream(), SecurityUsers.class);

            authRequest = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        } catch (IOException e) {
            try {//如果认证失败，提供自定义json格式异常
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = response.getWriter();
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("code", HttpServletResponse.SC_UNAUTHORIZED);
                map.put("message", "账号或密码错误！");
                out.write(new ObjectMapper().writeValueAsString(map));
                out.flush();
                out.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } finally {
        }
        return authenticationManager.authenticate(authRequest);
    }

    /**
     * Default behaviour for successful authentication.
     * <ol>
     * <li>Sets the successful <tt>Authentication</tt> object on the
     * {@link SecurityContextHolder}</li>
     * <li>Informs the configured <tt>RememberMeServices</tt> of the successful login</li>
     * <li>Fires an {@link InteractiveAuthenticationSuccessEvent} via the configured
     * <tt>ApplicationEventPublisher</tt></li>
     * <li>Delegates additional behaviour to the {@link AuthenticationSuccessHandler}.</li>
     * </ol>
     * <p>
     * Subclasses can override this method to continue the {@link FilterChain} after
     * successful authentication.
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult the object returned from the <tt>attemptAuthentication</tt>
     *                   method.
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        List<SecurityAuthorities> roles = new ArrayList<>();
        authResult.getAuthorities().stream().map(x -> x.getAuthority()).collect(Collectors.toList()).forEach(e -> roles.add(SecurityAuthorities.builder().name(e).build()));

        String token = JwtUtils.generateTokenExpireInMinutes(SecurityUsers
                .builder()
                .username(authResult.getName())
                .roles(roles)
                .build(), prop.getPrivateKey(), 20 * 60);
        response.addHeader("Authorization", "Bearer " + token);
        try {//登录成功時，返回json格式进行提示
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", HttpServletResponse.SC_OK);
            map.put("message", "登陆成功！");
            out.write(new ObjectMapper().writeValueAsString(map));
            out.flush();
            out.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

