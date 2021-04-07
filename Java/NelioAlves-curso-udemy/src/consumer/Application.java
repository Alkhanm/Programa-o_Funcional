package consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*CONSUMIDOR: que ou o que se alimenta de outros seres. */
public class Application {
	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		//FAZER UM PROGRAMA QUE, A PARTIR DE UMA LISTA DE PRODUTOS, AUMENTE O PREÇO DOS PRODUTOS EM 10%
		
		//Para cada produto dentro desta lista, diz o 'forEach', aplique a ação desta interface funcional
		
		/*Isso*/    
		 list.forEach(new ProductConsumerPriceUpdate());
		/*Equivale a isso:*/
		list.forEach(p -> p.setValue(p.getValue() * 1.1 ));
		
		//'Metod Reference' (static)
		list.forEach(Product::staticProductConsumer);
		
		//'Metod Reference' (nonStatic)
		list.forEach(Product::nonStaticProductConsumer);
		
		//Lambda Declarada
		Consumer<Product> action = (p) -> {
			p.setValue(p.getValue() * 1.1);  
		};
		list.forEach(action);
		
		//Argumento lambda
		list.forEach((p) -> p.setValue(p.getValue()  * 1.1));
		
		/*Isso*/ 		
		list.forEach(new ProductConsumerPrint());
		/*Equivale a isso:*/
		list.forEach(System.out::println);
		
		
		
	}
}
