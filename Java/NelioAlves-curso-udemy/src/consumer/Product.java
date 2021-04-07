package consumer;

					
public class Product {
	
	private String name;
	private Double value;
	
	
	
	public Product(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
										
	public static void staticProductConsumer(Product p) {//O metodo estatico trabalha com um objeto passado como argumento
		 p.setValue(p.getValue() * 1.1);
	}
	
	public void nonStaticProductConsumer() { //Um método não estático trabalha diretamento no objeto ao qual pertence
		value = value * 1.1;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", value=" + value + "]";
	}

	
	
}
