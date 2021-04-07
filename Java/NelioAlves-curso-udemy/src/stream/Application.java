package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Application {
	
	public static String removeIf(String nome) {
		if (nome.length() > 4) {
			return nome;
		}
		return "";
	}
	
	public static void main(String[] args) { 
	

		
		List<Integer> list = Arrays.asList(1, 2, 3,4,5,6,7,8,9);
		
		
		Stream<Integer> st1 = list.stream().map(x -> x * 10);
		System.out.println(Arrays.toString(st1.toArray()));

		Stream<String> st2 = Stream.of("João", "José", "Gabriel", "Lucas").map(Application::removeIf);
		System.out.println(Arrays.toString(st2.toArray()));
		
		Stream<String> st3 = Stream.of("João", "José", "Gabriel", "Lucas").filter(p -> p.length() > 4);
		System.out.println(Arrays.toString(st3.toArray()));
		
		//Cria-se uma Stream de inteiros
		//Esse stream começará em 0 e irá iterar sempre do primeiro elemento ao segundo aumentando de dois em dois
		Stream<Integer> st4 = Stream.iterate(0, x -> x + 2);
		//Ao invocar essa stream passasse um limit(10), para que só itere até 10 elementos e ñ ao infinito
		System.out.println(Arrays.toString(st4.limit(10).toArray()));
		
		Stream<Long> st5 = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[] {p[1], p[0] + p[1]}).map(p -> p[0]);
		System.out.println(Arrays.toString(st5.limit(10).toArray()));
	}
}






