package co.luisjavm3.combinatorpattern;

import java.util.function.Predicate;

public class UserValidators {
    static final Predicate<String> usernameIsValid = username -> !username.isEmpty() && username.length() >= 5;

    static final Predicate<String> passwordIsValid = password -> !password.isEmpty() && password.length() >= 5;

    static final Predicate<String> emailIsValid = email -> email
            .matches("^(.+)@(.+)$");

    static final Validator<User> usernameValidator = Validator.of(
            user -> usernameIsValid.test(user.getUsername()) ? ValidatorResult.valid()
                    : ValidatorResult.invalid("Username is NOT valid."));

    static final Validator<User> emailValidator = Validator.of(
            user -> emailIsValid.test(user.getEmail()) ? ValidatorResult.valid()
                    : ValidatorResult.invalid("Email is NOT valid."));

    static final Validator<User> passwordValidator = Validator.of(
            user -> passwordIsValid.test(user.getPassword()) ? ValidatorResult.valid()
                    : ValidatorResult.invalid("Password is NOT valid."));

    static Validator<User> userValidator = usernameValidator.and(emailValidator).and(passwordValidator);
}
