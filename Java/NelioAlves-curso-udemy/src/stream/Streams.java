package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* As operações realizaveis sobre um STREAM são divididas em dois grupos: intermédiarias e finais.
 * Como o nome sugere, operações finais são aquelas que encerram o fluxo da stream, 
 * as intermediarias são aquelas que ocorrem dentro da stream e que podem retornar stream menores.
 * A ocorrência de operações intermédiarias e finais dentro de uma STREAM recebe o nome de PIPELINE.
 * */ 

 /* INTERMEDIARIAS:
  		- produz novas streams (encadeamento)
  		- só executa quando uma operação terminaç é invocada (lazy evaluation)
  
   'filter(), para filtrar elementos'. 
  		* O filter é usado para filta elementos de uma stream de acordo com uma condição (predicate). Para tal ele recebe como parâmetro
  		* um objeto que implementa a interface Predicate<T> (interface funcional com valor de retorno igual a uma boolean) 
  		* e retorna uma nova stream contendo apenas os elementos que satisfação a condição.
  		* 
   'map()', para aplicar operações em elementos.
  		*   Diante de algumas situações se faz necessário realizar transformações em uma lista de dados. 
  		*   O método map() permite realizar essas mudanças sem a necessidade de variáveis intermediárias, 
  		*   apenas utilizando como argumento uma função do tipo java.util.function.Function, que, assim como Predicate<T>, 
  		*   também é uma interface funcional. Essa função toma cada elemento de uma stream como parâmetro 
  		*   e retorna o elemento processado como resposta. 
  		*   O resultado será uma nova stream contendo os elementos mapeados a partir da stream original.
   'sorted()', para organizar elementos. 
  		*
   'limit()', estabelece um limite de dados a serem processados pelo stream. Por exemplo, caso haja uma lista com n elementos 
   		* e vc queira processar apenas os 10 primeiros é possível fazer isso usando 'limit(10). Assim, no decimo elemento o stream() se encerra
   		* É chamado de SHORT-CIRCUIT', ou curto-circuito, pois não precisa processar todos os dados.
   		*
   'distinct()', usa o metódo equals() para adicionar apenas elementos não repetidos dentro de uma nova stream 
  */

  /* FINAIS: 
   		- produz um objeto não stream
   		- determina o fim do processamento da stream
  
  
   * 'collect(), coleta os elementos de uma stream e os transforma em coleções list, set ou map
   		*
   * 'average(), captura a média de um determinado valor
   		* 
   * 'forEach()', percorre uma stream, através de um loop, aplicando uma ação a cada elemento
   		* 
   * 'count()', conta qual elementos há em uma stream
   		*
   * 'allMatch()', verifica se todos os elementos em uma stream se encaixam em certo critério definido em um Predicate. 
   		* Caso todos os elementos passem nesse critério, retorna true, senão false.
   * ''
   * */


public class Streams {
	public static void main(String[] args) {
	
		//**********************************************************************************************************************************************//
		// O P E R A Ç Õ E S      I N T E R M É D I A R I A S 
		
		//FILTER() -> buscar pessoas que nasceram no Brasil
		List<Pessoa> pessoas = new Pessoa().populaPessoas(); 
		
		List<Pessoa> brasileiros = pessoas
				.stream() // Transforma a lista em um stream
				.filter((p) -> p.getNacionalidade().equalsIgnoreCase("Brasil")) // (INTERMÉDIARIA) Filtra através do predicate em forma de  expressão lambda 
				.collect(Collectors.toList()); // (FINAL) Transforma a stream em uma lista novamente
		System.out.println(brasileiros);
		
		//MAP() -> obter apenas as idades das pessoas presentes no fluxo de dados
		List<Integer> idades = pessoas.stream() // transforma em stream
				.filter((p) -> p.getNacionalidade().equals("Brasil")) // filtrar os elementos
				.map(Pessoa::getIdade) // para cada elemento aplica uma função getIdade() que irá retorna apenas a idade de cada pessoa
				.collect(Collectors.toList()); // transforma em lista
		System.out.println(idades);
		
		//SORTED() -> ordernar todas as pessoas pelo nome
		List<Pessoa> ordenadas = pessoas.stream()
					.sorted(Comparator.comparing(Pessoa::getNome)) //Usa o método comparing da interface comparator passando o nome dos elemento como meio de comparaçã
					.collect(Collectors.toList()); 
		System.out.println(ordenadas);
		
		//SORTED() -> verficar atráves do equals quais elementos são iguais e adiciona apenas os que não se repetem
		List<Integer> idadesDiferentes = pessoas.stream()
				.map(Pessoa::getIdade)
				.distinct()
				.collect(Collectors.toList()); 
		System.out.println(idadesDiferentes);
		
		//LIMIT() -> mostre apenas os dois primeiros elementos
		List<Pessoa> primeiras = pessoas.stream()
				.limit(2)
				.collect(Collectors.toList());
		System.out.println(primeiras);
		
		
		//**********************************************************************************************************************************************//
				// O P E R A Ç Õ E S      T E R M I N A I S
		
		//FOR EACH -> imprima o nome de todas as pessoas
		pessoas.stream().forEach((p) -> System.out.println(p.getNome()));
		
		//AVEGARE -> retorna a média da idade de todas as pessoas nascidas no Brasil
		double media = pessoas.stream()
				.filter((pessoa) -> pessoa.getNacionalidade().equals("Brasil"))
				.mapToInt(pessoa -> pessoa.getIdade())
				.average()
				.getAsDouble();
		System.out.println(media);
		
		//COLLECT -> transfome todos da lista em stream, depois converta para lista
		List<Pessoa> colecao = pessoas.stream().collect(Collectors.toList());
		System.out.println(colecao);
		
		//ALLMATCH() -> verifica se todos possuem idade menor que 49 nomes.
		boolean todosTemNome = pessoas.stream()
				.allMatch((pessoa) -> pessoa.getIdade() < 49);
		System.out.println(todosTemNome);
				
	}

}

class Pessoa {
	private String id;
	private String nome;
	private String nacionalidade;
	int idade; // gets e sets omitidos

	public Pessoa() {
	}

	
	public Pessoa(String id, String nome, String nacionalidade, int idade) {
		this.setId(id);
		this.nome = nome;
		this.setNacionalidade(nacionalidade);
		this.idade = idade;
	}

	public List<Pessoa> populaPessoas() {
		Pessoa pessoa1 = new Pessoa("p1", "Matheus Henrique", "Brasil", 18);
		Pessoa pessoa2 = new Pessoa("p2", "Hernandez Roja", "Mexico", 21);
		Pessoa pessoa3 = new Pessoa("p3", "Marcos", "Canada", 22);
		Pessoa pessoa4 = new Pessoa("p4", "Neymar Junior", "Brasil", 22);
		Pessoa pessoa5 = new Pessoa("p5", "Marcia Dias", "Argentina", 18);
		Pessoa pessoa6 = new Pessoa("p6", "", "EUA", 38);
		Pessoa pessoa7 = new Pessoa("p7", "Lucas", "EUA", 48);
		List<Pessoa> list = new ArrayList<Pessoa>();
		list.add(pessoa1);
		list.add(pessoa2);
		list.add(pessoa3);
		list.add(pessoa4);
		list.add(pessoa5);
		list.add(pessoa6);
		list.add(pessoa7);
		return list;
	}

	@Override
	public String toString() {
		return this.nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}



