package firstClassFunction;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {
	
	// É possivel criar um predicate que será definido apenas na hora da chamada desse metódo,
	// assim o programa não amarrado á caso a regra de validação mude.
	public double filteredSum(List<Product> list, Predicate<Product> criteria) {
		double sum = 0.0;
		
		for (Product p : list ) {
			if (criteria.test(p)) { //Verifica se esse 'product' passa pelos criterios definidos no 'Predicate'
				sum += p.getValue();
			}
		}
		return sum;
	}

}
