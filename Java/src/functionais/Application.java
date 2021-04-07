package functionais;

import functionais.interfaces.Functional;
import functionais.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Arrays.asList(
               new Product(1, "notebook", "informatica", 2.0),
               new Product(2, "celular", "informatica", 1.0),
               new Product(3, "hidratante", "cosmetico", 2.0),
               new Product(4, "geladeira", "eletroddomestico", 9.0))
        );

        Functional.of(products)
                .function(p -> {
                    p.price = p.price + 10;
                    return p;
                })
                .predicate(p -> p.price >= 12)
                .consumer(System.out::println);

        System.out.println("----------------------");
        Integer a = 2000000000;
        Integer b = 2000000000;
        System.out.println(a * b);
    }
}
