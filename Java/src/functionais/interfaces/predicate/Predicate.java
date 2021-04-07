package functionais.interfaces.predicate;


@FunctionalInterface
public interface Predicate<T> {
    boolean apply(T t);
}
