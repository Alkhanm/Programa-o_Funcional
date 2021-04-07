package function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*CONSUMIDOR: que ou o que se alimenta de outros seres. */
public class Application {
	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

/* Fazer um programa que, a partir de uma lista de produtos, gere uma nova lista contendo 
 * os nomes dos produtos em caixa alta
 * */
		
		// IMPLEMENTAÇÃO DA INTERFACE
			/* 'map()' é um metodo que aplica uma função para cada elemento de uma coleção
			 * 'stream()' converte uma lista em um stream
			 * '.collect(Collectors.toList())' transforma um stream em lista*/
			// Transforma list em um stream depois aplica a function a cada elemento da stream, 
			// então converte de volta para lista e adiciona em uma nova lista
			List<String> names = list.stream().map(new ProductUpperCaseFunction()).collect(Collectors.toList());  
	
		
		// REFERENCE METHOD COM MÉTODO ESTÁTICO
			List<String> names2 = list.stream().map(Product::staticProductUpperCase).collect(Collectors.toList());
		
		
		// REFERENCE METHOD COM MÉTODO NÃO ESTÁTICO
			List<String> names3 = list.stream().map(Product::nonStaticProductUpperCase).collect(Collectors.toList());
		
		// EXPRESSÃO LAMBDA DECLARADA
			Function <Product, String> funProductUpperCase = (p) -> p.getName().toLowerCase(); 
			List<String> names4 = list.stream().map(funProductUpperCase).collect(Collectors.toList());
			
		// EXPRESSÃO LAMBDA INLINE
			List<String> names5 = list.stream().map((p) -> p.getName().toUpperCase()).collect(Collectors.toList());
		
			System.out.println("names");
			names.forEach(System.out::println);
			System.out.println("\nnames2");
			names2.forEach(System.out::println);
			System.out.println("\nnames3");
			names3.forEach(System.out::println);
			System.out.println("\nnames4");
			names4.forEach(System.out::println);
			System.out.println("\nnames5");
			names5.forEach(System.out::println);
		
	}
}
