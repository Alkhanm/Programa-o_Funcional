package function;

import java.util.function.Function;

//Interface que implementa um metódo action da interface ffunction
public class ProductUpperCaseFunction implements Function<Product, String> { // Um function recebe 2 tipos: um de entrada, outro de saída

	@Override
	public String apply(Product p) {
		return p.getName().toUpperCase();
	}
	
}
