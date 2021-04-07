package functionais.interfaces.consumer;

@FunctionalInterface
public interface Consumer<T> {
    void apply(T t);
}
