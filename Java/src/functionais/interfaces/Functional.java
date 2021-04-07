package functionais.interfaces;

import functionais.interfaces.consumer.Consumer;
import functionais.interfaces.function.Function;
import functionais.interfaces.predicate.Predicate;

import java.util.ArrayList;
import java.util.List;

public class Functional<T extends Clone<T>> {
    private List<T> list;

    public Functional(List<? extends T> list){
        this.list = List.copyOf(list);
    }

    public static <T  extends Clone<T>> Functional<T> of(List<T> list){
        return new Functional<>(list);
    }

    public Functional<T> function(Function<T> function){
        List<T> transformed = new ArrayList<>();
        for (T t: this.list){
            transformed.add(function.apply(t.getClone()));
        }
        this.list = transformed;
        return this;
    }

    public Functional<T> predicate(Predicate<T> predicate){
        List<T> filtred = new ArrayList<>();
        for (T t: this.list){
            if (predicate.apply(t)) filtred.add(t);
        }
        this.list = filtred;
        return this;
    }
    
    public void consumer(Consumer<T> consumer){
        for (T t: this.list){
            consumer.apply(t.getClone());
        }
    }

    public List<T> get() {
        return this.list;
    }
}
