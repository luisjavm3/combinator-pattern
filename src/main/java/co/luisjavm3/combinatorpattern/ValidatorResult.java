package co.luisjavm3.combinatorpattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ValidatorResult {
    private final boolean isValid;
    private final String message;

    public static ValidatorResult valid() {
        return new ValidatorResult(true, "");
    }

    public static ValidatorResult invalid(String message) {
        return new ValidatorResult(false, message);
    }

}