import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public Main() {

	}

	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Scanner int_scanner = new Scanner(System.in);
		Scanner str_scanner = new Scanner(System.in);
		Scanner dou_scanner = new Scanner(System.in);
		int menu_index;
		int id_ref = 6;
		int id_check;

		employees.add(new Hourly("Bango", "Capital das Terras Verdes", 1, 150.00));
		employees.add(new Salaried("Cesar", "Terras de Ballor", 2, 600.00));
		employees.add(new Comissioned("Travis", "Capital das Terras Verdes", 3, 0.5));
		employees.add(new Hourly("Nocard", "Cidadela de Sao Arnaldo", 4, 15.00));
		employees.add(new Hourly("Damiao", "Puris Puris", 5, 2.00));

		do{
		System.out.println("MENU:\n[1] - Adicionar Empregado;\n[2] - Remover Empregado;\n[0] - Parar o Programa.\n");
		menu_index = int_scanner.nextInt();

		switch(menu_index){
		case 1:
			System.out.println("Informe o Nome do Empregado:\t");
			String name_in = str_scanner.nextLine();
			System.out.println("Informe o Endereco do Empregado:\t");
			String adress_in = str_scanner.nextLine();
			System.out.println("Informe o Tipo do Empregado:\t");
			String type_in = str_scanner.nextLine();
			if(type_in.equals("Hourly")){
				System.out.println("Informe o Valor da Hora do Empregado:\t");
				double hour_price_in = dou_scanner.nextDouble();
				employees.add(new Hourly(name_in, adress_in, id_ref, hour_price_in));
			}
			else if(type_in.equals("Salaried")){
				System.out.println("Informe o Valor do Salario do Empregado:\t");
				double month_price_in = dou_scanner.nextDouble();
				employees.add(new Salaried(name_in, adress_in, id_ref, month_price_in));
			}
			else if(type_in.equals("Comissioned")){
				System.out.println("Informe a Comissao do Empregado:\t");
				double comission_in = dou_scanner.nextDouble();
				employees.add(new Comissioned(name_in, adress_in, id_ref, comission_in));
			}
			id_ref++;
			break;
		case 2:
			System.out.println("Informe o Numero do Funcionario a ser Removido:\t");
			id_check = int_scanner.nextInt();
			for(int i = 0; i < employees.size(); i++){
				if(id_check == employees.get(i).getId()){
					employees.remove(i);
				}
			}
			break;
		case 3:
			System.out.println("Informe o Numero do Funcionario Associado ao Cartao:\t");
			id_check = int_scanner.nextInt();
			for(int i = 0; i < employees.size(); i++){
				if(id_check == employees.get(i).getId()){
					employees.remove(i);
				}
			}
			break;
		}
		}while(menu_index != 0);

	}
}
