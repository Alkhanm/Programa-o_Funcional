package strategy;

// Concrete Strategy
public class PizzaCalabresa implements Pizza {
    @Override public void preparar() {
        System.out.println("massa, presunto, queijo e cebola");
    }

}
