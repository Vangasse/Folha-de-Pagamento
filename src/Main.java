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
		System.out.println("MENU:\n[1] - Adicionar Empregado;\n[2] - Remover Empregado;\n[3] - Lancar Cartao;\n[0] - Parar o Programa.\n");
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
				double hour_price_in = dou_scanner.nextDouble();
				employees.put(id_ref, new Hourly(name_in, adress_in, id_ref, hour_price_in));
			}
			else if(type_in.equals("Salaried")){
				System.out.println("Informe o Valor do Salario do Empregado:\t");
				double month_price_in = dou_scanner.nextDouble();
				employees.put(id_ref, new Salaried(name_in, adress_in, id_ref, month_price_in));
			}
			else if(type_in.equals("Comissioned")){
				System.out.println("Informe a Comissao do Empregado:\t");
				double comission_in = dou_scanner.nextDouble();
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
			Hourly hourly = (Hourly) employees.get(id_check);
			hourly.getSituation();
			employees.replace(id_check, hourly);
			break;
		case 4:
			System.out.println("Informe o Numero do Vendedor:\t");
			id_check = int_scanner.nextInt();
			Comissioned comissioned = (Comissioned) employees.get(id_check);
			comissioned.sellResult();
			break;
		}
		}while(menu_index != 0);

	}
}
