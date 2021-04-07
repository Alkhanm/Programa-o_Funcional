package strategy;
// STRATEGY
/** Será usada como uma interface funcional por possuir apenas um método
 ** No Java, as interfaces funcionais são aquelas que implementam apenas um único método
 ** O motivo para isso é que durante a execução o compilador infere automaticamento
 ** que aquele único metodo será usado como uma expressão funcional (lambda) */
@FunctionalInterface
public interface Pizza {
    void preparar();
}
