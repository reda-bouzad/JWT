package maroc.reda.jwt.controller;

import maroc.reda.jwt.Security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jwt")
public class jwtController {

    @Autowired
    private JwtService jwtService;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }


    @GetMapping("/admin")
    public ResponseEntity<String> adminEndpoint(@RequestHeader("Authorization") String token) {
        boolean isAdmin = jwtService.hasAdminRole(token);
        if (isAdmin) {
            return ResponseEntity.ok("Hello from admin endpoint");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You do not have permission to access this endpoint");
        }
    }

}
