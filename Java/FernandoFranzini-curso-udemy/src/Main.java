import strategy.Forno;
import strategy.Pizza;
import strategy.PizzaCalabresa;
import strategy.PizzaNapolitana;

public class Main {
    public static void main(String[] args) {
        //Context criado
        Forno forno = new Forno();

        //Concrete Strategies
        PizzaNapolitana napolitana = new PizzaNapolitana();

        //O método pode receber um objeto que realizar a implementa a Strategy, assim:
        forno.assar(napolitana);
        //ou assim:
        forno.assar(new PizzaCalabresa());

        //E também atráves da implementação direta da interface
        forno.assar(new Pizza() {
            @Override public void preparar() {
                System.out.println("Faz qualquer coisa");
            }
        });

        //Ou ainda como uma expressão lambda
        forno.assar(() -> System.out.println("Hello, lambda"));
    }
}
