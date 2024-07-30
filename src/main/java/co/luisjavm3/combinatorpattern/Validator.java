package co.luisjavm3.combinatorpattern;

import java.util.function.Function;

@FunctionalInterface
public interface Validator<T> extends Function<T, ValidatorResult> {
    static <T> Validator<T> of(Function<T, ValidatorResult> f) {
        return f::apply;
    }

    default Validator<T> and(Validator<T> other) {
        return t -> {
            ValidatorResult result = this.apply(t);
            return result.isValid() ? other.apply(t) : result;
        };
    }
}
