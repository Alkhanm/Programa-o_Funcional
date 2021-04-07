package other;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exemplos {

	public static void main(String[] args) {
		
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Stream<Integer> st1 = list.stream().map( x -> x * 10);
		System.out.println(Arrays.deepToString(st1.toArray()));

		int sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("Sum = " + sum);
		
		
		List<Integer> list2 = list.stream()
				.filter(x -> x % 2 == 0) // captura apenas os pares
				.map(x -> x - 1)		 // reduz em 1 cada elemento, de forma que agora o que resta são itens impares
				.map(x -> x * 10)		//  multiplica por dez
				.collect(Collectors.toList());
		System.out.println(list2);
		
	}
}