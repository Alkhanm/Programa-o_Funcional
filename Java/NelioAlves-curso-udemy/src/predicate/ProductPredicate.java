package predicate;

import java.util.function.Predicate;

//Interface que implementa predicate para o Prodduct
public class ProductPredicate implements Predicate<Product> {

	
	@Override 
	public boolean test(Product p) {
		/*O predicado vai retorna verdadeiro caso, o valor do product seja maior que 100.00*/
		return p.getValue() >= 100.00;
	}

	
}
