package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		
		List<Product> products = Arrays.asList(
				new Product("Notebook", 2000),
				new Product("Smartphone", 1200),
				new Product("Computer", 4000),
				new Product("MacBook", 8000),
				new Product("Pen", 2));
		
		/* 1. Uma das formas de se implementar um 'Comparator', usando uma classe externa
		 */ 
		   products.sort(new MyComparator());
		
		
		/* 2. Outra forma seria usa uma classe anônima:
		 * Perceba que está classe anônima faz exatemente a mesma coisa que a classe externa MyComparator 
		 */
		  Comparator<Product> comp = new Comparator<Product>() {
			  @Override
			  public int compare(Product p1, Product p2) {
			  	 return p1.getValue().compareTo(p2.getValue()); // Compara os objetos através do valor de cada uma
			  }
		  };

		
		
		/* 3. A terceira é talvez mais interessante, pois reduz a verbosidade e aumenta a elegância */
		
		/* Observe que o compilador irá realizar a inferência de tipos. Na parte de argumentos (p1, p2),
		 * não é necessario dizer o que são essas duas variaveis, o compilador entende que eles pertencem ao mesmo tipo passado 
		 * no generics <Product> */
		Comparator<Product> comp2 = (p1, p2) -> {
			return p1.getValue().compareTo(p2.getValue());
		};
		/*Essa versão acima equivale a esta: */
		// Como há apenas um argumento, as chaves { } são desnecessarias
		// O 'return' tbm é desnecessario, pois está implicito que algo deve ser retornado (no caso, aquilo que estive após ->)
		Comparator<Product> comp3 = (p1, p2) -> p1.getValue().compareTo(p2.getValue());
		/*Obs: a ordenação será crescente caso seja comparado p1 > p2, caso deseja que a ordem seja decrescente, use p2 > p1*/
		
		/* Outra forma ainda de usar a comparação, é passando todo a expressão lambda como argumento. Veja: */
		products.sort((p1, p2) -> p2.getValue().compareTo(p1.getValue()));
		
		products.forEach(System.out::println);
		
	}
}
