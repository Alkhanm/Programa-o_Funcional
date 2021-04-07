package consumer;

import java.util.function.Consumer;

//Interface que implementa um metódo action da interface funcional Consumer 
public class ProductConsumerPriceUpdate implements Consumer<Product> {

	@Override
	public void accept(Product p) {
		p.setValue(p.getValue() * 1.1);
		//A ação será pegar o valor do produto e multiplica-lo por 1.1 (aumentar em 10%)
	}
	
}
