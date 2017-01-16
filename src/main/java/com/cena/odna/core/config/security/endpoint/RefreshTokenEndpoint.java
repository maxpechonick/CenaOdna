package com.cena.odna.core.config.security.endpoint;

import com.cena.odna.core.config.security.auth.jwt.extractor.TokenExtractor;
import com.cena.odna.core.config.security.auth.jwt.verifier.TokenVerifier;
import com.cena.odna.core.config.security.config.JwtSettings;
import com.cena.odna.core.config.security.config.WebSecurityConfig;
import com.cena.odna.core.config.security.exceptions.InvalidJwtToken;
import com.cena.odna.core.config.security.model.UserContext;
import com.cena.odna.core.config.security.model.token.JwtToken;
import com.cena.odna.core.config.security.model.token.JwtTokenFactory;
import com.cena.odna.core.config.security.model.token.RawAccessJwtToken;
import com.cena.odna.core.config.security.model.token.RefreshToken;
import com.cena.odna.core.mvc.service.user.UserService;
import com.cena.odna.dao.model.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Admin on 12.01.2017.
 */
@RestController
@CrossOrigin
public class RefreshTokenEndpoint {
    @Autowired
    private JwtTokenFactory tokenFactory;
    @Autowired
    private JwtSettings jwtSettings;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenVerifier tokenVerifier;
    @Autowired @Qualifier("jwtHeaderTokenExtractor")
    private TokenExtractor tokenExtractor;

    @RequestMapping(value="/api/auth/token", method= RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody
    JwtToken refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tokenPayload = tokenExtractor.extract(request.getHeader(WebSecurityConfig.JWT_TOKEN_HEADER_PARAM));

        RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(rawToken, jwtSettings.getTokenSigningKey()).orElseThrow(InvalidJwtToken::new);

        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new InvalidJwtToken();
        }

        String subject = refreshToken.getSubject();
        User user = userService.findByUserName(subject);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + subject);
        }

        if (user.getRole() == null) throw new InsufficientAuthenticationException("User has no roles assigned");
        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority(user.getRole().authority())
        );

        UserContext userContext = UserContext.create(user.getUsername(), authorities);

        return tokenFactory.createAccessJwtToken(userContext);
    }
}