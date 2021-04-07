package function;

					
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
										
	public static String staticProductUpperCase(Product p) {//O metodo estatico trabalha com um objeto passado como argumento
		 return p.getName().toUpperCase();
	}
	
	public String nonStaticProductUpperCase() { //Um método não estático trabalha diretamento no objeto ao qual pertence
		return name.toUpperCase();
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", value=" + value + "]";
	}

	
	
}
