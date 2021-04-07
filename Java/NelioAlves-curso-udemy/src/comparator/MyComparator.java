package comparator;

import java.util.Comparator;

/* Implementa uma interface de comparação.
 * */
public class MyComparator implements Comparator<Product>{

	@Override /*Esse é o metodo obrigatorio da interface onde será definido que criterios de comparação serão usados*/
	public int compare(Product p1, Product p2) { /*Os objetos 'p1' e 'p2', serão comparados usando: */
		/*Os principios são os seguintes: 
		 * 1 - caso o primeiro objeto seja maior, retorne um número inteiro positivo
		 * 2 - caso o segundo objeto seja maior, retorne um número negativo
		 * 3 - caso sejam iguais, retorne 0 */
		return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()); //A comparação se dará por orderm alfabetica entre os atributos 'name' dos objetos 'Product'
	}

}
