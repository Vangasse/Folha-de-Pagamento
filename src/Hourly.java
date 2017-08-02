import java.util.Scanner;


public class Hourly extends Employee{
	double hour_price;
	double hours_to_pay;
	double start;
	double end;
	double tax;
	Scanner dou_scanner = new Scanner(System.in);

	public double getHours_to_pay() {
		return hours_to_pay - tax;
	}

	public void tax(double tax) {
		this.tax = tax;
	}

	public void getSituation() {
		if(this.start == 0){
			System.out.println("Informe o inicio do expediente:\t");
			double hour_check = dou_scanner.nextDouble();
			setStart(hour_check);
		}
		else{
			System.out.println("Informe o fim do expediente:\t");
			double hour_check = dou_scanner.nextDouble();
			setEnd(hour_check);
		}
	}

	public void setStart(double start) {
		this.start = start;
	}

	public void setEnd(double end) {
		this.end = end;
		adjustHours_to_pay();
	}

	private void adjustHours_to_pay() {
		this.hours_to_pay += this.end - this.start;
		this.start = 0;
		this.end = 0;
	}

	public Hourly(String name_in, String adress_in, int id_ref, double hour_price_in){
		super(name_in, adress_in, id_ref, "Hourly");
		this.hour_price = hour_price_in;
		this.start = 0;
		this.hours_to_pay = 0;
		this.tax = 0;
	}
}
