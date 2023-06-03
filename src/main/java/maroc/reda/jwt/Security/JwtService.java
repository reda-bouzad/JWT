package maroc.reda.jwt.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import maroc.reda.jwt.dao.UserDao;
import maroc.reda.jwt.entity.User;
import maroc.reda.jwt.myenums.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    // injecting UserDao to find the user by email to check if he has admin role
    @Autowired
    private UserDao userDao;

    // generated online : Encryption Key Generator -> 256 bits
    private static final String  Secret_Key = "655468576D5A7134743777217A25432A46294A404E635266556A586E32723575";

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject  );
    }

    // generate token without extra claims
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    // generate token with extra claims
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        extraClaims.put("role", userDetails.getAuthorities().toString());
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact(); // this function is what allow us to build the token
    }



    // methode to validate a token
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()));
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(Secret_Key);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // check if a user has admin role
    public boolean hasAdminRole(String token) {
        String username = extractUserName(token);
        User user = userDao.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user.getRole() == Roles.ADMIN;
    }

}
