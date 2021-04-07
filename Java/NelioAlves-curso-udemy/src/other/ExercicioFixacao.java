package other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee{
	private String name;
	private String email;
	private Double salary;
	public Employee(String name, String email, Double salary) {
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	public Employee() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return  name + "," + email + "," + salary;
	}
	
}

public class ExercicioFixacao {
	/* Fazer um programa para ler os dados (nome, email e salário) de funcionários a partir de um arquivo em formato .csv.
	 * Em seguida mostrar, em ordem alfabética, o email dos funcionários cujo salário seja superior a um dado valor fornecido pelo usuário. 
	 * Mostrar também a soma dos salários dos funcionários cujo nome começa com a letra 'M'. */
	
	public static void main(String[] args) {
		String path = "/media/alkham/Heviternia/Programming/employee.csv";
		List<Employee> list = getEmployee(reader(path));
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Mostrar email dos funcionarios que recebem mais que:\n");
		int value = scan.nextInt();
		
		list.stream()
			.filter((p) -> p.getSalary() > value)
			.map(Employee::getEmail)
			.forEach(System.out::println);
		System.out.println("Soma do salario das pessoas que o nome começa com 'M': ");
		double sum = list.stream()
			.filter((p) -> p.getName().startsWith("M"))
			.mapToDouble(Employee::getSalary)
			.reduce(0.0, (x, y) -> x + y);
		System.out.print(sum);
	}

	
	public static List<Employee> getEmployee(List<String> text){
		List<Employee> employees = new ArrayList<>();
		
		for (String line : text) {
			String values [] = line.split(",");
			Employee emp = new Employee(values[0], values[1],Double.parseDouble(values[2]));
			employees.add(emp);
		}
		
		return employees;
	}
	
	public static List<String> reader(String path){
		List<String> lines = new ArrayList<>();
		
		try (BufferedReader read = new BufferedReader(new FileReader(path))){
			lines.add(read.readLine());
			
			while (read.ready()) {
				lines.add(read.readLine());
			}
			
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo: " + e.getMessage());
		}
		return lines;
	}
}









