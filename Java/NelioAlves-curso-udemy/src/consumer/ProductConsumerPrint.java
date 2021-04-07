package consumer;

import java.util.function.Consumer;

public class ProductConsumerPrint implements Consumer<Product> {

	@Override
	public void accept(Product t) {
		System.out.println(t.getValue());
	}

}
