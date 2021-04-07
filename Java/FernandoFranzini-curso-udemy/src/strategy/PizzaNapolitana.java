package strategy;

// Concrete Strategy
public class PizzaNapolitana implements Pizza {
    @Override public void preparar() {
        System.out.println("massa, presunto, queijo, tomate e oregano");
    }

}
