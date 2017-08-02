import java.util.Scanner;


public class Comissioned extends Employee{
	double comission;
	double total_to_pay;
	double tax;
	
	Scanner dou_scanner = new Scanner(System.in);
	
	public double getTotal_to_pay() {
		return total_to_pay - tax;
	}

	public void tax(double tax) {
		this.tax = tax;
	}

	public Comissioned(String name_in, String adress_in, int id_ref, double comission_in){
		super(name_in, adress_in, id_ref, "Comissioned");
		this.comission = comission_in;
		this.total_to_pay = 0;
		this.tax = 0;
	}

	public void sellResult(){
		System.out.println("Informe o valor da venda:\t");
		double sell = dou_scanner.nextDouble();
		this.total_to_pay += sell * this.comission;
	}
}
