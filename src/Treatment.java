import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Treatment {

	Scanner int_scanner = new Scanner(System.in);
	Scanner str_scanner = new Scanner(System.in);

	public int menuExeption(){

		int menu_index = 0;
		//throws?
		try {
			menu_index = int_scanner.nextInt();
			return menu_index;

		} catch(InputMismatchException e) {
			e.printStackTrace();
			System.out.println("Erro: Entrada Invalida\n");
			return 100;
		}
		}
	
	public int idExistingException(Map<Integer, Employee> employees) throws SystemException, InputMismatchException{
		
		int id_check;
		
		try {
			id_check = int_scanner.nextInt();
			if(employees.get(id_check) != null) {
				return id_check;
			}
			else {
				throw new SystemException();
			}
		} catch(InputMismatchException e) {
			throw new InputMismatchException();
		}
		
	}
	
	public int idHourlyException(Map<Integer, Employee> employees) throws SystemException{
		
		int id_check;
		
		try {
			id_check = idExistingException(employees);
			if(employees.get(id_check).getType().equals("Hourly")){
				return id_check;
			}
			else {
				throw new SystemException("Esta ID nao corresponde a um funcionario horista.");
			}
		} catch(SystemException | InputMismatchException e) {
			throw new SystemException("Esta ID nao corresponde a um funcionario horista.");
		}
		
	}
	
	public int idComissionedException(Map<Integer, Employee> employees) throws SystemException{
		
		int id_check;
		
		try {
			id_check = idExistingException(employees);
			if(employees.get(id_check).getType().equals("Comissioned")){
				return id_check;
			}
			else {
				throw new SystemException("Esta ID nao corresponde a um funcionario comissionado.");
			}
		} catch(SystemException | InputMismatchException e) {
			throw new SystemException("Esta ID nao corresponde a um funcionario comissionado.");
		}
		
	}
}
