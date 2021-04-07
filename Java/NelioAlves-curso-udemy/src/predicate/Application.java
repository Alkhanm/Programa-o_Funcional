package predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*PREDICATO: o que se afirma ou se nega a respeito do sujeito da oração.*/
public class Application {
	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

	// Remova todos os produtos que tenham um valor acima de 100.00 
		
	/* 'RemoveIf' é uma interface funcional predicate que aceita uma expressão
	 * lambda como argumento essa expressão deve gerar um valor booleano */

	/* Isso: */
		list.removeIf(p -> p.getValue() >= 100.00);
		
	/* Equivale a isso: */
		//list.removeIf(new ProductPredicate());

	/* O motivo é pq na verdade todas as expressões lambdas do Java são interpretadas como interfaces funcionais
	 * (interfaces que possuem apenas um metodo obrigatorio) */
		
	/*OUTROS METODOS INTERESSANTES**/
		
	/* 1. 'Reference Methods', a passagem de um metódo estático booleano que irá funcionar como predicate */
		// list.removeIf(Product::staticProductPredicate);
	/* 2. Tbm é aceitavel a passagem de um metódo não estático booleano que irá funcionar como predicate */
		// list.removeIf(Product::nonStaticProductPredicate);	
    /* 3. 'Expressão lambda declarada', nesse caso uma variavel Predicate é explicitamente declarada recebendo uma expressão lambda booleana.
     *     Esse método pode ser interessante pq torna-se muito fácil receber uma váriavel parametrizada, como 'min'*/
		// double min = 100.00;
		// Predicate<Product> pred = p -> p.getValue() >= min;
		// list.removeIf(pred);
		
		
		list.forEach(System.out::println);

	}
}
