import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;


public class Main {

	public Main() {

	}

	public static void main(String[] args) {
		Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
		ArrayList<Integer> id_in = new ArrayList<Integer>();
		Scanner int_scanner = new Scanner(System.in);
		Scanner str_scanner = new Scanner(System.in);
		Scanner dou_scanner = new Scanner(System.in);
		int menu_index;
		int id_ref = 6;
		int id_check;
		double tax_in;
		
		double comission_in;
		double hour_price_in;
		double month_price_in;
		
		Comissioned comissioned;
		Hourly hourly;
		Salaried salaried;
		Employee employee;

		id_in.add(1);
		id_in.add(2);
		id_in.add(3);
		id_in.add(4);
		id_in.add(5);

		employees.put(id_in.get(0), new Hourly("Bango", "Capital das Terras Verdes", 1, 150.00));
		employees.put(id_in.get(1), new Salaried("Cesar", "Terras de Ballor", 2, 600.00));
		employees.put(id_in.get(2), new Comissioned("Travis", "Capital das Terras Verdes", 3, 0.5));
		employees.put(id_in.get(3), new Hourly("Nocard", "Cidadela de Sao Arnaldo", 4, 15.00));
		employees.put(id_in.get(4), new Hourly("Damiao", "Puris Puris", 5, 2.00));

		do{
		System.out.println("MENU:\n[1] - Adicionar Empregado;\n[2] - Remover Empregado;\n[3] - Lancar Cartao;\n[4] - Lancar Resultado de Venda;\n[5] - Lancar Taxa de Servico;\n[0] - Parar o Programa.\n");
		menu_index = int_scanner.nextInt();

		switch(menu_index){
		case 1:
			id_in.add(id_ref);
			System.out.println("Informe o Nome do Empregado:\t");
			String name_in = str_scanner.nextLine();
			System.out.println("Informe o Endereco do Empregado:\t");
			String adress_in = str_scanner.nextLine();
			System.out.println("Informe o Tipo do Empregado:\t");
			String type_in = str_scanner.nextLine();
			if(type_in.equals("Hourly")){
				System.out.println("Informe o Valor da Hora do Empregado:\t");
				hour_price_in = dou_scanner.nextDouble();
				employees.put(id_ref, new Hourly(name_in, adress_in, id_ref, hour_price_in));
			}
			else if(type_in.equals("Salaried")){
				System.out.println("Informe o Valor do Salario do Empregado:\t");
				month_price_in = dou_scanner.nextDouble();
				employees.put(id_ref, new Salaried(name_in, adress_in, id_ref, month_price_in));
			}
			else if(type_in.equals("Comissioned")){
				System.out.println("Informe a Comissao do Empregado:\t");
				comission_in = dou_scanner.nextDouble();
				employees.put(id_ref, new Comissioned(name_in, adress_in, id_ref, comission_in));
			}
			id_ref++;
			break;
		case 2:
			System.out.println("Informe o Numero do Funcionario a ser Removido:\t");
			id_check = int_scanner.nextInt();
			employees.remove(id_check);
			//CASO SURJA O INTERESSE EM PRESERVAR O USO DO VECTOR, EXCLUIR O ELEMENTO QUE GUARDA O ID EXCLUIDO
			break;
		case 3:
			System.out.println("Informe o Numero do Funcionario Associado ao Cartao:\t");
			id_check = int_scanner.nextInt();
			hourly = (Hourly) employees.get(id_check);
			hourly.getSituation();
			employees.replace(id_check, hourly);
			break;
		case 4:
			System.out.println("Informe o Numero do Vendedor:\t");
			id_check = int_scanner.nextInt();
			comissioned = (Comissioned) employees.get(id_check);
			comissioned.sellResult();
			employees.replace(id_check, comissioned);
			break;
		case 5:
			System.out.println("Informe o Numero de Identificacao do Empregado:\t");
			id_check = int_scanner.nextInt();
			System.out.println("Informe a Taxa a ser Cobrada:\t");
			tax_in = dou_scanner.nextInt();
			if(employees.get(id_check).getType().equals("Comissioned")) {
				comissioned = (Comissioned) employees.get(id_check);
				comissioned.tax(tax_in);
				employees.replace(id_check, comissioned);
			}else if(employees.get(id_check).getType().equals("Hourly")) {
				hourly = (Hourly) employees.get(id_check);
				hourly.tax(tax_in);
				employees.replace(id_check, hourly);
			}else if(employees.get(id_check).getType().equals("Salaried")) {
				salaried = (Salaried) employees.get(id_check);
				salaried.tax(tax_in);
				employees.replace(id_check, salaried);
			}
			break;
		case 6:
			System.out.println("Informe o Numero de Identificacao do Empregado:\t");
			id_check = int_scanner.nextInt();
			System.out.println("MENU:\n[1] - Alterar Nome;\n[2] - Alterar Endereco;\n[3] - Alterar Tipo;\n[4] - Taxa Sindical;\n");
			int inner_menu = int_scanner.nextInt();
			
			switch(inner_menu) {
			case 1:
				System.out.println("Insira o novo nome:\t");
				String name_set = str_scanner.nextLine();
				employees.get(id_check).setName(name_set);
				break;
			case 2:
				System.out.println("Insira o novo endereco:\t");
				String adress_set = str_scanner.nextLine();
				employees.get(id_check).setAdress(adress_set);
				break;
			case 3:
				System.out.println("Insira o novo tipo:\t");
				String type_set = str_scanner.nextLine();
				
				if(type_set.equals("Comissioned")) {
					System.out.println("Informe a Comissao do Empregado:\t");
					comission_in = dou_scanner.nextDouble();
					employee = employees.get(id_check);
					comissioned = new Comissioned(employee.getName(), employee.getAdress(), id_check, comission_in);
					employees.replace(id_check, comissioned);
				}else if(type_set.equals("Salaried")) {
					System.out.println("Informe o Salario do Empregado:\t");
					month_price_in = dou_scanner.nextDouble();
					employee = employees.get(id_check);
					salaried = new Salaried(employee.getName(), employee.getAdress(), id_check, month_price_in);
					employees.replace(id_check, salaried);
				}else if(type_set.equals("Hourly")) {
					System.out.println("Informe o Preco da Hora do Empregado:\t");
					hour_price_in = dou_scanner.nextDouble();
					employee = employees.get(id_check);
					hourly = new Hourly(employee.getName(), employee.getAdress(), id_check, hour_price_in);
					employees.replace(id_check, hourly);
				}
				
				break;
			case 4:
				System.out.println("Informe a nova Taxa a ser Cobrada:\t");
				tax_in = dou_scanner.nextInt();
				if(employees.get(id_check).getType().equals("Comissioned")) {
					comissioned = (Comissioned) employees.get(id_check);
					comissioned.tax(tax_in);
					employees.replace(id_check, comissioned);
				}else if(employees.get(id_check).getType().equals("Hourly")) {
					hourly = (Hourly) employees.get(id_check);
					hourly.tax(tax_in);
					employees.replace(id_check, hourly);
				}else if(employees.get(id_check).getType().equals("Salaried")) {
					salaried = (Salaried) employees.get(id_check);
					salaried.tax(tax_in);
					employees.replace(id_check, salaried);
				}
				break;
			}

		}
		}while(menu_index != 0);

	}
}
