package firstClassFunction;

import java.util.Arrays;
import java.util.List;


public class Application {
	public static void main(String[] args) {
		
		/* Fazer um programa que, a partir de uma lista de produtos, 
		 * calcule a soma dos preções somente dos produtos que comecem que "T"
		 * */
		
		List<Product> list = Arrays.asList(
				new Product("Notebook", 2000),
				new Product("Smartphone", 1200),
				new Product("Computer", 4000),
				new Product("MacBook", 8000),
				new Product("Pen", 2),
				new Product("Tv", 1209),
				new Product("Tablet", 500));
		
		ProductService service = new ProductService();
		

		// Aqui o Predicate é definido.
		// Neste caso, para cada elemento da lista, verifica se esse produto começa com 'T'
		double sum = service.filteredSum(list, p -> p.getName().charAt(0) == 'T'); 
		
		System.out.println(sum);
		
	}
}
