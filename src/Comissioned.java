import java.util.Scanner;


public class Comissioned extends Employee{
	double comission;
	double total_to_pay;
	Scanner dou_scanner = new Scanner(System.in);

	public Comissioned(String name_in, String adress_in, int id_ref, double comission_in){
		super(name_in, adress_in, id_ref, "Comissioned");
		this.comission = comission_in;
		this.total_to_pay = 0;
	}

	public void sellResult(){
		System.out.println("Informe o valor da venda:\t");
		double sell = dou_scanner.nextDouble();
		this.total_to_pay += sell * this.comission;
	}
}
