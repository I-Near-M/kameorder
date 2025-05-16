package org.doomtech.kameorder.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private static final String SECRET_KEY = "2C038CBCF39C136FF5BB29810CAF00116EBC6B9874772CBFA14419883DC75041";

    // 🔐 Generar la clave secreta
    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes); // Devuelve SecretKey
    }

    // 🎟️ Crear token con claims (incluyendo roles)
    public String getToken(UserDetails user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));

        Instant now = Instant.now();
        Instant expiration = now.plusSeconds(60 * 60 * 24); // 24 horas

        return Jwts.builder()
                .claims(claims)
                .subject(user.getUsername())
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiration))
                .signWith(getSecretKey(), Jwts.SIG.HS256) // ✅ Firma segura
                .compact();
    }

    // ✅ Validar token
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    // 📛 Obtener username (subject)
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    // 📥 Obtener roles desde el token
    public List<String> getRolesFromToken(String token) {
        Claims claims = getAllClaims(token);
        Object roles = claims.get("roles");

        if (roles instanceof List<?>) {
            return ((List<?>) roles).stream()
                    .filter(r -> r instanceof String)
                    .map(r -> (String) r)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    // 🧾 Obtener un claim específico
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // 🧱 Parsear claims desde el token firmado
    private Claims getAllClaims(String token) {
        JwtParser parser = Jwts.parser()
                .verifyWith(getSecretKey()) // ✅
                .build();

        return parser.parseSignedClaims(token).getPayload();
    }

    // ⏰ Fecha de expiración
    private Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    // ❌ Token expirado
    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    public String extractToken(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7); // remueve "Bearer "
        }
        return null;
    }
}
