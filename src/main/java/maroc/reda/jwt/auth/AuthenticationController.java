package maroc.reda.jwt.auth;

import lombok.RequiredArgsConstructor;
import maroc.reda.jwt.dao.UserDao;
import maroc.reda.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth")

@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private UserDao userDao;

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/token/{email}")
    public String getToken(@PathVariable String email) {

        Optional<User> user = userDao.findByEmail(email);
        String myToken = null;
        if (user.isPresent()) {
            User myUser = user.get();
            myToken = myUser.getToken();
        }
        return myToken;
    }

}
