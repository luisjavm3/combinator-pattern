package co.luisjavm3.combinatorpattern;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/combinator-pattern")
public class DefaultController {

    @GetMapping
    public ResponseEntity<?> getMethodName() {
        User validUser = new User("john1", "john@example.com", "password123");

        User invalidUser = new User("unodos", "invalid@email.com", "pass12");

        ValidatorResult result1 = UserValidators.userValidator.apply(validUser);
        ValidatorResult result2 = UserValidators.userValidator.apply(invalidUser);

        List<ValidatorResult> r = List.of(result1, result2);

        return ResponseEntity.ok(r);
    }
}
