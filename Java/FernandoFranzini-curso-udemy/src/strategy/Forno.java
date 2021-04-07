package strategy;

import strategy.Pizza;

// Context
public class Forno {

    public void assar(Pizza pizza){
        //Operação polimorfica. O resultado dessa chamada dependerá da implementação que for dada a Pizza.
        pizza.preparar();
    }
}
