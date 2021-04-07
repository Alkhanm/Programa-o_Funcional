package other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Exercicio {
	public static void main(String[] args) {

		/*
		 * Fazer um programa para ler um conjunto de produtos a partir de um arquivo em
		 * formato .csv (suponha que exista pelo menos um produto). Em seguida mostrar o
		 * preço médio dos produtos. Depois, mostrar os nomes, em ordem decrescente, dos
		 * produtos que possuem preço inferior ao preço médio.
		 */
		String path = "/media/alkham/Heviternia/Programming/produtos.csv";
		
		//Método sem classe
		calcAverage1(readerText(path));
		System.out.println("\n---------------\n");
		//Com classe
		calcAverage2(readerText(path));

	}

	public static List<String> readerText(String path) {
		 // Cria uma lista para armazenar as linhas do texto
		List<String> lines = new ArrayList<>();

		//Instância os recursos para a leitura de um texto
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) { //Essa estrutura de try/catch se encarrega de fechar os recursos.
			//Lê a primeira linha e a adiciona na lista
			lines.add(reader.readLine()); 
			//Enquanto houver uma linha a ser lida...
			while (reader.ready()) { 
				//Leia e a adiciona na lista
				lines.add(reader.readLine());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return lines;
	}
	

	public static void calcAverage1(List<String> produtos) {

		double media = 
				produtos.stream()
				.mapToDouble(p -> Double.parseDouble(p.split(",")[1]))
				// soma os valores de todos os elementos depois os dividos pelo tamanho da lista para obter a média.
				.reduce(0.0, (x, y) ->  x + y) / produtos.size();

		System.out.println("Média: " + media + "\n");
		System.out.println("Abaixo da média: \n");
		
		Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
		
		produtos.stream()
			.filter(p -> Double.parseDouble(p.split(",")[1]) < media)
			.sorted(comp.reversed())
			.forEach(System.out::println);
	}

	public static void calcAverage2(List<String> text) {
		
		//Cria uma lista para guardar os produtos
		List<Product> products = new ArrayList<>();
		
		//Percorre o arquivo texto recebido no parâmetro
		for (String t : text) {
			//Cria uma objeto vazio de produto
			Product product = new Product();
			//Fatia em duas partes cada linha do arquivo
			String [] fields = t.split(",");
			product.setName(fields[0]); // A primeira parte antes do "," é o nome
			product.setPrice(Double.parseDouble(fields[1])); // A segunda, o preço
			
			//Adiciona o produto
			products.add(product);
		}
		//Faz a comparação entre nomes do produtos por ordem alfabetica inversa
		products.sort((p1, p2) -> p2.getName().compareToIgnoreCase(p1.getName()));
		double media = 
				products.stream() // cria uma stream com a lista de produtos
				.mapToDouble(Product::getPrice) // retorna uma stream contenddo apenas os preços
				.average()	//Calcula a média desses preços
				.orElse(0); // Caso não seja possivel calcular, irá retornar 0
		
		System.out.println("Média: " + media + "\n");
		System.out.println("Abaixo da média: \n");
		
		products.stream() // Transforma a lista em stream
				.filter(p -> p.getPrice() < media) // filtar apenas aqueles q estão com o preço abaixo da média
				.collect(Collectors.toList()) // transforma em lista novamente
				.forEach(System.out::println); // Imprime todos os elementos q restarão nessa nova lista
	}

}






