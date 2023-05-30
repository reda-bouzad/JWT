package maroc.reda.jwt.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @GetMapping
    public String get() {
        return  "Get:: admin controller";
    }

    @PostMapping
    public String post() {
        return  "Post:: admin controller";
    }

    @PutMapping
    public String put() {
        return  "Put:: admin controller";
    }

    @DeleteMapping
    public String delete() {
        return  "Delete:: admin controller";
    }



}
