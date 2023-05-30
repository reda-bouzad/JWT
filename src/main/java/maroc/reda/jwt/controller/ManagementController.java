package maroc.reda.jwt.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/management")
public class ManagementController {

    @GetMapping
    public String get() {
        return  "Get:: management controller";
    }

    @PostMapping
    public String post() {
        return  "Post:: management controller";
    }

    @PutMapping
    public String put() {
        return  "Put:: management controller";
    }

    @DeleteMapping
    public String delete() {
        return  "Delete:: management controller";
    }


}
