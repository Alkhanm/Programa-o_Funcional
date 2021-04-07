package predicate;

					
public class Product {
	
	private String name;
	private Double value;
	
	
	
	public Product(String name, Double value) {
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
	public void setValue(Double value) {
		this.value = value;
	}
										
	public static boolean staticProductPredicate(Product p) {//O metodo estatico trabalha com um objeto passado como argumento
		return p.getValue() >= 100.0;
	}
	
	public boolean nonStaticProductPredicate() { //Um método não estático trabalha diretamento no objeto ao qual pertence
		return value >= 100.0;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", value=" + value + "]";
	}

	
	
}
